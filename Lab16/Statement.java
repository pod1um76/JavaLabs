public class Statement {
    String currentAccount;
    String accountNumber;
    String currency;
    String date;
    String transactionReference;
    String descriptionOperations;
    double revenue;
    double cost;

    public Statement(String line) {
        String[] a = line.split(",");
        this.currentAccount = a[0];
        this.accountNumber = a[1];
        this.currency = a[2];
        this.date = a[3];
        this.transactionReference = a[4];
        for (int i = 0; i < a[5].length(); i++) {
            this.descriptionOperations = "";
            if (a[5].charAt(i) == '/' || a[5].charAt(i) == '\\')
                for (int j = i; j < a[5].length(); j++) {
                    if (a[5].charAt(j) == ' ' && a[5].charAt(j + 1) == ' ' && a[5].charAt(j + 2) == ' ') {
                        i = a[5].length();
                        break;
                    } else {
                        this.descriptionOperations += a[5].charAt(j);
                    }
                }
        }
        this.revenue = Double.parseDouble(a[6]);
        this.cost = Double.parseDouble(a[7]);
    }

    public void StatementWrite() {
        System.out.println(this.currentAccount + ", " + this.accountNumber + ", " + this.currency + ", " + this.date
                + ", " + this.transactionReference + ", " + this.descriptionOperations + ", " + this.revenue + ", "
                + this.cost);
    }
}
