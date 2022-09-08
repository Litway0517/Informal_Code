package com.litway.service;

import com.litway.template.Vegetable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChineseCabbage extends Vegetable {

    public void pourVegetable() {
        log.info("加入 大白菜...");
    }
}
