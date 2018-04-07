package wine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public final class DataSet {

    private DataSample[] dataArray;
    public int samples;
    public String[] sampleArr;
    public int label_s,i;
    public double[] attr;
    String taskOutputString;
    
    public DataSet(String filename)throws FileNotFoundException{
        File file = new File(filename);
        i=0;
        label_s = 0;
        this.dataArray = new DataSample[this.getDataSetSize(filename)];
        
        Scanner input = new Scanner(file);
        
        while(input.hasNextLine()){
            sampleArr = ((input.next()).split(","));
            this.attr = new double[sampleArr.length-1];
            label_s = Integer.parseInt(sampleArr[0]);
            
            for(int j = 0; j<(sampleArr.length-1);j++){
                attr[j] = Double.parseDouble(sampleArr[j+1]);
            }
            DataSample data = new DataSample(label_s,attr);
            
            dataArray[i] = data;
            i++;
        }
        this.taskOutputString = 
                "Mean of class 1: " + Arrays.toString(this.getMean(1)) + "\n"
                +"Std of class 1: " + Arrays.toString(this.getStd(1)) + "\n"
               + "Mean of class 2: " + Arrays.toString(this.getMean(2)) + "\n"
               + "Std of class 2: " + Arrays.toString(this.getStd(2)) + "\n"
               + "Mean of class 3: " + Arrays.toString(this.getMean(3)) + "\n"
               +"Std of class 3: " + Arrays.toString(this.getStd(3)) + "\n";
    }
    
    public int getDataSetSize(String filename) throws FileNotFoundException {
        File file = new File(filename);
        try(Scanner input = new Scanner(file)){
            samples = 0;
            while(input.hasNextLine()){
                    input.nextLine();
                    samples++;
            }
            input.close();
        }
    return samples;
    }
    
    public double[] getMean(int label){
        return null;
    }
    
    public double[] getStd(int label){
        return null;    
    }
    
    public DataSample[] getDataSet(){
        return dataArray;      
    }
}
