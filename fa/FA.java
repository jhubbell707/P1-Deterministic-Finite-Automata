package fa;

import java.util.Set;

public class FA implements FAInterface {

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
    
}
