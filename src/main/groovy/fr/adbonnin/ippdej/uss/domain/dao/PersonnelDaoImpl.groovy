package fr.adbonnin.ippdej.uss.domain.dao

import fr.adbonnin.ippdej.uss.domain.model.Personnel
import groovy.sql.Sql

class PersonnelDaoImpl implements PersonnelDao {

    final Sql sql

    PersonnelDaoImpl(Sql sql) {
        this.sql = sql
    }

    int compterPersonnels() {
        return sql.firstRow('select count(*) from personnel')[0]
    }

    int persisterPersonnel(Personnel personnel) {
        def keys = sql.executeInsert('insert into personnel (nom) values (?)', [personnel.nom])
        return keys[0][0]
    }

    List<Personnel> rechercherPersonnels(Recherche recherche) {
        def personnels = []

        sql.rows('select * from personnel where nom = ?', [recherche.nom]).each { row ->
            personnels.add(mapPersonnel(row))
        }

        return personnels
    }

    static Personnel mapPersonnel(def rs) {
        return new Personnel(
                id: rs.id,
                nom: rs.nom
        )
    }
}
