package fa.dfa;

import fa.State;

/**
 * Helper data object to store transitions
 * 
 * @author jimmyhubbell
 * @version Fall 2023
 */
public class Transition {
    private State sourceState;
    private State targetState;
    private char sign;

    public Transition(State sourceState, State targetState, char sign) {
        this.sourceState = sourceState;
        this.targetState = targetState;
        this.sign = sign;
    }

    /**
     * returns transition from
     * @return State source
     */
    public State getSourceState() {
        return sourceState;
    }

    /**
     * returns transition to
     * @return State target
     */
    public State getTargetState() {
        return targetState;
    }

    /**
     * gets sigma character
     * @return
     */
    public char getSign() {
        return sign;
    }

    /**
     * 
     * @param sign
     */
    public void setSign(char sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sourceState.getName() + " - " + sign + " > " + targetState.getName();
    }
}
