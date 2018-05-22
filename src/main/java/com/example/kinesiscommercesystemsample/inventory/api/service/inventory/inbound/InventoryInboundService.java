package com.example.kinesiscommercesystemsample.inventory.api.service.inventory.inbound;

import com.example.kinesiscommercesystemsample.inventory.api.controller.InventoryApiController;

public interface InventoryInboundService {

	InventoryInboundResult execute(InventoryApiController.InventoryInboundRequest request);
}
