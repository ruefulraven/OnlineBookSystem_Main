package com.obs.application.obs.sevice;


import com.obs.application.obs.dto.BookDto;
import com.obs.application.obs.entity.Book;
import com.obs.application.obs.mapstruct.BookMapper;
import com.obs.application.obs.repository.BookRepository;
import jakarta.jms.JMSConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final JmsTemplate jmsTemplate;
    private String bookCount;
    BookMapper bookMapper;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(JmsTemplate jmsTemplate, BookMapper bookMapper) {
        this.jmsTemplate = jmsTemplate;
        this.bookMapper = bookMapper;
    }

    public String hellow(String name){
        jmsTemplate.convertAndSend("queue-0-1", name);
        return "done queue";
    }

    @Override
    public void addBook(BookDto book) {
        bookRepository.save(
                bookMapper.map(book));
    }

    @Override
    public String countBook() {
        countBook();
        return bookCount;
    }

    @JmsListener(destination = "book-notification")
    public void countBook(String count) {
        System.out.println("Book COUNT: " + count);
        bookCount = count;
    }
}
