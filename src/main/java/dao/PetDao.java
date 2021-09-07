/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Pet;
import org.hibernate.SessionFactory;

public class PetDao extends AbstractGenericDao<Pet> {

    public PetDao(SessionFactory sessionFactory) {
        super(sessionFactory, Pet.class, "Pet");
    }
    
}
