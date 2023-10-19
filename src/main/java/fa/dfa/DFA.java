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

    private Set<DFAState> Q = new LinkedHashSet<>();
    private Set<Character> Sigma = new LinkedHashSet<Character>();
    private DFAState q0;
    private Set<DFAState> F = new LinkedHashSet<>();

    @Override
    public boolean addState(String name) {
        // Return false if state already exists
        for(DFAState s : Q) if(s.getName().equals(name)) return false;
        
        // Create state since it is new
        DFAState newState = new DFAState(name);
        Q.add(newState);

        return true;
    }

    @Override
    public boolean setFinal(String name) {
        for (DFAState s : Q) {
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
        for (DFAState s : Q)
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
        DFAState pointer = q0;

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
    public DFAState getState(String name) {
        for(DFAState s : Q) if(s.getName().equals(name)) return s;
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
        DFAState source = getState(fromState);
        DFAState target = getState(toState);
        if(source == null || target == null || !Sigma.contains(onSymb)) return false;

        source.addTransition(onSymb, toState);
        return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        DFA newDFA = new DFA();

        // copy the states and their properties
        for (DFAState state : Q) {
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
        for (DFAState fromState : Q) {
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
        for(DFAState state : Q) {
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

        for(char symbol : Sigma) result += "\t" + symbol;
        result += "\n";

        for(DFAState fromState : Q) {
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
        for(DFAState finalState : F) result += finalState.getName() + " ";
        result += "}";

        return result;
    }
}
