package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RyFlightAmendMapper;
import com.ruoyi.system.domain.RyFlightAmend;
import com.ruoyi.system.service.IRyFlightAmendService;

/**
 * 订单修改Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-29
 */
@Service
public class RyFlightAmendServiceImpl implements IRyFlightAmendService 
{
    @Autowired
    private RyFlightAmendMapper ryFlightAmendMapper;

    /**
     * 查询订单修改
     * 
     * @param flightid 订单修改主键
     * @return 订单修改
     */
    @Override
    public RyFlightAmend selectRyFlightAmendByFlightid(Long flightid)
    {
        return ryFlightAmendMapper.selectRyFlightAmendByFlightid(flightid);
    }

    /**
     * 查询订单修改列表
     * 
     * @param ryFlightAmend 订单修改
     * @return 订单修改
     */
    @Override
    public List<RyFlightAmend> selectRyFlightAmendList(RyFlightAmend ryFlightAmend)
    {
        return ryFlightAmendMapper.selectRyFlightAmendList(ryFlightAmend);
    }

    /**
     * 新增订单修改
     * 
     * @param ryFlightAmend 订单修改
     * @return 结果
     */
    @Override
    public int insertRyFlightAmend(RyFlightAmend ryFlightAmend)
    {
        return ryFlightAmendMapper.insertRyFlightAmend(ryFlightAmend);
    }

    /**
     * 修改订单修改
     * 
     * @param ryFlightAmend 订单修改
     * @return 结果
     */
    @Override
    public int updateRyFlightAmend(RyFlightAmend ryFlightAmend)
    {
        return ryFlightAmendMapper.updateRyFlightAmend(ryFlightAmend);
    }

    /**
     * 批量删除订单修改
     * 
     * @param flightids 需要删除的订单修改主键
     * @return 结果
     */
    @Override
    public int deleteRyFlightAmendByFlightids(Long[] flightids)
    {
        return ryFlightAmendMapper.deleteRyFlightAmendByFlightids(flightids);
    }

    /**
     * 删除订单修改信息
     * 
     * @param flightid 订单修改主键
     * @return 结果
     */
    @Override
    public int deleteRyFlightAmendByFlightid(Long flightid)
    {
        return ryFlightAmendMapper.deleteRyFlightAmendByFlightid(flightid);
    }
}
