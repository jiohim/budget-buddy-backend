package com.robo.project.controllers;


import com.robo.project.mappers.BalanceRestMapper;
import com.robo.project.model.Transaction;
import com.robo.project.services.BalanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

@RequestMapping("api/v1/search")
@RestController
@RequiredArgsConstructor
@Tag(name = "Search", description = "Search transactions")
public class SearchController {

    private final BalanceService balanceService;
    private final BalanceRestMapper mapper;

    //TODO logic needs to be moved to service
    @GetMapping
    @Operation(summary = "Get transaction by query")
    public ResponseEntity<?> searchProducts(@RequestParam("query") String query){
       var result =  balanceService.searchProducts(query)
               .stream()
               .sorted(Comparator.comparingLong(Transaction::getId))
               .map(transaction -> mapper.toDto(transaction))
               .toList();;
        return ResponseEntity.ok(result);
    }
}
