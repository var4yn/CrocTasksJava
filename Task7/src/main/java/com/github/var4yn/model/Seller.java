package com.github.var4yn.model;

/**
 * Продавец
 */
public class Seller {
    private final String lastName, firstName;
    private final int id;

    /**
     * Конструктор класса
     * @param id - id продавца
     * @param lastName - фамилия продавца
     * @param firstName - имя продавца
     */
    public Seller(int id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}
