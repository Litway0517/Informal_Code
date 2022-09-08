package com.litway.template;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Vegetable {


    public void cookVegetable() {
        log.info("炒菜的一般做法...");
        this.pourOil();
        this.headOil();
        this.pourVegetable();
        this.cooking();
    }


    // 1- 倒油
    public void pourOil() {
        log.info("倒油...");
    }

    // 2- 把油烧热
    public void headOil() {
        log.info("加热, 把油烧热...");
    }

    // 3- 油热了之后, 将蔬菜加入锅中. 具体是哪种蔬菜由子类决定
    public abstract void pourVegetable();

    // 4- 开始炒菜
    public void cooking() {
        log.info("炒菜...");
    }


}
