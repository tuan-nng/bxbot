/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.bxbot.core;

import com.gazbert.bxbot.core.engine.TradingEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * BX-bot - here be the main boot app.
 *
 * @author gazbert
 */
@SpringBootApplication
public class BXBot implements CommandLineRunner {

    @Autowired
    private TradingEngine tradingEngine;

    /*
     * Can't use constructor injection within @SpringBootApplication:
     * http://stackoverflow.com/questions/36696803/spring-boot-no-default-constructor-found-on-springbootapplication-class
     *
     * New feature coming in Boot 4.3: https://jira.spring.io/browse/SPR-13471
     */
//    @Autowired
//    public BXBot(TradingEngine tradingEngine) {
//        Assert.notNull(tradingEngine, "tradingEngine dependency cannot be null!");
//        this.tradingEngine = tradingEngine;
//    }

    public BXBot() {
    }

    public static void main(String[] args) {
        SpringApplication.run(BXBot.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        tradingEngine.start();
    }
}