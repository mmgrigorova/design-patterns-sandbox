package com.company.design_patterns.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Evaluate
{
    @Test
    public void test()
    {
        Dragon dragon = new Dragon();

        assertEquals("flying", dragon.fly());
        assertEquals("too young", dragon.crawl());

        dragon.setAge(20);

        assertEquals("too old", dragon.fly());
        assertEquals("crawling", dragon.crawl());
    }
}

