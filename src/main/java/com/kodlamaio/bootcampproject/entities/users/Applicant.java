package com.kodlamaio.bootcampproject.entities.users;

import com.kodlamaio.bootcampproject.entities.aplications.Application;
import com.kodlamaio.bootcampproject.entities.BlackList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "applicants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {
    @Column(name = "about")
    private String about;

    @OneToMany(mappedBy = "applicant")
    private List<BlackList> blackLists;
    
    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;
}
