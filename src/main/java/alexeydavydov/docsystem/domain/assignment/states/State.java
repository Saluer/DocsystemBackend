package alexeydavydov.docsystem.domain.assignment.states;

import alexeydavydov.docsystem.domain.assignment.Assignment;

public abstract class State {
    Assignment assignment;

    State(Assignment assignment) {
        this.assignment = assignment;
    }

    abstract void goToNextStep();
}
