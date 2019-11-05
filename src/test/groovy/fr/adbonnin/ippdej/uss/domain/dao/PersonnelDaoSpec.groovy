package fr.adbonnin.ippdej.uss.domain.dao

import fr.adbonnin.ippdej.uss.domain.model.Personnel
import groovy.sql.Sql
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class PersonnelDaoSpec extends Specification {

    @AutoCleanup
    def sql = Sql.newInstance('jdbc:h2:mem:test')

    @Subject
    def personnelDao = new PersonnelDaoImpl(sql)

    void setup() {
        sql.execute("""
          create table personnel (
            id  identity    not null primary key,
            nom varchar(25) not null
          )
        """)
    }

    @Unroll
    void "doit persister les personnels #nomPersonnels"() {
        expect:
        personnelDao.compterPersonnels() == 0

        when:
        nomPersonnels.each { nom ->
            personnelDao.persisterPersonnel(new Personnel(nom: nom))
        }

        then:
        personnelDao.compterPersonnels() == expectedNombrePersonnels

        where:
        nomPersonnels     || expectedNombrePersonnels
        ['Spock']         || 1
        ['Spock', 'Kirk'] || 2
    }
}
