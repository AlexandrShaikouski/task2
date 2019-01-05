package com.alexshay.task2.servise.chain;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.List;

public class FactoryChain {
    private TextChain paragraphParser = new ParagraphParser();
    private TextChain sentenceParser = new SentenceParser();
    private TextChain lexemeParser = new LexemeParser();
    private TextChain wordParser = new WordParser();

    public List<LeafText> getParserText(String str) throws ServiseException {
        paragraphParser.linkWith(sentenceParser);
        sentenceParser.linkWith(lexemeParser);
        lexemeParser.linkWith(wordParser);
        return paragraphParser.parsePartText(str);
    }
}
