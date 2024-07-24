package com.gark.project.Controller;

import com.gark.project.Entity.Club;
import com.gark.project.Entity.Group;
import com.gark.project.Service.ClubServiceImpl;
import com.gark.project.Service.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {
    @Autowired
    private GroupServiceImpl groupService ;

    @Autowired
    private ClubServiceImpl clubService ;

    @PostMapping("/add")
    public Group createGroup(@RequestBody Group group) {
        System.out.println(group.getClub().getNom() + " "+ group.getClub().getGroups());
        Club club = group.getClub();
        List<Group> groupsofClub =club.getGroups();

//        if(club.getGroups().isEmpty()){
//            groups = new ArrayList<>() ;
//        }
//        else {
//
//        }
        groupService.saveGroup(group) ;
        groupsofClub.add(group) ;
        club.setGroups(groupsofClub);
        System.out.println(club.getNom()+ " "+ club.getGroups() + " "+ club.getId());
        clubService.saveClub(club);
        return group;
    }

}
