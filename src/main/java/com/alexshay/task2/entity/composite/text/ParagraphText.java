package com.alexshay.task2.entity.composite.text;

import com.alexshay.task2.servise.exception.ServiseException;

import java.util.List;

public class ParagraphText implements CompositeText{
    private String paragraph;
    private List<LeafText> sentences;

    public ParagraphText(String paragraph) {
        this.paragraph = paragraph;
    }


    public List<LeafText> getCompositeText() {
        try {
            if (sentences == null) {
                sentences = factoryChain.getParserText(paragraph);
            }
            log.info("This is paragraph");
        } catch (ServiseException e) {
            log.error("Problem with Chain " + e.getMessage());
        }
        return sentences;
    }

    @Override
    public String toString() {
        return paragraph;
    }
}
