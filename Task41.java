import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Task41 {
    static int noofrecords = 0;

    static int[] price; static float[] rating;
    // static LinkedList<Integer> price = new LinkedList<Integer>();
    // static LinkedList<Float> rating = new LinkedList<Float>();
    static LinkedList<String> data = new LinkedList<String>();
    static String[] data1;

    public static void main(String[] args) throws IOException {
        String l = "";
        FileReader f;
        try {
            f = new FileReader("flipkart-product-sample.csv");
            BufferedReader br = new BufferedReader(f);
            while ((l = br.readLine()) != null) {
                noofrecords++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        price = new int[99];
        rating = new float[99];
        // data = new String[100];

        Task41.readFromFile();
        Task41.sortingOnPrice(price, data);
        Task41.sortingOnRating(rating, data);
    }

    static void readFromFile() {
        String l = "";
        int i = 0;

        FileReader f;
        try {
            f = new FileReader("data.csv");
            BufferedReader br = new BufferedReader(f);
            l = br.readLine();
            String tempString = "";
            while ((l = br.readLine()) != null) {
                data.add(l);
                // data[i] = l;
                tempString = l.replaceAll("No rating available", "0");
                String temp1[] = tempString.split(",");
                
                price[i] = Integer.parseInt(temp1[4]);
                rating[i] = Float.parseFloat(temp1[6]);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception io) {
            io.printStackTrace();
        }
    }

    static void sortingOnPrice(int[] price, LinkedList<String> data) {
        // int j = 0;
        data1 = new String[100];
        // System.out.println(data.size());
        // System.out.println(price.length);
        for (int j = 0; j < 99; j++) {
            data1[j] = data.get(j);
        }

        long startTime = System.currentTimeMillis();

        QuickSort.quickSort(price, 0, price.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("******************\nTime taken for Quick sorting to run is: " + (endTime - startTime)
                + "\n********************\n");

        try {
            FileWriter fw = new FileWriter("OutputDataOnSortPrice.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("pid,product_name,brand,product_url,retail_price,discounted_price,product_rating\n");

            for (int i = 0; i < 99 ; i++) {
                bw.write(data1[i] + "\n");
                // l++;
            }
            bw.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    static void sortingOnRating(float[] rating2, LinkedList<String> data) {
        // data1 = new String[100];
        // int j = 0;

        for (int j = 0; j < 99; j++) {
            // data1.add(data.get(j));
            data1[j] = data.get(j);
        }
        QuickSort.quickSort1(rating2, 0, rating2.length - 1);
        try {
            FileWriter fw = new FileWriter("OutputDataOnSortRatings.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("pid,product_name,brand,product_url,retail_price,discounted_price,product_rating\n");
            for (int i = 0; i < 99 ; i++) {
                bw.write(data1[i]+ "\n");
            }
            bw.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
