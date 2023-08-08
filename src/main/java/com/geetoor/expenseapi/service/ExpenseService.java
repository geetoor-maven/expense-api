package com.geetoor.expenseapi.service;

import com.geetoor.expenseapi.dto.Response;
import com.geetoor.expenseapi.dto.expense.RequestCreateExpense;
import com.geetoor.expenseapi.dto.expense.RequestUpdateExpense;
import com.geetoor.expenseapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.sql.Date;
import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    List<Expense> readByCategory(String category, Pageable page);
    List<Expense> readByDate(Date startDate, Date endDate, Pageable page);
    Expense getExpenseById(String expenseId);
    void deleteExpenseById(String expenseId);
    Response saveExpenseDetails(RequestCreateExpense expense);
    Response updateExpenseDetails(String expenseId, RequestUpdateExpense theExpense);
    Response findExpenseById(String expenseId);
}
