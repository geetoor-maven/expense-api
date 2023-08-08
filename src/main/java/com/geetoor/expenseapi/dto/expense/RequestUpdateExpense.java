package com.geetoor.expenseapi.dto.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestUpdateExpense {

    private String expenseName;

    private String description;

    private BigDecimal expenseAmount;

    private String category;

    private Date date;

}
