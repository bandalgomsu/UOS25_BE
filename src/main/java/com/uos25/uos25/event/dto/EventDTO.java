package com.uos25.uos25.event.dto;

import com.uos25.uos25.event.entity.Event;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class EventDTO {

    @Getter
    @AllArgsConstructor
    @Builder
    public static class EventCreateRequest {
        private String type;
        private String productName;
        private int discount;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class EventInfoResponse {
        private String type;
        private String productName;
        private int discount;

        public static EventInfoResponse toDTO(Event event) {
            return new EventInfoResponse(event.getType().toString(), event.getProducts().getProductName(),
                    event.getDiscount());
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class EventInfoResponses {
        List<EventInfoResponse> responses;

        public static EventInfoResponses toDTO(List<Event> events) {
            List<EventInfoResponse> eventInfoResponses = new ArrayList<>();

            events.forEach(event -> eventInfoResponses.add(EventInfoResponse.toDTO(event)));

            return EventInfoResponses.builder().responses(eventInfoResponses).build();
        }
    }
}