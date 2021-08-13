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
import com.heyue.wms.domain.Instore;
import com.heyue.wms.service.IInstoreService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 入库单Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/instore")
public class InstoreController extends BaseController
{
    @Autowired
    private IInstoreService instoreService;

    /**
     * 查询入库单列表
     */
    @PreAuthorize(hasPermi = "wms:instore:list")
    @GetMapping("/list")
    public TableDataInfo list(Instore instore)
    {
        startPage();
        List<Instore> list = instoreService.selectInstoreList(instore);
        return getDataTable(list);
    }

    /**
     * 导出入库单列表
     */
    @PreAuthorize(hasPermi = "wms:instore:export")
    @Log(title = "入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Instore instore) throws IOException
    {
        List<Instore> list = instoreService.selectInstoreList(instore);
        ExcelUtil<Instore> util = new ExcelUtil<Instore>(Instore.class);
        util.exportExcel(response, list, "入库单数据");
    }

    /**
     * 获取入库单详细信息
     */
    @PreAuthorize(hasPermi = "wms:instore:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(instoreService.selectInstoreById(id));
    }

    /**
     * 新增入库单
     */
    @PreAuthorize(hasPermi = "wms:instore:add")
    @Log(title = "入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Instore instore)
    {
        return toAjax(instoreService.insertInstore(instore));
    }

    /**
     * 修改入库单
     */
    @PreAuthorize(hasPermi = "wms:instore:edit")
    @Log(title = "入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Instore instore)
    {
        return toAjax(instoreService.updateInstore(instore));
    }

    /**
     * 删除入库单
     */
    @PreAuthorize(hasPermi = "wms:instore:remove")
    @Log(title = "入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(instoreService.deleteInstoreByIds(ids));
    }
}
