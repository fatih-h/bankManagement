package banking;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String name){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public boolean newCustomer(String name, double initialTransaction){
        if(findCustomer(name) != null){
            return false;
        }
        Customer customer = new Customer(name,initialTransaction);
        customers.add(customer);
        return true;

    }

    public boolean addCustomerTransaction(String name, double transaction){
        Customer customer = findCustomer(name);
        if(customer == null){
            return false;
        }
        customer.addTransaction(transaction);
        return true;
    }
}
