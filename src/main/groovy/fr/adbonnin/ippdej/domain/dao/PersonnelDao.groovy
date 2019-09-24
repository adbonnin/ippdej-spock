package fr.adbonnin.ippdej.domain.dao

import fr.adbonnin.ippdej.domain.model.Personnel
import groovy.sql.Sql

import javax.sql.DataSource

class PersonnelDao implements Closeable {

    final Sql sql

    PersonnelDao(Sql sql) {
        this.sql = sql
    }

    PersonnelDao(DataSource dataSource) {
        this.sql = new Sql(dataSource as DataSource)
    }

    List<Personnel> rechercherPersonnels(FiltreRecherche filtre) {
        def personnels = []

        sql.rows('select * from PERSONNEL where nom = ?', [filtre.nom]).each { row ->
            personnels.add(mapPersonnel(row))
        }

        return personnels
    }

    Personnel mapPersonnel(def rs) {
        return new Personnel(nom: rs.nom)
    }

    @Override
    void close() throws IOException {
        sql.close()
    }

    static class FiltreRecherche {

        String nom
    }
}
