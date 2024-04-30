//import com.mongodb.DB;
//import com.mongodb.MongoClient;
//import com.mongodb.client.ListCollectionsIterable;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.MongoIterable;
//import org.bson.Document;
//
//import java.util.List;
//import java.util.Set;
//
//public class MongoDBTest {
//    public static void main(String[] args) {
//        MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
//        MongoIterable<String> databaseNames = mongoClient.listDatabaseNames();
//        for (String databaseName : databaseNames) {
//            MongoDatabase db = mongoClient.getDatabase(databaseName);
//            System.out.println("- Database: " + databaseName);
//            ListCollectionsIterable<Document> collections = db.listCollections();
//            for (Document doc : collections) {
////                doc.
//                System.out.println("\t + Collection: " + doc.toJson());
//            }
//
//        }
//    }
//}
