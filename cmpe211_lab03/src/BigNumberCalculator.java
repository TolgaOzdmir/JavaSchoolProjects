import java.util.Scanner;

public class BigNumberCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command:");
        String commands[] = sc.nextLine().trim().split(" ");

        BigNumber num1, num2, num3;
        boolean checkNum = true;

        while (!commands[0].equalsIgnoreCase("q")) {

            if (!(commands[0].equalsIgnoreCase("add") || commands[0].equalsIgnoreCase("sub") || commands[0].equalsIgnoreCase("min") || commands[0].equalsIgnoreCase("max") || commands[0].equalsIgnoreCase("sub3") || commands[0].equalsIgnoreCase("min3"))) {
                System.out.println("Unknown command, please enter a correct command!");
                System.out.println("Enter command:");
                commands = sc.nextLine().trim().split(" ");
                checkNum = true;
                continue;
            }
            if (commands.length > 1) {
                for (int i = 0; i < commands[1].length(); i++) {
                    if (commands[1].charAt(i) == '-' && i == 0)
                        continue;
                    if (!Character.isDigit(commands[1].charAt(i))) {
                        System.out.println("First given number is not contains only digits!");
                        checkNum = false;
                        break;
                    }
                }
            } else {
                System.out.println("First number is not entered!");
                checkNum = false;
            }
            if (commands.length > 2) {
                for (int i = 0; i < commands[2].length(); i++) {
                    if (commands[2].charAt(i) == '-' && i == 0)
                        continue;
                    if (!Character.isDigit(commands[2].charAt(i))) {
                        System.out.println("Second given number is not contains only digits!");
                        checkNum = false;
                        break;
                    }
                }
            } else {
                System.out.println("Second number is not entered!");
                checkNum = false;
            }
            if (commands.length > 3) {
                for (int i = 0; i < commands[3].length(); i++) {
                    if (commands[3].charAt(i) == '-' && i == 0)
                        continue;
                    if (!Character.isDigit(commands[3].charAt(i))) {
                        System.out.println("Third given number is not contains only digits!");
                        checkNum = false;
                        break;
                    }
                }
            } else if(commands[0].equalsIgnoreCase("sub3") || commands[0].equalsIgnoreCase("min3")){
                System.out.println("Third number is not entered!");
                checkNum = false;
            }

            if (checkNum) {
                num1 = new BigNumber(commands[1]);
                num2 = new BigNumber(commands[2]);
                switch (commands[0]) {
                    case "min":
                        System.out.println(num1.minimum(num2));
                        break;
                    case "max":
                        System.out.println(num1.maximum(num2));
                        break;
                    case "add":
                        System.out.println(num1.add(num2));
                        break;
                    case "sub":
                        System.out.println(num1.substract(num2));
                        break;
                    case "sub3":
                        num3 = new BigNumber(commands[3]);
                        System.out.println(num1.substract(num2).substract(num3));
                        break;
                    case "min3":
                        num3 = new BigNumber(commands[3]);
                        System.out.println(num1.minimum(num2).minimum(num3));
                        break;
                }
            }
            System.out.println("Enter command:");
            commands = sc.nextLine().trim().split(" ");
            checkNum = true;
        }
    }
}
