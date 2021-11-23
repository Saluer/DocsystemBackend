package alexeydavydov.docsystem.domain.assignment.states;

import alexeydavydov.docsystem.domain.assignment.Assignment;

public class OperatingState extends State{
    OperatingState(Assignment assignment){
        super(assignment);
    }

    @Override
    void goToNextStep() {
        this.assignment.changeState(new ControlState(assignment));
    }
}
