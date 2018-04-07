
package wine;

import java.io.FileNotFoundException;

public class main {
      public static void main(String[] args) throws FileNotFoundException {
         DataSet train = new DataSet("wine.txt");
         System.out.println(train.taskOutputString);
    }
}
