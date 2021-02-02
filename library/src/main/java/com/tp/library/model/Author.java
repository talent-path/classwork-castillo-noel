package com.tp.library.model;

import java.util.List;

public class Author {

    // V A R I A B L E S
    public String firstName;
    public String lastName;


    // C O N S T R U C T O R S

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // M E T H O D S

    // G E T T E R S && S E T T E R S

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
