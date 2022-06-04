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
import com.ruoyi.system.domain.Ticket;
import com.ruoyi.system.service.ITicketService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-06-04
 */
@RestController
@RequestMapping("/ticket")
public class TicketController extends BaseController
{
    @Autowired
    private ITicketService ticketService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:ticket:list")
    @GetMapping("/list")
    public TableDataInfo list(Ticket ticket)
    {
        startPage();
        List<Ticket> list = ticketService.selectTicketList(ticket);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:ticket:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Ticket ticket)
    {
        List<Ticket> list = ticketService.selectTicketList(ticket);
        ExcelUtil<Ticket> util = new ExcelUtil<Ticket>(Ticket.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("system:ticket:query")
    @GetMapping(value = "/{ticketid}")
    public AjaxResult getInfo(@PathVariable("ticketid") Long ticketid)
    {
        return AjaxResult.success(ticketService.selectTicketByTicketid(ticketid));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("system:ticket:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Ticket ticket)
    {
        return toAjax(ticketService.insertTicket(ticket));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:ticket:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Ticket ticket)
    {
        return toAjax(ticketService.updateTicket(ticket));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:ticket:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ticketids}")
    public AjaxResult remove(@PathVariable Long[] ticketids)
    {
        return toAjax(ticketService.deleteTicketByTicketids(ticketids));
    }
}
