

package com.ruptraining.aem.core.models;

import com.ruptraining.aem.core.models.AuthorBook;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class AuthorBooksImplTest {

    private final AemContext aemContext=new AemContext();

    private AuthorBook author;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(AuthorBookImpl.class);
        //aemContext.load().json(classpathResource:)
        aemContext.load().json("/com.ruptraining.aem.core.models.impl/AuthorBooks.json","/component");
       // aemContext.load().json("/com/ruptraining/aem/core/models/impl/Page.json","/page");
       // aemContext.load().json("/com/ruptraining/aem/core/models/impl/Resource.json","/resource");
    }


    @Test
    void getAuthorBooks() {
        aemContext.currentResource("/component/authorbooks");
        author=aemContext.request().adaptTo(AuthorBook.class);
        assertEquals(2,author.getAuthorBooks().size());
        assertEquals("Book1",author.getAuthorBooks().get(0));
        assertEquals("Book2",author.getAuthorBooks().get(1));
    }




    @Test
    void getAuthorName() {
        //assertEquals("Chetan Bhagat", aemContext.registerService(new AuthorBookImpl()).getAuthorName());
        aemContext.currentResource("/component/authorbooks");
        author=aemContext.request().adaptTo(AuthorBook.class);
        assertEquals("Chetan Bhagat",author.getAuthorName());
    }


    @Test
    void getBookDetailsWithMap() {
        aemContext.currentResource("/component/authorbooks");
        author=aemContext.request().adaptTo(AuthorBook.class);
        assertEquals(2,author.getBookDetailsWithMap().size());
        assertEquals("2001",author.getBookDetailsWithMap().get(0).get("publishyear"));
        assertEquals("Drama",author.getBookDetailsWithMap().get(0).get("booksubject"));
    }

}
