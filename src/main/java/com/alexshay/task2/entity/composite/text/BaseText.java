package com.alexshay.task2.entity.composite.text;

import com.alexshay.task2.servise.exception.ServiseException;

import java.util.List;

public class BaseText implements CompositeText{
    private String text;
    private List<LeafText> paragraphs;

    public BaseText(String text) {
        this.text = text;
    }

    public List<LeafText> getCompositeText() {
        try {
            if(paragraphs == null) {
                paragraphs = factoryChain.getParserText(text);
            }
            log.info("This is base text");
        } catch (ServiseException e) {
            log.error("Problem with Chain " + e.getMessage());
        }
        return paragraphs;
    }

    @Override
    public String toString() {
        return text;
    }
}
