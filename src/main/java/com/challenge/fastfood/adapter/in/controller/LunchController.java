package com.challenge.fastfood.adapter.in.controller;

import com.challenge.fastfood.adapter.in.controller.request.LunchRequest;
import com.challenge.fastfood.adapter.in.controller.response.LunchResponse;
import com.challenge.fastfood.adapter.out.mapstruct.LunchMapper;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.in.lunch.CreateLunchUseCasePort;
import com.challenge.fastfood.domain.ports.in.lunch.FindLunchUseCasePort;
import com.challenge.fastfood.domain.ports.in.lunch.LunchControllerPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lunch")
@Tag(name = "Lunch", description = "Lunch Controller")
@RequiredArgsConstructor
public class LunchController {

    private final LunchControllerPort lunchControllerPort;
    private final LunchMapper lunchMapper;

    @PostMapping
    @Operation(summary = "Create a lunch order", description = "Create a lunch order")
    public ResponseEntity<LunchResponse> createLunch(@RequestBody LunchRequest lunchRequest) {
        Lunch createdLunch = lunchControllerPort.createLunch(lunchRequest);
        return ResponseEntity.ok(lunchMapper.lunchToLunchResponse(createdLunch));
    }

    @GetMapping
    @Operation(summary = "Get lunch order", description = "Get lunch order")
    public ResponseEntity<List<LunchResponse>> getAllLunchs() {
        List<Lunch> lunchs = lunchControllerPort.findLunchs();
        return ResponseEntity.ok(lunchMapper.lunchsToLunchsResponse(lunchs));
    }


}
