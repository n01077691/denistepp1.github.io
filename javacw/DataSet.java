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
        double[] attributes=new double[samples]; //to convert string array into doubles array

        for(int i=0;i<samples;i++){
            String[] token=sampleArr[i].split(","); //this is to split string by ','
            label=Integer.parseInt(token[0]); //split label is token[0]

            for(int j=1;j<token.length;j++)
            attributes[j-1]=Double.parseDouble(token[j]); //token[1] to token[13] are attributes, this will convert string into //double

            dataArray[i]=new DataSample(label,attributes); 
            }
        System.out.println(dataArray[0]);
    }
    
    public int getDataSetSize(String filename) throws FileNotFoundException {
        samples=0;
        File file = new File(filename);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()){
                sampleArr[samples]=input.nextLine(); //sampleArr , has each line read from file
                samples++;
            }
            input.close();
            System.out.println("done ");
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
