package com.ruptraining.aem.core.models;
import java.util.List;
import java.util.Map;
public interface AuthorBook {

    String getAuthorName();

    List<String> getAuthorBooks();

    List<Map<String,String>> getBookDetailsWithMap();
}
