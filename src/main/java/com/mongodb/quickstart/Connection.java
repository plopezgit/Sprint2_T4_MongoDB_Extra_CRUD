package com.mongodb.quickstart;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Connection {

	public static void main(String[] args) {
		
//		String connectionString;
		
		try (MongoClient mongoClient = MongoClients.create()) {
			List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
			
			databases.forEach(db -> System.out.println(db.toJson()));
		}
	}

}
