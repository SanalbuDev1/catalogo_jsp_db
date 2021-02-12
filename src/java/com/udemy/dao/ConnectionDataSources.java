/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author salvarez
 */
public class ConnectionDataSources {
    
    private Connection con;
    
    public ConnectionDataSources(){
        connect();
    }
    
    public void connect(){
        try{
            Context contexto = new InitialContext();
            DataSource ds = (DataSource) contexto.lookup("java/javaCatalogo");
            con = ds.getConnection();
        } catch(NamingException e){
             Logger.getLogger(ConnectionDataSources.class.getName()).log(Level.SEVERE, null, e);
        } catch(SQLException e){
            Logger.getLogger(ConnectionDataSources.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public Connection getConnect(){
        return con;
    }
    
}
