package com.robo.project.controllers;


import com.robo.project.mappers.BalanceRestMapper;
import com.robo.project.services.BalanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/search")
@RestController
@RequiredArgsConstructor
@Tag(name = "Search", description = "Search transactions")
public class SearchController {

    private final BalanceService balanceService;
    private final BalanceRestMapper mapper;

    @GetMapping
    @Operation(summary = "Get transaction by query")
    public ResponseEntity<?> searchProducts(@RequestParam("query") @NotBlank String query){
       var result =  balanceService.getSortedAndMappedTransactionDTOs(balanceService.searchProducts(query));
        return ResponseEntity.ok(result);
    }
}
