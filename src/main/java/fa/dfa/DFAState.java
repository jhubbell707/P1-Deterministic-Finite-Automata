package fa.dfa;

import java.util.HashMap;

import fa.State;

/**
 * Extension of abstract class State.
 * 
 * @author jimmyhubbell
 * @version Fall 2023
 */
public class DFAState extends State {

    private HashMap<Character, String> transitions = new HashMap<>();

    public DFAState(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void addTransition(char sign, String state) {
        transitions.put(sign, state);
    }

    @Override
    public String getTransition(char sign) {
        return transitions.get(sign);
    }
    
}
