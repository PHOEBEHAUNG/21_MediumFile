import java.io.*;

import java.util.*;
import java.util.regex.*;

import java.nio.charset.StandardCharsets;
import java.awt.*;
import java.awt.event.InputEvent;

public class IOUtility 
{
  private static void DemoSysPrint()
  {
    try 
    {
      String msg = "Try I/O";

      System.out.println("println : " + msg);
      Thread.sleep(1000);
      System.out.append​('H');
      System.out.format("println : %s", msg);
    } 
    catch (InterruptedException e) 
    {
      e.printStackTrace(); 
    }
  }

  private static void DemoSysInRead()
  {
    try
    {
      String msg = "Try I/O";
      char c;
      int intChar;

      /// System.in.read
      long preTime = System.currentTimeMillis();
      int iDiffTime = 0;
      while(true)
      {
        intChar = System.in.read();
        
        if(intChar < 0)
        {
          continue;
        }

        //System.out.println("System.in.read is byte : " + intChar);
        c = (char)intChar;
        System.out.println(c);

        if(intChar == 'q')
        {
          break;
        }
      }
      iDiffTime = (int)(System.currentTimeMillis() - (long)preTime);
      System.out.println("Execute TIme : " + iDiffTime);
    } 
    catch (IOException e) 
    {
      e.printStackTrace(); 
    }
  }

  private static void DemoBufferedReaderLine()
  {
    try 
    {
      String line;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

      while(true)
      { 
        line = br.readLine();
        if(line.equals("q"))
        {
          break;
        }

        System.out.println(line);
      }
    } 
    catch (IOException e) 
    {
      e.printStackTrace(); 
    }
  }

  private static void DemoBufferedReader()
  {
    try 
    {
      char c;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      long preTime = System.currentTimeMillis();
      int iDiffTime = 0;

      c = (char) br.read();

      while(true)
      { 
        if(c < 0)
        {
          continue;
        }

        if(c == 'q')
        {
          break;
        }
        
        System.out.println(c);
        c = (char) br.read();
      }

      iDiffTime = (int)(System.currentTimeMillis() - (long)preTime);
      System.out.println("Execute TIme : " + iDiffTime);

    } 
    catch (IOException e) 
    {
      e.printStackTrace(); 
    }
  }

  /// Scanner
  private static void DemoScannerNext()
  {
    try
    {
      Scanner sc = new Scanner(System.in);
      String str = "";
      int iNum = 0;
      float fNum = 0;
      while(true)
      {
        if(!sc.hasNext()) 
        {
          break;
        }

        iNum = sc.nextInt();
        System.out.println(iNum);
        
        // str = sc.nextLine();
        // System.out.println(str);
        
        // str = sc.next();
        // System.out.println(str);
        
        
        // fNum = sc.nextFloat();
        // System.out.println(fNum);
        
        if(str.equals("q"))
        {
          break;
        }
      }
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

  private static void DemoScannerFindInLine()
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

  private static void DemoScannerUseDelimiter()
  {
    try
    {
      String input2 = "1 fish 2 fish red fish blue fish";
      Scanner s2 = new Scanner(input2).useDelimiter("\\s*fish\\s*");
      String str = "";
      while(true)
      {
        if(!s2.hasNext()) 
        {
          break;
        }
        str = s2.next();
        System.out.println("input 2 : " + str);
      }
      s2.close();
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

  void DemoFileStream() throws IOException
  {
    File outFile = new File("../data/data.txt");
    FileOutputStream outFileStream = new FileOutputStream(outFile);
    // FileOutputStream outFileStream = new FileOutputStream(outFile, true); /// the second constructure
    byte[] data = new byte[4];
    /// a = 97, b = 98, c = 99, d = 100
    data[0] = (byte)('a');  // data[0] = 97;
    data[1] = (byte)('b');  // data[0] = 98;
    data[2] = (byte)('c');  // data[0] = 99;
    data[3] = (byte)('d');  // data[0] = 100;

    outFileStream.write(data);
    outFileStream.close();

    ///==================================================================///
    
    File inFile = new File("../data/data.txt");
    FileInputStream inFileStream = new FileInputStream(inFile);

    int availableByte = inFileStream.available();
    System.out.println("Cnt : " + availableByte);

    int[] dataRead = new int[availableByte];
    int i = 0;

    for(i = 0;i < availableByte;i++)
    {
      dataRead[i] = inFileStream.read();
      System.out.println(dataRead[i]);
      System.out.println((char)dataRead[i]);
    }

    inFileStream.close();
  }

  void DemoFileCharset() throws IOException
  {
  
  }

  void DemoFileErrorCharset() throws IOException
  {
   
  }

  void DemoFile() throws IOException
  {
    String filePath = "../data/data.txt";
    FileWriter fileWriter = new FileWriter(filePath);

    fileWriter.write("a b c d \n"); /// write string
    fileWriter.write("a b c d"); /// write string

    fileWriter.close();
    char[] str = new char[16];
    int test;

    FileReader fildeReader = new FileReader(filePath);
    /// method 1 : read one char
    while((test = fildeReader.read()) != -1)
    {
      System.out.println((char)test);
    }

    /// method 2 : read remain char to char array at one time 
    // fildeReader.read(str);
    // System.out.println(str);
    
    fildeReader.close();
  }

  void DemoFileLineByLine() throws IOException
  {
    ///https://www.journaldev.com/709/java-read-file-line-by-line
    String filePath = "../data/data.txt";
    FileWriter fileWriter = new FileWriter(filePath);

    fileWriter.write("a b c d \n"); /// write string
    fileWriter.write("a b c d \n"); /// write char

    fileWriter.close();

    FileReader fildeReader = new FileReader(filePath);
    BufferedReader bufferReader = new BufferedReader(fildeReader);

    String strLine = bufferReader.readLine();
    while(strLine != null)
    { 
      System.out.println(strLine);
      strLine = bufferReader.readLine();
    }
    fildeReader.close();
  }

  public static void main(String[] args) throws IOException
  {
    DemoFileLineByLine();
  }
}
