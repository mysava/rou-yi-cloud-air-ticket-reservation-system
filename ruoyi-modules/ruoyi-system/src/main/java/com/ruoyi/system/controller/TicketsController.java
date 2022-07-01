package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.RyFlight;
import com.ruoyi.system.domain.TicketsHistory;
import com.ruoyi.system.service.IRyFlightReserveService;
import com.ruoyi.system.service.IRyFlightService;
import com.ruoyi.system.service.ITicketsHistoryService;
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
 * 订单管理Controller
 * 
 * @author ruoyi
 * @date 2022-06-21
 */
@RestController
@RequestMapping("/tickets")
public class TicketsController extends BaseController
{
    @Autowired
    private ITicketsService ticketsService;

    @Autowired
    private ITicketsHistoryService ticketsHistoryService;

    @Autowired
    private IRyFlightReserveService ryFlightReserveService;

    /**
     * 查询订单管理列表
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
     * 导出订单管理列表
     */
    @RequiresPermissions("system:tickets:export")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tickets tickets)
    {
        List<Tickets> list = ticketsService.selectTicketsList(tickets);
        ExcelUtil<Tickets> util = new ExcelUtil<Tickets>(Tickets.class);
        util.exportExcel(response, list, "订单管理数据");
    }

    /**
     * 获取订单管理详细信息
     */
//    @RequiresPermissions("system:tickets:query")
//    @GetMapping(value = "/{ticketId}")
//    public AjaxResult getInfo(@PathVariable("ticketId") Long ticketId)
//    {
//        return AjaxResult.success(ticketsService.selectTicketsByTicketId(ticketId));
//    }

    /**
     * 新增订单管理
     */
    @RequiresPermissions("system:tickets:add")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping(value = "/{flightid}")
    public AjaxResult add(@RequestBody Tickets tickets,@PathVariable("flightid") String flightid)
    {
       String level = tickets.getLevel();
       if (Objects.equals(level, "商务舱")){
           ryFlightReserveService.updatevipsubtract(flightid);
       }else if (Objects.equals(level,"经济舱")){
           ryFlightReserveService.updatecomsubtract(flightid);
       }
        return toAjax(ticketsService.insertTickets(tickets));
    }


    @RequiresPermissions("system:tickets:alter")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping(value = "/alter/{ticketId}")
    public AjaxResult alter(@RequestBody Tickets tickets,@PathVariable("ticketId") String ticketId)
    {
        Tickets  ticket=ticketsService.selectTicketsByTicketId(Long.valueOf(ticketId));
        String flightid1=ticket.getFlightid();
        String level1 = ticket.getLevel();

        ticketsHistoryService.insertTicketsHistory(ticket);
        ticketsService.deleteTicketsByTicketId(Long.valueOf(ticketId));
        if (Objects.equals(level1, "商务舱")){
            ryFlightReserveService.updatevipadd(flightid1);
        }else if (Objects.equals(level1,"经济舱")){
            ryFlightReserveService.updatecomadd(flightid1);
        }

        String flightid=tickets.getFlightid();
        String level = tickets.getLevel();
        if (Objects.equals(level, "商务舱")){
            ryFlightReserveService.updatevipsubtract(flightid);
        }else if (Objects.equals(level,"经济舱")){
            ryFlightReserveService.updatecomsubtract(flightid);
        }

        return toAjax(ticketsService.insertTickets(tickets));
    }

    /**
     * 修改订单管理
     */
    @RequiresPermissions("system:tickets:edit")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tickets tickets)
    {

        return toAjax(ticketsService.updateTickets(tickets));
    }

    /**
     * 删除订单管理
     */
    @RequiresPermissions("system:tickets:remove")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ticketIds}")
    public AjaxResult remove(@PathVariable Long[] ticketIds)
    {
        return toAjax(ticketsService.deleteTicketsByTicketIds(ticketIds));
    }
}
