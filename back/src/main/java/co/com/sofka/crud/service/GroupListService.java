package co.com.sofka.crud.service;

import co.com.sofka.crud.model.GroupList;
import co.com.sofka.crud.repository.GroupListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupListService {

    @Autowired
    private GroupListRepository repository;

    public Iterable<GroupList> list(){
        return repository.findAll();
    }

    public GroupList save(GroupList category){
        return repository.save(category);
    }

    public GroupList update(GroupList category){
        return repository.save(category);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public GroupList get(Long id){
        return repository.findById(id).orElseThrow();
    }
}