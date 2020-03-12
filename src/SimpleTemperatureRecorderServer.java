import java.util.ArrayList;

public class SimpleTemperatureRecorderServer
{
    ArrayList<Double> temperatures = new ArrayList<Double>() ;

    public Boolean isServerConnected()
    {
        System.out.println("[SERVER] - Testing if the server is connected");
        return true ;
    }

    public void addTemperature(Double sample , String scale) throws Exception {
        if(-1000 < sample  && sample < 1000)
        {
            if(scale.equals("f"))
            {
                double cel_value = (sample - 32)*5/9 ;
                System.out.println("[SERVER] - Adding Sample: " + cel_value) ;
                temperatures.add(cel_value) ;
                System.out.println("[SERVER] - All samples now are: " + temperatures) ;
            }

            if(scale.equals("k"))
            {
                double kel_value = sample - 273.15 ;
                System.out.println("[SERVER] - Adding Sample: " + kel_value) ;
                temperatures.add(kel_value) ;
                System.out.println("[SERVER] - All samples now are: " + temperatures) ;
            }

            if(scale.equals("c"))
            {
                System.out.println("[SERVER] - Adding Sample: " + sample) ;
                temperatures.add(sample) ;
                System.out.println("[SERVER] - All samples now are: " + temperatures) ;
            }
        }
        else
        {
            throw new Exception() ;
        }


    }

    public Double getColdestTemperature() throws Exception {
        if(temperatures.size() == 0)
        {
            throw new Exception() ;
        }
        else
        {
            double min = temperatures.get(0) ;

            for(int i = 0 ; i < temperatures.size() ; i++)
            {
                if (min > temperatures.get(i))
                {
                    min = temperatures.get(i) ;
                }
            }
            return min ;
        }


    }

    public Double getHottestTemperature() throws Exception {
        if(temperatures.size() == 0)
        {
            throw new Exception() ;
        }
        else
        {
            double max = temperatures.get(0) ;

            for(int i = 0 ; i < temperatures.size() ; i++)
            {
                if (max < temperatures.get(i))
                {
                    max = temperatures.get(i) ;
                }
            }
            return max ;
        }
    }

    public Double getAverageTemperature() throws Exception {
        if(temperatures.size() == 0)
        {
            throw new Exception() ;
        }
        else
        {
            double count = 0.0 ;

            for(int i = 0 ; i < temperatures.size() ; i++)
            {
                count = count + temperatures.get(i) ;
            }
            return count/temperatures.size() ;
        }
    }

    public void getNumberOfSamples()
    {
        int sample = temperatures.size() ;
        System.out.println("Num of samples : " + sample);
    }


}
