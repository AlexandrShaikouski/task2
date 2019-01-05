package com.alexshay.task2.servise;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.Comparator;
import java.util.List;

public class WordsSort {
    public String getWordSort(AllPartsText allPartsText) throws ServiseException {
        String str = "";
        LeafText text = allPartsText.getAllPartsText();
        List<LeafText> paragraphs = text.getCompositeText();
        for(LeafText paragraph : paragraphs){
            List<LeafText> sentences = paragraph.getCompositeText();
            for(LeafText sentence : sentences){
                List<LeafText> lexemes = sentence.getCompositeText();
                str += lexemes.stream().sorted(new Comparator<LeafText>() {
                    @Override
                    public int compare(LeafText o1, LeafText o2) {
                        return o1.toString().length() > o2.toString().length()?1:
                                o1.toString().length() == o2.toString().length()?0:-1;
                    }
                }).map(s -> s.toString()).reduce((s,k) -> s + " " + k).orElse("");
                str += "\n";
            }
        }
        return str;
    }
}
