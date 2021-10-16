package cn.edu.xmu.restfuldemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@ApiModel(description = "商品对象")
public class OrdersRetVo {

    @ApiModelProperty(value = "订单id")
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "父订单id")
    private Integer pid;

    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "地区id")
    private Integer regionId;

    @ApiModelProperty(value = "收货详细地址")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String mobile;

    @ApiModelProperty(value = "附言")
    private String message;

    @ApiModelProperty(value = "订单类型")
    private Integer orderType;

    @ApiModelProperty(value = "运费")
    private Integer freightPrice;

    @ApiModelProperty(value = "使用的优惠券id")
    private Integer couponId;

//    @ApiModelProperty(value = "优惠活动id")
//    private Integer couponActivityId;

    @ApiModelProperty(value = "折扣数额")
    private Integer discountPrice;

    @ApiModelProperty(value = "订单商品优惠前总额")
    private Integer originPrice;

    @ApiModelProperty(value = "预售活动id")
    private Integer presaleId;

//    @ApiModelProperty(value = "团购折扣")
//    private Integer grouponDiscount;

    @ApiModelProperty(value = "返给分享者点数")
    private Integer rebateNum;

    @ApiModelProperty(value = "发货时间")
    private LocalDateTime confirmTime;

    @ApiModelProperty(value = "快递单号")
    private String shipmentSn;

    @ApiModelProperty(value = "订单主状态")
    private Integer state;

    @ApiModelProperty(value = "订单子状态")
    private Integer substate;

//    @ApiModelProperty(value = "买家逻辑删除")
//    private Integer beDeleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "团购活动id")
    private Integer grouponId;


    @ApiModelProperty(value = "子订单")
    private List<OrderItemRetVo> orderItems;
    /**
     * 构造函数，由Goods对象创建Vo
     * @param orders orders对象
     */
    public OrdersRetVo(Orders orders) {
        this.id = orders.getId();
        this.orderSn = orders.getOrderSn();
        this.pid = orders.getPid();
        this.orderType = orders.getOrderType();
        this.state = orders.getState();
        this.substate = orders.getSubstate();
        this.gmtCreate = orders.getGmtCreate();
        this.gmtModified = orders.getGmtModified();
        this.confirmTime = orders.getConfirmTime();
        this.originPrice = orders.getOriginPrice();
        this.discountPrice = orders.getDiscountPrice();
        this.freightPrice = orders.getFreightPrice();
        this.rebateNum = orders.getRebateNum();
        this.message = orders.getMessage();
        this.regionId = orders.getRegionId();
        this.address = orders.getAddress();
        this.mobile = orders.getMobile();
        this.consignee = orders.getConsignee();
        this.couponId = orders.getCouponId();
        this.grouponId = orders.getGrouponId();
        this.presaleId = orders.getPresaleId();
        this.shipmentSn = orders.getShipmentSn();
        if (null != orders.getOrderItems()) {
            List<OrderItemRetVo> orderItemsList = new ArrayList<>(orders.getOrderItems().size());

            for (OrderItem orderItem : orders.getOrderItems()) {
                OrderItemRetVo orderItemRetVo = new OrderItemRetVo(orderItem);
                orderItemsList.add(orderItemRetVo);
            }
            this.orderItems = orderItemsList;
        }

    }
}
