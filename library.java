/*
 * The main objective of this project is to provide a complete automated Library by digitizing its each and every functionality. Starting from the book-keeping, issuing of books, fine generation, advance booking and report generation all will be accomplished under one single project. The project will be a web based project with a database server responsible for maintaining every single detail of the Library. It has a very user friendly interface which can easily be operated by any non-technical person. There are essentially two modules of this software;

Admin module: Admin will have complete control over the system. Admin has permissions to
update, delete or modify any existing record or make a new entry (books and members). 

Users: The normal users enjoy only limited privileges. They have a view access to the books. They can browse through the categories, search for a particular book, return and issue a book. They are also provided with an email option in case of a query.
 */
import java.util.*;

class Books {
    String Bname, author;
    int Bid;

    public Books(String name, String au, int id) {
        Bname = name;
        author = au;
        Bid = id;
    }
}

class Admin {
    static int login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username of admin ");
        String username = sc.next();
        System.out.println("Enter the id of admin ");
        int id = sc.nextInt();

        if (username.equals("darshan") && id == 3001) {
            System.out.print("\nWelcome " + username + "!\n");
            return 1;
        }
        return 0;
    }

    static Books[] users = {
            new Books("Rich Dad Poor Dad", "Robert Kiyosaki and Sharon Lechter", 2001),
            new Books("The wings of fire", "A.P.J Abdul Kalam", 2002)
    };

    static void addBook(Books book) {
        Books[] updatedArray = new Books[users.length + 1];
        System.arraycopy(users, 0, updatedArray, 0, users.length);
        updatedArray[users.length] = book;
        users = updatedArray;
    }

    static void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new book Name :- ");
        String name = sc.next();
        System.out.println("Enter the Name of author :- ");
        String author = sc.next();
        System.out.println("Enter the new book id :- ");
        int id = sc.nextInt();

        Books b = new Books(name, author, id);
        addBook(b);
    }

    static void show() {
        System.out.println("Name \t\t Author \t ID");
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].Bname + " " + users[i].author + " " + users[i].Bid);
        }
    }

    static void modify(int id) {
        int c = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i].Bid == id) {
                c = 1;
            }
        }
        if (c == 1) {
            System.out.println("******** Enter the new data ********");
            insert();
            System.out.println("The record is updated ");
        } else {
            System.out.println("Enter right id");
        }
    }

    static void delete(int id) {
        int c = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i].Bid == id) {
                c = 1;
            }
        }
        if (c == 1) {
            System.out.println("******** The record is deleted ******* ");
        } else {
            System.out.println("Enter valid book id");
        }

    }
}

class users extends Admin {

    static int ulogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username of user ");
        String username = sc.next();
        System.out.println("Enter the id of user ");
        int id = sc.nextInt();

        if (username.equals("om") && id == 1) {
            System.out.print("\nWelcome " + username + "!\n");
            return 1;
        }
        return 0;

    }

    static void Ashow() {
        System.out.println("Name \t\t Author \t ID");
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].Bname + " " + users[i].author + " " + users[i].Bid);
        }
    }

    static void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of book :- ");
        int id = sc.nextInt();
        for (int i = 0; i < users.length; i++) {
            if (users[i].Bid == id) {
                System.out.println(users[i].Bname + "\t" + users[i].author + "\t" + users[i].Bid);
            }
        }
    }
}

public class library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin ad = new Admin();
        users u = new users();
        int ch1 = 0;
        int choice;

        do {
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Users");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                if (ad.login() == 1) {
                    System.out.println("Sucessfull login as admin");
                    do {
                        System.out.println("1. insert new data");
                        System.out.println("2. update data ");
                        System.out.println("3. delete data");
                        System.out.println("4. show Books");
                        System.out.println("5. Exits");
                        System.out.print("Choose an option: ");
                        ch1 = sc.nextInt();
                        switch (ch1) {
                            case 1:
                                ad.insert();
                                break;
                            case 2:
                                System.out.println("Enter the id for modification:- ");
                                int id = sc.nextInt();
                                ad.modify(id);
                                break;

                            case 3:
                                System.out.println("Enter the id for delete record:- ");
                                id = sc.nextInt();
                                ad.delete(id);
                                break;

                            case 4:
                                ad.show();
                                break;

                            case 5:
                                break;

                            default:
                                System.out.println("***** Enter valid choice *****");
                        }
                    } while (ch1 != 5);
                }
            } else if (choice == 2) {
                if (u.ulogin() == 1) {
                    do {
                        System.out.println("1. Showing all Books ");
                        System.out.println("2. Searching the book");
                        System.out.println("3. Exit");
                        System.out.print("Choose an option: ");
                        ch1 = sc.nextInt();
                        switch (ch1) {
                            case 1:
                                u.Ashow();
                                break;
                            case 2:
                                u.search();
                                break;

                            case 3:
                                System.out.println("Thank you");
                                break;

                            default:
                                System.out.println("***** Enter valid choice *****");
                        }
                    } while (ch1 != 3);
                }
            } else if (choice == 3) {
                System.out.println("Exiting... \n Thank you");
            }
        } while (choice != 3);
    }
}