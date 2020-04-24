package ru.dias.homebudget.action;

import ru.dias.homebudget.persistence.entities.Participant;

public interface BudgetAction {

    String action(ActionContext context);
}
