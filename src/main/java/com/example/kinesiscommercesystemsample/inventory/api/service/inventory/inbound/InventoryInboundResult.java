package com.example.kinesiscommercesystemsample.inventory.api.service.inventory.inbound;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InventoryInboundResult {

	private String messageId;

	private String inventoryId;
}
