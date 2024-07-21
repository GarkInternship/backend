package com.gark.project.Controller;

import com.gark.project.Entity.Club;
import com.gark.project.Service.ClubServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubServiceImpl clubService;

    @GetMapping("/view")
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public Club getClubById(@PathVariable String id) {
        return clubService.getClubById(id);
    }

    @PostMapping("/add")
    public Club createClub(@RequestBody Club club) {
        return clubService.saveClub(club);
    }

    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable String id) {
        clubService.deleteClub(id);
    }
}
