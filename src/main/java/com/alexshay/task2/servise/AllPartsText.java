package com.alexshay.task2.servise;

import com.alexshay.task2.dao.TextDAO;
import com.alexshay.task2.dao.exceptions.NotFoundTextDAOExceptions;
import com.alexshay.task2.dao.impl.TextFromFileDAO;
import com.alexshay.task2.entity.composite.text.BaseText;
import com.alexshay.task2.entity.composite.text.LeafText;
import com.alexshay.task2.servise.chain.FactoryChain;
import com.alexshay.task2.servise.exception.ServiseException;


public class AllPartsText {
    private FactoryChain factoryChain = new FactoryChain();
    private TextDAO textDAO = new TextFromFileDAO();
    private String text;
    private LeafText compText;
    public LeafText getAllPartsText() throws ServiseException {
        try {
            text = textDAO.getText();
            compText = new BaseText(text);
            return compText;
        } catch (NotFoundTextDAOExceptions notFoundTextDAOExceptions) {
            throw new ServiseException("Not found File");
        }


    }
}
