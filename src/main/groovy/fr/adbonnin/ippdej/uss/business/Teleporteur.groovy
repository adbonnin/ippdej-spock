package fr.adbonnin.ippdej.uss.business

import fr.adbonnin.ippdej.uss.domain.model.Personnel

interface Teleporteur {

    boolean teleporter(List<Personnel> personnels)
}