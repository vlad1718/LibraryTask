package com.epam.library.service;

import com.epam.library.exception.ServiceException;
import com.epam.library.model.Employee;

import java.util.List;

public interface EmployeeService extends CrudService<Employee, Integer> {
    List<String> readMoreThanOneBook() throws ServiceException;
    List<String> readLessThanOrEqualTwoBook() throws ServiceException;
    boolean updateBookByTitle(String newTitle, String oldTitle) throws ServiceException;
}
