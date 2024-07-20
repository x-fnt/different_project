package com.example.rest;

import static xfnt.LoggerFactory.info;
import static xfnt.LoggerFactory.step;

public class LoanController {

    public static String readLoanUpdate(String loan) {
        step(">>>>LoanUpdateMessage_v1 Request");
        info(loan);
        step("<<<< LoanUpdateMessage_v1 Response");
        return loan;
    }
}
