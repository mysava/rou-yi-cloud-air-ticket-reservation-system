package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TicketMapper;
import com.ruoyi.system.domain.Ticket;
import com.ruoyi.system.service.ITicketService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@Service
public class TicketServiceImpl implements ITicketService 
{
    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param ticketid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Ticket selectTicketByTicketid(Long ticketid)
    {
        return ticketMapper.selectTicketByTicketid(ticketid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ticket 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Ticket> selectTicketList(Ticket ticket)
    {
        return ticketMapper.selectTicketList(ticket);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ticket 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTicket(Ticket ticket)
    {
        return ticketMapper.insertTicket(ticket);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ticket 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTicket(Ticket ticket)
    {
        return ticketMapper.updateTicket(ticket);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ticketids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTicketByTicketids(Long[] ticketids)
    {
        return ticketMapper.deleteTicketByTicketids(ticketids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param ticketid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTicketByTicketid(Long ticketid)
    {
        return ticketMapper.deleteTicketByTicketid(ticketid);
    }
}
