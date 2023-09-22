package fa.dfa;

import fa.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFA implements  DFAInterface{

    private Set<State> Q = new HashSet<State>();
    private Set<Character> Sigma = new HashSet<Character>();
    private State q0;
    private Set<State> F = new HashSet<State>();
    private List<Transition> Delta = new ArrayList<Transition>();

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
        else return false;
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        State source = getState(fromState);
        State target = getState(toState);
        if(source == null || target == null) return false;

        Transition transition = new Transition(source, target);
        Delta.add(transition);

        return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        return null;
    }
}
