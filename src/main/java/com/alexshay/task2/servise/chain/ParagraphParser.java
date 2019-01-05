package com.alexshay.task2.servise.chain;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.entity.composite.text.ParagraphText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser extends TextParser{
    @Override
    public List<LeafText> parsePartText(String str) throws ServiseException {
        if(str.startsWith("  ")) {
            List<LeafText> paragraphs = Arrays.asList(str.replace("\n"," ").
                    replace("\r","").
                    trim().
                    split("\t|  +")).stream().
                    map(s -> new ParagraphText(s)).
                    collect(Collectors.toList());
            paragraphs.stream().
                    forEach(s -> s.toString());
            return paragraphs;
        }else{
            return nextPart(str);
        }
    }
}
