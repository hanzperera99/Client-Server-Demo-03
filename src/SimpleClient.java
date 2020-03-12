import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleClient
{
    public static void main(String[] args)
    {
        SimpleClient client = new SimpleClient() ;
        client.execute();
    }

    private  void execute()
    {
        SimpleTemperatureRecorderServer server = new SimpleTemperatureRecorderServer() ;
        /*if(server.isServerConnected())
        {
            System.out.println("[CLIENT] - The Server is connected. The test can proceed") ;
            server.addTemperature(new Double(10));
            try {
                server.addTemperature(13.0);
            } catch (Exception ex) {
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("[CLIENT] - The minimum recorded temperature is " + server.getColdestTemperature());
            System.out.println("[CLIENT] - The highest recorded temperature is " + server.getHottestTemperature());
            System.out.println("[CLIENT] - The number of temperatures being recorded so far : " + server.getNumberOfSamples());
            System.out.println();

            server.addTemperature(1.0);
            System.out.println("[CLIENT] - The minimum recorded temperature is " + server.getColdestTemperature());
            System.out.println("[CLIENT] - The highest recorded temperature is " + server.getHottestTemperature());
            System.out.println("[CLIENT] - The number of temperatures being recorded so far : " + server.getNumberOfSamples());
            System.out.println();

            server.addTemperature(12.0);
            System.out.println("[CLIENT] - The minimum recorded temperature is " + server.getColdestTemperature());
            System.out.println("[CLIENT] - The highest recorded temperature is " + server.getHottestTemperature());
            System.out.println("[CLIENT] - The number of temperatures being recorded so far : " + server.getNumberOfSamples());
            System.out.println();

            server.addTemperature(-0.1);
            System.out.println("[CLIENT] - The minimum recorded temperature is " + server.getColdestTemperature());
            System.out.println("[CLIENT] - The highest recorded temperature is " + server.getHottestTemperature());
            System.out.println("[CLIENT] - The number of temperatures being recorded so far : " + server.getNumberOfSamples());
            System.out.println();

            server.addTemperature(-18.0);
            System.out.println("[CLIENT] - The minimum recorded temperature is " + server.getColdestTemperature());
            System.out.println("[CLIENT] - The highest recorded temperature is " + server.getHottestTemperature());
            System.out.println("[CLIENT] - The number of temperatures being recorded so far : " + server.getNumberOfSamples());
            System.out.println();

            server.addTemperature(18.0);
            System.out.println("[CLIENT] - The minimum recorded temperature is " + server.getColdestTemperature());
            System.out.println("[CLIENT] - The highest recorded temperature is " + server.getHottestTemperature());
            System.out.println("[CLIENT] - The number of temperatures being recorded so far : " + server.getNumberOfSamples());
            System.out.println();

            System.out.println("[CLIENT] - Average temperature is " + server.getAverageTemperature());

        }*/
        /*else
        {
            System.out.println("[CLIENT] - The server is not connected, terminate test") ;
        }*/

        Scanner in = new Scanner(System.in);
        System.out.println("=====================Menu===================");
        System.out.println(" 1 . Add temperatures");
        System.out.println(" 2 . To get the highest temp");
        System.out.println(" 3 . To get the lowest temp");
        System.out.println(" 4 . To get the num of temps");
        System.out.println(" 5 . To save the current values");
        System.out.println(" 6 . To get the previous values");
        System.out.println(" 7 . To quit");

        boolean quit = false;

        int menuItem;

        do {

            System.out.print("Choose menu item: ");

            menuItem = in.nextInt();

            switch (menuItem) {

                case 1:
                    System.out.println("You've chosen item #1");

                    Scanner input1 = new Scanner(System.in) ;

                    System.out.print("Enter temp 01 : ");
                    Double temp01 = input1.nextDouble() ;
                    System.out.println("Whats the scale of the temp 01");
                    String scale01 = input1.next();

                    try {
                        server.addTemperature(temp01 , scale01);
                    } catch (Exception ex) {
                        Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.print("Enter temp 02 : ");
                    Double temp02 = input1.nextDouble() ;
                    System.out.println("Whats the scale of the temp 01");
                    String scale02 = input1.next();

                    try {
                        server.addTemperature(temp02,scale02);
                    } catch (Exception ex) {
                        Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.print("Enter temp 03 : ");
                    Double temp03 = input1.nextDouble() ;
                    System.out.println("Whats the scale of the temp 01");
                    String scale03 = input1.next();

                    try {
                        server.addTemperature(temp03, scale03);
                    } catch (Exception ex) {
                        Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.print("Enter temp 04 : ");
                    Double temp04 = input1.nextDouble() ;
                    System.out.println("Whats the scale of the temp 01");
                    String scale04 = input1.next();

                    try {
                        server.addTemperature(temp04 , scale04);
                    } catch (Exception ex) {
                        Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.print("Enter temp 05 : ");
                    Double temp05 = input1.nextDouble() ;
                    System.out.println("Whats the scale of the temp 01");
                    String scale05 = input1.next();

                    try {
                        server.addTemperature(temp05, scale05);
                    } catch (Exception ex) {
                        Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 2:
                    System.out.println("You've chosen item #2");
                    try {
                        Double max_temp = server.getHottestTemperature();
                        System.out.println("Hottest temperature is : " + max_temp);
                    } catch (Exception ex) {
                        Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 3:
                    System.out.println("You've chosen item #3");
                    try {
                        Double min_temp = server.getColdestTemperature() ;
                        System.out.println("Coldest temperature is : " + min_temp);
                    } catch (Exception ex) {
                        Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 4:
                    System.out.println("You've chosen item #4");
                    server.getNumberOfSamples() ;
                    break;

                case 5:
                    try
                    {
                        File file = new File("ArrayList.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        PrintWriter pw = new PrintWriter(file);
                        for (int i = 0; i < server.temperatures.size(); i++)
                        {
                            pw.println(server.temperatures.get(i));
                        }
                        pw.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 6:

                    try
                    {
                        File file = new File("ArrayList.txt");
                        FileReader fr = new FileReader(file);
                        char [] a = new char[server.temperatures.size()];
                        fr.read(a) ;
                        for(char c : a)
                            System.out.print(c);   // prints the characters one by one
                        fr.close();
                        for(int i = 0 ; i < server.temperatures.size() ; i++)
                        {
                            double d1 = a[0] ;
                            double d2 = a[1] ;
                            double d3 = a[2] ;
                            double d4 = a[3] ;
                            double d5 = a[4] ;

                            try {
                                /*server.addTemperature(d1);
                                server.addTemperature(d2);
                                server.addTemperature(d3);
                                server.addTemperature(d4);
                                server.addTemperature(d5);*/
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    break;


                case 7:
                    System.out.println("You've chosen item #5");
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (!quit);

    }
}
