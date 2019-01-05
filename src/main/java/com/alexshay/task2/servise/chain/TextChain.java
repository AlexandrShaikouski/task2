package com.alexshay.task2.servise.chain;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.List;

public interface TextChain {
    List<LeafText> parsePartText(String str) throws ServiseException;
    void linkWith(TextChain textChain);
}
