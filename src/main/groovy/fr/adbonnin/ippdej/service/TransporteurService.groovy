package fr.adbonnin.ippdej.service

import fr.adbonnin.ippdej.business.Transporteur
import fr.adbonnin.ippdej.domain.dao.PersonnelDao

import static fr.adbonnin.ippdej.domain.dao.PersonnelDao.FiltreRecherche

class TransporteurService {

    Transporteur transporteur
    PersonnelDao personnelDao

    TransporteurService(Transporteur transporteur, PersonnelDao personnelDao) {
        this.transporteur = transporteur
        this.personnelDao = personnelDao
    }

    boolean transporter(String nom) {
        def personnels = personnelDao.rechercherPersonnels(new FiltreRecherche(nom: nom))
        return personnels && transporteur.transporter(personnels)
    }
}
