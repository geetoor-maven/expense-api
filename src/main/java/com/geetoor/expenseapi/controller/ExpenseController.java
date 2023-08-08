package com.geetoor.expenseapi.controller;

import com.geetoor.expenseapi.dto.Response;
import com.geetoor.expenseapi.dto.expense.RequestCreateExpense;
import com.geetoor.expenseapi.dto.expense.RequestUpdateExpense;
import com.geetoor.expenseapi.entity.Expense;
import com.geetoor.expenseapi.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @DeleteMapping("/expenses/{expenseId}")
    public void deleteExpenseById(@PathVariable("expenseId") String expenseId){
        expenseService.deleteExpenseById(expenseId);
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable page){
        return expenseService.getAllExpenses(page).toList();
    }

    @GetMapping(
            path = "/expenses/category",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Expense> getExpensesByCategory(@RequestParam String category, Pageable page){
        return expenseService.readByCategory(category, page);
    }

    @GetMapping(
            "/expenses/date"
    )
    public List<Expense> getExpenseByDates(
                                            @RequestParam(required = false)Date startDate,
                                            @RequestParam(required = false)Date endDate,
                                            Pageable page
                                            ){
        return expenseService.readByDate(startDate, endDate, page);
    }

    @GetMapping(
            path = "/expenses/{expenseId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Response> findExpenseById(@PathVariable("expenseId") String expenseId){
        Response response = expenseService.findExpenseById(expenseId);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @PostMapping(
            path = "/expenses",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Response> saveExpenseDetails(@Valid @RequestBody RequestCreateExpense expense){
        Response response = expenseService.saveExpenseDetails(expense);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @PutMapping(
            path = "/expenses/{expenseId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Response> updateExpenseDetails(@PathVariable("expenseId") String expenseId, @RequestBody RequestUpdateExpense expense){
        Response response = expenseService.updateExpenseDetails(expenseId, expense);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }
}
