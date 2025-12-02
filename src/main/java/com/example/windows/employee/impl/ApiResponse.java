package com.example.windows.employee.impl;


import java.time.LocalDateTime;
import java.util.Date;

//public class ApiResponse<T> {
public class ApiResponse {
private LocalDateTime timestamp;
private int status;
private String error;
private String message;
private String path;

// Constructors
public ApiResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        }

// Getters & Setters
public LocalDateTime getTimestamp() {
        return timestamp;
        }

public int getStatus() {
        return status;
        }

public String getError() {
        return error;
        }

public String getMessage() {
        return message;
        }

public String getPath() {
        return path;
        }
        }


