
interface Bird {
    void eat();
}

interface Fly_bird extends Bird {
    void fly();
}


class Sparrow implements Fly_bird 
{
    public void eat() {
        System.out.println("Sparrow is eating");
    }

    public void fly()
     {
        System.out.println("Sparrow is flying");
    }
}

class Penguin implements Bird 
{
    public void eat()
     {
        System.out.println("Penguin is eating");
       }

    public void swim() 
      {
        System.out.println("Penguin is swimming");
        }
}

public class Assignment2
 {
    public static void main(String[] args)
     {
        Sparrow sparrow = new Sparrow();
        sparrow.eat();
        sparrow.fly(); 
         Penguin penguin = new Penguin();
        penguin.eat();
        penguin.swim(); 
    }
}
