package com.alexshay.task2.entity.composite.text;

import com.alexshay.task2.servise.exception.ServiseException;
import java.util.Arrays;
import java.util.List;

public class WordText implements LeafText{
    private String word;

    public WordText(String word) {
        this.word = word;
    }

    @Override
    public List<LeafText> getCompositeText()  {
        return Arrays.asList();
    }

}
