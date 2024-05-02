package com.challenge.fastfood.domain.actor;

public class Example {

    private Long id;

    private String name;

    private String description;


    public Example() {
    }

    public Example(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Example( String name, String description) {
        this.description = description;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

}
