package com.microservice.inventory.dto;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class InventoryResponseDto {
    private Long id;
    private String skuCode;
    private Integer quantity;

    private String productId;

    private String productName;

    private String description;

    private LocalDateTime inputDateTime;

    private LocalDateTime deliverDateTime;

}
