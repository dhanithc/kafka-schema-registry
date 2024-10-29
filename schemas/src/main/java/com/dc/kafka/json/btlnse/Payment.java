package com.dc.kafka.json.btlnse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

/**
 * Created by dhanith on 1/26/2024
 */
public class Payment {
    @JsonProperty(required = true)
    @NotBlank(message = "Id is required")
    private String id;
    @JsonProperty
    private int currNo;
    @JsonProperty
    private String companyCode;
    @JsonProperty
    private String bu;
    @JsonProperty
    private Audit audit;
    @JsonProperty
    private String countryCode;
    @JsonProperty
    private String testOptionalField;
    @JsonProperty(required = true)
    private String testRequiredField;

    @JsonProperty
    private String newOptionalField;

    @JsonProperty(required = true)
    private String newRequiredField;

//    @JsonProperty
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private Date dateTime;

    private Payment() {
    }

    public Payment(String id, int currNo, String companyCode, String bu, Audit audit, String countryCode, String testOptionalField, String testRequiredField, String newOptionalField, String newRequiredField) {
        this.id = id;
        this.currNo = currNo;
        this.companyCode = companyCode;
        this.bu = bu;
        this.audit = audit;
        this.countryCode = countryCode;
        this.testOptionalField = testOptionalField;
        this.testRequiredField = testRequiredField;
        this.newOptionalField = newOptionalField;
        this.newRequiredField = newRequiredField;
    }

    //    @JsonCreator

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrNo() {
        return currNo;
    }

    public void setCurrNo(int currNo) {
        this.currNo = currNo;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTestOptionalField() {
        return testOptionalField;
    }

    public void setTestOptionalField(String testOptionalField) {
        this.testOptionalField = testOptionalField;
    }

    public String getTestRequiredField() {
        return testRequiredField;
    }

    public void setTestRequiredField(String testRequiredField) {
        this.testRequiredField = testRequiredField;
    }

    public String getNewOptionalField() {
        return newOptionalField;
    }

    public void setNewOptionalField(String newOptionalField) {
        this.newOptionalField = newOptionalField;
    }

    public String getNewRequiredField() {
        return newRequiredField;
    }

    public void setNewRequiredField(String newRequiredField) {
        this.newRequiredField = newRequiredField;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", currNo=" + currNo +
                ", companyCode='" + companyCode + '\'' +
                ", bu='" + bu + '\'' +
                ", audit=" + audit +
                ", countryCode='" + countryCode + '\'' +
                ", testOptionalField='" + testOptionalField + '\'' +
                ", testRequiredField='" + testRequiredField + '\'' +
                ", newOptionalField='" + newOptionalField + '\'' +
                ", newRequiredField='" + newRequiredField + '\'' +
                '}';
    }

    public static final class Builder {
        private String id;
        private int currNo;
        private String companyCode;
        private String bu;
        private Audit audit;
        private String countryCode;
        private String testOptionalField;
        private String testRequiredField;

        private Builder() {
        }

        public static Builder aPayment() {
            return new Builder();
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withCurrNo(int currNo) {
            this.currNo = currNo;
            return this;
        }

        public Builder withCompanyCode(String companyCode) {
            this.companyCode = companyCode;
            return this;
        }

        public Builder withBu(String bu) {
            this.bu = bu;
            return this;
        }

        public Builder withAudit(Audit audit) {
            this.audit = audit;
            return this;
        }

        public Builder withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder withTestOptionalField(String testOptionalField) {
            this.testOptionalField = testOptionalField;
            return this;
        }

        public Builder withTestRequiredField(String testRequiredField) {
            this.testRequiredField = testRequiredField;
            return this;
        }

        public Payment build() {
            Payment payment = new Payment();
            payment.setId(id);
            payment.setCurrNo(currNo);
            payment.setCompanyCode(companyCode);
            payment.setBu(bu);
            payment.setAudit(audit);
            payment.setCountryCode(countryCode);
            payment.setTestOptionalField(testOptionalField);
            payment.setTestRequiredField(testRequiredField);
            return payment;
        }
    }
}
