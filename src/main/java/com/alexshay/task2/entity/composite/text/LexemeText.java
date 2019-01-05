package com.alexshay.task2.entity.composite.text;

import com.alexshay.task2.servise.exception.ServiseException;
import java.util.List;

public class LexemeText implements CompositeText {
    private String lexeme;
    private List<LeafText> words;

    public LexemeText(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public List<LeafText> getCompositeText() {
        try {
            if(words == null){
                words = factoryChain.getParserText(lexeme);
            }
            log.info("This is lexeme");
        } catch (ServiseException e) {
            log.error("Problem with Chain " + e.getMessage());
        }
        return words;
    }

    @Override
    public String toString() {
        return lexeme;
    }
}
