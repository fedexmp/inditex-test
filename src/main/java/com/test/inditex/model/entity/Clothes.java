package com.test.inditex.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clothes")
@Getter
@Setter
@NoArgsConstructor
public class Clothes {

    /**
     * Identifier attribute
     */
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Name attribute
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Sales attribute
     */
    @Column(name = "sales")
    private Integer sales;

    /**
     * Small size attribute
     */
    @Column(name = "small_size")
    private Integer small;

    /**
     * Medium size attribute
     */
    @Column(name = "medium_size")
    private Integer medium;

    /**
     * Large size attribute
     */
    @Column(name = "large_size")
    private Integer large;

    public Integer getPoints() {
        return sales + small + medium + large;
    }
}
