package com.epam.library;

import com.epam.library.exception.ServiceException;
import com.epam.library.service.EmployeeService;
import com.epam.library.service.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeServiceTest {
    private EmployeeService employeeService = EmployeeServiceImpl.getInstance();

    @Test
    public void testReadMoreThanOne() throws ServiceException {
        Assert.assertNotNull(employeeService.readMoreThanOneBook());
    }
}
