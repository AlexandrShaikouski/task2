package com.alexshay.task2.servise.chain;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.entity.composite.text.LexemeText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LexemeParser extends TextParser{
    @Override
    public List<LeafText> parsePartText(String str) throws ServiseException {
        if(str.contains(" ")){
            List<LeafText> lexeme = Arrays.asList(str.split(" ")).stream().
                    map(s -> new LexemeText(s)).
                    collect(Collectors.toList());
            return lexeme;
        }else{
            return nextPart(str);
        }
    }
}
