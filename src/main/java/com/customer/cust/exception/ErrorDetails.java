package com.customer.cust.exception;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private int statusCode;
    private String message;
    private String details;
}
