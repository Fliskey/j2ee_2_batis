package cn.edu.xmu.restfuldemo.service;

import cn.edu.xmu.restfuldemo.dao.OrdersDao;
import cn.edu.xmu.restfuldemo.model.*;
import cn.edu.xmu.restfuldemo.util.ResponseCode;
import cn.edu.xmu.restfuldemo.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    public ReturnObject<VoObject> findById(Integer id) {
        OrdersPo queryObj = new OrdersPo();
        queryObj.setId(id);
        ReturnObject<VoObject> retOrders = null;
        ReturnObject<List<Orders>> returnObject = ordersDao.findOrders(queryObj,true);
        //ReturnObject<List<Goods>> returnObject = goodsDao.findGoodsWithProduct(queryObj);
        if (returnObject.getCode().equals(ResponseCode.OK)) {
            if (returnObject.getData().size() == 1) {
                retOrders = new ReturnObject<>(returnObject.getData().get(0));
            }else{
                retOrders = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST);
            }
        }else{
            retOrders = new ReturnObject<>(returnObject.getCode(), returnObject.getErrmsg());
        }
        return retOrders;
    }

    /**
     * 新增商品
     * @param ordersVo 新商品信息
     * @return 新商品
     */
    @Transactional
    public ReturnObject<VoObject> createOrders(OrdersVo ordersVo) {
       // logger.info("createOrders: ordersVo = " + ordersVo);
        Orders orders = ordersVo.createOrders();
       // logger.info("createOrders: goods = " + orders);
        ReturnObject<Orders> retObj = ordersDao.createOrders(orders);
        ReturnObject<VoObject> retOrders = null;
        if (retObj.getCode().equals(ResponseCode.OK)) {
            retOrders = new ReturnObject<>(retObj.getData());
        }else{
            retOrders = new ReturnObject<>(retObj.getCode(), retObj.getErrmsg());
        }
        //logger.info("createGoods: retGoods = " + retOrders.getData());
        return retOrders;
    }
}
