package com.desktopapp.implementations;

import java.util.List;

import com.desktopapp.Context;
import com.desktopapp.model.User;
import com.desktopapp.repository.repository;

public class userRepository extends repository<User> {
    @Override
    public List<User> get(User item){
        Context ctx = new Context();
        String query_str = "FROM User WHERE id_user = :id";
        var query = ctx.createQuery(User.class, query_str);
        query.setParameter("id", item.getId());
        return query.getResultList();
    }
}
