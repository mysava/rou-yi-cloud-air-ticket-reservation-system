package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Tickets;

/**
 * 机票管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-22
 */
public interface TicketsMapper 
{
    /**
     * 查询机票管理
     * 
     * @param ticketId 机票管理主键
     * @return 机票管理
     */
    public Tickets selectTicketsByTicketId(Long ticketId);

    /**
     * 查询机票管理列表
     * 
     * @param tickets 机票管理
     * @return 机票管理集合
     */
    public List<Tickets> selectTicketsList(Tickets tickets);

    /**
     * 新增机票管理
     * 
     * @param tickets 机票管理
     * @return 结果
     */
    public int insertTickets(Tickets tickets);

    /**
     * 修改机票管理
     * 
     * @param tickets 机票管理
     * @return 结果
     */
    public int updateTickets(Tickets tickets);

    /**
     * 删除机票管理
     * 
     * @param ticketId 机票管理主键
     * @return 结果
     */
    public int deleteTicketsByTicketId(Long ticketId);

    /**
     * 批量删除机票管理
     * 
     * @param ticketIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTicketsByTicketIds(Long[] ticketIds);
}
