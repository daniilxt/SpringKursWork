package ru.spbstu.decanat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spbstu.decanat.entity.Group;
import ru.spbstu.decanat.exception.GroupNotFoundException;
import ru.spbstu.decanat.repository.GroupRepository;
import ru.spbstu.decanat.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> listGroups() {
        return (List<Group>) groupRepository.findAll();
    }

    @Override
    public Group findGroups(Long id) {
        Optional<Group> optGroups = groupRepository.findById(id);
        if (optGroups.isPresent()) {
            return optGroups.get();
        } else {
            throw new GroupNotFoundException("Group not found");
        }
    }

    @Override
    public Group addGroups(Group groups) {
        return groupRepository.save(groups);
    }

    @Override
    public void deleteGroups(Long id) {
        groupRepository.deleteById(id);
    }

}
