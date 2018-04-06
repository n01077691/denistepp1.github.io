package wine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class DataSet {

    private DataSample[] dataArray;
    public int samples;
    public String[] sampleArr = null;
    public int label;
    
    public DataSet(String filename)throws FileNotFoundException{
        System.out.println("Calculating number of lines...");
        getDataSetSize(filename);
        DataSample[] dataArray = new DataSample[samples];
    }
    
    public int getDataSetSize(String filename) throws FileNotFoundException {
        File file = new File(filename);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()){
                input.nextLine();
                samples++;
            }
        input.close();
            System.out.println("done");
        }
        return samples;
    }
    
    public double[] getMean(int label){
        double x[] = null;
        return x;
    }
    
    public double[] getStd(int label){
        return null;    
    }
    
    public DataSample[] getDataSet(){
        return dataArray;      
    }
}
