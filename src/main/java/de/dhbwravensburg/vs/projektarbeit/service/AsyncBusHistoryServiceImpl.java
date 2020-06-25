package de.dhbwravensburg.vs.projektarbeit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AsyncBusHistoryServiceImpl implements AsyncBusHistoryService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private BusHistoryService busHistoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public void recieveMessage(BusHistory busHistory) {
        try {
            busHistoryService.addBusHistory(busHistory.getBusId(), busHistory.getBuslinie(), busHistory.getHaltestellenId(), busHistory.getAnkunftszeit());
            System.out.println("Recieved Message From RabbitMQ 2: " + objectMapper.writeValueAsString(busHistory));
        } catch (JsonProcessingException e) {
        }
    }
}
