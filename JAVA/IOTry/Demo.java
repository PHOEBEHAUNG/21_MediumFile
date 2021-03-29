import java.io.*;

public class Demo 
{
  public static void main(String[] args)
  {
    try
    {
      String input = "1 fish 2 fish red fish blue fish";
      Scanner s = new Scanner(input);
      s.findInLine​("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
      MatchResult result = s.match();
      System.out.println("findInLine cnt : " + result.groupCount());
      for (int i = 1; i <= result.groupCount(); i++)
      {
        System.out.println(result.group(i));
      }
      s.close();
    }
    catch(InputMismatchException e)
    {
      System.out.println("InputMismatchException");
    }
    catch(UnsupportedOperationException e)
    {
      System.out.println("UnsupportedOperationException");
    }
  }
}


