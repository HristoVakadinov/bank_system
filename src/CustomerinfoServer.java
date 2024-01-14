import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomerinfoServer {
    public static LinkedList<String> listOfBranches = new LinkedList<String>();
    public static LinkedList<Customer> listOfCustomers = new LinkedList<Customer>();

    public static void main(String[] args) throws IOException{
        listOfBranches.add("Sofia");
        listOfBranches.add("Plovdiv");
        listOfBranches.add("Varna");
        listOfBranches.add("Burgas");
        listOfBranches.add("Petrich");

        listOfCustomers.add(new Customer(1, "Ivan", 1000));
        listOfCustomers.add(new Customer(2, "Maria", 2000));
        listOfCustomers.add(new Customer(3, "Pesho", 3000));
        listOfCustomers.add(new Customer(4, "Nikol", 4000));
        listOfCustomers.add(new Customer(5, "Katrin", 5000));
        try(
                ServerSocket server = new ServerSocket(1211);
                ExecutorService pool = Executors.newFixedThreadPool(10);
                ){
                    while(true){
                        pool.execute(new CustomerThread(server.accept()));
                        System.out.println("Client is connected");
                    }
                }
        }

        public static Customer getCustomer(int customerId){
            for(Customer customer : listOfCustomers){
                if(customer.getCustomerId() == customerId){
                    return customer;
                }
            }
            return null;
    }

}
