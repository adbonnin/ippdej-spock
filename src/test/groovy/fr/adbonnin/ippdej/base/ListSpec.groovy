package fr.adbonnin.ippdej.base

import spock.lang.*

@Title("Spécification relative aux listes")
@Narrative("Une description encore plus longue")
class ListSpec extends Specification {

    @Issue("CD-42")
    void "doit ajouter une valeur à une liste"() {

        given:
        @Subject def list = []

        expect: "la liste est vide"
        list.isEmpty()

        when:
        list.add(value)

        then: "la liste n'est plus vide"
        !list.isEmpty()
        list.size() == 1

        and: "la valeur a été ajoutée"
        list.first() == value

        where:
        value = 1
    }
}

