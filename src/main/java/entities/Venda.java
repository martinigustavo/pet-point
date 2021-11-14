/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VENDA")
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    private double valor;
    private String forma_pagamento;
    
    @OneToOne(mappedBy = "venda")
    private Caixa caixa;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "venda_produto", 
        joinColumns = { @JoinColumn(name = "venda_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "produto_id") }
    )
    Set<Produto> produtos = new HashSet<>();
}
