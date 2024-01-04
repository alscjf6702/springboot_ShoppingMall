package com.shop.dto;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {

    private Long id;

    private String itemNm;

    private String itemDetail;

    private Integer price;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;

    private String sellStatCd;


}
