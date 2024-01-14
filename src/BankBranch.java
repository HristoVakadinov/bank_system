import java.util.LinkedList;

public class BankBranch {
    private int branchId;
    private String branchName;
    private LinkedList<Customer> customers;

    public BankBranch(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.customers = new LinkedList<Customer>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public LinkedList<Customer> getCustomers() {
        return this.customers;
    }

}
