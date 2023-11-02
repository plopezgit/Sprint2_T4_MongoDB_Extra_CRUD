package com.mongodb.quickstart;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Create {

	public static void main(String[] args) {


		try (MongoClient mongoClient = MongoClients.create()) {
			
			MongoDatabase opticDb = mongoClient.getDatabase("optic");
			
			MongoCollection<Document> clientCollection = opticDb.getCollection("client");
			
			
			Document client = new Document ("_id", new ObjectId());
			client.append("name", "Rol")
				.append("phone", "634625424")
				.append("email", "rol@kio.com");
			
			clientCollection.insertOne(client);
		}
		
	}

}
