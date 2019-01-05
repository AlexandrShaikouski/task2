package com.alexshay.task2.servise;

import com.alexshay.task2.servise.exception.ServiseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParagraphSortTest {
    private AllPartsText allPartsText;
    private ParagraphSort paragraphSort;
    private String expected;

    @Before
    public void loadData(){
        expected = "Bye\n" +
                "It is a (8^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of apage when looking at its layout.\n" +
                "It is a long established fact that a reader will be distracted by the readablecontent of a page when looking at its layout. The point of using(71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normaldistribution of letters, as opposed to using (Content here), content here, making it looklike readable English.\n" +
                "It has survived - not only (five) centuries, but also the leap into 13<<2 electronictypesetting, remaining 3>>5 essentially 6&9|(3&4) unchanged. It was popularised in the5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) with the release of Letraset sheets containing LoremIpsum passages, and more recently with desktop publishing software like AldusPageMaker including versions of Lorem Ipsum.";
        paragraphSort = new ParagraphSort();
        allPartsText = new AllPartsText();
    }

    @Test
    public void getSortParagraph() {
        String actual = "";
        try {
            actual = paragraphSort.getSortParagraph(allPartsText);
        } catch (ServiseException e) {
            e.printStackTrace();
        }
        assertEquals(expected,actual);
    }
    @After
    public void removeData(){
        expected = null;
        paragraphSort = null;
        allPartsText = null;
    }
}