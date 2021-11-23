package alexeydavydov.docsystem.domain.assignment.states;

import alexeydavydov.docsystem.domain.assignment.Assignment;

public class ControlState extends State {
    ControlState(Assignment assignment) {
        super(assignment);
    }

    @Override
    void goToNextStep() {
        //При условии, что проставлены оба флага, состояние становится "Приём", иначе — состоянием "Доработка"
        if (this.assignment.isControlSign() && this.assignment.isOperateSign()) {
            this.assignment.changeState(new ControlState(assignment));
        } else {
            this.assignment.changeState(new ReceivingState(assignment));
        }
    }
}
