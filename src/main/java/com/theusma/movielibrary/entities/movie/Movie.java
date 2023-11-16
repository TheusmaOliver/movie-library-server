package com.theusma.movielibrary.entities.movie;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_movies")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String category;
    private Double score;
    private String year;
    private String description;
}
