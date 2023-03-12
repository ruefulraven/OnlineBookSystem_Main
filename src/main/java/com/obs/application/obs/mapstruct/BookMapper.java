package com.obs.application.obs.mapstruct;

import com.obs.application.obs.dto.BookDto;
import com.obs.application.obs.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto map (Book book);

    Book map (BookDto book);
}
