package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 seat
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public class Seat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 座位号 */
    private Long seatid;

    /** 乘客姓名 */
    @Excel(name = "乘客姓名")
    private String name;

    /** 乘客身份证 */
    @Excel(name = "乘客身份证")
    private String idcard;

    /** 乘客电话 */
    @Excel(name = "乘客电话")
    private String phone;

    public void setSeatid(Long seatid) 
    {
        this.seatid = seatid;
    }

    public Long getSeatid() 
    {
        return seatid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIdcard(String idcard) 
    {
        this.idcard = idcard;
    }

    public String getIdcard() 
    {
        return idcard;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("seatid", getSeatid())
            .append("name", getName())
            .append("idcard", getIdcard())
            .append("phone", getPhone())
            .toString();
    }
}
