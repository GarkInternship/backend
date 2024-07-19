package com.gark.project.Service;

import com.gark.project.Entity.Contract;
import com.gark.project.Entity.Group;
import com.gark.project.Rpository.ContractRepository;
import com.gark.project.Rpository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;
    @Override
    public List<Group> getAllGroups() {
        return (List<Group>) groupRepository.findAll();
    }

    @Override
    public Group getGroupById(String id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Group saveGroup(Group contract) {
        return groupRepository.save(contract);
    }

    @Override
    public void deleteGroup(String id) {
        groupRepository.deleteById(id);
    }
}
