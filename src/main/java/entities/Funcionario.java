    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Funcionario extends Pessoa {
    
    private String usuario;
    private String senha;
    private boolean logado;
    private String atividade;
    
    @ManyToOne
    @JoinColumn(name = "permissao_id", nullable = false)
    private Permissao permissao;
    
    @OneToMany(mappedBy = "funcionario")
    private List<Log> logs;
}

