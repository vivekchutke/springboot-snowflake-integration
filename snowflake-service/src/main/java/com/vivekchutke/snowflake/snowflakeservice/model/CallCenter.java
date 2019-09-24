package com.vivekchutke.snowflake.snowflakeservice.model;

//import javax.persistence.Entity;

//@Entity
public class CallCenter {

    private String CC_STREET_TYPE;
    private String CC_SUITE_NUMBER;
    private String CC_CITY;
    private String CC_COUNTY;
    private String CC_STATE;
    private String CC_ZIP;
    private String CC_COUNTRY;
    private String CC_GMT_OFFSET;
    private String CC_TAX_PERCENTAGE;

    public String getCC_STREET_TYPE() {
        return CC_STREET_TYPE;
    }

    public void setCC_STREET_TYPE(String CC_STREET_TYPE) {
        this.CC_STREET_TYPE = CC_STREET_TYPE;
    }

    public String getCC_SUITE_NUMBER() {
        return CC_SUITE_NUMBER;
    }

    public void setCC_SUITE_NUMBER(String CC_SUITE_NUMBER) {
        this.CC_SUITE_NUMBER = CC_SUITE_NUMBER;
    }

    public String getCC_CITY() {
        return CC_CITY;
    }

    public void setCC_CITY(String CC_CITY) {
        this.CC_CITY = CC_CITY;
    }

    public String getCC_COUNTY() {
        return CC_COUNTY;
    }

    public void setCC_COUNTY(String CC_COUNTY) {
        this.CC_COUNTY = CC_COUNTY;
    }

    public String getCC_STATE() {
        return CC_STATE;
    }

    public void setCC_STATE(String CC_STATE) {
        this.CC_STATE = CC_STATE;
    }

    public String getCC_ZIP() {
        return CC_ZIP;
    }

    public void setCC_ZIP(String CC_ZIP) {
        this.CC_ZIP = CC_ZIP;
    }

    public String getCC_COUNTRY() {
        return CC_COUNTRY;
    }

    public void setCC_COUNTRY(String CC_COUNTRY) {
        this.CC_COUNTRY = CC_COUNTRY;
    }

    public String getCC_GMT_OFFSET() {
        return CC_GMT_OFFSET;
    }

    public void setCC_GMT_OFFSET(String CC_GMT_OFFSET) {
        this.CC_GMT_OFFSET = CC_GMT_OFFSET;
    }

    public String getCC_TAX_PERCENTAGE() {
        return CC_TAX_PERCENTAGE;
    }

    public void setCC_TAX_PERCENTAGE(String CC_TAX_PERCENTAGE) {
        this.CC_TAX_PERCENTAGE = CC_TAX_PERCENTAGE;
    }

    @Override
    public String toString() {
        return "CallCenter{" +
                "CC_STREET_TYPE='" + CC_STREET_TYPE + '\'' +
                ", CC_SUITE_NUMBER='" + CC_SUITE_NUMBER + '\'' +
                ", CC_CITY='" + CC_CITY + '\'' +
                ", CC_COUNTY='" + CC_COUNTY + '\'' +
                ", CC_STATE='" + CC_STATE + '\'' +
                ", CC_ZIP='" + CC_ZIP + '\'' +
                ", CC_COUNTRY='" + CC_COUNTRY + '\'' +
                ", CC_GMT_OFFSET='" + CC_GMT_OFFSET + '\'' +
                ", CC_TAX_PERCENTAGE=" + CC_TAX_PERCENTAGE +
                '}';
    }
}
