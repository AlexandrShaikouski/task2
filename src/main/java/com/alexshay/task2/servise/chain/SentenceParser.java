package com.alexshay.task2.servise.chain;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.entity.composite.text.SentenceText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser extends TextParser{
    @Override
    public List<LeafText> parsePartText(String str) throws ServiseException {
        if(str.endsWith(".")) {
            List<LeafText> sentences = Arrays.asList(str.split("[.!?]")).stream().
                    filter(s -> !s.startsWith("\n")).
                    map(s -> new SentenceText(s)).
                    collect(Collectors.toList());
            sentences.stream().
                    forEach(s -> s.toString());
            return sentences;
        }else{
            return nextPart(str);
        }
    }
}
