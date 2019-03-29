package account_1;

public class Account {


    private int balence;

    public Account(int money) {
        this.balence = money;
    }


    public int getBalence() {
        return this.balence;
    }

    public void withdraw(int money) {
        this.balence -= money;
    }

    public void deposit(int money) {
        this.balence += money;
    }
}

