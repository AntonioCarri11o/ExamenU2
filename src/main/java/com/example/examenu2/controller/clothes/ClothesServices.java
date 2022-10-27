package com.example.examenu2.controller.clothes;

import com.example.examenu2.model.category.BeanCategory;
import com.example.examenu2.model.clothes.BeanClothes;
import com.example.examenu2.model.clothes.DaoClothes;
import com.example.examenu2.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/clothes")
public class ClothesServices {
Map<String,Object>response= new HashMap<>();
    @GET
    @Path("/")
    @Produces(value={"application/json"})
    public List<BeanClothes> getAll(){
        return  new DaoClothes().findAll();
    }
    /*
    @GET
    @Path("/categories")
    @Produces (value={"application/json"})
    public List<BeanCategory> getCategories(){
        return new DaoClothes().findCat();
    }
     */
    /*
    @GET
    @Path("/type")
    @Produces (value={"application/json"})
    public List<BeanCategory> getTypes(){
        return new DaoClothes().findType();
    }
*/
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id")Long id){
        return  new DaoClothes().findById(id);
    }
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,Object> save(BeanClothes clothe){
        Response<BeanClothes> result= new DaoClothes().save(clothe);
        response.put("result",result);
        return response;
    }

}
