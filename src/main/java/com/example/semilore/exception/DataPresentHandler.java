package com.example.semilore.exception;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

public class DataPresentHandler extends IncorrectResultSizeDataAccessException {

    public DataPresentHandler(String msg, int expectedSize) {
        super(msg, expectedSize);
    }

}
