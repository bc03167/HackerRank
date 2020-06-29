import java.math.BigDecimal;

interface  Account {
    BigDecimal b = new BigDecimal(0);
}

class SA implements Account {
    public SA(BigDecimal iv) {
       BigDecimal x = b;
    }
    public static void main(String args[]) {
        SA i = new SA(new BigDecimal(50.00));
    }
}