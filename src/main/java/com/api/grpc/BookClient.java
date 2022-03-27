package com.api.grpc;

import com.endpoints.examples.bookstore.BookAuthorRequest;
import com.endpoints.examples.bookstore.BookResponse;
import com.endpoints.examples.bookstore.BookServiceGrpc;
import com.endpoints.examples.bookstore.GetBookRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BookClient {
    ManagedChannel channel;

    BookServiceGrpc.BookServiceBlockingStub bookServiceStub;

    public BookClient() {
        channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
        bookServiceStub = BookServiceGrpc.newBlockingStub(channel);
    }

    public BookResponse getBookByISBN(Integer ISBN) throws Exception {
        try {
            GetBookRequest getBookRequest = GetBookRequest.newBuilder().setIsbn(ISBN).build();
            return bookServiceStub.getBook(getBookRequest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public BookResponse getBookByAuthor(String authorName) throws Exception {
        try {
            BookAuthorRequest getBookRequest = BookAuthorRequest.newBuilder().setAuthor(authorName).build();
            return bookServiceStub.getBooksViaAuthor(getBookRequest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
