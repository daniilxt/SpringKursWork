package ru.spbstu.decanat.service;

import ru.spbstu.decanat.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> listGroups();
    Group findGroups(Long id);
    Group addGroups(Group groups);
    void deleteGroups(Long id);
}
