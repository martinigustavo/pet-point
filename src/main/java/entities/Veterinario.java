/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VETERINARIO")
public class Veterinario extends Pessoa {
    
    private String crmv;
    private String usuario;
    private String senha;
    
    // agendas do veterinario
}
