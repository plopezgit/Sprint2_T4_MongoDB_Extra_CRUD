package com.mongodb.quickstart;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;

public class Read {

	public static void main(String[] args) {
		
		try (MongoClient mongoClient = MongoClients.create()) {
			
			MongoDatabase opticDb = mongoClient.getDatabase("optic");
			
			MongoCollection<Document> clientCollection = opticDb.getCollection("client");
			
			/*Document firstClient = clientCollection.find(new Document("name", "Ryal")).first();
			
			Document firstClient2 = clientCollection.find(eq("name", "Ryal")).first();

			System.out.println(firstClient2.toJson());*/

			
			/*List<Document> sampleResultRangeQuery = clientCollection.find(ne("name", "kjhfdjhd")).into(new ArrayList<>());
			
			for (Document client : sampleResultRangeQuery) {
				System.out.println(client.toJson());
			}*/
			
			
			FindIterable<Document> iterable = clientCollection.find((ne("name", "kjhfdjhd")));
			MongoCursor<Document> cursor = iterable.iterator();
			while (cursor.hasNext()) {
			    System.out.println(cursor.next().toJson());
			}
			
			
		}
		
	}

}
