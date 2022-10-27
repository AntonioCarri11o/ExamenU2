package com.example.examenu2.model.clothes;

import com.example.examenu2.model.Repository;
import com.example.examenu2.model.category.BeanCategory;
import com.example.examenu2.model.types.BeanType;
import com.example.examenu2.utils.MySQLConnection;
import com.example.examenu2.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoClothes implements Repository<BeanClothes> {
Connection connection;
PreparedStatement pstm;
ResultSet rs;
MySQLConnection client= new MySQLConnection();

@Override
    public List<BeanClothes> findAll(){
    List<BeanClothes> listClothes= new ArrayList<>();
    BeanClothes clothe= null;
    BeanCategory category= null;
    BeanType type= null;
    try{
        connection=client.getConnection();
        String query="SELECT clothes.*,categories.*,clothe_types.* From clothes JOIN categories ON categories.id=category_id JOIN clothe_types ON clothe_types.id=clothe_type_id;";
        pstm=connection.prepareStatement(query);
        rs=pstm.executeQuery();
        while (rs.next()){
            clothe= new BeanClothes();
            category= new BeanCategory();
            type= new BeanType();
            System.out.println(rs.getLong("clothes.id"));
            clothe.setId(rs.getLong("clothes.id"));
            clothe.setName(rs.getString("clothes.name"));
            clothe.setPrice(rs.getDouble("price"));
            clothe.setSize(rs.getString("size"));
            clothe.setBrand(rs.getString("brand"));
            clothe.setStock(rs.getInt("stock"));
            clothe.setCreated_at(rs.getString("created_at"));
            clothe.setStatus(rs.getInt("status"));
            category.setId(rs.getLong("categories.id"));
            category.setName(rs.getString("categories.name"));
            type.setId(rs.getLong("clothe_types.id"));
            type.setName(rs.getString("clothe_types.name"));
            clothe.setCategory(category);
            clothe.setType(type);
            listClothes.add(clothe);
        }
    }catch (SQLException e){
        Logger.getLogger(DaoClothes.class.getName()).log(Level.SEVERE,"Error->findAll"+e.getMessage());
    }finally {
        client.close(connection,pstm,rs);
    }
    return listClothes;
    }
/*
    @Override
    public List<BeanCategory> findCat() {
        List<BeanCategory> listCategories= new ArrayList<>();
        BeanCategory category= null;
        try{
            connection=client.getConnection();
            String query="Select * from categories;";
            pstm=connection.prepareStatement(query);
            rs=pstm.executeQuery();
            while (rs.next()){
                category= new BeanCategory();
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
                listCategories.add(category);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoClothes.class.getName()).log(Level.SEVERE,"Error->findCategories "+e.getMessage());

        }
        return listCategories;
    }



    @Override
    public List<BeanClothes> findType() {
        return null;
    }
*/
    @Override
    public Response findById(Long id) {
    BeanClothes clothe=null;
    BeanCategory category=null;
    BeanType type=null;
    try{
        connection=client.getConnection();
        String query="SELECT clothes.*,categories.*,clothe_types.* From clothes JOIN categories ON categories.id=category_id JOIN clothe_types ON clothe_types.id=clothe_type_id where clothes.id=?;";
        pstm=connection.prepareStatement(query);
        pstm.setLong(1,id);
        rs=pstm.executeQuery();
        while(rs.next()){
            clothe= new BeanClothes();
            category= new BeanCategory();
            type= new BeanType();
            System.out.println(rs.getLong("clothes.id"));
            clothe.setId(rs.getLong("clothes.id"));
            clothe.setName(rs.getString("clothes.name"));
            clothe.setPrice(rs.getDouble("price"));
            clothe.setSize(rs.getString("size"));
            clothe.setBrand(rs.getString("brand"));
            clothe.setStock(rs.getInt("stock"));
            clothe.setCreated_at(rs.getString("created_at"));
            clothe.setStatus(rs.getInt("status"));
            category.setId(rs.getLong("categories.id"));
            category.setName(rs.getString("categories.name"));
            type.setId(rs.getLong("clothe_types.id"));
            type.setName(rs.getString("clothe_types.name"));
            clothe.setCategory(category);
            clothe.setType(type);
        }
    }catch (SQLException e){
        Logger.getLogger(DaoClothes.class.getName()).log(Level.SEVERE,"Error->find: "+e.getMessage());
    }finally {
        client.close(connection,pstm,rs);
    }
        return  new Response<>(200,"Registrado Correctamente",clothe,false);
    }

    @Override
    public Response save(BeanClothes clothe) {
        try{
            connection =client.getConnection();
            String query= "Insert into clothes (name,price,size,brand,stock,category_id,clothe_type_id) values(?,?,?,?,?,?,?);";
            pstm=connection.prepareStatement(query);
            pstm.setString(1,clothe.getName());
            pstm.setDouble(2,clothe.getPrice());
            pstm.setString(3,clothe.getSize());
            pstm.setString(4,clothe.getBrand());
            pstm.setInt(5,clothe.getStock());
            pstm.setLong(6,clothe.getCategory().getId());
            pstm.setLong(7,clothe.getType().getId());
            if(pstm.executeUpdate()==1){
                return  new Response<>(200,"Registrado Correctamente",clothe,false);
            }else{
                return new Response<>(200,"Error al registrar",clothe,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoClothes.class.getName()).log(Level.SEVERE,"Error->save: "+e.getMessage());
            return new Response<>(400,"Error con el Servidor",null,true);
        }finally {
            client.close(connection,pstm,rs);
        }
    }

    @Override
    public Response update(BeanClothes object) {
        return null;
    }
}
