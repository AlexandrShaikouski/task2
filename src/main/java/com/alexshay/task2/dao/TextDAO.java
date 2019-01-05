package com.alexshay.task2.dao;

import com.alexshay.task2.dao.exceptions.NotFoundTextDAOExceptions;

public interface TextDAO {
    String getText() throws NotFoundTextDAOExceptions;
}
