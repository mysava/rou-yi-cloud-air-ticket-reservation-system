package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.domain.Tickets;
import com.ruoyi.system.service.ITicketsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 机票管理Controller
 * 
 * @author ruoyi
 * @date 2022-06-22
 */
@RestController
@RequestMapping("/tickets")
public class TicketsController extends BaseController
{
    @Autowired
    private ITicketsService ticketsService;

    /**
     * 查询机票管理列表
     */
    @RequiresPermissions("system:tickets:list")
    @GetMapping("/list")
    public TableDataInfo list(Tickets tickets)
    {
        startPage();
        List<Tickets> list = ticketsService.selectTicketsList(tickets);
        return getDataTable(list);
    }

    /**
     * 导出机票管理列表
     */
    @RequiresPermissions("system:tickets:export")
    @Log(title = "机票管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tickets tickets)
    {
        List<Tickets> list = ticketsService.selectTicketsList(tickets);
        ExcelUtil<Tickets> util = new ExcelUtil<Tickets>(Tickets.class);
        util.exportExcel(response, list, "机票管理数据");
    }

    /**
     * 获取机票管理详细信息
     */
    @RequiresPermissions("system:tickets:query")
    @GetMapping(value = "/{ticketId}")
    public AjaxResult getInfo(@PathVariable("ticketId") Long ticketId)
    {
        return AjaxResult.success(ticketsService.selectTicketsByTicketId(ticketId));
    }

    /**
     * 新增机票管理
     */
    @RequiresPermissions("system:tickets:add")
    @Log(title = "机票管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tickets tickets)
    {
        return toAjax(ticketsService.insertTickets(tickets));
    }

    /**
     * 修改机票管理
     */
    @RequiresPermissions("system:tickets:edit")
    @Log(title = "机票管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tickets tickets)
    {
        return toAjax(ticketsService.updateTickets(tickets));
    }

    /**
     * 删除机票管理
     */
    @RequiresPermissions("system:tickets:remove")
    @Log(title = "机票管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ticketIds}")
    public AjaxResult remove(@PathVariable Long[] ticketIds)
    {
        return toAjax(ticketsService.deleteTicketsByTicketIds(ticketIds));
    }
}
