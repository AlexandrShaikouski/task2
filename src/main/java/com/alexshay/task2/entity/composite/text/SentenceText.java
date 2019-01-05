package com.alexshay.task2.entity.composite.text;

import com.alexshay.task2.servise.exception.ServiseException;

import java.util.List;

public class SentenceText implements CompositeText{
    private String sentece;
    private List<LeafText> lexemes;

    public SentenceText(String sentece) {
        this.sentece = sentece;
    }

    @Override
    public List<LeafText> getCompositeText() {
        try{
            if(lexemes == null){
                lexemes = factoryChain.getParserText(sentece);
            }
            log.info("This is sentence");
        } catch (ServiseException e) {
            log.error("Problem with Chain " + e.getMessage());
        }
        return lexemes;
    }

    @Override
    public String toString() {
        return sentece;
    }
}
