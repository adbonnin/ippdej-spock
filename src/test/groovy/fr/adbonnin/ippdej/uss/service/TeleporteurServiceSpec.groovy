package fr.adbonnin.ippdej.uss.service

import fr.adbonnin.ippdej.uss.business.Teleporteur
import fr.adbonnin.ippdej.uss.domain.dao.PersonnelDao
import fr.adbonnin.ippdej.uss.domain.model.Personnel
import spock.lang.Specification
import spock.lang.Subject

class TeleporteurServiceSpec extends Specification {

    def mockTransporteur = Mock(Teleporteur)
    def mockPersonnelDao = Mock(PersonnelDao)

    @Subject
    def service = new TeleporteurServiceImpl(mockTransporteur, mockPersonnelDao)

    def "doit transporter les personnels"() {
        when:
        def result = service.transporter('Spock')

        then:
        1 * mockPersonnelDao.rechercherPersonnels(_) >> personnels

        then:
        expectedTransporter * mockTransporteur.teleporter(personnels) >> transportReussi

        and:
        result == expectedResult

        where:
        personnels                    | transportReussi || expectedTransporter | expectedResult
        []                            | _               || 0                   | false
        [new Personnel(nom: 'Spock')] | false           || 1                   | false
        [new Personnel(nom: 'Spock')] | true            || 1                   | true
    }
}
