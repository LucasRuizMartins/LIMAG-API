package com.limag.sistema_limag.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "tb_compradores")
@Entity
@Setter
public class Purchaser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private String origin;
    private String phoneNumber;
    private String email;


    @ManyToOne
    @JoinColumn(name="client_group_id")
    private ClientGroup clientGroup;






}
