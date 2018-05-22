package com.example.kinesiscommercesystemsample.inventory.api.mom.inventory;

import com.example.kinesiscommercesystemsample.common.messaging.inventory.entity.InventoryMessage;
import com.example.kinesiscommercesystemsample.common.messaging.inventory.mom.writer.AbstractInventoryStreamWriter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class InventoryStreamWriter extends AbstractInventoryStreamWriter {

	@Value("${application.kinesis.inventory.stream-name}")
	private String streamName;

	@Override
	public void write(InventoryMessage message) {
		super.write(message);
	}
}
