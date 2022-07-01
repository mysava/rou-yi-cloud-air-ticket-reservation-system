package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 订单查询对象 ry_order
 * 
 * @author ruoyi
 * @date 2022-06-19
 */
public class RyOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单号 */
    private Long orderId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 航班号 */
    @Excel(name = "航班号")
    private String flightno;

    /** 出发时间 */
    @Excel(name = "出发时间")
    private String departtime;

    /** 出发日期 */
    @Excel(name = "出发日期")
    private String data;

    /** 支付金额 */
    @Excel(name = "支付金额")
    private String paymentamount;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setFlightno(String flightno) 
    {
        this.flightno = flightno;
    }

    public String getFlightno() 
    {
        return flightno;
    }
    public void setDeparttime(String departtime) 
    {
        this.departtime = departtime;
    }

    public String getDeparttime() 
    {
        return departtime;
    }
    public void setData(String data) 
    {
        this.data = data;
    }

    public String getData() 
    {
        return data;
    }
    public void setPaymentamount(String paymentamount) 
    {
        this.paymentamount = paymentamount;
    }

    public String getPaymentamount() 
    {
        return paymentamount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("userName", getUserName())
            .append("flightno", getFlightno())
            .append("departtime", getDeparttime())
            .append("data", getData())
            .append("paymentamount", getPaymentamount())
            .toString();
    }
}
