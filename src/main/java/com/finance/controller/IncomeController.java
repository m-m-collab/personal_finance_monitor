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
import reactor.core.publisher.Flux;
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

    @GetMapping
    public Flux<IncomeDto> getAllIncomes() {
        return Flux.fromIterable(incomeService.getAllIncomes());
    }

    /**
     * Create a new Income.
     */
    @PostMapping("/{userId}")
    @Operation(description = "createIncome")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New income successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request, adjust before retrying"),
            @ApiResponse(responseCode = "406", description = "Rejected, missing required fields"),
            @ApiResponse(responseCode = "409", description = "Income with the same name already exists"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Mono<ResponseEntity<IncomeDto>> createIncome(
            @RequestBody(required = true) IncomeDto incomeDto,
            @PathVariable Long userId
            ){
        IncomeDto savedIncomeDto = incomeService.createIncome(incomeDto, userId);

        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedIncomeDto));
    }

}
