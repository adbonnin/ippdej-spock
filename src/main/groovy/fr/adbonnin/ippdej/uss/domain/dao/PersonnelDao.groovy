package fr.adbonnin.ippdej.uss.domain.dao

import fr.adbonnin.ippdej.uss.domain.model.Personnel

interface PersonnelDao {

    int compterPersonnels()

    int persisterPersonnel(Personnel personnel)

    List<Personnel> rechercherPersonnels(Recherche recherche)

    static class Recherche {

        String nom
    }
}