package actions;

import service.LoanService;

import javax.inject.Inject;

public class LoanOperations {

    @Inject
    LoanService loanService;

    public LoanOperations() {
        this.loanService = new LoanService();
    }


}
