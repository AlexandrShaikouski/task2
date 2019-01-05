package com.alexshay.task2.servise.chain;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.Arrays;
import java.util.List;

public abstract class TextParser implements TextChain{
    private TextChain next;
    @Override
    public void linkWith(TextChain textChain) {
        next = textChain;
    }
    protected List<LeafText> nextPart(String str) throws ServiseException{
        if (next != null) {
            return next.parsePartText(str);
        } else {
            return Arrays.asList();
        }

    }
}
