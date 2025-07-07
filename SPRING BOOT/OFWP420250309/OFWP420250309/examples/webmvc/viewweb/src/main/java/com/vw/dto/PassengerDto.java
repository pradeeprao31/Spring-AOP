package com.vw.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of")
public class PassengerDto {
    private String passengerName;
    private int age;
    private String gender;
    private String mobileNo;
    private String busStopName;
}
