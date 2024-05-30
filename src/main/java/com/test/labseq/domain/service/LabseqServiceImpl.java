package com.test.labseq.domain.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LabseqServiceImpl implements LabseqService {

    @Override
    @Cacheable("sequence")
    public int getSingleValue(int n) {
        validateParam(n);
        return (n <= 3) ? getDefault(n) : getBySequence(n);
    }

    private void validateParam(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index must be a non-negative.");
        }
    }

    private int getDefault(int n) {
        return n == 0 || n == 2 ? 0 : 1;
    }

    private int getBySequence(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 0;
        ints[3] = 1;

        for (int i = 4; i <= n; i++) {
            ints[i] = ints[i - 4] + ints[i - 3];
        }

        return ints[n];
    }
}
