package com.mongodb.quickstart;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Read {

	public static void main(String[] args) {
		
		try (MongoClient mongoClient = MongoClients.create()) {
			
			MongoDatabase opticDb = mongoClient.getDatabase("optic");
			
			MongoCollection<Document> clientCollection = opticDb.getCollection("client");
			
			Document firstClient = clientCollection.find(new Document("name", "Ryal")).first();
			
			System.out.println(firstClient.toJson());
		}
		
	}

}
