package templates.elasticsearch_mongodb_bulkloader.mongodb;

import org.junit.Test;

import junit.framework.TestCase;

public class MongoReaderTest extends TestCase {

	@Test
	public void readTest(){
		
		MongoReader reader = new MongoReader();
		
		reader.read(10000);
		
		
	}
}
