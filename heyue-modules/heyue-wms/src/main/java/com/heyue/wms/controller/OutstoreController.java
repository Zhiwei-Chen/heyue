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
import com.heyue.wms.domain.Outstore;
import com.heyue.wms.service.IOutstoreService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 出库单管理Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/outstore")
public class OutstoreController extends BaseController
{
    @Autowired
    private IOutstoreService outstoreService;

    /**
     * 查询出库单管理列表
     */
    @PreAuthorize(hasPermi = "wms:outstore:list")
    @GetMapping("/list")
    public TableDataInfo list(Outstore outstore)
    {
        startPage();
        List<Outstore> list = outstoreService.selectOutstoreList(outstore);
        return getDataTable(list);
    }

    /**
     * 导出出库单管理列表
     */
    @PreAuthorize(hasPermi = "wms:outstore:export")
    @Log(title = "出库单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Outstore outstore) throws IOException
    {
        List<Outstore> list = outstoreService.selectOutstoreList(outstore);
        ExcelUtil<Outstore> util = new ExcelUtil<Outstore>(Outstore.class);
        util.exportExcel(response, list, "出库单管理数据");
    }

    /**
     * 获取出库单管理详细信息
     */
    @PreAuthorize(hasPermi = "wms:outstore:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(outstoreService.selectOutstoreById(id));
    }

    /**
     * 新增出库单管理
     */
    @PreAuthorize(hasPermi = "wms:outstore:add")
    @Log(title = "出库单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Outstore outstore)
    {
        return toAjax(outstoreService.insertOutstore(outstore));
    }

    /**
     * 修改出库单管理
     */
    @PreAuthorize(hasPermi = "wms:outstore:edit")
    @Log(title = "出库单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Outstore outstore)
    {
        return toAjax(outstoreService.updateOutstore(outstore));
    }

    /**
     * 删除出库单管理
     */
    @PreAuthorize(hasPermi = "wms:outstore:remove")
    @Log(title = "出库单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(outstoreService.deleteOutstoreByIds(ids));
    }
}
