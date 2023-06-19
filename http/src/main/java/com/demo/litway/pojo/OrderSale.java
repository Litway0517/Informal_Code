package com.demo.litway.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_sale")
public class OrderSale {
    /**
     * id
     */
    private Long id;

    /**
     * 单据编号
     */
    private String orderNo;

    /**
     * 单据进度
     */
    private String progress;

    /**
     * 销售组织
     */
    private String saleOrgid;

    /**
     * 订单交期
     */
    private Date cdate;

    /**
     * 客户名称
     */
    private String customeName;

    /**
     * 销售部门id
     */
    private String saleDeptId;

    /**
     * 销售组id
     */
    private String saleGroupId;

    /**
     * 销售员id
     */
    private String salerId;

    /**
     * 收货方id
     */
    private String receiveId;

    /**
     * 结算方id
     */
    private String settleId;

    /**
     * 结算方地址
     */
    private String settleAddress;

    /**
     * 付款方id
     */
    private String chargeId;

    /**
     * 作废状态
     */
    private String cancelStatus;

    /**
     * 作废人id
     */
    private String cancellerId;

    /**
     * 作废日期
     */
    private Date cancelDate;

    /**
     * 变更人id
     */
    private String changerId;

    /**
     * 变更日期
     */
    private Date changeDate;

    /**
     * 变更原因
     */
    private String changeReason;

    /**
     * 单据类型
     */
    private String billTypeId;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 交货方式
     */
    private String deliveryWay;

    /**
     * 收货人姓名
     */
    private String receiveName;

    /**
     * 收货人地址
     */
    private String receiveAddress;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;
}

