package cn.edu.xmu.restfuldemo.dao;


import cn.edu.xmu.restfuldemo.mapper.GoodsMapper;
import cn.edu.xmu.restfuldemo.mapper.OrdersMapper;
import cn.edu.xmu.restfuldemo.model.*;
import cn.edu.xmu.restfuldemo.util.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static cn.edu.xmu.restfuldemo.util.Common.genSeqNum;

@Repository
public class OrdersDao {
    private Logger logger = LoggerFactory.getLogger(OrdersDao.class);

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 用GoodsPo对象找Goods对象
     * @param ordersPo 条件对象，所有条件为AND，仅有索引的值可以作为条件
     * @return  Orders对象列表
     */
    public ReturnObject<List<Orders>> findOrders(OrdersPo ordersPo,boolean withOrderItem){
        logger.info("findOrders: ordersPo =" + ordersPo);
        List<OrdersPo> ordersPos = ordersMapper.findOrders(ordersPo);
        logger.info("findOrders: ordersPos =" + ordersPos);
        List<Orders> retOrders = new ArrayList<>(ordersPos.size());
        OrderItemPo orderItemPo =null;
        if(withOrderItem)
        {
            orderItemPo=new OrderItemPo();
        }



        for (OrdersPo ordersItem : ordersPos){
            Orders item = new Orders(ordersItem);
            if(withOrderItem)
            {
                orderItemPo.setOrderId(ordersItem.getId());
                List<OrderItemPo> orderItemPos = ordersMapper.findOrderItem(orderItemPo);
//                logger.info("orderItemPos: "+orderItemPos );
                List<OrderItem> orderItemList = new ArrayList<>(orderItemPos.size());
                for(OrderItemPo orderItemPo1:orderItemPos)
                {
                    OrderItem orderItem = new OrderItem(orderItemPo1);
                    orderItemList.add(orderItem);
                }
                item.setOrderItems(orderItemList);

            }
            retOrders.add(item);

        }
        logger.info("findGoods: retGoods = "+retOrders );

        return new ReturnObject<>(retOrders);
    }


    public ReturnObject<Orders> createOrders(Orders orders){
        OrdersPo ordersPo = orders.gotOrdersPo();
        int ret = ordersMapper.createOrders(ordersPo);
        logger.info("findGoods: retGoods = "+orders.getOrderItems() );
        if (orders.getOrderItems() != null) {
            logger.info("findGoods: retGoods = "+orders.getOrderItems() );
            for (OrderItem orderItem : orders.getOrderItems()) {
                OrderItemPo orderItemPo = orderItem.getOrderItemPo();
                //productPo.setProductSn("P"+seqNum+"-"+productPo.getProductSn());
                //productPo.setGoodsId(goodsPo.getId());
                ret = ordersMapper.createOrderItem(orderItemPo);
            }
        }
        ReturnObject<Orders> returnObject = new ReturnObject<>(orders);
        return returnObject;
    }

}
