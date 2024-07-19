package com.gark.project.Controller;

import com.gark.project.Entity.Club;
import com.gark.project.Entity.Contract;
import com.gark.project.Entity.Group;
import com.gark.project.Entity.Joueur;
import com.gark.project.Rpository.ClubRepository;
import com.gark.project.Rpository.ContractRepository;
import com.gark.project.Rpository.GroupRepository;
import com.gark.project.Rpository.JoueurRepository;
import com.gark.project.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private JoueurServiceImpl joueurService;

    @Autowired
    private ClubServiceImpl clubService;
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupService groupService;


    @GetMapping("/view")
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable String id) {
        return contractService.getContractById(id);
    }

    @PostMapping("/add")
    public Contract createContract(@RequestBody Contract body) {
        Optional<Club> clubOptional = clubRepository.findById(body.getClub().getId());
        Optional<Joueur> joueurOptional = joueurRepository.findById(body.getJoueur().getId());

        if (clubOptional.isPresent() && joueurOptional.isPresent()) {
            Club club = clubOptional.get();
            Joueur joueur = joueurOptional.get();

            Contract contract = new Contract();
            contract.setDateDebut(body.getDateDebut());
            contract.setDateFin(body.getDateFin());
            contract.setTitre(body.getTitre());
            contract.setDetails(body.getDetails());
            contract.setClub(club);
            contract.setJoueur(joueur);

            // Sauvegarder le contrat d'abord pour obtenir un ID
            Contract savedContract = contractService.saveContract(contract);

            System.out.println(savedContract);

            joueur.getContracts().add(savedContract);
            club.getContracts().add(savedContract);

            System.out.println(joueur +"000000000000000000  " +club);

//            joueurService.savePlayer(joueur);
//            clubService.saveClub(club);

            // so when a new player is added get the group of the club and that player to the group
            //Group group= club.getGroups();

            // Determine the player's age
            LocalDate today = LocalDate.now();
            LocalDate birthDate = joueur.getBday();  // Make sure Joueur has a birthDate field
            int age = Period.between(birthDate, today).getYears();

            // Find or create the appropriate group
            Group group = findOrCreateGroupForAge(club, age);

            // Add player to the group
            group.getPlayers().add(joueur);

            List<Group> groups =club.getGroups();
            groups.add(group) ;
            club.setGroups(groups);

            // Save the updated entities
            joueurService.savePlayer(joueur);
            clubService.saveClub(club);
            groupService.saveGroup(group);  // Assuming you have a GroupService



            return savedContract;
        } else {
            throw new RuntimeException("Club or Joueur not found");
        }
    }


    private Group findOrCreateGroupForAge(Club club, int age) {
        String groupName;
        Group.Niveau niveau ;
        if (age <= 10) {
            groupName = "U10";
            niveau= Group.Niveau.Poussin ;
        } else if (age == 11 || age == 12) {
            groupName = "U12";
            niveau= Group.Niveau.Benjamin ;
        } else if (age==13 || age == 14) {
            groupName = "U14";
            niveau= Group.Niveau.Minim;
        } else if (age == 15 ||  age==16 || age==17) {
            groupName = "U17";
            niveau= Group.Niveau.Cadet ;
        } else if (age ==18 ||  age==19 || age == 20) {
            groupName = "U20";
            niveau= Group.Niveau.Junior ;
        } else {
            groupName = "Senior";
            niveau= Group.Niveau.Senior ;
        }


        // Construct the full group name
        String fullGroupName = club.getNom() + " " + groupName;

        if(groupRepository.findByNom(fullGroupName)==null){
            Group newGroup = new Group();
            newGroup.setNom(club.getNom() + " " +groupName);
            newGroup.setType("Age Group");
            newGroup.setNiveau(niveau);
            newGroup.setClub(club);
            return groupService.saveGroup(newGroup);
        }
        else{
            return groupRepository.findByNom(fullGroupName);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable String id) {
        contractService.deleteContract(id);
    }
}
