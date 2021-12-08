/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@NoArgsConstructor
@Entity
@Immutable
@Subselect("SELECT DATE_TRUNC('month', v.data_venda) AS  data, COUNT(v.id) AS qtde_vendas FROM venda v GROUP BY data order by data desc limit 12")
public class VendasPorMesView {
    
    @Id
    LocalDate data;
    int qtde_vendas;
    
}
