package com.gark.project.Service;

import com.gark.project.Entity.Club;
import com.gark.project.Rpository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> getAllClubs() {
        return (List<Club>) clubRepository.findAll();
    }

    public Club getClubById(String id) {
        return clubRepository.findById(id).orElse(null);
    }

    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    public void deleteClub(String id) {
        clubRepository.deleteById(id);
    }
}
