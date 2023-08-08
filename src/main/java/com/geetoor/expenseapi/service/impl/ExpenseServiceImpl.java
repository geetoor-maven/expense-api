package com.geetoor.expenseapi.service.impl;

import com.geetoor.expenseapi.dto.Response;
import com.geetoor.expenseapi.dto.expense.RequestCreateExpense;
import com.geetoor.expenseapi.dto.expense.RequestUpdateExpense;
import com.geetoor.expenseapi.entity.Expense;
import com.geetoor.expenseapi.exception.ResourceNotFoundException;
import com.geetoor.expenseapi.repository.ExpenseRepository;
import com.geetoor.expenseapi.service.ExpenseService;
import com.geetoor.expenseapi.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private UserService userService;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, UserService userService) {
        this.expenseRepository = expenseRepository;
        this.userService = userService;
    }

    @Override
    public Page<Expense> getAllExpenses(Pageable pageable) {
        return expenseRepository.findByUser(userService.getLoggedInUser(), pageable);
    }

    @Override
    public List<Expense> readByCategory(String category, Pageable page) {
        return expenseRepository.findByUserAndCategory(userService.getLoggedInUser() ,category, page).toList();
    }

    @Override
    public List<Expense> readByDate(Date startDate, Date endDate, Pageable page) {
        if (startDate == null){
            startDate = new Date(0);
        }
        if (endDate == null){
            endDate = new Date(System.currentTimeMillis());
        }

        return expenseRepository.findByUserAndCreateAtBetween(userService.getLoggedInUser() ,startDate, endDate, page).toList();
    }

    @Override
    public Expense getExpenseById(String expenseId) {
        Optional<Expense> expense = expenseRepository.findByUserAndExpenseId(userService.getLoggedInUser(), expenseId);
        if (expense.isPresent()){
            return expense.get();
        }
        throw new ResourceNotFoundException("Expense is not found");
    }

    @Transactional
    @Override
    public void deleteExpenseById(String expenseId) {
        Expense expense = getExpenseById(expenseId);
        expenseRepository.delete(expense);
    }


    // for update Expense
    @Transactional
    @Override
    public Response updateExpenseDetails(String expenseId, RequestUpdateExpense expense) {
        Response theResponse = new Response();

        Expense theExpense = getExpenseById(expenseId);

        theExpense.setExpenseName(expense.getExpenseName() != null ? expense.getExpenseName() : theExpense.getExpenseName());
        theExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : theExpense.getDescription());
        theExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : theExpense.getCategory());
        theExpense.setDate(expense.getDate() != null ? expense.getDate() : theExpense.getDate());
        theExpense.setExpenseAmount(expense.getExpenseAmount() != null ? expense.getExpenseAmount() : theExpense.getExpenseAmount());

        expenseRepository.save(theExpense);
        theResponse.setStatus(HttpStatus.OK.value());
        theResponse.setData(theExpense);

        return theResponse;
    }

    @Override
    public Response findExpenseById(String expenseId) {
        Response response = new Response();
        Optional<Expense> expense = expenseRepository.findByUserAndExpenseId(userService.getLoggedInUser(),expenseId);
        if (expense.isPresent()){
            response.setStatus(HttpStatus.FOUND.value());
            response.setData(expense);

            return response;
        }
        throw new ResourceNotFoundException("Expense is not found");
    }

    // for save Expense
    @Transactional
    @Override
    public Response saveExpenseDetails(RequestCreateExpense expense) {
        Response response = new Response();

        Expense theExpense = new Expense();
        theExpense.setExpenseId(UUID.randomUUID().toString());
        theExpense.setExpenseName(expense.getExpenseName());
        theExpense.setDescription(expense.getDescription());
        theExpense.setExpenseAmount(expense.getExpenseAmount());
        theExpense.setCategory(expense.getCategory());
        theExpense.setDate(expense.getDate());
        theExpense.setUser(userService.getLoggedInUser());

        expenseRepository.save(theExpense);

        response.setStatus(HttpStatus.CREATED.value());
        response.setData(theExpense);
        return response;
    }
}
