package com.vw.view;

import com.google.common.collect.ImmutableList;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Table;
import com.vw.dto.PassengerDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.util.Map;

@Component("bus-passengers-pdf")
public class BusPassengersPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    com.lowagie.text.Document document,
                                    com.lowagie.text.pdf.PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        final ImmutableList<PassengerDto> passengerDtos = (ImmutableList<PassengerDto>) model.get("passengers");
        final Table table = new Table(5);
        table.addCell("Passenger Name");
        table.addCell("Age");
        table.addCell("Gender");
        table.addCell("Mobile No");
        table.addCell("Bus Stop to Board");

        passengerDtos.forEach(passengerDto -> {
            try {
                table.addCell(passengerDto.getPassengerName());
                table.addCell(String.valueOf(passengerDto.getAge()));
                table.addCell(passengerDto.getGender());
                table.addCell(passengerDto.getMobileNo());
                table.addCell(passengerDto.getBusStopName());
            } catch (BadElementException e) {
                throw new RuntimeException(e);
            }
        });

        document.add(table);
    }
}
