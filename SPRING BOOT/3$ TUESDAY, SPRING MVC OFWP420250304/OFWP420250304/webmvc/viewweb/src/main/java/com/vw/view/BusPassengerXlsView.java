package com.vw.view;

import com.google.common.collect.ImmutableList;
import com.vw.dto.PassengerDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import java.util.Map;
import java.util.stream.IntStream;

@Component("bus-passengers-xls")
public class BusPassengerXlsView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(final Map<String, Object> model, final Workbook workbook, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final ImmutableList<PassengerDto> passengerDtos = (ImmutableList<PassengerDto>) model.get("passengers");
        final Sheet passengersSheet = workbook.createSheet("passengers");
        final Row headerRow = passengersSheet.createRow(0);
        headerRow.createCell(0).setCellValue("Passenger Name");
        headerRow.createCell(1).setCellValue("Age");
        headerRow.createCell(2).setCellValue("Gender");
        headerRow.createCell(3).setCellValue("Mobile No");
        headerRow.createCell(4).setCellValue("Bus Stop to Board");

        IntStream.range(0, passengerDtos.size()).forEach(index -> {
            final PassengerDto passengerDto = passengerDtos.get(index);
            final Row dataRow = passengersSheet.createRow(index + 1);
            dataRow.createCell(0).setCellValue(passengerDto.getPassengerName());
            dataRow.createCell(1).setCellValue(passengerDto.getAge());
            dataRow.createCell(2).setCellValue(passengerDto.getGender());
            dataRow.createCell(3).setCellValue(passengerDto.getMobileNo());
            dataRow.createCell(4).setCellValue(passengerDto.getBusStopName());
        });
    }
}
