package com.mryzhan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DefaultExceptionMessageDto {
    private String message;
}
