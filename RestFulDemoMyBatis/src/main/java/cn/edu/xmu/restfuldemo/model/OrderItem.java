package cn.edu.xmu.restfuldemo.model;

import java.time.LocalDateTime;

public class OrderItem implements VoObject{

//    代理对象
    private OrderItemPo orderItemPo;
    //构造函数
    public OrderItem()
    {
        this.orderItemPo = new OrderItemPo();
    }
    public OrderItem(OrderItemPo orderItemPo)
    {
        this.orderItemPo = orderItemPo;
    }

    /**
     * 由OrderItem对象创建Vo对象
     */
    @Override
    public Object createVo(){
        return new OrderItemRetVo(this);
    }

    public OrderItemPo getOrderItemPo() {
        return orderItemPo;
    }

    public void setOrderItemPo(OrderItemPo orderItemPo) {
        this.orderItemPo = orderItemPo;
    }

    /**
     * 获得内部的代理对象
     * @return OrderItemPo对象
     */
    public Integer getId() {
        return orderItemPo.getId();
    }

    public void setId(Integer id) {
        orderItemPo.setId(id);
    }

    public Integer getOrderId() {
        return orderItemPo.getOrderId();
    }

    public void setOrderId(Integer orderId) {
        orderItemPo.setOrderId(orderId);
    }

    public Integer getGoodsSkuId() {
        return orderItemPo.getGoodsSkuId();
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        orderItemPo.setGoodsSkuId(goodsSkuId);
    }

    public Integer getQuantity() {
        return orderItemPo.getQuantity();
    }

    public void setQuantity(Integer quantity) {
        orderItemPo.setQuantity(quantity);
    }

    public Integer getPrice() {
        return orderItemPo.getPrice();
    }

    public void setPrice(Integer price) {
        orderItemPo.setPrice(price);
    }

    public Integer getDiscount() {
        return orderItemPo.getDiscount();
    }

    public void setDiscount(Integer discount) {
        orderItemPo.setDiscount(discount);
    }

    public String getName() {
        return orderItemPo.getName();
    }

    public void setName(String name) {
        orderItemPo.setName(name);
    }

    public Integer getCouponActivityId() {
        return orderItemPo.getCouponActivityId();
    }

    public void setCouponActivityId(Integer couponActivityId) {
        orderItemPo.setCouponActivityId(couponActivityId);
    }

    public Integer getBeShareId() {
        return orderItemPo.getBeShareId();
    }

    public void setBeShareId(Integer beShareId) {
        orderItemPo.setBeShareId(beShareId);
    }

    public LocalDateTime getGmtCreate() {
        return orderItemPo.getGmtCreate();
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        orderItemPo.setGmtCreate(gmtCreate);
    }

    public LocalDateTime getGmtModified() {
        return orderItemPo.getGmtModified();
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        orderItemPo.setGmtModified(gmtModified);
    }
}
