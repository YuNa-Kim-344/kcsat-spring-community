package hpclab.kcsatspringcommunity.myBook.service;

import hpclab.kcsatspringcommunity.myBook.dto.BookResponseForm;

public interface BookService {

    void makeBook(String userEmail);
    BookResponseForm findBook(String userEmail);
}