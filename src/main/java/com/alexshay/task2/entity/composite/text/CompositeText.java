package com.alexshay.task2.entity.composite.text;

import com.alexshay.task2.servise.chain.FactoryChain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public interface CompositeText extends LeafText{
    Logger log = LogManager.getLogger(CompositeText.class);
    FactoryChain factoryChain = new FactoryChain();
}
