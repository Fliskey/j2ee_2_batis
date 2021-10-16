package cn.edu.xmu.restfuldemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品视图对象
 * @author Ming Qiu
 **/
@Data
@ApiModel(description = "商品视图对象")
public class OrdersVo {

    private static Logger logger = LoggerFactory.getLogger(GoodsVo.class);

    @ApiModelProperty(value = "订单id")
    private Integer id;

    @ApiModelProperty(value = "购买者id")
    private Integer customerId;

    @ApiModelProperty(value = "店铺id")
    private Integer shopId;

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

    @ApiModelProperty(value = "优惠活动id")
    private Integer couponActivityId;

    @ApiModelProperty(value = "折扣数额")
    private Integer discountPrice;

    @ApiModelProperty(value = "订单商品优惠前总额")
    private Integer originPrice;

    @ApiModelProperty(value = "预售活动id")
    private Integer presaleId;

    @ApiModelProperty(value = "团购折扣")
    private Integer grouponDiscount;

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

    @ApiModelProperty(value = "买家逻辑删除")
    private Integer beDeleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "团购活动id")
    private Integer grouponId;

    @ApiModelProperty(value = "子订单")
    private List<OrderItemVo> orderItems;

    public Orders createOrders(){
        Orders orders = new Orders();
        orders.setConsignee(this.consignee);
        orders.setRegionId(this.regionId);
        orders.setAddress(this.address);
        orders.setMobile(this.mobile);
        orders.setMessage(this.message);
        orders.setCouponId(this.couponId);
        orders.setPresaleId(this.presaleId);
        orders.setGrouponId(this.grouponId);

        if (null != this.orderItems) {
            logger.info("createOrders: this.orderItems = "+this.orderItems);
            List<OrderItem> newOrderItemList = new ArrayList<>(this.orderItems.size());

            for (OrderItemVo orderItemVo : this.orderItems) {
                OrderItem orderItem = orderItemVo.createOrderItem();
                newOrderItemList.add(orderItem);
            }
            orders.setOrderItems(newOrderItemList);
        }

        return orders;
    }

}
