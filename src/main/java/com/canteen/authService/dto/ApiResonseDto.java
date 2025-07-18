package com.canteen.authService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResonseDto<T> {
    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timeStamp;
}
