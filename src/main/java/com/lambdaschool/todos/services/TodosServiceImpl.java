package com.lambdaschool.todos.services;

import com.lambdaschool.todos.repository.TodosRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosRepository;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        todosRepository.findById(todoid)
            .orElseThrow(() -> new EntityNotFoundException("Todo id " + todoid + "Not Found"));

    }
}
