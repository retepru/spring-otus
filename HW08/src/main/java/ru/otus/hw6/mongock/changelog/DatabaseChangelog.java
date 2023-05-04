package ru.otus.hw6.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import java.util.Arrays;

@ChangeLog
public class DatabaseChangelog {
    @ChangeSet(order = "001", id = "dropDb", author = "Sergio", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertAuthor", author = "Sergio")
    public void insertAuthor(MongoDatabase db) {
        MongoCollection<Document> authorsCollection = db.getCollection("authors");
        var a1 = new Document().append("name", "Шолохов ChangeSet");
        var a2 = new Document().append("name", "Достоевский ChangeSet");
//        authorsCollection.insertOne(a1);
//        authorsCollection.insertOne(a2);
        authorsCollection.insertMany(Arrays.asList(a1, a2));

        MongoCollection<Document> stylesCollection = db.getCollection("styles");
        var s1 = new Document().append("name", "Исторический роман ChangeSet");
        stylesCollection.insertOne(s1);

        MongoCollection<Document> booksCollection = db.getCollection("books");
        var b1 = new Document()
                .append("name", "Тихий дон ChangeSet")
                .append("author", a1)
                .append("Style", s1);

        booksCollection.insertOne(b1);
    }

//    @ChangeSet(order = "003", id = "insertStyle", author = "Sergio")
//    public void insertStyle(MongoDatabase db) {
//        MongoCollection<Document> myCollection = db.getCollection("styles");
//        var doc = new Document()
//                .append("name", "Исторический роман ChangeSet");
//        InsertOneResult insertOneResult = myCollection.insertOne(doc);
//    }
}
