/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.udemy.dao.ConnectionDataSources;
import dto.ContactPerson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salvarez
 */
public class ServiceCP implements IServiceCP {

    private Connection con;

    public Connection getConnection() {
        if (con == null) {
            con = new ConnectionDataSources().getConnect();
        }
        return new ConnectionDataSources().getConnect();
    }

    public void closeConnection() {
        try {
            getConnection().close();
            con = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ContactPerson> lista() {
        List<ContactPerson> list = new ArrayList<>();

        try {
            Statement stmt = getConnection().createStatement();
            ResultSet result = stmt.executeQuery("select * from contactperson");
            while (result.next()) {
                ContactPerson contactPerson = new ContactPerson();
                contactPerson.setId(result.getInt("id_"));
                contactPerson.setName(result.getString("name_"));
                contactPerson.setLastname(result.getString("lastname_"));
                contactPerson.setContactName(result.getInt("cellphone_"));
                contactPerson.setDescription(result.getString("description_"));
                list.add(contactPerson);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    @Override
    public ContactPerson findById(Integer dato) {
        ResultSet result = null;
        ContactPerson contactPerson = new ContactPerson();

        try {
            String sql = "select * from contactperson where id_ = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, dato);
            result = ps.executeQuery();
            if (!result.next()) {
                throw new SQLException("No hay datos en BD");
            }

            contactPerson.setId(result.getInt("id_"));
            contactPerson.setName(result.getString("name_"));
            contactPerson.setLastname(result.getString("lastname_"));
            contactPerson.setContactName(result.getInt("cellphone_"));
            contactPerson.setDescription(result.getString("description_"));
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(ServiceCP.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return contactPerson;
    }

    @Override
    public void saveOrUpdate(ContactPerson contactPerson) {
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO CONTACTPERSON (name_,lastname_,cellphone_,description_) values(?,?,?,?)";
            String sqlUpdate = "UPDATE CONTACTPERSON SET name_=?, lastname_=?, cellphone_=?, description_=? where id_ = ?";
            if (contactPerson.getId() == 0) {
                preparedStatement = getConnection().prepareStatement(sqlInsert);
                preparedStatement.setString(1, contactPerson.getName());
                preparedStatement.setString(2, contactPerson.getLastname());
                preparedStatement.setInt(3, contactPerson.getContactName());
                preparedStatement.setString(4, contactPerson.getDescription());
            } else {
                preparedStatement = getConnection().prepareStatement("UPDATE CONTACTPERSON SET name_=?, lastname_=?, cellphone_=?, description_=? where id_ = ?");
                preparedStatement.setString(1, contactPerson.getName());
                preparedStatement.setString(2, contactPerson.getLastname());
                preparedStatement.setInt(3, contactPerson.getContactName());
                preparedStatement.setString(4, contactPerson.getDescription());
                preparedStatement.setInt(5, contactPerson.getId());
            }
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ServiceCP.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }

    }

    @Override
    public void delete(String id) {
        PreparedStatement preparedStatement = null;
        try {
            String sqlRemove = "delete from CONTACTPERSON where id_ = ? ";
            preparedStatement = getConnection().prepareStatement(sqlRemove);
            preparedStatement.setString(1, id);            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            Logger.getLogger(ServiceCP.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
    }

}
