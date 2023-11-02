package com.mongodb.quickstart;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;

public class Create {

	public static void main(String[] args) {


		try (MongoClient mongoClient = MongoClients.create()) {
			
			MongoDatabase opticDb = mongoClient.getDatabase("optic");
			
			MongoCollection<Document> clientCollection = opticDb.getCollection("client");
			
			
			Document client = new Document ("_id", new ObjectId());
			client.append("name", "Tris")
				.append("phone", "534675345")
				.append("email", "tri@kio.com");
			
			
			
			List <Document> clients = new ArrayList<>();
			
			clients.add(new Document ("_id", new ObjectId()).append("name", "Bull")
					.append("phone", "35687463")
					.append("email", "bull@gus.com"));
			clients.add(new Document ("_id", new ObjectId()).append("name", "Marc")
					.append("phone", "35344352")
					.append("email", "marc@is.com"));
			clients.add(new Document ("_id", new ObjectId()).append("name", "Kyr")
					.append("phone", "865345435")
					.append("email", "kir@wer.com"));
			
			
			clientCollection.insertMany(clients, new InsertManyOptions().ordered(false));
		}
		
	}
	
}
