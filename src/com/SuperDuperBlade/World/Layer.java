package com.SuperDuperBlade.World;

import com.SuperDuperBlade.Main;

import java.io.*;
import java.util.Arrays;


public class Layer {

    private File mapDataLocation;
    private Tile[][] tilemap;



    public Layer(File mapDataLocation){
        this.mapDataLocation = mapDataLocation;
        loadMapData();
    }

    // loads tha information
    // rowEnd is the row that the fileParser stops parsing the data
    public void loadMapData(){
        long start = System.currentTimeMillis();
        int lines  = getLinesInFile(mapDataLocation);

        try (BufferedReader fileReader = new BufferedReader(new FileReader(mapDataLocation))) {

            String line = fileReader.readLine();
            tilemap = new Tile[lines][];

            for (int i = 0; line != null ; i++) {
                int mapDataRow[] = Arrays.stream(line.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                tilemap[i] = Tile.valueOfArray(mapDataRow);
                line = fileReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Main.debug("Time taken to load "+mapDataLocation.getName()+": "+ (System.currentTimeMillis()-start)+"ms");


    }
    //Gets the number of lines in a file
    private int getLinesInFile(File file){
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file))) {
           lineNumberReader.skip(Long.MAX_VALUE);
         return   lineNumberReader.getLineNumber()+1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Tile[][] getTilemap() {
        return tilemap;
    }
}
