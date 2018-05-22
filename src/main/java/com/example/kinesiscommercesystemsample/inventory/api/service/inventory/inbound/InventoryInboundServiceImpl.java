package com.example.kinesiscommercesystemsample.inventory.api.service.inventory.inbound;

import com.eaio.uuid.UUID;
import com.example.kinesiscommercesystemsample.common.messaging.inventory.entity.v1.InventoryInboundMessage;
import com.example.kinesiscommercesystemsample.common.messaging.inventory.mom.writer.AbstractInventoryStreamWriter;
import com.example.kinesiscommercesystemsample.inventory.api.controller.InventoryApiController;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryInboundServiceImpl implements InventoryInboundService {

	@Autowired
	private AbstractInventoryStreamWriter inventoryStreamWriter;

	@Override
	public InventoryInboundResult execute(InventoryApiController.InventoryInboundRequest request) {

		try {

			val messageId = new UUID().toString();
			val inventoryId = new UUID().toString();

			val itemId = request.getItemId();
			val quantity = request.getQuantity();
			val purchaseId = request.getPurchaseId();

			// TODO : derive domain model

			val message = new InventoryInboundMessage(messageId, itemId, quantity, purchaseId);

			inventoryStreamWriter.write(message);

			val result = new InventoryInboundResult();
			result.setMessageId(messageId);
			result.setInventoryId(inventoryId);

			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
