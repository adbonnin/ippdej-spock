package fr.adbonnin.ippdej

import groovy.sql.Sql
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Unroll

class SqlPersonnelSpec extends Specification {

    @AutoCleanup
    def sql = Sql.newInstance('jdbc:h2:mem:test')

    void setup() {
        sql.execute("create table PERSONNEL (NOM varchar(25))")
    }

    @Unroll
    void "doit compter #expectedCount membres d'équipage pour la requête '#updateQuery'"() {
        expect:
        !sql.firstRow(countQuery)[0]

        when:
        sql.execute(updateQuery)

        then:
        sql.firstRow(countQuery)[0] == expectedCount

        where:
        updateQuery                                             || expectedCount
        "insert into PERSONNEL (NOM) values ('Spock')"           || 1
        "insert into PERSONNEL (NOM) values ('Spock'), ('Kirk')" || 2

        countQuery = 'select count(*) from PERSONNEL'
    }
}
