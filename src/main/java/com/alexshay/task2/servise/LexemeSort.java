package com.alexshay.task2.servise;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.Comparator;
import java.util.List;

public class LexemeSort {
    public String getLexemSort(AllPartsText allPartsText, char symbol) throws ServiseException {
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
                        String str1 = o1.toString();
                        String str2 = o2.toString();
                        return str1.chars().filter(ch -> ch ==symbol).count() > str2.chars().filter(ch -> ch ==symbol).count()?-1:
                                str1.chars().filter(ch -> ch ==symbol).count() == str2.chars().filter(ch -> ch ==symbol).count()?
                                        str1.compareTo(str2):1;
                    }
                }).map(s -> s.toString()).reduce((s,k) -> s + " " + k).orElse("");
                str += "\n";
            }
        }
        return str;
    }

}
