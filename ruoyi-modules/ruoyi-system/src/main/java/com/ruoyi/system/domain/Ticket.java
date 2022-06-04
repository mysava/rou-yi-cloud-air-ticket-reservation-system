package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ticket
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public class Ticket extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 机票编号 */
    private Long ticketid;

    /** 航班编号 */
    @Excel(name = "航班编号")
    private Long flightid;

    /** 出发地 */
    @Excel(name = "出发地")
    private String departure;

    /** 出发时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出发时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departuretime;

    /** 空余票数 */
    @Excel(name = "空余票数")
    private String free;

    /** 座位号 */
    private Long seatid;

    /** 折扣 */
    @Excel(name = "折扣")
    private String discount;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 预订状态 */
    @Excel(name = "预订状态")
    private String book;

    /** 支付状态 */
    @Excel(name = "支付状态")
    private String buy;

    public void setTicketid(Long ticketid) 
    {
        this.ticketid = ticketid;
    }

    public Long getTicketid() 
    {
        return ticketid;
    }
    public void setFlightid(Long flightid) 
    {
        this.flightid = flightid;
    }

    public Long getFlightid() 
    {
        return flightid;
    }
    public void setDeparture(String departure) 
    {
        this.departure = departure;
    }

    public String getDeparture() 
    {
        return departure;
    }
    public void setDeparturetime(Date departuretime) 
    {
        this.departuretime = departuretime;
    }

    public Date getDeparturetime() 
    {
        return departuretime;
    }
    public void setFree(String free) 
    {
        this.free = free;
    }

    public String getFree() 
    {
        return free;
    }
    public void setSeatid(Long seatid) 
    {
        this.seatid = seatid;
    }

    public Long getSeatid() 
    {
        return seatid;
    }
    public void setDiscount(String discount) 
    {
        this.discount = discount;
    }

    public String getDiscount() 
    {
        return discount;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setBook(String book) 
    {
        this.book = book;
    }

    public String getBook() 
    {
        return book;
    }
    public void setBuy(String buy) 
    {
        this.buy = buy;
    }

    public String getBuy() 
    {
        return buy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ticketid", getTicketid())
            .append("flightid", getFlightid())
            .append("departure", getDeparture())
            .append("departuretime", getDeparturetime())
            .append("free", getFree())
            .append("seatid", getSeatid())
            .append("discount", getDiscount())
            .append("price", getPrice())
            .append("book", getBook())
            .append("buy", getBuy())
            .toString();
    }
}
