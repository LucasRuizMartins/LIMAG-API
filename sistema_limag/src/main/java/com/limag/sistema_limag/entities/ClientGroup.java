package com.limag.sistema_limag.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_grupo_clientes")
public class ClientGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "clientGroup")
    private List<Client> customers = new ArrayList<>();

    @OneToMany(mappedBy = "clientGroup")
    private List<Purchaser> purchasers = new ArrayList<>();

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
    public List<Purchaser> getPurchasers() {
        return  new ArrayList<>(purchasers) ;
    }
    public void addCustomers(Client client) {
        customers.add(client);
    }
    public void addPurchaser(Purchaser purchaser) {
        purchasers.add(purchaser);
    }
}
