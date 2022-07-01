package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TicketsHistory;

/**
 * 历史订单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
public interface TicketsHistoryMapper 
{
    /**
     * 查询历史订单
     * 
     * @param ticketId 历史订单主键
     * @return 历史订单
     */
    public TicketsHistory selectTicketsHistoryByTicketId(Long ticketId);

    /**
     * 查询历史订单列表
     * 
     * @param ticketsHistory 历史订单
     * @return 历史订单集合
     */
    public List<TicketsHistory> selectTicketsHistoryList(TicketsHistory ticketsHistory);

    /**
     * 新增历史订单
     * 
     * @param ticketsHistory 历史订单
     * @return 结果
     */
    public int insertTicketsHistory(TicketsHistory ticketsHistory);

    /**
     * 修改历史订单
     * 
     * @param ticketsHistory 历史订单
     * @return 结果
     */
    public int updateTicketsHistory(TicketsHistory ticketsHistory);

    /**
     * 删除历史订单
     * 
     * @param ticketId 历史订单主键
     * @return 结果
     */
    public int deleteTicketsHistoryByTicketId(Long ticketId);

    /**
     * 批量删除历史订单
     * 
     * @param ticketIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTicketsHistoryByTicketIds(Long[] ticketIds);
}
