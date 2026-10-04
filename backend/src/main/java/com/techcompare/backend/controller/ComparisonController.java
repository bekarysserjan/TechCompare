package com.techcompare.backend.controller;

import com.techcompare.backend.dto.ComparisonRequest;
import com.techcompare.backend.dto.ComparisonResponse;
import com.techcompare.backend.service.ComparisonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin(origins = "http://localhost:5173")
public class ComparisonController {

    private final ComparisonService comparisonService;

    public ComparisonController(ComparisonService comparisonService) {
        this.comparisonService = comparisonService;
    }

    @PostMapping("/compare")
    public ComparisonResponse compareDevices(
            @Valid @RequestBody ComparisonRequest request) {

        return comparisonService.compareDevices(request);
    }
}