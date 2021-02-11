package com.tp.staffing.model;


public class Position {

    // V A R I A B L E S
    private Integer id;
    private String title;
    private Integer employeeId;


    // C O N S T R U C T O R S
    public Position() {
        this.employeeId = null;
    }

    public Position(Integer id, String title, Integer employeeId) {
        this.id = id;
        this.title = title;
        this.employeeId = employeeId;

    }

    public Position(Position that) {
        this.id = that.id;
        this.title = that.title;
        this.employeeId = that.employeeId;

    }

    // M E T H O D S

    // G E T T E R S && S E T T E R S
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
