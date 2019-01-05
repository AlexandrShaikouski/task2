package com.alexshay.task2.dao.exceptions;

import java.io.IOException;

public class NotFoundTextDAOExceptions extends Exception {
    public NotFoundTextDAOExceptions() {
        super();
    }

    public NotFoundTextDAOExceptions(String message) {
        super(message);
    }

    public NotFoundTextDAOExceptions(String message, Exception e) {
        super(message, e);
    }
}
