package com.heyue.wms.controller;

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
import com.heyue.common.log.annotation.Log;
import com.heyue.common.log.enums.BusinessType;
import com.heyue.common.security.annotation.PreAuthorize;
import com.heyue.wms.domain.WmsOrder;
import com.heyue.wms.service.IWmsOrderService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 仓储信息Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/wmsorder")
public class WmsOrderController extends BaseController
{
    @Autowired
    private IWmsOrderService wmsOrderService;

    /**
     * 查询仓储信息列表
     */
    @PreAuthorize(hasPermi = "wms:wmsorder:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsOrder wmsOrder)
    {
        startPage();
        List<WmsOrder> list = wmsOrderService.selectWmsOrderList(wmsOrder);
        return getDataTable(list);
    }

    /**
     * 导出仓储信息列表
     */
    @PreAuthorize(hasPermi = "wms:wmsorder:export")
    @Log(title = "仓储信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsOrder wmsOrder) throws IOException
    {
        List<WmsOrder> list = wmsOrderService.selectWmsOrderList(wmsOrder);
        ExcelUtil<WmsOrder> util = new ExcelUtil<WmsOrder>(WmsOrder.class);
        util.exportExcel(response, list, "仓储信息数据");
    }

    /**
     * 获取仓储信息详细信息
     */
    @PreAuthorize(hasPermi = "wms:wmsorder:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wmsOrderService.selectWmsOrderById(id));
    }

    /**
     * 新增仓储信息
     */
    @PreAuthorize(hasPermi = "wms:wmsorder:add")
    @Log(title = "仓储信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsOrder wmsOrder)
    {
        return toAjax(wmsOrderService.insertWmsOrder(wmsOrder));
    }

    /**
     * 修改仓储信息
     */
    @PreAuthorize(hasPermi = "wms:wmsorder:edit")
    @Log(title = "仓储信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsOrder wmsOrder)
    {
        return toAjax(wmsOrderService.updateWmsOrder(wmsOrder));
    }

    /**
     * 删除仓储信息
     */
    @PreAuthorize(hasPermi = "wms:wmsorder:remove")
    @Log(title = "仓储信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsOrderService.deleteWmsOrderByIds(ids));
    }
}
