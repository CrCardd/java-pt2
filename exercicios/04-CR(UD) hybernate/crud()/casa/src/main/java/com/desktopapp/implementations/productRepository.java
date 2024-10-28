package com.desktopapp.implementations;

import java.util.List;

import com.desktopapp.Context;
import com.desktopapp.model.Product;
import com.desktopapp.repository.repository;

public class productRepository extends repository<Product> {
    @Override
    public List<Product> get(Product item){
        Context ctx = new Context();
        String query_str = "FROM Product WHERE id_Product = :id";
        var query = ctx.createQuery(Product.class, query_str);
        query.setParameter("id", item.getId());
        return query.getResultList();
    }
}
