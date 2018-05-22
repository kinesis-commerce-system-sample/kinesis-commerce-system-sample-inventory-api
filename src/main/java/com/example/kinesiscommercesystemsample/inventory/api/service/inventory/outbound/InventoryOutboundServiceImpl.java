package com.example.kinesiscommercesystemsample.inventory.api.service.inventory.outbound;

import com.eaio.uuid.UUID;
import com.example.kinesiscommercesystemsample.common.messaging.inventory.entity.v1.InventoryOutboundMessage;
import com.example.kinesiscommercesystemsample.common.messaging.inventory.mom.writer.AbstractInventoryStreamWriter;
import com.example.kinesiscommercesystemsample.inventory.api.controller.InventoryApiController;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryOutboundServiceImpl implements InventoryOutboundService {

	@Autowired
	private AbstractInventoryStreamWriter inventoryStreamWriter;

	@Override
	public InventoryOutboundResult execute(InventoryApiController.InventoryOutboundRequest request) {

		try {

			val messageId = new UUID().toString();
			val inventoryId = new UUID().toString();

			val itemId = request.getItemId();
			val quantity = request.getQuantity();
			val orderId = request.getOrderId();

			// TODO : derive domain model

			val message = new InventoryOutboundMessage(messageId, itemId, quantity, orderId);

			inventoryStreamWriter.write(message);

			val result = new InventoryOutboundResult();
			result.setMessageId(messageId);
			result.setInventoryId(inventoryId);

			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
