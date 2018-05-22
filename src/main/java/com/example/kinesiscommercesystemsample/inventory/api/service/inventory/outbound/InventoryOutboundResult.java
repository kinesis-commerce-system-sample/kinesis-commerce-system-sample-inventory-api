package com.example.kinesiscommercesystemsample.inventory.api.service.inventory.outbound;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InventoryOutboundResult {

	private String messageId;

	private String inventoryId;
}
