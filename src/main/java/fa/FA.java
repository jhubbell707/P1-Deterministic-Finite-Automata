package fa;

import java.util.HashSet;
import java.util.Set;

import fa.dfa.DFAState;

public class FA implements FAInterface {

    private Set<State> Q = new HashSet<State>();
    private Set<Character> Sigma = new HashSet<Character>();
    private State q0;
    private Set<State> F = new HashSet<State>();
 
    @Override
    public boolean addState(String name) {
        // Return false if state already exists
        for(State s : Q) if(s.getName().equals(name)) return false;
        
        // Create state since it is new
        State newState = new DFAState(name);
        Q.add(newState);

        return true;
    }

    @Override
    public boolean setFinal(String name) {
        for(State s : Q) {
            if(s.getName().equals(name)) {
                F.add(s);
                return true;
            }
            
        }
        return false;
    }

    @Override
    public boolean setStart(String name) {
        for(State s : Q) if(s.getName().equals(name)) {
            q0 = s;
            return true;
        }
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        Sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        return false;
    }

    @Override
    public Set<Character> getSigma() {
        return Sigma;
    }

    @Override
    public State getState(String name) {
        for(State s : Q) if(s.getName().equals(name)) return s;
        return null;
    }

    @Override
    public boolean isFinal(String name) {
        for(State s : F) if(s.getName().equals(name)) return true;
        return false;
    }

    @Override
    public boolean isStart(String name) {
        if(q0.getName().equals(name)) return true;
        return false;
    }
}
