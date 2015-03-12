package com.campusconnect.neo4j.da;

import com.campusconnect.neo4j.akka.goodreads.GoodreadsAsynchHandler;
import com.campusconnect.neo4j.akka.goodreads.api.GetBook;
import com.campusconnect.neo4j.akka.goodreads.api.Search;
import com.campusconnect.neo4j.akka.goodreads.types.*;
import com.campusconnect.neo4j.types.Book;
import com.campusconnect.neo4j.types.SearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sn1 on 3/4/15.
 */
public class GoodreadsDao {
    private Search search;
    private GetBook getBook;
    private GoodreadsAsynchHandler goodreadsAsynchHandler;

    public void setGoodreadsAsynchHandler(GoodreadsAsynchHandler goodreadsAsynchHandler) {
        this.goodreadsAsynchHandler = goodreadsAsynchHandler;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
    public void setGetBook(GetBook getBook) {
        this.getBook = getBook;
    }

    
    public SearchResult search(String queryString) {
        try {
            SearchResponse searchResponse = search.search(queryString);
            return formSearchResult(searchResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private SearchResult formSearchResult(SearchResponse searchResponse) {
        List<Book> searchBooks = new ArrayList<>();
        if(searchResponse.getSearch() != null)

            for (Result result : searchResponse.getSearch().getResults()) {
                final BestBook bestBook = result.getBestBook();
                if(bestBook != null) {
                    Book book = new Book();
                    final Author author = bestBook.getAuthor();
                    if(author != null){
                        book.setAuthorName(author.getName());
                        book.setGoodreadsAuthorId(author.getId());
                    }

                    book.setGoodreadsId(bestBook.getId());
                    book.setImageUrl(bestBook.getImageUrl());
                    book.setName(bestBook.getTitle());
                    book.setPublishedYear(result.getOriginalPublicationYear());
                    searchBooks.add(book);
                }
            }
        return new SearchResult(searchBooks);
    }

    public Book getBookById(String goodreadsId) throws IOException {
        GetBookResponse getBookResponse = getBook.getBookById(goodreadsId);
        final Book book = getBookFromBookResponse(getBookResponse);
        if(book != null)
            goodreadsAsynchHandler.saveBook(book);
        return book;
    }
    
    public Book getBookByISBN(String isbn) throws IOException {
        GetBookResponse getBookResponse = getBook.getBookByISBN(isbn);
        return getBookFromBookResponse(getBookResponse);
    }

    private Book getBookFromBookResponse(GetBookResponse getBookResponse) {
        Book book = new Book();

        final com.campusconnect.neo4j.akka.goodreads.types.Book respBook = getBookResponse.getBook();
        if(respBook != null){
            final Author author = respBook.getAuthors().get(0);
            if(author != null){
                book.setAuthorName(author.getName());
                book.setGoodreadsAuthorId(author.getId());    
            }
            book.setDescription(respBook.getDescription());
            book.setGoodreadsId(Integer.valueOf(respBook.getId()));
            book.setImageUrl(respBook.getImageUrl());
            book.setIsbn(respBook.getIsbn());
            book.setIsbn13(respBook.getIsbn13());
            book.setName(respBook.getTitle());
            book.setPublishedYear(Integer.valueOf(respBook.getPublicationYear()));
            book.setPublisher(respBook.getPublisher());
            book.setNumberOfPages(Integer.parseInt(respBook.getNumPages()));
            return book;
        }
        return null;
    }
    
    
}
