package cn.edu.xmu.restfuldemo.controller;


import cn.edu.xmu.restfuldemo.model.*;
import cn.edu.xmu.restfuldemo.service.GoodsService;
import cn.edu.xmu.restfuldemo.service.OrdersService;
import cn.edu.xmu.restfuldemo.util.ResponseCode;
import cn.edu.xmu.restfuldemo.util.ResponseUtil;
import cn.edu.xmu.restfuldemo.util.ReturnObject;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static cn.edu.xmu.restfuldemo.util.Common.getRetObject;
import static cn.edu.xmu.restfuldemo.util.Common.processFieldErrors;

@Api(value = "订单API", tags = "订单API")
@RestController /*Restful的Controller对象*/
@RequestMapping(value = "/orders", produces = "application/json;charset=UTF-8")
public class OrdersController {
    private final Logger logger = LoggerFactory.getLogger(OrdersController.class);
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @GetMapping("{id}")
    public Object getOrdersById(@PathVariable("id") Integer id) {
        ReturnObject<VoObject> returnObject =  ordersService.findById(id);
        ResponseCode code = returnObject.getCode();
        switch (code){
            case RESOURCE_ID_NOTEXIST:
                httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
                return ResponseUtil.fail(returnObject.getCode(), returnObject.getErrmsg());
            case OK:
                OrdersRetVo ordersRetVo = (OrdersRetVo) returnObject.getData().createVo();
                return ResponseUtil.ok(ordersRetVo);
            default:
                return ResponseUtil.fail(code);
        }
    }

    @PostMapping("")
    public Object createGood(@Validated @RequestBody OrdersVo ordersVo, BindingResult bindingResult){

        logger.info("findGoods: retGoods = "+ordersVo.getOrderItems() );
        Object returnObject = processFieldErrors(bindingResult, httpServletResponse);
        if (null != returnObject){
            return returnObject;
        }
        ReturnObject<VoObject> returnObject1 = ordersService.createOrders(ordersVo);
        httpServletResponse.setStatus(HttpStatus.CREATED.value());
        return getRetObject(returnObject1);
    }
}
