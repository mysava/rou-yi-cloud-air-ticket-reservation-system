package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 地区对象 city
 * 
 * @author ruoyi
 * @date 2022-05-30
 */
public class City extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 地区描述 */
    @Excel(name = "地区描述")
    private String areaName;

    /** 上级id */
    @Excel(name = "上级id")
    private Long parentId;

    /** 地区简称描述 */
    @Excel(name = "地区简称描述")
    private String areaShortName;

    /** 级别 */
    @Excel(name = "级别")
    private Long level;

    /** 地区编码 */
    @Excel(name = "地区编码")
    private String areaCode;

    /** 地区邮编 */
    @Excel(name = "地区邮编")
    private String zipCode;

    /** 地区组合描述 */
    @Excel(name = "地区组合描述")
    private String areaMergerName;

    /** 拼音 */
    @Excel(name = "拼音")
    private String pinyin;

    /** 拼音首字母 */
    @Excel(name = "拼音首字母")
    private String pinyinFirst;

    /** 经度 */
    @Excel(name = "经度")
    private String lng;

    /** 纬度 */
    @Excel(name = "纬度")
    private String lat;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

    /** 修改人id */
    @Excel(name = "修改人id")
    private Long modifyUserId;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setAreaShortName(String areaShortName) 
    {
        this.areaShortName = areaShortName;
    }

    public String getAreaShortName() 
    {
        return areaShortName;
    }
    public void setLevel(Long level) 
    {
        this.level = level;
    }

    public Long getLevel() 
    {
        return level;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }
    public void setZipCode(String zipCode) 
    {
        this.zipCode = zipCode;
    }

    public String getZipCode() 
    {
        return zipCode;
    }
    public void setAreaMergerName(String areaMergerName) 
    {
        this.areaMergerName = areaMergerName;
    }

    public String getAreaMergerName() 
    {
        return areaMergerName;
    }
    public void setPinyin(String pinyin) 
    {
        this.pinyin = pinyin;
    }

    public String getPinyin() 
    {
        return pinyin;
    }
    public void setPinyinFirst(String pinyinFirst) 
    {
        this.pinyinFirst = pinyinFirst;
    }

    public String getPinyinFirst() 
    {
        return pinyinFirst;
    }
    public void setLng(String lng) 
    {
        this.lng = lng;
    }

    public String getLng() 
    {
        return lng;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
    }
    public void setModifyUserId(Long modifyUserId) 
    {
        this.modifyUserId = modifyUserId;
    }

    public Long getModifyUserId() 
    {
        return modifyUserId;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaName", getAreaName())
            .append("parentId", getParentId())
            .append("areaShortName", getAreaShortName())
            .append("level", getLevel())
            .append("areaCode", getAreaCode())
            .append("zipCode", getZipCode())
            .append("areaMergerName", getAreaMergerName())
            .append("pinyin", getPinyin())
            .append("pinyinFirst", getPinyinFirst())
            .append("lng", getLng())
            .append("lat", getLat())
            .append("createUserId", getCreateUserId())
            .append("modifyUserId", getModifyUserId())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .toString();
    }
}
