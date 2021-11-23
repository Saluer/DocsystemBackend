package alexeydavydov.docsystem.domain.assignment.states;

import alexeydavydov.docsystem.domain.assignment.Assignment;

public class ModificationState extends State {
    ModificationState(Assignment assignment){
        super(assignment);
    }

    @Override
    void goToNextStep() {
        this.assignment.changeState(new OperatingState(assignment));
    }
}
