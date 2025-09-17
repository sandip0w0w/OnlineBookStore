package com.example.OnlineBookStore.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private String error;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponseDTO(String error, String message){
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
