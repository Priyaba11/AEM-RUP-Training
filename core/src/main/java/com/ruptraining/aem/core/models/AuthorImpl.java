package com.ruptraining.aem.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class,
adapters=Author.class)
public class AuthorImpl implements Author {
    

    @Inject
    String fname;

    @Inject
    String lname;

    @Inject
    boolean professor;

    @Override
    public String getFirstName(){
        return fname;
    }

    @Override
    public String getLastName(){
        return lname;
    }

    @Override
    public boolean getIsProfessor(){
        return professor;
    }
}
