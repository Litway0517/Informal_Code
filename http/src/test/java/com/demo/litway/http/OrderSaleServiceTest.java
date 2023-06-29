package com.demo.litway.http;

import com.demo.litway.mapper.OrderSaleMapper;
import com.demo.litway.pojo.OrderSale;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Litway
 * @version 1.0
 */
@SpringBootTest
public class OrderSaleServiceTest {

    @Resource
    private OrderSaleMapper orderSaleMapper;

    @Test
    public void testIndex() {
        List<OrderSale> orderSales = orderSaleMapper.selectList(null);
        System.out.println(orderSales);
    }

    @Test
    public void testInsert() {
        OrderSale orderSale = new OrderSale();
        orderSale.setOrderNo("XSDD00000a");
        orderSale.setProgress("C");
        orderSale.setSaleOrgid("");
        orderSale.setCdate(new Date());
        orderSale.setCustomeName("");
        orderSale.setSaleDeptId("");
        orderSale.setSaleGroupId("");
        orderSale.setSalerId("");
        orderSale.setBillTypeId("");
        orderSale.setCreateTime(new Date());
        orderSale.setUpdateTime(new Date());

        int insert = orderSaleMapper.insert(orderSale);
        System.out.println(insert);
    }

}
