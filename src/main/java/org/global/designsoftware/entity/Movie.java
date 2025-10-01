package org.global.designsoftware.entity;

import jakarta.persistence.*;
import lombok.*;
import org.global.designsoftware.enums.Genre;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "fees")
    private Float fees;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

}

