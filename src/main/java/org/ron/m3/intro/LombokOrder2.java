package org.ron.m3.intro;

import java.math.BigDecimal;
import java.time.LocalDate;

@lombok.Data
public class LombokOrder2 {
    private final LocalDate orderDate;
    private final int orderNumber;
    private String customerName;
    private int state;
    private String productType;
    private BigDecimal area;
    private BigDecimal materialCost;
    private BigDecimal labourCost;
    private BigDecimal tax;
    private BigDecimal total;
}
