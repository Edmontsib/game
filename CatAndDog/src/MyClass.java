public class MyClass {
    int number;
    char symbol;
    void show(){
        System.out.println("Число: "+number);
        System.out.println("Символ: "+symbol);
    }
    MyClass(int n, char s){
        System.out.println("Создается объект");
        number=n;
        symbol=s;
    }
    MyClass(){
        this(100,'A');
        System.out.println("Объект создан");
    }
    MyClass(int n){
        this(n,'B');
    }
    MyClass(char s){
        System.out.println("Новый объект");
        number=300;
        symbol=s;
    }
}
