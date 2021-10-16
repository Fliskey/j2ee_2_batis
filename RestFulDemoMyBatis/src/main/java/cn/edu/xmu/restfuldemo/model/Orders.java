package cn.edu.xmu.restfuldemo.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders implements VoObject {
    /**
     * 代理对象
     */
    private OrdersPo ordersPo;

    /**
     * 构造函数
     */
    public Orders() {
        this.ordersPo = new OrdersPo();
    }

    /**
     * 构造函数
     */
    public Orders(OrdersPo ordersPo) {
        this.ordersPo = ordersPo;
    }

    /**
     * 由Orders对象创建Vo对象
     */
    @Override
    public Object createVo(){
        return new OrdersRetVo(this);
    }

    /**
     * 获得内部的代理对象
     * @return GoodsPo对象
     */
    public OrdersPo gotOrdersPo(){
        return this.ordersPo;
    }


    public Integer getId() {
        return ordersPo.getId();
    }

    public void setId(Integer id) {
        ordersPo.setId(id);
    }

    public Integer getCustomerId() {
        return ordersPo.getCustomerId();
    }

    public void setCustomerId(Integer customerId) {
        ordersPo.setCustomerId(customerId);
    }

    public Integer getShopId() {
        return ordersPo.getShopId();
    }

    public void setShopId(Integer shopId) {
        ordersPo.setShopId(shopId);
    }

    public String getOrderSn() {
        return ordersPo.getOrderSn();
    }

    public void setOrderSn(String orderSn) {
        ordersPo.setOrderSn(orderSn);
    }

    public Integer getPid() {
        return ordersPo.getPid();
    }

    public void setPid(Integer pid) {
        ordersPo.setPid(pid);
    }

    public String getConsignee() {
        return ordersPo.getConsignee();
    }

    public void setConsignee(String consignee) {
        ordersPo.setConsignee(consignee);
    }

    public Integer getRegionId() {
        return ordersPo.getRegionId();
    }

    public void setRegionId(Integer regionId) {
        ordersPo.setRegionId(regionId);
    }

    public String getAddress() {
        return ordersPo.getAddress();
    }

    public void setAddress(String address) {
        ordersPo.setAddress(address);
    }

    public String getMobile() {
        return ordersPo.getMobile();
    }

    public void setMobile(String mobile) {
        ordersPo.setMobile(mobile);
    }

    public String getMessage() {
        return ordersPo.getMessage();
    }

    public void setMessage(String message) {
        ordersPo.setMessage(message);
    }

    public Integer getOrderType() {
        return ordersPo.getOrderType();
    }

    public void setOrderType(Integer orderType) {
        ordersPo.setOrderType(orderType);
    }

    public Integer getFreightPrice() {
        return ordersPo.getFreightPrice();
    }

    public void setFreightPrice(Integer freightPrice) {
        ordersPo.setFreightPrice(freightPrice);
    }

    public Integer getCouponId() {
        return ordersPo.getCouponId();
    }

    public void setCouponId(Integer couponId) {
        ordersPo.setCouponId(couponId);
    }

    public Integer getCouponActivityId() {
        return ordersPo.getCouponActivityId();
    }

    public void setCouponActivityId(Integer couponActivityId) {
        ordersPo.setCouponActivityId(couponActivityId);
    }

    public Integer getDiscountPrice() {
        return ordersPo.getDiscountPrice();
    }

    public void setDiscountPrice(Integer discountPrice) {
        ordersPo.setDiscountPrice(discountPrice);
    }

    public Integer getOriginPrice() {
        return ordersPo.getOriginPrice();
    }

    public void setOriginPrice(Integer originPrice) {
        ordersPo.setOriginPrice(originPrice);
    }

    public Integer getPresaleId() {
        return ordersPo.getPresaleId();
    }

    public void setPresaleId(Integer presaleId) {
        ordersPo.setPresaleId(presaleId);
    }

    public Integer getGrouponDiscount() {
        return ordersPo.getGrouponDiscount();
    }

    public void setGrouponDiscount(Integer grouponDiscount) {
        ordersPo.setGrouponDiscount(grouponDiscount);
    }

    public Integer getRebateNum() {
        return ordersPo.getRebateNum();
    }

    public void setRebateNum(Integer rebateNum) {
        ordersPo.setRebateNum(rebateNum);
    }

    public LocalDateTime getConfirmTime() {
        return ordersPo.getConfirmTime();
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        ordersPo.setConfirmTime(confirmTime);
    }

    public String getShipmentSn() {
        return ordersPo.getShipmentSn();
    }

    public void setShipmentSn(String shipmentSn) {
        ordersPo.setShipmentSn(shipmentSn);
    }

    public Integer getState() {
        return ordersPo.getState();
    }

    public void setState(Integer state) {
        ordersPo.setState(state);
    }

    public Integer getSubstate() {
        return ordersPo.getSubstate();
    }

    public void setSubstate(Integer substate) {
        ordersPo.setSubstate(substate);
    }

    public Integer getBeDeleted() {
        return ordersPo.getBeDeleted();
    }

    public void setBeDeleted(Integer beDeleted) {
        ordersPo.setBeDeleted(beDeleted);
    }

    public LocalDateTime getGmtCreate() {
        return ordersPo.getGmtCreate();
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        ordersPo.setGmtCreate(gmtCreate);
    }

    public LocalDateTime getGmtModified() {
        return ordersPo.getGmtModified();
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        ordersPo.setGmtModified(gmtModified);
    }

    public Integer getGrouponId() {
        return ordersPo.getGrouponId();
    }

    public void setGrouponId(Integer grouponId) {
        ordersPo.setGrouponId(grouponId);
    }

    public List<OrderItem> getOrderItems() {
        return ordersPo.getOrderItems();
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        ordersPo.setOrderItems(orderItems);
    }


    @Override
    public int hashCode() {
        return ordersPo.hashCode();
    }

    @Override
    public String toString() {
        return ordersPo.toString();
    }

    @Override
    public boolean equals(Object o) {
        return ordersPo.equals(((Orders)o).ordersPo);
    }

}
