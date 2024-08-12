package com.wanted;


import java.math.BigDecimal;
import java.time.LocalDate;

import static com.wanted.AmountToWords.convert;
import static com.wanted.InsuranceSubmission.getVacCheck;

public class Main {
    public static void main(String[] args) {

        //Task 1
        LocalDate today = LocalDate.of(2024, 8, 17);
        LocalDate nextWorkingDay = getVacCheck(today);
        System.out.println("Next working day: " + nextWorkingDay);

        //Task 2
        //System.out.println(convert(new BigDecimal("99999.99")));

        //SQL task
        /*
        SELECT
        rel."familyName",
                rel."givenName",
                rel."middleName",
                rel."birthDate",
                dep."contactRelationship"
        FROM
        "HPPersonGeneric" emp
                JOIN
        "HPPersonDependant" dep ON emp."sysId" = dep."HPPersonGenericSysId"
        JOIN
        "HPPersonGeneric" rel ON dep."HPRelatedPersonSysId" = rel."sysId"
        WHERE
        emp."personId" = 'test';
        */
    }

}