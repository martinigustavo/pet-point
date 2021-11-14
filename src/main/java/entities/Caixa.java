/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CAIXA")
public class Caixa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double valor_total;
    
    @ManyToOne()
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id", referencedColumnName = "id")
    private Venda venda;
    
    @ManyToOne()
    @JoinColumn(name = "servico_id")
    private Servico servico;
}
