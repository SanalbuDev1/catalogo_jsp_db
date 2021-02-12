/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBean;

import dto.ContactPerson;
import java.util.List;
import service.IServiceCP;
import service.ServiceCP;

/**
 *
 * @author salvarez
 */
public class ContactNameBean extends ContactPerson {

   
            
    private IServiceCP IService = new ServiceCP();   
    
    public List<ContactPerson> findAll() {
        return IService.lista();
    }
    
    public ContactPerson findById(){
        return IService.findById(id);
    }
    
    public void saveOrUpdate(ContactPerson cp){
        IService.saveOrUpdate(cp);
    }
    
    public void delete(String id){
        IService.delete(id);
    }
}
