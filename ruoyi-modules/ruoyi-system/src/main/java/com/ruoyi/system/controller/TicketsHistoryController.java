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
import com.ruoyi.system.domain.TicketsHistory;
import com.ruoyi.system.service.ITicketsHistoryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 历史订单Controller
 * 
 * @author ruoyi
 * @date 2022-06-28
 */
@RestController
@RequestMapping("/history")
public class TicketsHistoryController extends BaseController
{
    @Autowired
    private ITicketsHistoryService ticketsHistoryService;

    /**
     * 查询历史订单列表
     */
    @RequiresPermissions("system:history:list")
    @GetMapping("/list")
    public TableDataInfo list(TicketsHistory ticketsHistory)
    {
        startPage();
        List<TicketsHistory> list = ticketsHistoryService.selectTicketsHistoryList(ticketsHistory);
        return getDataTable(list);
    }

    /**
     * 导出历史订单列表
     */
    @RequiresPermissions("system:history:export")
    @Log(title = "历史订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TicketsHistory ticketsHistory)
    {
        List<TicketsHistory> list = ticketsHistoryService.selectTicketsHistoryList(ticketsHistory);
        ExcelUtil<TicketsHistory> util = new ExcelUtil<TicketsHistory>(TicketsHistory.class);
        util.exportExcel(response, list, "历史订单数据");
    }

    /**
     * 获取历史订单详细信息
     */
    @RequiresPermissions("system:history:query")
    @GetMapping(value = "/{ticketId}")
    public AjaxResult getInfo(@PathVariable("ticketId") Long ticketId)
    {
        return AjaxResult.success(ticketsHistoryService.selectTicketsHistoryByTicketId(ticketId));
    }

    /**
     * 新增历史订单
     */
    @RequiresPermissions("system:history:add")
    @Log(title = "历史订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TicketsHistory ticketsHistory)
    {
        return toAjax(ticketsHistoryService.insertTicketsHistory(ticketsHistory));
    }

    /**
     * 修改历史订单
     */
    @RequiresPermissions("system:history:edit")
    @Log(title = "历史订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TicketsHistory ticketsHistory)
    {
        return toAjax(ticketsHistoryService.updateTicketsHistory(ticketsHistory));
    }

    /**
     * 删除历史订单
     */
    @RequiresPermissions("system:history:remove")
    @Log(title = "历史订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ticketIds}")
    public AjaxResult remove(@PathVariable Long[] ticketIds)
    {
        return toAjax(ticketsHistoryService.deleteTicketsHistoryByTicketIds(ticketIds));
    }
}
