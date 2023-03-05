package com.finance.controller;


import com.finance.dto.IncomeDto;
import com.finance.service.income.IncomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * REST API controller to manage incomes.
 */
@RestController
@RequestMapping("/api/incomes")
@ResponseStatus
public class IncomeController {

    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService){
        this.incomeService = incomeService;
    }

    /**
     * Create a new Income.
     */
    @PostMapping("")
    @Operation(description = "createIncome")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New income successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request, adjust before retrying"),
            @ApiResponse(responseCode = "406", description = "Rejected, missing required fields"),
            @ApiResponse(responseCode = "409", description = "Income with the same name already exists"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Mono<?>> createIncome(
            @RequestBody(required = true) IncomeDto incomeDto
            ){
        if (incomeDto == null){
            return new ResponseEntity<>(Mono.empty(), HttpStatus.NOT_ACCEPTABLE);
        }
        incomeService.createIncome(incomeDto);

        return new ResponseEntity<>(Mono.empty(), HttpStatus.CREATED);
    }

}
