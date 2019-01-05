package com.alexshay.task2.servise.chain;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.entity.composite.text.WordText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.Arrays;
import java.util.List;

public class WordParser extends TextParser{
    @Override
    public List<LeafText> parsePartText(String str) throws ServiseException {
        if(str.matches("\\w+")) {
            List<LeafText> words = Arrays.asList(new WordText(str));
            return words;
        }else {
            return nextPart(str);
        }

    }
}
