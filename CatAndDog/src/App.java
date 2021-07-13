import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DynamicArray toDoList = new DynamicArray();
        Scanner sc = new Scanner(System.in);
       int choose =3;
       do {
           System.out.println("1.Add item\n2.Show All\n3.Exit");
           choose = sc.nextInt();
           if (choose == 1) {
               System.out.println("Enter new ToDo");
               sc.nextLine();
               toDoList.add(sc.nextLine());
           } else if (choose == 2) {
               System.out.println(toDoList);
           }
       } while (choose!=3);
    }

}
