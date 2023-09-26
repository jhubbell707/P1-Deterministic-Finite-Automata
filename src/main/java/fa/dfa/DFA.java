package fa.dfa;

import fa.State;

import java.util.HashSet;
import java.util.Set;

/**
 * Class responsible for handling states, transitions, and seeing if a 
 * given string is accepted.
 * 
 * @author jimmyhubbell
 * @version Fall 2023
 */
public class DFA implements DFAInterface{

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
        for (State s : Q) {
            // Check of state exists
            if (s.getName().equals(name)) {
                // Add state to F
                F.add(s);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean setStart(String name) {
        for (State s : Q)
            if (s.getName().equals(name)) {
                q0 = s;
                return true;
            }
        return false;
    }

    @Override
    public void addSigma(char symbol) {
        if(Sigma.contains(symbol)) return;
        Sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        State pointer = q0;

        for(char c : s.toCharArray()) {
            String str = pointer.getTransition(c);
            if(str == null) return false;
            pointer = getState(str);
        }

        return F.contains(pointer);
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
        else return false;
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        State source = getState(fromState);
        State target = getState(toState);
        if(source == null || target == null || !Sigma.contains(onSymb)) return false;

        source.addTransition(onSymb, toState);
        return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        return null;
    }
}
