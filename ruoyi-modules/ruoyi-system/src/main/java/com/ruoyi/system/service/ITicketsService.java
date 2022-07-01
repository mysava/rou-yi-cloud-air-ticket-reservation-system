package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Tickets;

/**
 * 订单管理Service接口
 * 
 * @author ruoyi
 * @date 2022-06-21
 */
public interface ITicketsService 
{
    /**
     * 查询订单管理
     * 
     * @param ticketId 订单管理主键
     * @return 订单管理
     */
    public Tickets selectTicketsByTicketId(Long ticketId);

    /**
     * 查询订单管理列表
     * 
     * @param tickets 订单管理
     * @return 订单管理集合
     */
    public List<Tickets> selectTicketsList(Tickets tickets);

    /**
     * 新增订单管理
     * 
     * @param tickets 订单管理
     * @return 结果
     */
    public int insertTickets(Tickets tickets);

    /**
     * 修改订单管理
     * 
     * @param tickets 订单管理
     * @return 结果
     */
    public int updateTickets(Tickets tickets);

    /**
     * 批量删除订单管理
     * 
     * @param ticketIds 需要删除的订单管理主键集合
     * @return 结果
     */
    public int deleteTicketsByTicketIds(Long[] ticketIds);

    /**
     * 删除订单管理信息
     * 
     * @param ticketId 订单管理主键
     * @return 结果
     */
    public int deleteTicketsByTicketId(Long ticketId);
}
