package com.example.books.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="authors")
public class Author {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "full_names")
    private String fullNames;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="date_of_birth")
    private LocalDate dob;

    public Author(Long id, String fullNames) {
        this.id = id;
        this.fullNames = fullNames;
    }


}
