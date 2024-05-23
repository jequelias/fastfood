package com.challenge.fastfood.adapter.in.controller;

import com.challenge.fastfood.adapter.in.controller.request.LunchItemRequest;
import com.challenge.fastfood.adapter.in.controller.response.LunchItemResponse;
import com.challenge.fastfood.adapter.out.mapstruct.LunchItemMapper;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.entities.LunchItemType;
import com.challenge.fastfood.domain.ports.in.lunchItem.LunchItemsControllerPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lunch-items")
@Tag(name = "LunchItems", description = "Lunch Items Controller")
@RequiredArgsConstructor
public class LunchItemsController {

    private final LunchItemsControllerPort lunchItemsControllerPort;
    private final LunchItemMapper lunchItemMapper;

    @GetMapping
    @Operation(summary = "Get available lunch items", description = "Get available lunch items")
    public ResponseEntity<List<LunchItemResponse>> getLunchItems(@RequestParam(required = false) String type) {
        LunchItemType lunchItemType;
        try {
            lunchItemType = type == null ? null : LunchItemType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(List.of());
        }
        List<LunchItem> lunchItemList = lunchItemsControllerPort.findLunchItems(lunchItemType);
        return ResponseEntity.ok(lunchItemMapper.lunchItemToLunchItemResponse(lunchItemList));
    }

    @PostMapping
    @Operation(summary = "Create a lunch item", description = "Create a lunch item")
    public ResponseEntity<LunchItemResponse> createLunchItem(@RequestBody LunchItemRequest lunchItemRequest) {
        LunchItem lunchItem = lunchItemsControllerPort.createLunchItem(lunchItemMapper.lunchItemRequestToLunchItem(lunchItemRequest));
        return ResponseEntity.ok(lunchItemMapper.lunchItemToLunchItemResponse(lunchItem));
    }

    @DeleteMapping("/{lunchId}")
    @Operation(summary = "Delete a lunch order", description = "Delete a lunch order")
    public ResponseEntity<Boolean> deleteLunch(@PathVariable Long lunchId, @RequestParam Boolean status){
        Boolean deleteLunchItem = lunchItemsControllerPort.editStatusLunchItem(lunchId, status);
        return ResponseEntity.ok(deleteLunchItem);
    }

    @PutMapping("/{lunchId}")
    @Operation(summary = "Edit a lunch order", description = "Edit a lunch order")
    public ResponseEntity<LunchItemResponse> editLunchItem(@PathVariable Long lunchId, @RequestBody LunchItemRequest lunchItemRequest) {
        LunchItem toLunchItem = lunchItemMapper.lunchItemRequestToLunchItem(lunchItemRequest);
        LunchItem lunchItem = lunchItemsControllerPort.editLunchItem(lunchId, toLunchItem);
        return ResponseEntity.ok(lunchItemMapper.lunchItemToLunchItemResponse(lunchItem));
    }
}
