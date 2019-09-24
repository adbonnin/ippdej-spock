package fr.adbonnin.ippdej

import spock.lang.Specification
import spock.lang.Unroll

class MathSpec extends Specification {

    void "doit retourner le max de 2 nb"() {
        given:
        def a = 1
        def b = 2

        when:
        def max = Math.max(a, b)

        then:
        max == 2
    }

    @Unroll("doit retourner #max pour le max entre #a et #b")
    void "doit retourner le max de deux nombres"() {
        when:
        def result = Math.max(a, b)

        then:
        result == max

        where:
        a | b || max
        1 | 2 || 2
        2 | 4 || 4
    }
}
