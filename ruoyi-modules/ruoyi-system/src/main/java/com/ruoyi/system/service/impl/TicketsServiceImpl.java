package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TicketsMapper;
import com.ruoyi.system.domain.Tickets;
import com.ruoyi.system.service.ITicketsService;

/**
 * 机票管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-22
 */
@Service
public class TicketsServiceImpl implements ITicketsService 
{
    @Autowired
    private TicketsMapper ticketsMapper;

    /**
     * 查询机票管理
     * 
     * @param ticketId 机票管理主键
     * @return 机票管理
     */
    @Override
    public Tickets selectTicketsByTicketId(Long ticketId)
    {
        return ticketsMapper.selectTicketsByTicketId(ticketId);
    }

    /**
     * 查询机票管理列表
     * 
     * @param tickets 机票管理
     * @return 机票管理
     */
    @Override
    public List<Tickets> selectTicketsList(Tickets tickets)
    {
        return ticketsMapper.selectTicketsList(tickets);
    }

    /**
     * 新增机票管理
     * 
     * @param tickets 机票管理
     * @return 结果
     */
    @Override
    public int insertTickets(Tickets tickets)
    {
        return ticketsMapper.insertTickets(tickets);
    }

    /**
     * 修改机票管理
     * 
     * @param tickets 机票管理
     * @return 结果
     */
    @Override
    public int updateTickets(Tickets tickets)
    {
        return ticketsMapper.updateTickets(tickets);
    }

    /**
     * 批量删除机票管理
     * 
     * @param ticketIds 需要删除的机票管理主键
     * @return 结果
     */
    @Override
    public int deleteTicketsByTicketIds(Long[] ticketIds)
    {
        return ticketsMapper.deleteTicketsByTicketIds(ticketIds);
    }

    /**
     * 删除机票管理信息
     * 
     * @param ticketId 机票管理主键
     * @return 结果
     */
    @Override
    public int deleteTicketsByTicketId(Long ticketId)
    {
        return ticketsMapper.deleteTicketsByTicketId(ticketId);
    }
}
