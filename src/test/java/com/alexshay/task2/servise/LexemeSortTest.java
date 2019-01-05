package com.alexshay.task2.servise;

import com.alexshay.task2.servise.exception.ServiseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LexemeSortTest {
    private AllPartsText allPartsText;
    private LexemeSort lexemeSort;
    private String expected;

    @Before
    public void loadData(){
        expected = "also essentially has leap remaining unchanged (five) - 13<<2 3>>5 6&9|(3&4) It but centuries, electronictypesetting, into not only survived the\n" +
                "AldusPageMaker passages, Letraset and containing popularised release software was  Ipsum It Lorem LoremIpsum desktop in including like more of of publishing recently sheets the the5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) versions with with\n" +
                "readablecontent a a a at distracted established fact layout page reader that It be by is its long looking of the when will\n" +
                "readable a as has making normaldistribution that  (Content English Ipsum The content here), here, is it it letters, looklike more-or-less of of opposed point to using using(71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78\n" +
                "apage a a at established fact layout reader that (8^5|1&2<<(2|5>>2&71))|1200 It be is its looking of when will\n" +
                "\n";
        lexemeSort = new LexemeSort();
        allPartsText = new AllPartsText();
    }
    @Test
    public void getLexemSort() {
        String actual = "";
        try {
            actual = lexemeSort.getLexemSort(allPartsText, 'a');
        } catch (ServiseException e) {
            e.printStackTrace();
        }
        assertEquals(expected,actual);
    }

    @After
    public void removeData(){
        expected = null;
        lexemeSort = null;
        allPartsText = null;
    }
}