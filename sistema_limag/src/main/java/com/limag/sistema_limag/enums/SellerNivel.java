package com.limag.sistema_limag.enums;

import java.math.BigDecimal;

public enum SellerNivel {
/*
    SUPPORT(new BigDecimal("30000.00"), new BigDecimal("50000.00"), new BigDecimal("75000.00"), new BigDecimal("87000.00"), new BigDecimal("100000.00")),
    JUNIOR(new BigDecimal("60000.00"), new BigDecimal("100000.00"), new BigDecimal("125000.00"), new BigDecimal("150000.00"), new BigDecimal("175000.00")),
    SPECIALIST(new BigDecimal("120000.00"), new BigDecimal("180000.00"), new BigDecimal("225000.00"), new BigDecimal("270000.00"), new BigDecimal("315000.00"));
*/
        SUPPORT, JUNIOR, SPECIALIST;

        private BigDecimal quota;
        private BigDecimal goal;
        private BigDecimal megaGoalOne;
        private BigDecimal megaGoalTwo;
        private BigDecimal megaGoalThree;

        public void setQuota(BigDecimal quota) {
            this.quota = quota;
        }

        public void setGoal(BigDecimal goal) {
            this.goal = goal;
        }

        public void setMegaGoalOne(BigDecimal megaGoalOne) {
            this.megaGoalOne = megaGoalOne;
        }

        public void setMegaGoalTwo(BigDecimal megaGoalTwo) {
            this.megaGoalTwo = megaGoalTwo;
        }

        public void setMegaGoalThree(BigDecimal megaGoalThree) {
            this.megaGoalThree = megaGoalThree;
        }

        public BigDecimal getQuota() {
            return quota;
        }

        public BigDecimal getGoal() {
            return goal;
        }

        public BigDecimal getMegaGoalOne() {
            return megaGoalOne;
        }

        public BigDecimal getMegaGoalTwo() {
            return megaGoalTwo;
        }

        public BigDecimal getMegaGoalThree() {
            return megaGoalThree;
        }
    }

