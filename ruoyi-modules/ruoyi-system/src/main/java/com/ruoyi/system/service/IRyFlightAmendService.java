package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RyFlightAmend;

/**
 * 订单修改Service接口
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
public interface IRyFlightAmendService 
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
     * 批量删除订单修改
     * 
     * @param flightids 需要删除的订单修改主键集合
     * @return 结果
     */
    public int deleteRyFlightAmendByFlightids(Long[] flightids);

    /**
     * 删除订单修改信息
     * 
     * @param flightid 订单修改主键
     * @return 结果
     */
    public int deleteRyFlightAmendByFlightid(Long flightid);
}
