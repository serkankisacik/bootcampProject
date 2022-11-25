package com.kodlamaio.bootcampproject.entities.bootcamps;

import com.kodlamaio.bootcampproject.entities.aplications.Application;
import com.kodlamaio.bootcampproject.entities.users.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "bootcamps")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "dateStart")
    private LocalDate dateStart;
    @Column(name = "dateEnd")
    private LocalDate dateEnd;
    @Column(name = "state")
    private int state;

    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
