package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RyOrderMapper;
import com.ruoyi.system.domain.RyOrder;
import com.ruoyi.system.service.IRyOrderService;

/**
 * 订单查询Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-19
 */
@Service
public class RyOrderServiceImpl implements IRyOrderService 
{
    @Autowired
    private RyOrderMapper ryOrderMapper;

    /**
     * 查询订单查询
     * 
     * @param orderId 订单查询主键
     * @return 订单查询
     */
    @Override
    public RyOrder selectRyOrderByOrderId(Long orderId)
    {
        return ryOrderMapper.selectRyOrderByOrderId(orderId);
    }

    /**
     * 查询订单查询列表
     * 
     * @param ryOrder 订单查询
     * @return 订单查询
     */
    @Override
    public List<RyOrder> selectRyOrderList(RyOrder ryOrder)
    {
        return ryOrderMapper.selectRyOrderList(ryOrder);
    }

    /**
     * 新增订单查询
     * 
     * @param ryOrder 订单查询
     * @return 结果
     */
    @Override
    public int insertRyOrder(RyOrder ryOrder)
    {
        return ryOrderMapper.insertRyOrder(ryOrder);
    }

    /**
     * 修改订单查询
     * 
     * @param ryOrder 订单查询
     * @return 结果
     */
    @Override
    public int updateRyOrder(RyOrder ryOrder)
    {
        return ryOrderMapper.updateRyOrder(ryOrder);
    }

    /**
     * 批量删除订单查询
     * 
     * @param orderIds 需要删除的订单查询主键
     * @return 结果
     */
    @Override
    public int deleteRyOrderByOrderIds(Long[] orderIds)
    {
        return ryOrderMapper.deleteRyOrderByOrderIds(orderIds);
    }

    /**
     * 删除订单查询信息
     * 
     * @param orderId 订单查询主键
     * @return 结果
     */
    @Override
    public int deleteRyOrderByOrderId(Long orderId)
    {
        return ryOrderMapper.deleteRyOrderByOrderId(orderId);
    }
}
