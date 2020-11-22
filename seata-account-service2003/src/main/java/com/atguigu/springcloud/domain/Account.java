package com.atguigu.springcloud.domain;

import java.math.BigDecimal;

public class Account {
    private Long id;
    private Long useId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUseId() {
        return useId;
    }

    public void setUseId(Long useId) {
        this.useId = useId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public BigDecimal getResidue() {
        return residue;
    }

    public void setResidue(BigDecimal residue) {
        this.residue = residue;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", useId=" + useId +
                ", total=" + total +
                ", used=" + used +
                ", residue=" + residue +
                '}';
    }

    public Account(Long id, Long useId, BigDecimal total, BigDecimal used, BigDecimal residue) {
        this.id = id;
        this.useId = useId;
        this.total = total;
        this.used = used;
        this.residue = residue;
    }
}
