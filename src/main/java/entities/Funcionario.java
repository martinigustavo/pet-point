    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String sexo;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;
    private LocalDate data_nascimento;
    private LocalDate data_cadastro;
    private String status;
    private String tipo;
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

