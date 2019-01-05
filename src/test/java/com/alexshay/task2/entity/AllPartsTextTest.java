package com.alexshay.task2.entity;

import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.servise.AllPartsText;
import com.alexshay.task2.servise.exception.ServiseException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AllPartsTextTest {
    private AllPartsText allPartsText;
    private LeafText leafText;

    @Before
    public void loadData(){
        try {
            allPartsText = new AllPartsText();
            leafText = allPartsText.getAllPartsText();
        } catch (ServiseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testPartsText(){
        List<LeafText> paragraphs = leafText.getCompositeText();
        paragraphs.stream().
                forEach(System.out::println);
        for(LeafText paragraph : paragraphs){
            List<LeafText> sentences = paragraph.getCompositeText();
            System.out.println(paragraph.toString());
            for (LeafText sentence : sentences){
                List<LeafText> lexemes = sentence.getCompositeText();
                System.out.println(sentence.toString());
                for (LeafText lexeme : lexemes){
                    System.out.println(lexeme.toString());
                }
            }
        }
        assertTrue(true);
    }
}