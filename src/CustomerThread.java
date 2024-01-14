import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CustomerThread implements Runnable{
    Socket socket;
    public CustomerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try(
                PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);
                Scanner receiver = new Scanner(socket.getInputStream())
                ){
                    sender.println("Enter branch id: ");
                    int branchId = Integer.parseInt(receiver.next());
                    if(branchId < 0 || branchId >= CustomerinfoServer.listOfBranches.size()){
                        sender.println("Invalid code");
                        return;
                    }
                    sender.println("OK");


                    String branchid= CustomerinfoServer.listOfBranches.get(branchId);
                    sender.println("***Welcome in branch " + branchid + "***");


                    sender.println("Enter customer id: ");
                    int customerId = receiver.nextInt();
                    Customer customer = CustomerinfoServer.getCustomer(customerId);
                    if(customer == null){
                        sender.println("Invalid customer id");
                        return;
                    }
                    sender.println(customer.getCustomerId() + "*" + customer.getCustomerName() + "*" + customer.getAmount());
//                    sender.println("OK");

//                String customerInfo = customer.getCustomerId() + "*" + customer.getCustomerName() + "*" + customer.getAmount();


        }catch(IOException e){
                    throw new RuntimeException(e);
                }
    }
}
