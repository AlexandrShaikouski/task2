package com.alexshay.task2.dao.impl;

import com.alexshay.task2.dao.TextDAO;
import com.alexshay.task2.dao.exceptions.NotFoundTextDAOExceptions;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextFromFileDAO implements TextDAO {
    private URI path;

    @Override
    public String getText() throws NotFoundTextDAOExceptions {
        String text;
        try {
            path = ClassLoader.getSystemResource("text.txt").toURI();
            List<String> texts = Files.readAllLines(Paths.get(path),Charset.forName("UTF-8"));
            text = texts.stream().reduce((s,k)-> s + k).orElse("");
        } catch (IOException e) {
            throw new NotFoundTextDAOExceptions();
        }catch (Exception e) {
            throw new NotFoundTextDAOExceptions();
        }
        return text;
    }
}
