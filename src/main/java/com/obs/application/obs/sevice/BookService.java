package com.obs.application.obs.sevice;

import com.obs.application.obs.dto.BookDto;
import com.obs.application.obs.entity.Book;

public interface BookService {

    public void addBook(BookDto book);

    public String countBook();
    public void countBook(String count);
}
