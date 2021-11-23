package alexeydavydov.docsystem.domain.assignment.states;

import alexeydavydov.docsystem.domain.assignment.Assignment;


public class PreparingState extends State {
    public PreparingState(Assignment assignment) {
        super(assignment);
    }

    @Override
    void goToNextStep() {
        this.assignment.changeState(new OperatingState(assignment));
    }
}
