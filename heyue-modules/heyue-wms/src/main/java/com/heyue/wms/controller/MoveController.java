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
import com.heyue.wms.domain.Move;
import com.heyue.wms.service.IMoveService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 调拨单Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/move")
public class MoveController extends BaseController
{
    @Autowired
    private IMoveService moveService;

    /**
     * 查询调拨单列表
     */
    @PreAuthorize(hasPermi = "wms:move:list")
    @GetMapping("/list")
    public TableDataInfo list(Move move)
    {
        startPage();
        List<Move> list = moveService.selectMoveList(move);
        return getDataTable(list);
    }

    /**
     * 导出调拨单列表
     */
    @PreAuthorize(hasPermi = "wms:move:export")
    @Log(title = "调拨单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Move move) throws IOException
    {
        List<Move> list = moveService.selectMoveList(move);
        ExcelUtil<Move> util = new ExcelUtil<Move>(Move.class);
        util.exportExcel(response, list, "调拨单数据");
    }

    /**
     * 获取调拨单详细信息
     */
    @PreAuthorize(hasPermi = "wms:move:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(moveService.selectMoveById(id));
    }

    /**
     * 新增调拨单
     */
    @PreAuthorize(hasPermi = "wms:move:add")
    @Log(title = "调拨单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Move move)
    {
        return toAjax(moveService.insertMove(move));
    }

    /**
     * 修改调拨单
     */
    @PreAuthorize(hasPermi = "wms:move:edit")
    @Log(title = "调拨单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Move move)
    {
        return toAjax(moveService.updateMove(move));
    }

    /**
     * 删除调拨单
     */
    @PreAuthorize(hasPermi = "wms:move:remove")
    @Log(title = "调拨单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(moveService.deleteMoveByIds(ids));
    }
}
