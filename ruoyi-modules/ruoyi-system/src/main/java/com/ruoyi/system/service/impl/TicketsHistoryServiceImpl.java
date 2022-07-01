package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TicketsHistoryMapper;
import com.ruoyi.system.domain.TicketsHistory;
import com.ruoyi.system.service.ITicketsHistoryService;

/**
 * 历史订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
@Service
public class TicketsHistoryServiceImpl implements ITicketsHistoryService 
{
    @Autowired
    private TicketsHistoryMapper ticketsHistoryMapper;

    /**
     * 查询历史订单
     * 
     * @param ticketId 历史订单主键
     * @return 历史订单
     */
    @Override
    public TicketsHistory selectTicketsHistoryByTicketId(Long ticketId)
    {
        return ticketsHistoryMapper.selectTicketsHistoryByTicketId(ticketId);
    }

    /**
     * 查询历史订单列表
     * 
     * @param ticketsHistory 历史订单
     * @return 历史订单
     */
    @Override
    public List<TicketsHistory> selectTicketsHistoryList(TicketsHistory ticketsHistory)
    {
        return ticketsHistoryMapper.selectTicketsHistoryList(ticketsHistory);
    }

    /**
     * 新增历史订单
     * 
     * @param ticketsHistory 历史订单
     * @return 结果
     */
    @Override
    public int insertTicketsHistory(TicketsHistory ticketsHistory)
    {
        return ticketsHistoryMapper.insertTicketsHistory(ticketsHistory);
    }

    /**
     * 修改历史订单
     * 
     * @param ticketsHistory 历史订单
     * @return 结果
     */
    @Override
    public int updateTicketsHistory(TicketsHistory ticketsHistory)
    {
        return ticketsHistoryMapper.updateTicketsHistory(ticketsHistory);
    }

    /**
     * 批量删除历史订单
     * 
     * @param ticketIds 需要删除的历史订单主键
     * @return 结果
     */
    @Override
    public int deleteTicketsHistoryByTicketIds(Long[] ticketIds)
    {
        return ticketsHistoryMapper.deleteTicketsHistoryByTicketIds(ticketIds);
    }

    /**
     * 删除历史订单信息
     * 
     * @param ticketId 历史订单主键
     * @return 结果
     */
    @Override
    public int deleteTicketsHistoryByTicketId(Long ticketId)
    {
        return ticketsHistoryMapper.deleteTicketsHistoryByTicketId(ticketId);
    }
}
