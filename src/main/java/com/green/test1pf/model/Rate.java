package com.green.test1pf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rate {
    @Id
    private String shortName;
    private Date validFrom;
    private String name;
    private String country;
    private int amount;
    private BigDecimal valBuy;
    private BigDecimal valSell;
    private BigDecimal valMid;
    private BigDecimal currBuy;
    private BigDecimal currSell;
    private BigDecimal currMid;
    private BigDecimal move;
    private BigDecimal cnbMid;
    private int version;
}
