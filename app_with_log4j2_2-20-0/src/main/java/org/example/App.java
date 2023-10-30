package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * Hello world!
 *
 */
public class App
{
    private static Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        logger.info("a message without mdc");
        ThreadContext.put("mdcField", "hi");
        logger.info("a message with mdc");
        ThreadContext.clearAll();
    }
}
