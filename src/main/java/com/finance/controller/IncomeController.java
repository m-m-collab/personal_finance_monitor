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

import java.util.stream.Stream;

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
     * Get all incomes.
     */
    @GetMapping("/")
    @Operation(description = "getAllIncomes")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Flux<IncomeDto>> getAllIncomes(){
        Stream<IncomeDto> streamIncomeDto = incomeService.getAllIncomes().stream();

        return new ResponseEntity<>(Flux.fromStream(streamIncomeDto), HttpStatus.OK);
    }

    /**
     * Get income.
     */
    @GetMapping("/{incomeId}")
    @Operation(description = "getIncomeById")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New income successfully created"),
            @ApiResponse(responseCode = "404", description = "Income not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")    })
    public ResponseEntity<Mono<IncomeDto>> getIncomeById(
            @PathVariable Long incomeId
    ){
        IncomeDto IncomeDto = incomeService.findIncomeById(incomeId);

        return new ResponseEntity<>(Mono.just(IncomeDto), HttpStatus.CREATED);
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
    public ResponseEntity<Mono<IncomeDto>> createIncome(
            @RequestBody(required = true) IncomeDto incomeDto,
            @PathVariable Long userId
            ){
        IncomeDto savedIncomeDto = incomeService.createIncome(incomeDto, userId);

        return new ResponseEntity<>(Mono.just(savedIncomeDto), HttpStatus.CREATED);
    }


    /**
     * Delete Income.
     */
    @PostMapping("/{incomeId}")
    @Operation(description = "deleteIncome")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Income deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Income not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Mono<?>> deleteIncome(
            @PathVariable Long incomeId
    ){
        incomeService.deleteIncomeById(incomeId);

        return new ResponseEntity<>(Mono.empty(), HttpStatus.NO_CONTENT);
    }

}
