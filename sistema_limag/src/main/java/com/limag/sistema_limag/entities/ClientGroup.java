package com.limag.sistema_limag.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_grupo_clientes")
public class ClientGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "clientGroup")
    private List<Client> customers = new ArrayList<>();

    public ClientGroup() {    }

    public ClientGroup(Long id, String name, List<Client> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getCustomers() {
        return  new ArrayList<>(customers) ;
    }

    public void addCustomers(Client client) {
        customers.add(client);
    }
}
