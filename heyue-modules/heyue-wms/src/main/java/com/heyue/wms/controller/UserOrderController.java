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
import com.heyue.wms.domain.UserOrder;
import com.heyue.wms.service.IUserOrderService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 用户订单Controller
 * 
 * @author wchu
 * @date 2021-08-10
 */
@RestController
@RequestMapping("/userorder")
public class UserOrderController extends BaseController
{
    @Autowired
    private IUserOrderService userOrderService;

    /**
     * 查询用户订单列表
     */
    @PreAuthorize(hasPermi = "wms:userorder:list")
    @GetMapping("/list")
    public TableDataInfo list(UserOrder userOrder)
    {
        startPage();
        List<UserOrder> list = userOrderService.selectUserOrderList(userOrder);
        return getDataTable(list);
    }

    /**
     * 导出用户订单列表
     */
    @PreAuthorize(hasPermi = "wms:userorder:export")
    @Log(title = "用户订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserOrder userOrder) throws IOException
    {
        List<UserOrder> list = userOrderService.selectUserOrderList(userOrder);
        ExcelUtil<UserOrder> util = new ExcelUtil<UserOrder>(UserOrder.class);
        util.exportExcel(response, list, "用户订单数据");
    }

    /**
     * 获取用户订单详细信息
     */
    @PreAuthorize(hasPermi = "wms:userorder:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userOrderService.selectUserOrderById(id));
    }

    /**
     * 新增用户订单
     */
    @PreAuthorize(hasPermi = "wms:userorder:add")
    @Log(title = "用户订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserOrder userOrder)
    {
        return toAjax(userOrderService.insertUserOrder(userOrder));
    }

    /**
     * 修改用户订单
     */
    @PreAuthorize(hasPermi = "wms:userorder:edit")
    @Log(title = "用户订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserOrder userOrder)
    {
        return toAjax(userOrderService.updateUserOrder(userOrder));
    }

    /**
     * 删除用户订单
     */
    @PreAuthorize(hasPermi = "wms:userorder:remove")
    @Log(title = "用户订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userOrderService.deleteUserOrderByIds(ids));
    }
}
