package fr.adbonnin.ippdej.uss.service

import fr.adbonnin.ippdej.uss.business.Teleporteur
import fr.adbonnin.ippdej.uss.domain.dao.PersonnelDao

import static fr.adbonnin.ippdej.uss.domain.dao.PersonnelDao.Recherche

class TeleporteurServiceImpl {

    Teleporteur transporteur
    PersonnelDao personnelDao

    TeleporteurServiceImpl(Teleporteur transporteur, PersonnelDao personnelDao) {
        this.transporteur = transporteur
        this.personnelDao = personnelDao
    }

    boolean transporter(String nom) {
        def personnels = personnelDao.rechercherPersonnels(new Recherche(nom: nom))
        return personnels && transporteur.teleporter(personnels)
    }
}
