package fa.dfa;

import fa.State;

public class Transition {
    private State sourceState;
    private State targetState;

    public Transition(State sourceState, State targetState) {
        this.sourceState = sourceState;
        this.targetState = targetState;
    }

    public State getSourceState() {
        return sourceState;
    }

    public State getTargetState() {
        return targetState;
    }

    @Override
    public String toString() {
        return sourceState.getName() + " -> " + targetState.getName();
    }
}
