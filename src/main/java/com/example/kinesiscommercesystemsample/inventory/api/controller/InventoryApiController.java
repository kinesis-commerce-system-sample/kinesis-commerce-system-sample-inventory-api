package com.example.kinesiscommercesystemsample.inventory.api.controller;

import com.example.kinesiscommercesystemsample.common.web.base.controller.api.AbstractRestController;
import com.example.kinesiscommercesystemsample.common.web.base.controller.api.resource.Resource;
import com.example.kinesiscommercesystemsample.common.web.base.controller.api.resource.ResourceFactory;
import com.example.kinesiscommercesystemsample.common.web.base.dto.Dto;
import com.example.kinesiscommercesystemsample.inventory.api.service.inventory.inbound.InventoryInboundResult;
import com.example.kinesiscommercesystemsample.inventory.api.service.inventory.inbound.InventoryInboundService;
import com.example.kinesiscommercesystemsample.inventory.api.service.inventory.outbound.InventoryOutboundResult;
import com.example.kinesiscommercesystemsample.inventory.api.service.inventory.outbound.InventoryOutboundService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = {"/inventory"})
@Slf4j
public class InventoryApiController extends AbstractRestController {

	@Autowired
	private InventoryInboundService inventoryInboundService;

	@Autowired
	private InventoryOutboundService inventoryOutboundService;

	@PutMapping(value = "/inbound", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource inbound(@RequestBody  InventoryInboundRequest request) {

		InventoryInboundResult inventoryInboundResult = inventoryInboundService.execute(request);

		val response = new InventoryInboundResponse(inventoryInboundResult.getMessageId());
		val responses = new ArrayList<Dto>();
		responses.add(response);

		Resource resource = ResourceFactory.create();
		resource.setData(responses);
		resource.setMessage(getMessage(SUCCESS));

		return resource;
	}

	@Getter
	@Setter
	@ToString
	public static class InventoryInboundRequest implements Dto {

		/**
		 * 商品ID
		 */
		@JsonProperty("item_id")
		private String itemId;

		/**
		 * 数量
		 */
		@JsonProperty("quantity")
		private Integer quantity;

		/**
		 * 入庫と紐づく仕入れID
		 */
		@JsonProperty("purchase_id")
		private String purchaseId;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	public static class InventoryInboundResponse implements Dto {

		/**
		 * 発番されたメッセージID
		 */
		@JsonProperty("message_id")
		private String messageId;
	}

	@PutMapping(value = "/outbound", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource outbound(@RequestBody InventoryOutboundRequest request) {

		InventoryOutboundResult inventoryOutboundResult = inventoryOutboundService.execute(request);

		val response = new InventoryOutboundResponse(inventoryOutboundResult.getMessageId());
		val responses = new ArrayList<Dto>();
		responses.add(response);

		Resource resource = ResourceFactory.create();
		resource.setData(responses);
		resource.setMessage(getMessage(SUCCESS));

		return resource;
	}

	@Getter
	@Setter
	@ToString
	public static class InventoryOutboundRequest implements Dto {

		/**
		 * 商品ID
		 */
		@JsonProperty("item_id")
		private String itemId;

		/**
		 * 数量
		 */
		@JsonProperty("quantity")
		private Integer quantity;

		/**
		 * 出庫と紐づく受注ID
		 */
		@JsonProperty("order_id")
		private String orderId;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	public static class InventoryOutboundResponse implements Dto {

		/**
		 * 発番されたメッセージID
		 */
		@JsonProperty("message_id")
		private String messageId;
	}
}
