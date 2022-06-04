package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Seat;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public interface ISeatService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param seatid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Seat selectSeatBySeatid(Long seatid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param seat 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Seat> selectSeatList(Seat seat);

    /**
     * 新增【请填写功能名称】
     * 
     * @param seat 【请填写功能名称】
     * @return 结果
     */
    public int insertSeat(Seat seat);

    /**
     * 修改【请填写功能名称】
     * 
     * @param seat 【请填写功能名称】
     * @return 结果
     */
    public int updateSeat(Seat seat);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param seatids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSeatBySeatids(Long[] seatids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param seatid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSeatBySeatid(Long seatid);
}
