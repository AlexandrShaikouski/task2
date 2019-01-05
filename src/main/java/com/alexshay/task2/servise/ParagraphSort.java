package com.alexshay.task2.servise;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.servise.exception.ServiseException;

import java.util.Comparator;
import java.util.List;

public class ParagraphSort {
    public String getSortParagraph(AllPartsText allPartsText) throws ServiseException {
        LeafText text = allPartsText.getAllPartsText();
        List<LeafText> paragraphs = text.getCompositeText();
        String result = paragraphs.stream().
                sorted(new Comparator<LeafText>() {
                    @Override
                    public int compare(LeafText o1, LeafText o2) {
                        return o1.getCompositeText().size() > o2.getCompositeText().size()?1:-1;
                    }
                }).
                map(s -> s.toString()).
                reduce((s,k) -> s + "\n" + k).orElse("");
        return result;
    }
}
