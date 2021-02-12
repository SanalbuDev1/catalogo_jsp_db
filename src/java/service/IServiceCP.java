/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.ContactPerson;
import java.util.List;

/**
 *
 * @author salvarez
 */
public interface IServiceCP {
    
    public List<ContactPerson> lista();
    
    public ContactPerson findById(Integer dato);
    
    public void saveOrUpdate(ContactPerson contactPerson);
    
    public void delete(String id);
    
}
