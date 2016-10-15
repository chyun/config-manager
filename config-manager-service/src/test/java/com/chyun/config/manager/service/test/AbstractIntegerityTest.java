package com.chyun.config.manager.service.test;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = {"classpath*:/config/spring/appcontext-*",
        "classpath*:/config/spring/local/appcontext-*.xml"})
public class AbstractIntegerityTest {
    static {
//        try {
//            Log4jConfigurer.initLogging("classpath:config/log/log4j.properties");
//        } catch (FileNotFoundException ex) {
//            System.err.println("Cannot Initialize log4j");
//        }
    }
//    protected void print(Object obj) {
//        System.out.println(ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE));
//    }
    private long start;

    public void notNull(Object obj) {
        assertNotNull(obj);
    }

    public void isNull(Object obj) {
        assertNull(obj);
    }

    public void equal(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }

    public void start() {
        this.start = System.currentTimeMillis();
    }

    public void end() {
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + "ms");
    }


}

