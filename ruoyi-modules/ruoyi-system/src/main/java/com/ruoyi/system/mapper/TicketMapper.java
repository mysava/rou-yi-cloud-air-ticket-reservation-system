package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Ticket;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
public interface TicketMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param ticketid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Ticket selectTicketByTicketid(Long ticketid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ticket 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Ticket> selectTicketList(Ticket ticket);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ticket 【请填写功能名称】
     * @return 结果
     */
    public int insertTicket(Ticket ticket);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ticket 【请填写功能名称】
     * @return 结果
     */
    public int updateTicket(Ticket ticket);

    /**
     * 删除【请填写功能名称】
     * 
     * @param ticketid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTicketByTicketid(Long ticketid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ticketids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTicketByTicketids(Long[] ticketids);
}
