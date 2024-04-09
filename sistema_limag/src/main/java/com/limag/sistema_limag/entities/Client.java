package com.limag.sistema_limag.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name="client_group_id")
    private ClientGroup clientGroup;

    public Client() {

    }

    public Client(Long id, String name, String address, ClientGroup clientGroup) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.clientGroup = clientGroup;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientGroup getClientGroup() {
        return clientGroup;
    }

    public void setClientGroup(ClientGroup clientGroup) {
        this.clientGroup = clientGroup;
    }
}
