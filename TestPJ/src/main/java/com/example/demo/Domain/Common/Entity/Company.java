package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Company {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private String stockCode;
    private String corpCode;
    private String corpName;
    private String market;
    private boolean listed;
}