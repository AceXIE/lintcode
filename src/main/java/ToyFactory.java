/**
 * Created by Administrator on 2016/6/20.
 */
interface Toy {
    void talk();
}
class Dog implements Toy {//类继承接口Toy
    public void talk() {
        System.out.println("Wow");
    }
}
class Cat implements Toy {
    public void talk() {
        System.out.println("Meow");
    }
}
public class ToyFactory {
    public Toy getToy(String type) {
        Toy toy = null;
        if (type.equals("Dog")) {
            toy = new Dog();
        } else if (type.equals("Cat")) {
            toy = new Cat();
        }
        return toy;
    }
}
