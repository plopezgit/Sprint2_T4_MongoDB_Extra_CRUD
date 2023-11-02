package com.mongodb.quickstart;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

public class Delete {

	public static void main(String[] args) {

		try (MongoClient mongoClient = MongoClients.create()) {
			
			MongoDatabase opticDb = mongoClient.getDatabase("optic");
			MongoCollection<Document> clientCollection = opticDb.getCollection("client");
			
			Bson filter = eq("phone", "634625424");
			DeleteResult result = clientCollection.deleteOne(filter);
			
			System.out.println(result);
		}
	}

}
