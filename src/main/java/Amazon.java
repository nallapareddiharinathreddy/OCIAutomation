import java.io.IOException;

class Animal{
    void eat(){System.out.println("eating...");}
}
class Dog extends Animal{
    void bark(){System.out.println("barking...");}
}
class BabyDog extends Dog{
    void weep(){System.out.println("weeping...");}
}
class Amazon{
    public static void main(String args[]){
        BabyDog d=new BabyDog();
        System.out.println("test");

    }}


