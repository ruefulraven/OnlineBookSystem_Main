package com.obs.application.obs.controller;

import com.netflix.discovery.EurekaClient;
import com.obs.application.obs.dto.BookDto;
import com.obs.application.obs.sevice.BookService;
import com.obs.application.obs.sevice.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/book/{name}")
    public String hellow(@PathVariable("name") String name){
        bookService.hellow(name);
        return "contorller done";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody BookDto bookDTO){
        bookService.addBook(bookDTO);
        return "success";
    }

    @GetMapping("/countBook")
    public String countBooks(){
        return bookService.countBook();
    }

    @GetMapping("/greeting")
    public String greeting(){
        return "Hello FROM: " + appName;
    }
}
