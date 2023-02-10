package com.example.Project.service;

import com.example.Project.model.Limit;

import java.util.List;

public interface ILimitService {
    public Limit add(Limit limit);
    public List<Limit> getAll();
}
