package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RyFlightAmend;

/**
 * 订单修改Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
public interface RyFlightAmendMapper 
{
    /**
     * 查询订单修改
     * 
     * @param flightid 订单修改主键
     * @return 订单修改
     */
    public RyFlightAmend selectRyFlightAmendByFlightid(Long flightid);

    /**
     * 查询订单修改列表
     * 
     * @param ryFlightAmend 订单修改
     * @return 订单修改集合
     */
    public List<RyFlightAmend> selectRyFlightAmendList(RyFlightAmend ryFlightAmend);

    /**
     * 新增订单修改
     * 
     * @param ryFlightAmend 订单修改
     * @return 结果
     */
    public int insertRyFlightAmend(RyFlightAmend ryFlightAmend);

    /**
     * 修改订单修改
     * 
     * @param ryFlightAmend 订单修改
     * @return 结果
     */
    public int updateRyFlightAmend(RyFlightAmend ryFlightAmend);

    /**
     * 删除订单修改
     * 
     * @param flightid 订单修改主键
     * @return 结果
     */
    public int deleteRyFlightAmendByFlightid(Long flightid);

    /**
     * 批量删除订单修改
     * 
     * @param flightids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRyFlightAmendByFlightids(Long[] flightids);
}
