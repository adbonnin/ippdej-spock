package fr.adbonnin.ippdej

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class LifeCycleSpec1 extends Specification {

    @Shared @AutoCleanup
    def sharedVariable = new Closeable() {
        { println('> shared variable') }
        void close() { println('< cleanup shared variable') }
    }

    @AutoCleanup
    def variable = new Closeable() {
        { println(' > build variable') }
        void close() { println(' < cleanup variable') }
    }

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
