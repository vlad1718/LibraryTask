package com.epam.library;

import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;
import com.epam.library.model.Book;
import com.epam.library.service.BookService;
import com.epam.library.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class BookServiceTest {
    private BookService bookService = BookServiceImpl.getInstance();

    @Test
    public void testFindById() throws ServiceException, DAOException {
        Book book = bookService.getById(5);
        Assert.assertEquals("Hilabok", book.getTitle());
    }
}
