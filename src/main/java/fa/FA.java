package fa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fa.dfa.DFAState;

public class FA implements FAInterface {

    private Set<State> Q = new HashSet<State>();
    private Set<Character> Sigma = new HashSet<Character>();
    private State q0;
    private Set<State> F = new HashSet<State>();
    private Map<String, HashSet<String>> Delta = new HashMap<String, HashSet<String>>();
 
    @Override
    public boolean addState(String name) {
        // Return false if state already exists
        for(State s : Q) if(s.getName().equals(name)) return false;
        
        // Create state since it is new
        State newState = new DFAState(name);
        Q.add(newState);
        Delta.put(name, new  HashSet<String>());

        return true;
    }

    @Override
    public boolean setFinal(String name) {
        for(State s : Q) {
            // Check of state exists
            if(s.getName().equals(name)) {
                // Add state to F
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
        else return false;
    }

    @Override
    public String toString() {
        String sigma = " ";
        for(char c : Sigma) sigma += c + " ";
        
        String states = " ";
        for(State s : Q) states += s.getName() + " ";
        
        return "Q = {"+states+"}\n" + //
            "\t Sigma = {"+sigma+"}\n" + //
            "\t delta =\n" + //
            "\t \t\t0\t1\t\n" + //
            "\t *\ta\ta\tb\t\n" + //
            "\t *\tb\ta\tb\t\n" + //
            "\tq0 = "+q0.getName()+"\n" + //
            "\tF = { b }";
    }
}
