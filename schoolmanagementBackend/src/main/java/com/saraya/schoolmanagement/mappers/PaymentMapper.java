package com.saraya.schoolmanagement.mappers;


import com.saraya.schoolmanagement.dto.PaymentDto;
import com.saraya.schoolmanagement.models.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentDto modelToDto(Payment payment);
    List<PaymentDto> modelsToDtos(List<Payment> payments);

    Payment dtoToModel(PaymentDto paymentDto);
}
