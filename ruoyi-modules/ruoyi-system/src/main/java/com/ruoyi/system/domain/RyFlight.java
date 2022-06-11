package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 航班信息管理对象 ry_flight
 * 
 * @author ruoyi
 * @date 2022-06-10
 */
public class RyFlight extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 航班编号 */
    @Excel(name = "航班编号")
    private String flightno;

    /** 飞机类型 */
    @Excel(name = "飞机类型")
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

    /** 出发机场 */
    @Excel(name = "出发机场")
    private String departportname;

    /** 到达机场 */
    @Excel(name = "到达机场")
    private String arrivecityname;

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
    public void setDepartportname(String departportname) 
    {
        this.departportname = departportname;
    }

    public String getDepartportname() 
    {
        return departportname;
    }
    public void setArrivecityname(String arrivecityname) 
    {
        this.arrivecityname = arrivecityname;
    }

    public String getArrivecityname() 
    {
        return arrivecityname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("flightno", getFlightno())
            .append("aircrafttype", getAircrafttype())
            .append("departdate", getDepartdate())
            .append("departtime", getDeparttime())
            .append("arrivetime", getArrivetime())
            .append("departurecityname", getDeparturecityname())
            .append("departportname", getDepartportname())
            .append("arrivecityname", getArrivecityname())
            .toString();
    }
}
