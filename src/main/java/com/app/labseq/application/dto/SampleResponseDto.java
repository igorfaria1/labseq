package com.app.labseq.application.dto;

public class SampleResponseDto {
    private int result;

    public SampleResponseDto(int result) {
        this.result = result;
    }

    public int getResult() {
        return this.result;
    }
}
