package com.alexshay.task2.servise;

import com.alexshay.task2.servise.exception.ServiseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordsSortTest {
    private AllPartsText allPartsText;
    private WordsSort wordsSort;
    private String expected;

    @Before
    public void loadData(){
        expected = "- It has not but the only also leap into 3>>5 13<<2 (five) survived remaining 6&9|(3&4) unchanged centuries, essentially electronictypesetting,\n" +
                " It in of of was the and with more with like Lorem Ipsum sheets release desktop Letraset recently software versions passages, including containing LoremIpsum publishing popularised AldusPageMaker the5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1)\n" +
                "a a a It is be by of at the its long fact that will page when reader layout looking distracted established readablecontent\n" +
                " a of is it of as to it The has that point Ipsum using here, here), making opposed content English letters, (Content looklike readable more-or-less normaldistribution using(71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78\n" +
                "a a It is be of at its fact that will when apage reader layout looking established (8^5|1&2<<(2|5>>2&71))|1200\n" +
                "\n";
        wordsSort = new WordsSort();
        allPartsText = new AllPartsText();
    }

    @Test
    public void getWordsSort(){
        String actual = "";
        try {
            actual = wordsSort.getWordSort(allPartsText);
        } catch (ServiseException e) {
            e.printStackTrace();
        }
        assertEquals(expected,actual);
    }
    @After
    public void removeData(){
        expected = null;
        wordsSort = null;
        allPartsText = null;
    }
}