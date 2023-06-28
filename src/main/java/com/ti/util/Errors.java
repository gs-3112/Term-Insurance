package com.ti.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Errors {
    private String status;
    private Integer statusCode;
    private Integer errorCode;
    private String source;
    private List<Message> message;

}
