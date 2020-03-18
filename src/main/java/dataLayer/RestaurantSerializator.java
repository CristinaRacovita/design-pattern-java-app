package dataLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import businessLayer.IRestaurantProcessing;
import businessLayer.MenuItem;
import businessLayer.Restaurant;

public class RestaurantSerializator {
    private File file;

    public RestaurantSerializator(String fileName) {
        this.file = new File(fileName);
    }

    public void writeData(IRestaurantProcessing restaurant) {

        FileOutputStream fileOutputStream;
        try {

            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(restaurant.getProduse());
            outputStream.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void readData(Restaurant restaurant) {

        FileInputStream fileInputStream;
        try {

            fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            restaurant.setProduse((ArrayList<MenuItem>)inputStream.readObject());

            inputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}

