package cn.edu.xmu.restfuldemo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Alias("OrdersPo")
public class OrdersPo {

    private Integer id;

    private Integer customerId;

    private Integer shopId;

    private String orderSn;

    private Integer pid;

    private String consignee;

    private Integer regionId;

    private String address;

    private String mobile;

    private String message;

    private Integer orderType;

    private Integer freightPrice;

    private Integer couponId;

    private Integer couponActivityId;

    private Integer discountPrice;

    private Integer originPrice;

    private Integer presaleId;

    private Integer grouponDiscount;

    private Integer rebateNum;

    private LocalDateTime confirmTime;

    private String shipmentSn;

    private Integer state;

    private Integer substate;

    private Integer beDeleted;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer grouponId;

    private List<OrderItem> orderItems;

}
