package com.mongodb.quickstart;

import static com.mongodb.client.model.Filters.ne;
import static com.mongodb.client.model.Updates.*;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

public class Update {

	public static void main(String[] args) {
		
		JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();
		
		try (MongoClient mongoClient = MongoClients.create()) {
			
			MongoDatabase opticDb = mongoClient.getDatabase("optic");
			MongoCollection<Document> clientCollection = opticDb.getCollection("client");
			
			Bson filter = ne("name", "Ryal");
			Bson updateOperation = set("comment", "Ryal is a very frequent client");
			
			UpdateResult updateResult = clientCollection.updateOne(filter, updateOperation);
	
			System.out.println(clientCollection.find(filter).first().toJson(prettyPrint));		
			System.out.println(updateResult);

		}
	}

}
