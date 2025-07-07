package com.vw.controller;

import com.google.common.collect.ImmutableList;
import com.vw.dto.PassengerDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller("/getBusPassengers.htm")
public class GetBusPassengersController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        final String action = request.getParameter("action");
        String viewName = "bus-passengers";

        final ImmutableList<PassengerDto> passengerDtos = ImmutableList.of(
                PassengerDto.of().passengerName("Alex").age(23).gender("male").mobileNo("6738279992").busStopName("Ameerpet").build(),
                PassengerDto.of().passengerName("Tom").age(24).gender("male").mobileNo("9384748484").busStopName("Somajiguda").build(),
                PassengerDto.of().passengerName("Juli").age(23).gender("female").mobileNo("9837282891").busStopName("Kalyan nagar").build(),
                PassengerDto.of().passengerName("Mike").age(27).gender("male").mobileNo("7363747844").busStopName("Ameerpet").build(),
                PassengerDto.of().passengerName("Mikki").age(29).gender("female").mobileNo("9832873734").busStopName("Somajiguda").build()
        );
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("passengers", passengerDtos);
        modelAndView.addObject("busNo", request.getParameter("busNo"));
        modelAndView.addObject("journeyDate", request.getParameter("journeyDate"));

        if(action != null) {
            if(action.equals("pdf")) {
                viewName = "bus-passengers-pdf";
            }else if (action.equals("xls")){
                viewName = "bus-passengers-xls";
            }
        }
        modelAndView.setViewName(viewName);

        return modelAndView;
    }
}
