package cn.edu.xmu.restfuldemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "订单详情对象")
public class OrderItemRetVo {

    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    @ApiModelProperty(value = "商品SKU id")
    private Integer goodsSkuId;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "商品单价")
    private Integer price;

    @ApiModelProperty(value = "折让数目")
    private Integer discount;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "优惠活动id")
    private Integer couponActivityId;

    @ApiModelProperty(value = "分享成功id")
    private Integer beShareId;
    /**
     * 构造函数，由Goods对象创建Vo
     * @param orderItem orderItem对象
     */
    public OrderItemRetVo(OrderItem orderItem)
    {
        this.goodsSkuId = orderItem.getGoodsSkuId();
        this.orderId = orderItem.getOrderId();
        this.name = orderItem.getName();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.discount = orderItem.getDiscount();
        this.couponActivityId = orderItem.getCouponActivityId();
        this.beShareId = orderItem.getBeShareId();
    }
}
