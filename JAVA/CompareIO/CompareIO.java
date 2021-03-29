import java.io.*;
import java.util.*;
public class CompareIO 
{
  private static void DemoCmprEfficScannerBR() throws InputMismatchException, UnsupportedOperationException, IOException, FileNotFoundException
  {
    int i = 0;
    long preTime = System.currentTimeMillis();
    int availableLine = 10124;

    ///==================================================================///
    /// Scanner
    Scanner scan = new Scanner(new FileReader("../data/data.txt"));
    preTime = System.currentTimeMillis();
    for(i = 0;i < availableLine;i++)
    {
      scan.nextLine();
    }
    System.out.format("Scanner Execute Time : %d\n", System.currentTimeMillis() - preTime);
    scan.close();

    ///==================================================================///
    /// BufferedReader
    BufferedReader br = new BufferedReader(new FileReader("../data/data.txt"));
    preTime = System.currentTimeMillis();
    for(i = 0;i < availableLine;i++)
    {
      br.readLine();
    }  
    System.out.format("BufferedReader Execute Time : %d\n", System.currentTimeMillis() - preTime);
    br.close();
  }

  private static void DemoCmprEfficFileStreamFR() throws InputMismatchException, UnsupportedOperationException, IOException, FileNotFoundException
  {
    int i = 0;
    long preTime = System.currentTimeMillis();
    File inFile = new File("../data/data.txt");
    int availableByte = 91124;

    ///==================================================================///
    /// FileInputStream  
    FileInputStream inFileStream = new FileInputStream(inFile);
    preTime = System.currentTimeMillis();
    for(i = 0;i < availableByte;i++)
    {
      inFileStream.read();
    }    
    System.out.format("FileInputStream Execute Time : %d ms\n", System.currentTimeMillis() - preTime);
    inFileStream.close();

    ///==================================================================///
    /// FileReader
    FileReader fildeReader = new FileReader(inFile);    
    preTime = System.currentTimeMillis();
    for(i = 0;i < availableByte;i++)
    {
      fildeReader.read();
    }    
    System.out.format("FileReader Execute Time : %d ms\n", System.currentTimeMillis() - preTime);
    fildeReader.close();
  }

  public static void main(String[] args) throws InputMismatchException, 
                                                UnsupportedOperationException, 
                                                IOException, FileNotFoundException
  {
    DemoCmprEfficScannerBR();
  }
}