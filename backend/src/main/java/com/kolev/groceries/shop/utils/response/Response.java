package com.kolev.groceries.shop.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    protected String message;
    protected Map<String, Object> data;

    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

    public static class ResponseBuilder {
        private String message;
        private Map<String, Object> data = new HashMap<>();

        public ResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder data(String key, Object value) {
            this.data.put(key, value);
            return this;
        }

        public Response build() {
            return new Response(
                    this.message,
                    this.data
            );
        }
    }
}