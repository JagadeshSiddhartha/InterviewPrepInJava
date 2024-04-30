//
//import com.mongodb.MongoClient
//import com.mongodb.client.ListCollectionsIterable
//import com.mongodb.client.MongoDatabase
//import com.mongodb.client.MongoIterable
//import org.bson.Document
//import java.text.SimpleDateFormat
//import java.util.*
//
//fun main() {
////    val mongoClient = MongoClient("127.0.0.1", 27017)
////    val databaseNames: MongoIterable<String> = mongoClient.listDatabaseNames()
////    for (databaseName in databaseNames) {
////        val db: MongoDatabase = mongoClient.getDatabase(databaseName)
////        println("- Database: $databaseName")
////        val collections: ListCollectionsIterable<Document> = db.listCollections()
////        for (doc in collections) { //                doc.
////            println("\t + Collection: " + doc.toJson())
////        }
////    }
//    val date = "2014-11-20T15:20:00+05:30"
////    val date = fromDate.substringBeforeLast(".")+"Z"
//    val utcFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//    utcFormat.timeZone = TimeZone.getTimeZone("UTC")
//    try {
//        val configDate = utcFormat.parse(date)
//        println("Everything is fineee")
//    } catch (e:Exception) {
//        e.printStackTrace()
//        println("There is a problem")
//    }
//
//}
