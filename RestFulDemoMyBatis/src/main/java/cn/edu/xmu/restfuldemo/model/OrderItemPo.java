package cn.edu.xmu.restfuldemo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
//ok''
@Data
@Alias("OrderItemPo")
public class OrderItemPo {
    private Integer id;

    private Integer orderId;

    private Integer goodsSkuId;

    private Integer quantity;

    private Integer price;

    private Integer discount;

    private String name;

    private Integer couponActivityId;

    private Integer beShareId;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;


}
