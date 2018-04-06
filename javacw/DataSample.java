package wine;

class DataSample {
    private int label;
    private int numOfAttributes;
    private double[] attributes;
    
    public DataSample(int lb, double[] atr){
        
    }
    
    public void setLabel(int lb){
        this.label = lb;
    }
    
    public int getLabel(){
        return label; 
    }
    
    public int getnumOfAttributes(){
        return numOfAttributes;
    }
    
    public double[] getAttributes(){
        return attributes;   
    }
    
    public double distance(DataSample dat){
        return 0;
    }
}
