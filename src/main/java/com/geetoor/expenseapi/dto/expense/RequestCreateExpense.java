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
public class RequestCreateExpense {

    @NotBlank(message = "Expense name must not be null")
    @Size(min = 5, message = "Expense name at least 5 char")
    private String expenseName;

    @Size(min = 10, message = "Description at least 10 char")
    private String description;

    @NotNull(message = "Expense Amount must not be null")
    private BigDecimal expenseAmount;

    private String category;

    @NotNull(message = "Expense Date must not be null")
    private Date date;
}
