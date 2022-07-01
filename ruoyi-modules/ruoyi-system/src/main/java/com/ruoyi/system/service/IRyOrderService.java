package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RyOrder;

/**
 * 订单查询Service接口
 * 
 * @author ruoyi
 * @date 2022-06-19
 */
public interface IRyOrderService 
{
    /**
     * 查询订单查询
     * 
     * @param orderId 订单查询主键
     * @return 订单查询
     */
    public RyOrder selectRyOrderByOrderId(Long orderId);

    /**
     * 查询订单查询列表
     * 
     * @param ryOrder 订单查询
     * @return 订单查询集合
     */
    public List<RyOrder> selectRyOrderList(RyOrder ryOrder);

    /**
     * 新增订单查询
     * 
     * @param ryOrder 订单查询
     * @return 结果
     */
    public int insertRyOrder(RyOrder ryOrder);

    /**
     * 修改订单查询
     * 
     * @param ryOrder 订单查询
     * @return 结果
     */
    public int updateRyOrder(RyOrder ryOrder);

    /**
     * 批量删除订单查询
     * 
     * @param orderIds 需要删除的订单查询主键集合
     * @return 结果
     */
    public int deleteRyOrderByOrderIds(Long[] orderIds);

    /**
     * 删除订单查询信息
     * 
     * @param orderId 订单查询主键
     * @return 结果
     */
    public int deleteRyOrderByOrderId(Long orderId);
}
