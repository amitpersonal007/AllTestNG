package databasetesting;

import java.io.FileInputStream;
import org.testng.annotations.Test;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

public class CloudFirebase {
	
	
	@Test
	public void dbinstance() throws Exception {
		

FileInputStream serviceAccount =
  new FileInputStream("C:\\Users\\Amit\\Downloads\\first-planet-344506-3b0a641da12c.json"); 

FirestoreOptions firestoreOptions =
FirestoreOptions.getDefaultInstance().toBuilder()
    .setProjectId("amitdb007-cf662")
    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    .build();

Firestore db = firestoreOptions.getService();

System.out.println(db);



DocumentReference docRef = db.collection("amitdbinstance").document("7oBDOYHKYPkQkEdYPEI9");
ApiFuture<DocumentSnapshot> future = docRef.get();

DocumentSnapshot document = future.get();
if (document.exists()) {
  System.out.println("Document data: " + document.getData());
} else {
 System.out.println("No such document!");}


db.close();


	}
	

}
	

