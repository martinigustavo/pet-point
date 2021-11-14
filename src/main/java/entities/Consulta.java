/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CONSULTA")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalTime hora;
    private LocalDate data;
    @Column(length = 1024)
    private String observacoes;
    @Column(length = 1024)
    private String medicamentos;
    
    @ManyToOne()
    @JoinColumn(name = "pet_id")
    private Pet pet;
    
    @ManyToOne()
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;
    
    @OneToMany(mappedBy = "consulta")
    private Set<Servico> servicos;
}
