package com.finance.controller;


import com.finance.dto.IncomeDto;
import com.finance.service.income.IncomeService;
import io.swagger.annotations.*;
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
@Api(value = "Incomes")
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
    @ApiOperation(value = "createIncome", notes = "Crates a new income")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New income successfully created"),
            @ApiResponse(code = 400, message = "Bad request, adjust before retrying"),
            @ApiResponse(code = 406, message = "Rejected, missing required fields"),
            @ApiResponse(code = 409, message = "Income with the same name already exists"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Mono<?>> createIncome(
            @ApiParam("Income specification") @RequestBody IncomeDto incomeDto
            ){
        if (incomeDto == null){
            return new ResponseEntity<>(Mono.empty(), HttpStatus.NOT_ACCEPTABLE);
        }
        incomeService.createIncome(incomeDto);

        return new ResponseEntity<>(Mono.empty(), HttpStatus.CREATED);
    }

}
