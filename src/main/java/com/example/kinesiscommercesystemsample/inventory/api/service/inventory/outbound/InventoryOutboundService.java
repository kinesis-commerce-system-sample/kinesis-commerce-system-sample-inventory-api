package com.example.kinesiscommercesystemsample.inventory.api.service.inventory.outbound;

import com.example.kinesiscommercesystemsample.inventory.api.controller.InventoryApiController;

public interface InventoryOutboundService {

	InventoryOutboundResult execute(InventoryApiController.InventoryOutboundRequest request);
}
