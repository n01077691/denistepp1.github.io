package wine;

final class DataSample {
    private int label;
    private int numOfAttributes;
    private double[] attributes;
    public double dist;
    
    public DataSample(int lb, double[] atr){
        setLabel(lb);
        
        for(int i = 0; i<atr.length;i++){
            numOfAttributes++;
        }
        
        this.attributes = new double[numOfAttributes];
        for(int i = 0; i<atr.length;i++){
            attributes[i] = atr[i];
        }
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
        dist = 0;
        for(int i=0; i<numOfAttributes;i++){
            dist = dist + Math.pow((this.attributes[i] - dat.attributes[i]),2);
        }
        dist = Math.pow(dist, 0.5);
        
        return dist;
    }
}
