package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 航班管理对象 ry_flight
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
public class RyFlight extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long flightid;

    /** 航班编号 */
    @Excel(name = "航班编号")
    private String flightno;

    /** 飞机型号 */
    @Excel(name = "飞机型号")
    private String aircrafttype;

    /** 出发日期 */
    @Excel(name = "出发日期")
    private String departdate;

    /** 出发时间 */
    @Excel(name = "出发时间")
    private String departtime;

    /** 到达时间 */
    @Excel(name = "到达时间")
    private String arrivetime;

    /** 出发城市 */
    @Excel(name = "出发城市")
    private String departurecityname;

    /** 到达城市 */
    @Excel(name = "到达城市")
    private String arrivecityname;

    /** 商务舱数量 */
    @Excel(name = "商务舱数量")
    private Long vipNum;

    /** 普通舱数量 */
    @Excel(name = "普通舱数量")
    private Long comNum;

    /** 商务舱价格 */
    @Excel(name = "商务舱价格")
    private String vipPrice;

    /** 普通舱价格 */
    @Excel(name = "普通舱价格")
    private String comPrice;

    /** 剩余商务舱 */
    @Excel(name = "剩余商务舱")
    private Long vipNumChange;

    /** 剩余普通舱 */
    @Excel(name = "剩余普通舱")
    private Long comNumChange;

    public void setFlightid(Long flightid) 
    {
        this.flightid = flightid;
    }

    public Long getFlightid() 
    {
        return flightid;
    }
    public void setFlightno(String flightno) 
    {
        this.flightno = flightno;
    }

    public String getFlightno() 
    {
        return flightno;
    }
    public void setAircrafttype(String aircrafttype) 
    {
        this.aircrafttype = aircrafttype;
    }

    public String getAircrafttype() 
    {
        return aircrafttype;
    }
    public void setDepartdate(String departdate) 
    {
        this.departdate = departdate;
    }

    public String getDepartdate() 
    {
        return departdate;
    }
    public void setDeparttime(String departtime) 
    {
        this.departtime = departtime;
    }

    public String getDeparttime() 
    {
        return departtime;
    }
    public void setArrivetime(String arrivetime) 
    {
        this.arrivetime = arrivetime;
    }

    public String getArrivetime() 
    {
        return arrivetime;
    }
    public void setDeparturecityname(String departurecityname) 
    {
        this.departurecityname = departurecityname;
    }

    public String getDeparturecityname() 
    {
        return departurecityname;
    }
    public void setArrivecityname(String arrivecityname) 
    {
        this.arrivecityname = arrivecityname;
    }

    public String getArrivecityname() 
    {
        return arrivecityname;
    }
    public void setVipNum(Long vipNum) 
    {
        this.vipNum = vipNum;
    }

    public Long getVipNum() 
    {
        return vipNum;
    }
    public void setComNum(Long comNum) 
    {
        this.comNum = comNum;
    }

    public Long getComNum() 
    {
        return comNum;
    }
    public void setVipPrice(String vipPrice) 
    {
        this.vipPrice = vipPrice;
    }

    public String getVipPrice() 
    {
        return vipPrice;
    }
    public void setComPrice(String comPrice) 
    {
        this.comPrice = comPrice;
    }

    public String getComPrice() 
    {
        return comPrice;
    }
    public void setVipNumChange(Long vipNumChange) 
    {
        this.vipNumChange = vipNumChange;
    }

    public Long getVipNumChange() 
    {
        return vipNumChange;
    }
    public void setComNumChange(Long comNumChange) 
    {
        this.comNumChange = comNumChange;
    }

    public Long getComNumChange() 
    {
        return comNumChange;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("flightid", getFlightid())
            .append("flightno", getFlightno())
            .append("aircrafttype", getAircrafttype())
            .append("departdate", getDepartdate())
            .append("departtime", getDeparttime())
            .append("arrivetime", getArrivetime())
            .append("departurecityname", getDeparturecityname())
            .append("arrivecityname", getArrivecityname())
            .append("vipNum", getVipNum())
            .append("comNum", getComNum())
            .append("vipPrice", getVipPrice())
            .append("comPrice", getComPrice())
            .append("vipNumChange", getVipNumChange())
            .append("comNumChange", getComNumChange())
            .toString();
    }
}
