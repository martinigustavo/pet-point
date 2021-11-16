/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PRODUTO")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String SKU;
    private String nome;
    private String descricao;
    private int estoque;
    private double preco_custo;
    private double preco_venda;
    private double desconto;
    private String status;
    private String categoria;
    
    @OneToMany(mappedBy = "produto")
    private Set<VendaProduto> vendaProdutos;
}
