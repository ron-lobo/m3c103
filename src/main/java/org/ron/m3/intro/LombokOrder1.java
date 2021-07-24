package org.ron.m3.intro;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LombokOrder1 {
    private final LocalDate orderDate;
    private final int orderNumber;
    private String customerName;
    private int state;
    private String productType;
    private BigDecimal area;
    private BigDecimal materialCost;
    private BigDecimal labourCost;
    private BigDecimal tax;
}
