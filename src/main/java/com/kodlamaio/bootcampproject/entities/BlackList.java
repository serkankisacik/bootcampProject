package com.kodlamaio.bootcampproject.entities;

import com.kodlamaio.bootcampproject.entities.aplications.Application;
import com.kodlamaio.bootcampproject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "black_lists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "reason")
    private String reason;

}
