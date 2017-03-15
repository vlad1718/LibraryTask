package com.epam.library.dao.impl;


import com.epam.library.config.DataSource;
import com.epam.library.dao.EmployeeDao;
import com.epam.library.exception.DAOException;
import com.epam.library.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final String SQL_READ_MORE_THAN_ONE = "SELECT EMPLOYEE.NAME, COUNT(BOOK_ID) as NUMBER_OF_BOOKS " +
            "FROM EMPLOYEE JOIN EMPLOYEE_BOOK ON EMPLOYEE.ID = EMPLOYEE_ID GROUP BY NAME " +
            "HAVING COUNT(BOOK_ID) > 1 ORDER BY NUMBER_OF_BOOKS";
    private static final String SQL_READ_LESS_THAN_TWO = "SELECT EMPLOYEE.NAME, EMPLOYEE.DATE_OF_BIRTH, " +
            "COUNT(BOOK_ID) as NUMBER_OF_BOOKS FROM EMPLOYEE JOIN EMPLOYEE_BOOK ON EMPLOYEE.ID = EMPLOYEE_ID " +
            "GROUP BY NAME, DATE_OF_BIRTH HAVING COUNT(BOOK_ID) <= 2 ORDER BY NUMBER_OF_BOOKS DESC, DATE_OF_BIRTH";
    private static final String SQL_UPDATE_BY_TITLE = "UPDATE BOOK SET BOOK.TITLE = ? WHERE BOOK.TITLE = ?";
    private static final String DATE_FORMAT = "yyyy.MM.dd";
    private static EmployeeDao employeeDao;

    private EmployeeDaoImpl() {
    }

    public static EmployeeDao getInstance() {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoImpl();
            return employeeDao;
        } else {
            return employeeDao;
        }
    }

    @Override
    public Map<String, Integer> readMoreThanOneBook() throws DAOException {
        Map<String, Integer> result;
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_READ_MORE_THAN_ONE);
        ) {
            ResultSet set = statement.executeQuery();
            result = new HashMap<>();
            while (set.next()) {
                String name = set.getString(1);
                int numberOfBooks = set.getInt(2);
                result.put(name, numberOfBooks);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    public Map<String, Integer> readLessThanOrEqualTwoBook() throws DAOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Map<String, Integer> result;
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_READ_LESS_THAN_TWO);
        ) {
            ResultSet set = statement.executeQuery();
            result = new HashMap<>();
            while (set.next()) {
                String resultInfo = set.getString(1) + dateFormat.format(set.getDate(2));
                Integer numberOfBooks = set.getInt(3);
                result.put(resultInfo, numberOfBooks);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    public boolean updateBookByTitle(String newTitle, String oldTitle) throws DAOException {
        boolean flag = false;
        try (
                Connection connection = DataSource.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BY_TITLE);
        ) {
            statement.setString(1, newTitle);
            statement.setString(2, oldTitle);
            statement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return flag;
    }

    @Override
    public Employee getById(Integer key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer add(Employee persistenceObject) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
