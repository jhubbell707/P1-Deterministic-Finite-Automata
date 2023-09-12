package fa.dfa;

import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

    @Override
    public boolean addState(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'addState'");
    }

    @Override
    public boolean setFinal(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'setFinal'");
    }

    @Override
    public boolean setStart(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'setStart'");
    }

    @Override
    public void addSigma(char symbol) {
        throw new UnsupportedOperationException("Unimplemented method 'addSigma'");
    }

    @Override
    public boolean accepts(String s) {
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    @Override
    public Set<Character> getSigma() {
        throw new UnsupportedOperationException("Unimplemented method 'getSigma'");
    }

    @Override
    public State getState(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }

    @Override
    public boolean isFinal(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'isFinal'");
    }

    @Override
    public boolean isStart(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'isStart'");
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }

    @Override
    public String toString() {
        return null;
    }
    
}
