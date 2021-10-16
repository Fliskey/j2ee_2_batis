package cn.edu.xmu.restfuldemo.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
//ok
@Data
@ApiModel(description = "订单视图对象")
public class OrderItemVo {


    private static Logger logger = LoggerFactory.getLogger(OrderItemVo.class);

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

    @NotBlank(message="商品名称不能为空")
    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "优惠活动id")
    private Integer couponActivityId;

    @ApiModelProperty(value = "分享成功id")
    private Integer beShareId;

    /**
     * 由Vo对象创建OrderItem对象
     * @return OrderItem对象
     */
    public OrderItem createOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodsSkuId(this.goodsSkuId);
        orderItem.setQuantity(this.quantity);
        orderItem.setCouponActivityId(this.couponActivityId);
        return orderItem;
    }

}
