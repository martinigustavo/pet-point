/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class VendaProduto {
    
    private int id;
    private double qtde_item;
    private double valor_item;
    
    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;
    
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
}
