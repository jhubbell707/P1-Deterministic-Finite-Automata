package fa.dfa;

import fa.State;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Class responsible for handling states, transitions, and seeing if a
 * given string is accepted.
 * 
 * @author jimmyhubbell 
 * 
 * @version Fall 2023
 */
public class DFA implements DFAInterface{

    private Set<State> Q = new LinkedHashSet<State>();
    private Set<Character> Sigma = new LinkedHashSet<Character>();
    private State q0;
    private Set<State> F = new LinkedHashSet<State>();

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
        DFA newDFA = new DFA();

        // copy the states and their properties
        for (State state : Q) {
            newDFA.addState(state.getName());
            if (isFinal(state.getName())) {
                newDFA.setFinal(state.getName());
            }
            if (isStart(state.getName())) {
                newDFA.setStart(state.getName());
            }
        }

        // copy the alphabet
        for (char symbol : Sigma) {
            newDFA.addSigma(symbol);
        }

        // copy the transitions, swapping labels as needed
        for (State fromState : Q) {
            for (char symbol : Sigma) {
                String toStateName = fromState.getTransition(symbol);
                if (toStateName != null) {
                    if (symbol == symb1) {
                        // swap the symbol from symb1 to symb2
                        newDFA.addTransition(fromState.getName(), toStateName, symb2);
                    } else if (symbol == symb2) {
                        // swap the symbol from symb2 to symb1
                        newDFA.addTransition(fromState.getName(), toStateName, symb1);
                    } else {
                        // copy the transition as is
                        newDFA.addTransition(fromState.getName(), toStateName, symbol);
                    }
                }
            }
        }

        return newDFA;
    }

    @Override
    public String toString() {
        String result = "";

        // states
        result += " Q = { ";
        for (State state : Q) {
            result += state.getName() + " ";
        }
        result += "}\n";

        // alphabet
        result += "Sigma = { ";
        for (char symbol : Sigma) {
            result += symbol + " ";
        }
        result += "}\n";

        // transitions
        result += "delta =\n";
        result += "\t";

        for (char symbol : Sigma) result += "\t" + symbol;
        result += "\n";

        for (State fromState : Q) {
            result += "\t" + fromState.getName();
            for (char symbol : Sigma) {
                String toStateName = fromState.getTransition(symbol);
                if (toStateName != null) {
                    result += "\t" + toStateName;
                } else {
                    result += "\t-"; // Use "-" for missing transitions
                }
            }
            result += "\n";
        }

        // starting state
        result += "q0 = " + q0.getName() + "\n";

        // final states
        result += "F = { ";
        for (State finalState : F) result += finalState.getName() + " ";
        result += "}";

        return result;
    }
}
