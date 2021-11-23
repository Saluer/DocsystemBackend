package alexeydavydov.docsystem.domain.assignment.states;

import alexeydavydov.docsystem.domain.assignment.Assignment;

public class ReceivingState extends State {
    ReceivingState(Assignment assignment){
        super(assignment);
    }

    @Override
    void goToNextStep() {

    }
}
