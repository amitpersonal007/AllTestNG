import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.testng.annotations.Test;

public class InfluxD {

    @Test
    public void setup() {

        System.setProperty("javax.net.ssl.trustStore", "/opt/homebrew/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "");

        // Connect to InfluxDB instance
        InfluxDB influxDB = InfluxDBFactory.connect("https://localhost:8086", "root", "root");
        System.out.println("Connected");
        influxDB.query(new Query("SHOW DATABASES"));
        // Create a new database
              /*  influxDB.query(new Query("CREATE DATABASE mydb"));

                // Use the new database
                influxDB.setDatabase("mydb");

                // Create a new table
                influxDB.query(new Query("CREATE RETENTION POLICY myrp ON mydb DURATION 1d REPLICATION 1 DEFAULT"));
                influxDB.query(new Query("CREATE CONTINUOUS QUERY mycq ON mydb BEGIN SELECT COUNT(*) INTO mytable FROM mymeasurement GROUP BY time(1h) END"));*/

    }}
