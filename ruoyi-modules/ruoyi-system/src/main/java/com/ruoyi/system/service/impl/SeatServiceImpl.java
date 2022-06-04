package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SeatMapper;
import com.ruoyi.system.domain.Seat;
import com.ruoyi.system.service.ISeatService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@Service
public class SeatServiceImpl implements ISeatService 
{
    @Autowired
    private SeatMapper seatMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param seatid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Seat selectSeatBySeatid(Long seatid)
    {
        return seatMapper.selectSeatBySeatid(seatid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param seat 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Seat> selectSeatList(Seat seat)
    {
        return seatMapper.selectSeatList(seat);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param seat 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSeat(Seat seat)
    {
        return seatMapper.insertSeat(seat);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param seat 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSeat(Seat seat)
    {
        return seatMapper.updateSeat(seat);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param seatids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSeatBySeatids(Long[] seatids)
    {
        return seatMapper.deleteSeatBySeatids(seatids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param seatid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSeatBySeatid(Long seatid)
    {
        return seatMapper.deleteSeatBySeatid(seatid);
    }
}
