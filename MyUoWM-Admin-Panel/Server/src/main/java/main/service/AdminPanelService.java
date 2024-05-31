package main.service;

import main.datasource.model.Club;
import main.datasource.model.Link;
import main.datasource.model.Personnel;

import java.util.List;

public interface AdminPanelService {
    public Personnel savePersonnel(Personnel personnel);
    public List<Personnel> updatePersonnel(List<Personnel> personnel);
    public String deletePersonnel(String personalId);
    public Club saveClub(Club club);
    public List<Club> updateClub(List<Club> clubs);
    public String deleteClub(String clubId);
    public List<Link> updateLinks(List<Link> links);
}
