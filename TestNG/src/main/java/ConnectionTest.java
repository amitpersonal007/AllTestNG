import okhttp3.OkHttpClient;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

public class ConnectionTest {
    public static void main(String... a) throws CertificateException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        ConnectionTest c = new ConnectionTest();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        builder = getOkHttpClientWithTrustedCertificate();
        InfluxDB influxDB = InfluxDBFactory.connect("https://localhost:8086", "root", "root",builder);
        StringBuffer sb = new StringBuffer();
        QueryResult queryResult = influxDB.query(new Query("SHOW DATABASES","TEST1"));
        for (QueryResult.Result resultdata : queryResult.getResults()) {
            for (QueryResult.Series series : resultdata.getSeries()) {
                sb.append("Series name: " + series.getName());
                sb.append("<br>");
                List<String> columns = series.getColumns();

                for (List<Object> values : series.getValues()) {

                    for(int i = 0; i < columns.size(); i++)
                    {
                        String column = columns.get(i);
                        Object value = values.get(i);
                        sb.append(column + ":" +value);
                        sb.append("<br>");
                    }

                }
                /**/

            }
        }
        System.out.println(sb.toString());
        System.out.println("Connected");
    }
    private static OkHttpClient.Builder
    getOkHttpClientWithTrustedCertificate() throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        // Load trusted certificate from file
        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        // obtain the ClassLoader for the current class
        ClassLoader classLoader = ConnectionTest.class.getClassLoader();
        // get the input stream for the resource
         InputStream inputStream = classLoader.getResourceAsStream("influxdb.crt");
        //InputStream inputStream = new FileInputStream(new File("/Users/rajesh/work/influx/example.pem"));
        //InputStream inputStream = new FileInputStream(new File("/Users/amits/Desktop/influxdb.crt"));
        X509Certificate trustedCertificate = (X509Certificate) cf.generateCertificate(inputStream);
        inputStream.close();

        // Create a trust manager that trusts the loaded certificate
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);
        trustStore.setCertificateEntry("trusted_cert", trustedCertificate);
        TrustManagerFactory tmf =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);

        // Create an SSLContext with the trust manager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        // Create an OkHttpClient with the SSLContext
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.sslSocketFactory(sslContext.getSocketFactory(),
                (X509TrustManager)tmf.getTrustManagers()[0]);
        builder.hostnameVerifier((hostname, session) -> {

            return true;//hostname.equals(commonName);
        });
        //OkHttpClient okHttpClient = builder.build();
        return builder;
    }
}
