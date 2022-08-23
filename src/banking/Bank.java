package banking;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<>();
    }


    private Branch findBranch(String name){
        for(int i =0; i < branches.size(); i++){
            Branch branch = branches.get(i);
            if(branch.getName().equals(name)){
                return branch;
            }
        }
        return null;
    }

    public boolean addBranch(String name){
        if(findBranch(name) != null){
            return false;
        }
        branches.add(new Branch(name));
        return true;
    }
    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return false;
        }

        for(int i = 0; i < branch.getCustomers().size(); i++){
            Customer customer = branch.getCustomers().get(i);
            if(customer.getName().equals(customerName)){
                return false;
            }
        }
        branch.newCustomer(customerName, initialTransaction);

        return true;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return false;
        }
        for(int i = 0; i < branch.getCustomers().size(); i++) {
            Customer customer = branch.getCustomers().get(i);
            if(customer.getName().equals(customerName)){
                customer.addTransaction(transaction);
                return true;
            }
        }

        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return false;
        }
        System.out.println("Customer details for branch " + branch.getName());
        for(int i = 0; i < branch.getCustomers().size(); i++){
            Customer customer = branch.getCustomers().get(i);
            System.out.println("Customer: " + customer.getName() + "[" + (i+1) + "]");
            if(printTransactions){
                System.out.println("Transactions");
                for(int j = 0; j < customer.getTransactions().size(); j++){
                    Double transaction = customer.getTransactions().get(j);
                    System.out.println("[" + (j+1) + "]  Amount " + transaction);
                }

            }
        }

        return true;
    }

}
