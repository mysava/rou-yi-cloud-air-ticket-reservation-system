package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 历史订单对象 tickets_history
 *
 * @author ruoyi
 * @date 2022-06-29
 */
public class TicketsHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 机票编号 */
    private Long ticketId;

    /** 编号 */
    @Excel(name = "编号")
    private String flightid;

    /** 乘客姓名 */
    @Excel(name = "乘客姓名")
    private String pname;

    /** 航班编号 */
    @Excel(name = "航班编号")
    private String fno;

    /** 座舱等级 */
    @Excel(name = "座舱等级")
    private String level;

    /** 出发时间 */
    @Excel(name = "出发时间")
    private String dtime;

    /** 出发城市 */
    @Excel(name = "出发城市")
    private String dcity;

    /** 到达时间 */
    @Excel(name = "到达时间")
    private String atime;

    /** 到达城市 */
    @Excel(name = "到达城市")
    private String acity;

    /** 价格 */
    @Excel(name = "价格")
    private String price;

    /** 座位号 */
    @Excel(name = "座位号")
    private String seat;

    public void setTicketId(Long ticketId)
    {
        this.ticketId = ticketId;
    }

    public Long getTicketId()
    {
        return ticketId;
    }
    public void setFlightid(String flightid)
    {
        this.flightid = flightid;
    }

    public String getFlightid()
    {
        return flightid;
    }
    public void setPname(String pname)
    {
        this.pname = pname;
    }

    public String getPname()
    {
        return pname;
    }
    public void setFno(String fno)
    {
        this.fno = fno;
    }

    public String getFno()
    {
        return fno;
    }
    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getLevel()
    {
        return level;
    }
    public void setDtime(String dtime)
    {
        this.dtime = dtime;
    }

    public String getDtime()
    {
        return dtime;
    }
    public void setDcity(String dcity)
    {
        this.dcity = dcity;
    }

    public String getDcity()
    {
        return dcity;
    }
    public void setAtime(String atime)
    {
        this.atime = atime;
    }

    public String getAtime()
    {
        return atime;
    }
    public void setAcity(String acity)
    {
        this.acity = acity;
    }

    public String getAcity()
    {
        return acity;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getPrice()
    {
        return price;
    }
    public void setSeat(String seat)
    {
        this.seat = seat;
    }

    public String getSeat()
    {
        return seat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("ticketId", getTicketId())
                .append("flightid", getFlightid())
                .append("pname", getPname())
                .append("fno", getFno())
                .append("level", getLevel())
                .append("dtime", getDtime())
                .append("dcity", getDcity())
                .append("atime", getAtime())
                .append("acity", getAcity())
                .append("price", getPrice())
                .append("seat", getSeat())
                .toString();
    }
}
