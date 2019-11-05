package fr.adbonnin.ippdej.lifecycle

import spock.lang.Specification

class LifeCycleSpec2 extends Specification {

    void setupSpec() { println('> setupSpec') }

    void cleanupSpec() { println('< cleanupSpec') }

    void setup() { println(' > setup') }

    void cleanup() { println(' < cleanup') }

    def "doit présenter le cycle de vie"() {
        given:
        println("  > setup feature $index")

        expect:
        true

        cleanup:
        println("  < cleanup feature $index")

        where:
        index << [0, 1]
    }
}
