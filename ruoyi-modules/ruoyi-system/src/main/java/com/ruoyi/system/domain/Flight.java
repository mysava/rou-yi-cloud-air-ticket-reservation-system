package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 flight
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public class Flight extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 航班号 */
    private Long flightid;

    /** 飞机编号 */
    @Excel(name = "飞机编号")
    private Long aircraftid;

    /** 出发地 */
    @Excel(name = "出发地")
    private String departure;

    /** 目的地 */
    @Excel(name = "目的地")
    private String destination;

    /** 出发时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出发时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departuretime;

    /** 到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivaltime;

    /** 票价 */
    @Excel(name = "票价")
    private Long originalprice;

    /** 客容量 */
    @Excel(name = "客容量")
    private Long passengercapacity;

    public void setFlightid(Long flightid) 
    {
        this.flightid = flightid;
    }

    public Long getFlightid() 
    {
        return flightid;
    }
    public void setAircraftid(Long aircraftid) 
    {
        this.aircraftid = aircraftid;
    }

    public Long getAircraftid() 
    {
        return aircraftid;
    }
    public void setDeparture(String departure) 
    {
        this.departure = departure;
    }

    public String getDeparture() 
    {
        return departure;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getDestination() 
    {
        return destination;
    }
    public void setDeparturetime(Date departuretime) 
    {
        this.departuretime = departuretime;
    }

    public Date getDeparturetime() 
    {
        return departuretime;
    }
    public void setArrivaltime(Date arrivaltime) 
    {
        this.arrivaltime = arrivaltime;
    }

    public Date getArrivaltime() 
    {
        return arrivaltime;
    }
    public void setOriginalprice(Long originalprice) 
    {
        this.originalprice = originalprice;
    }

    public Long getOriginalprice() 
    {
        return originalprice;
    }
    public void setPassengercapacity(Long passengercapacity) 
    {
        this.passengercapacity = passengercapacity;
    }

    public Long getPassengercapacity() 
    {
        return passengercapacity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("flightid", getFlightid())
            .append("aircraftid", getAircraftid())
            .append("departure", getDeparture())
            .append("destination", getDestination())
            .append("departuretime", getDeparturetime())
            .append("arrivaltime", getArrivaltime())
            .append("originalprice", getOriginalprice())
            .append("passengercapacity", getPassengercapacity())
            .toString();
    }
}
