package atm;

public class Parents implements Runnable {
    private final String type;
    private final Atm atm;

    public Parents(String type, Atm atm) {
        this.type = type;
        this.atm = atm;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int decision = (int) (Math.random() * 2);
                int cantidad = 1 + (int) (Math.random() * 200);

                if (decision == 0) {
                    atm.deposit(cantidad, type);
                } else {
                    atm.withdraw(cantidad, type);
                }

                Thread.sleep(200 + (int) (Math.random() * 800));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
