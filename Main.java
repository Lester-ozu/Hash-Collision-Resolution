import java.util.Scanner;

public class Main {

    static HashTableChaining hashChaining = new HashTableChaining(10);
    static HashTableLinearProb hashLinearProb = new HashTableLinearProb(10);
    static HashTableQuadraticProb hashQuadProb = new HashTableQuadraticProb(10);
    
    public static void main (String [] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Note that these tables do not accept values that are already in the table!\n");
            System.out.println("\nPlease pick a HashTable to use: " + 
                            "\n\n[1] HashTable w/ Chaining" +
                            "\n[2] HashTable w/ Linear Probing" +
                            "\n[3] HashTable w/ Quadratic Probing" +
                            "\n[4] Exit");
            System.out.print("\n> ");

            if(!scanner.hasNextInt()) {

                System.out.println("\nPlease input a valid choice number!\n");
                scanner.next();

                continue;
            }
            
            int choice = scanner.nextInt();

            if(choice < 1 || choice > 4) {

                System.out.println("\nPlease input a valid choice number!\n");

                continue;
            }

            if(choice == 4) break;

            while(true) {

                System.out.println("\n[1] Insert" +
                                   "\n[2] Remove" +
                                   "\n[3] Search" +
                                   "\n[4] Exit");
                System.out.print("\n> ");

                if(!scanner.hasNextInt()) {

                    System.out.println("\nPlease input a valid choice number!\n");
                    scanner.next();

                    continue;
                }

                int option = scanner.nextInt();

                if(option < 1 || option > 4) {

                    System.out.println("\nPlease input a valid choice number!\n");
    
                    continue;
                }

                switch(option) {

                    case 1:
                        while(true) {

                            System.out.println("\nPlease enter an integer to insert: ");
                            System.out.print("\n> ");

                            if(!scanner.hasNextInt()) {

                                System.out.println("\nPlease input a valid integer!\n");
                                scanner.next();
            
                                continue;
                            }

                            int element = scanner.nextInt();

                            if(search(element, choice)) {

                                System.out.println("\nElement " + element + " is already in the table!\n");
                                break;
                            }

                            insert(element, choice);
                            System.out.println("\nElement " + element + " has succesfully been inserted into the table\n");

                            printTable(choice);
                            break;
                        }
                        continue;
                    
                    case 2:
                        while(true) {

                            System.out.println("\nPlease enter an integer to remove: ");
                            System.out.print("\n> ");

                            if(!scanner.hasNextInt()) {

                                System.out.println("\nPlease input a valid integer!\n");
                                scanner.next();
            
                                continue;
                            }

                            int element = scanner.nextInt();

                            if(remove(element, choice)) System.out.println("Element " + element + " removed from the table!\n");

                            else System.out.println("\nEither the element is not in the table or something went wrong :(");

                            printTable(choice);
                            break;
                        }
                        continue;

                    case 3:
                        while(true) {

                            System.out.println("\nPlease enter an integer to search: ");
                            System.out.print("\n> ");

                            if(!scanner.hasNextInt()) {

                                System.out.println("\nPlease input a valid integer!\n");
                                scanner.next();
            
                                continue;
                            }

                            int element = scanner.nextInt();

                            if(search(element, choice)) System.out.println("Element " + element + " is in the table!\n");

                            else System.out.println("\nEither the element is not in the table or something went wrong :(");
                            break;
                        }
                        continue;

                    case 4:
                        break;
                }
                break;
            }
        }
    }

    static void insert(int element, int choice) {

        switch(choice) {

            case 1:
                hashChaining.insert(element);
                break;
            case 2:
                hashLinearProb.insert(element);
                break;
            case 3:
                hashQuadProb.insert(element);
                break;
        }
    }

    static boolean remove(int element, int choice) {

        switch(choice) {

            case 1:
                return hashChaining.remove(element);
            case 2:
                return hashLinearProb.remove(element);
            case 3:
                return hashQuadProb.remove(element);
        }

        return false;
    }

    static boolean search(int element, int choice) {

        switch(choice) {

            case 1:
                return hashChaining.search(element);
            case 2:
                return hashLinearProb.search(element);
            case 3:
                return hashQuadProb.search(element);
        }

        return false;
    }

    static void printTable(int choice) {

        System.out.println();

        switch(choice) {

            case 1:
                System.out.println(hashChaining.toString());
                break;
            case 2:
                System.out.println(hashLinearProb.toString());
                break;
            case 3:
                System.out.println(hashQuadProb.toString());
                break;
        }
    }
}
