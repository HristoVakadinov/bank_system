public class Customer {
    private int customerId;
    private String customerName;
    private double amount;

    public Customer(int customerId, String customerName, double amount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

}
