package com.app.labseq.application.controller;

import com.app.labseq.application.dto.SampleResponseDto;
import com.app.labseq.domain.service.LabseqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "LabseqController", description = "REST APIs related to get single value of sequence")
public class LabseqController {

    private final LabseqService labseqService;

    @Autowired
    public LabseqController(LabseqService labseqService) {
        this.labseqService = labseqService;
    }

    @GetMapping("/labseq/{n}")
    @Operation(
        summary = "Get sequence value",
        description = "Returns the single value of sequence for a given index"
    )
    public ResponseEntity<SampleResponseDto> getSequence(
        @Parameter(description = "Index of the sequence", required = true)
        @PathVariable int n
    ) {
        return ResponseEntity.ok(
            new SampleResponseDto(labseqService.getSingleValue(n))
        );
    }
}
