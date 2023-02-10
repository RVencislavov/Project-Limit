package com.example.Project.Dao;

import com.example.Project.model.Limit;

import java.util.List;

public interface ILimitDao {
    public Limit add(Limit limit);
    public List<Limit> getAll();
}
