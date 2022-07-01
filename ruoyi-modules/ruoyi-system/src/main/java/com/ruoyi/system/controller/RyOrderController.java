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
import com.ruoyi.system.domain.RyOrder;
import com.ruoyi.system.service.IRyOrderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单查询Controller
 * 
 * @author ruoyi
 * @date 2022-06-19
 */
@RestController
@RequestMapping("/order")
public class RyOrderController extends BaseController
{
    @Autowired
    private IRyOrderService ryOrderService;

    /**
     * 查询订单查询列表
     */
    @RequiresPermissions("system:order:list")
    @GetMapping("/list")
    public TableDataInfo list(RyOrder ryOrder)
    {
        startPage();
        List<RyOrder> list = ryOrderService.selectRyOrderList(ryOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单查询列表
     */
    @RequiresPermissions("system:order:export")
    @Log(title = "订单查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RyOrder ryOrder)
    {
        List<RyOrder> list = ryOrderService.selectRyOrderList(ryOrder);
        ExcelUtil<RyOrder> util = new ExcelUtil<RyOrder>(RyOrder.class);
        util.exportExcel(response, list, "订单查询数据");
    }

    /**
     * 获取订单查询详细信息
     */
    @RequiresPermissions("system:order:query")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(ryOrderService.selectRyOrderByOrderId(orderId));
    }

    /**
     * 新增订单查询
     */
    @RequiresPermissions("system:order:add")
    @Log(title = "订单查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RyOrder ryOrder)
    {
        System.out.println("hello");
        return toAjax(ryOrderService.insertRyOrder(ryOrder));
    }

    /**
     * 修改订单查询
     */
    @RequiresPermissions("system:order:edit")
    @Log(title = "订单查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RyOrder ryOrder)
    {
        return toAjax(ryOrderService.updateRyOrder(ryOrder));
    }

    /**
     * 删除订单查询
     */
    @RequiresPermissions("system:order:remove")
    @Log(title = "订单查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(ryOrderService.deleteRyOrderByOrderIds(orderIds));
    }
}
