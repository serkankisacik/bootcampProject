package com.kodlamaio.bootcampproject.entities.aplications;

import com.kodlamaio.bootcampproject.entities.bootcamps.Bootcamp;
import com.kodlamaio.bootcampproject.entities.users.Applicant;
import com.kodlamaio.bootcampproject.entities.users.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}
