
public class HelloWorld 
{
  public static void main(String[] args) 
  {
    CalculateSpeed test = new CalculateSpeed();
    int speed = 0;
    System.out.println("Hello World!");

    speed = test.GetSpeed();
    System.out.println(speed);
  }
  
}