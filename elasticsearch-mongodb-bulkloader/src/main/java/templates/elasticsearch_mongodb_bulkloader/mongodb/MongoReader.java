package templates.elasticsearch_mongodb_bulkloader.mongodb;

import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

public class MongoReader {
	
	public static void main(String [] args){
		
		MongoReader reader = new MongoReader();
		reader.read(10);		
	}

	public void read(int size) {
		try {

			MongoCredential credential = MongoCredential.createMongoCRCredential("luiz", "test-data-for-index", "luiz123".toCharArray());

			MongoClient mongoClient = new MongoClient(new ServerAddress("dogen.mongohq.com", 10020), Arrays.asList(credential));

			DB db = mongoClient.getDB("test-data-for-index");

			// get a single collection
			DBCollection collection = db.getCollection("Style Spa");

			DBCursor cursor = collection.find();
			
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			mongoClient.close();

		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
}
