package fr.adbonnin.ippdej.business;

import fr.adbonnin.ippdej.domain.model.Personnel;

import java.util.List;

public interface Transporteur {

    boolean transporter(List<Personnel> personnels);
}
