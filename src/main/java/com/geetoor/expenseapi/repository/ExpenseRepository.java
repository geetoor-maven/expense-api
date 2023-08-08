package com.geetoor.expenseapi.repository;

import com.geetoor.expenseapi.entity.Expense;
import com.geetoor.expenseapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, String> {
    Page<Expense> findByUserAndCategory(User user ,String category, Pageable page);
    Page<Expense> findByUserAndCreateAtBetween(User user ,@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable page);
    Page<Expense> findByUser(User user, Pageable page);
    Optional<Expense> findByUserAndExpenseId(User user, String expanseId);
}
