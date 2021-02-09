package com.tp.staffing.model;


public class Position {

    // V A R I A B L E S
    private Integer id;
    private String title;


    // C O N S T R U C T O R S
    public Position(){

    }

    public Position(Integer bookId, String title) {
        this.id = bookId;
        this.title = title;

    }

    public Position(Position that) {
        this.id = that.id;
        this.title = that.title;

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

}
