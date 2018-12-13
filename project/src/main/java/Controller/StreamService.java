package Controller;

import java.io.*;

/**
 * This class create Streams for load and save files about customers
 */
public class StreamService {

    /**
     * Create new ObjectOutputStream for save file about customers
     * @param fileName where located file about customers
     * @return ObjectOutputStream
     * @throws IOException exceptions of IO
     */
    public ObjectOutputStream getOOS(String fileName) throws IOException{
        try{
            return new ObjectOutputStream(new FileOutputStream(fileName, false));
        }
        catch (IOException e){
            throw e;
        }
    }

    /**
     * Create new ObjectInputStream for load file about customers
     * @param fileName where located file about customers
     * @return ObjectInputStream
     * @throws IOException exceptions of IO
     */
    public ObjectInputStream getOIS(String fileName) throws IOException{
        try{
            return new ObjectInputStream(new FileInputStream(fileName));
        }
        catch (IOException e){
            throw e;
        }
    }
}
