import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        ArrayList<Bank> bankArrayList = new ArrayList<>();
        ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a command: ");
        String[] commands = sc.nextLine().split(" ");

        while (!commands[0].equalsIgnoreCase("q")) {
            switch (commands[0]) {
                case "createPerson":
                    personArrayList.add(new Person(commands[1], commands[2], commands[3], new Address(commands[4], commands[5], commands[6], commands[7])));
                    System.out.println(personArrayList.get(personArrayList.size()-1));
                    break;
                case "createBank":
                    bankArrayList.add(new Bank(commands[1], new Address(commands[2], commands[3], commands[4], commands[5])));
                    System.out.println(bankArrayList.get(bankArrayList.size()-1));
                    break;
                case "createBankAccount":
                    bankAccountArrayList.add(new BankAccount(personArrayList.get(Integer.parseInt(commands[1])), bankArrayList.get(Integer.parseInt(commands[2])), Double.parseDouble(commands[3]), Integer.parseInt(commands[4])));
                    System.out.println(bankAccountArrayList.get(bankAccountArrayList.size()-1));
                    break;
                case "withdraw":
                    for (BankAccount bankAccount : bankAccountArrayList) {
                        if (Integer.parseInt(commands[1]) == bankAccount.getAccountNumber()) {
                            double balance = bankAccount.withdraw(Double.parseDouble(commands[2]));
                            if (balance != -1)
                                System.out.println(bankAccount);
                            else
                                System.out.println("Cannot withdraw a bigger amount than balance.");
                            break;
                        }
                    }
                    break;
                case "deposit":
                    for (BankAccount bankAccount : bankAccountArrayList) {
                        if (Integer.parseInt(commands[1]) == bankAccount.getAccountNumber()) {
                            bankAccount.deposit(Double.parseDouble(commands[2]));
                            System.out.println(bankAccount);
                            break;
                        }
                    }
                    break;
                case "yearsPassed":
                    for (int i=0; i<bankAccountArrayList.size(); i++){
                        if (!bankAccountArrayList.get(i).yearsPassed(Integer.parseInt(commands[1]))){
                            System.out.println("Bank Account "+ bankAccountArrayList.get(i).getAccountNumber() +" deleted.");
                            bankAccountArrayList.remove(i);
                            i--;
                        }
                        else
                            System.out.println(bankAccountArrayList.get(i));
                    }
                case "Q":
                case "q":
                    break;
            }

            System.out.println("Enter a command: ");
            commands = sc.nextLine().split(" ");
        }
    }

}
