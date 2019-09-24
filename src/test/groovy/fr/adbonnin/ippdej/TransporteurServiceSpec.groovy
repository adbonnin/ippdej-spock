package fr.adbonnin.ippdej

import fr.adbonnin.ippdej.business.Transporteur
import fr.adbonnin.ippdej.domain.dao.PersonnelDao
import fr.adbonnin.ippdej.domain.model.Personnel
import fr.adbonnin.ippdej.service.TransporteurService
import spock.lang.Specification
import spock.lang.Subject

class TransporteurServiceSpec extends Specification {

    def mockTransporteur = Mock(Transporteur)
    def mockDao = Mock(PersonnelDao)

    @Subject
    def service = new TransporteurService(mockTransporteur, mockDao)

    def "doit transporter les personnels"() {
        when:
        def result = service.transporter('Spock')

        then:
        1 * mockDao.rechercherPersonnels(_) >> personnels

        then:
        expectedTransporter * mockTransporteur.transporter(personnels) >> transportReussi

        and:
        result == expectedResult

        where:
        personnels                    | transportReussi || expectedTransporter | expectedResult
        []                            | _               || 0                   | false
        [new Personnel(nom: 'Spock')] | false           || 1                   | false
        [new Personnel(nom: 'Spock')] | true            || 1                   | true
    }
}
