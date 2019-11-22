package flowers.dao;

import flowers.bean.Flower;
import flowers.exceptions.MyExceptionIncorrectLength;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlowerFileDaoImp implements FlowerDao {

    public List<Flower> readAll() {
        List<Flower> flowers = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("c:\\data\\flower_storage.txt"));
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                String[] s = tmp.split(" ");
                if(s.length != 7){
                    new MyExceptionIncorrectLength("Incorrect string in the file!");
                    //throw new MyExceptionIncorrectLength("Incorrect string in the file!");
                }

                Flower flower = new Flower(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]),
                Double.parseDouble(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6]));
                flowers.add(flower);
                }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return (flowers);
    }

    public void addFlower(Flower flower) {
        BufferedWriter bw = null;
         try {
            bw = new BufferedWriter(new FileWriter("c:\\data\\flower_storage.txt", true));
            PrintWriter out = new PrintWriter(bw);
            out.println(flower.toString());
            } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void clearFile(String filename)
    {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename, false));
            PrintWriter out = new PrintWriter(bw);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void create(Flower entity) {

    }

    @Override
    public Flower read(int id) {
        return null;
    }

    @Override
    public void update(Flower entity) {

    }

    @Override
    public void delete(int id) {

    }
}
