package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TicketsMapper;
import com.ruoyi.system.domain.Tickets;
import com.ruoyi.system.service.ITicketsService;

/**
 * 订单管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-21
 */
@Service
public class TicketsServiceImpl implements ITicketsService 
{
    @Autowired
    private TicketsMapper ticketsMapper;

    /**
     * 查询订单管理
     * 
     * @param ticketId 订单管理主键
     * @return 订单管理
     */
    @Override
    public Tickets selectTicketsByTicketId(Long ticketId)
    {
        return ticketsMapper.selectTicketsByTicketId(ticketId);
    }

    /**
     * 查询订单管理列表
     * 
     * @param tickets 订单管理
     * @return 订单管理
     */
    @Override
    public List<Tickets> selectTicketsList(Tickets tickets)
    {
        return ticketsMapper.selectTicketsList(tickets);
    }

    /**
     * 新增订单管理
     * 
     * @param tickets 订单管理
     * @return 结果
     */
    @Override
    public int insertTickets(Tickets tickets)
    {
        return ticketsMapper.insertTickets(tickets);
    }

    /**
     * 修改订单管理
     * 
     * @param tickets 订单管理
     * @return 结果
     */
    @Override
    public int updateTickets(Tickets tickets)
    {
        return ticketsMapper.updateTickets(tickets);
    }

    /**
     * 批量删除订单管理
     * 
     * @param ticketIds 需要删除的订单管理主键
     * @return 结果
     */
    @Override
    public int deleteTicketsByTicketIds(Long[] ticketIds)
    {
        return ticketsMapper.deleteTicketsByTicketIds(ticketIds);
    }

    /**
     * 删除订单管理信息
     * 
     * @param ticketId 订单管理主键
     * @return 结果
     */
    @Override
    public int deleteTicketsByTicketId(Long ticketId)
    {
        return ticketsMapper.deleteTicketsByTicketId(ticketId);
    }
}
