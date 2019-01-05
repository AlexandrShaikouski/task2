package com.alexshay.task2.entity.composite.text;


import java.util.List;

public interface LeafText {
    List<LeafText> getCompositeText();
}
