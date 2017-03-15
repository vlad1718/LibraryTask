package com.epam.library.service.impl;


import com.epam.library.dao.EmployeeDao;
import com.epam.library.dao.impl.EmployeeDaoImpl;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;
import com.epam.library.model.Employee;
import com.epam.library.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeService employeeService;
    private EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

    private EmployeeServiceImpl() {
    }

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            employeeService = new EmployeeServiceImpl();
            return employeeService;
        } else {
            return employeeService;
        }
    }

    @Override
    public List<String> readMoreThanOneBook() throws ServiceException {
        List<String> books;
        try {
            books = employeeDao.readMoreThanOneBook().entrySet()
                    .stream().map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return books;
    }

    @Override
    public List<String> readLessThanOrEqualTwoBook() throws ServiceException {
        List<String> books;
        try {
            books = employeeDao.readLessThanOrEqualTwoBook().entrySet()
                    .stream().map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return books;
    }

    @Override
    public boolean updateBookByTitle(String newTitle, String oldTitle) throws ServiceException {
        boolean result;
        try {
            result = employeeDao.updateBookByTitle(newTitle, oldTitle);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public Employee getById(Integer key) throws ServiceException {
        Employee employee;
        try {
            employee = employeeDao.getById(key);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return employee;
    }

    @Override
    public Integer add(Employee persistenceObject) throws ServiceException {
        Integer id;
        try {
            id = employeeDao.add(persistenceObject);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return id;
    }

    @Override
    public boolean delete(Integer key) throws ServiceException {
        boolean result = false;
        try {
            result = employeeDao.delete(key);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean update(Employee employee) throws ServiceException {
        boolean idUpdated;
        try {
            idUpdated = employeeDao.update(employee);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return idUpdated;
    }
}
