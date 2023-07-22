package com.SuperDuperBlade.World.Layers;

import com.SuperDuperBlade.Main;
import com.SuperDuperBlade.World.Camera;
import com.SuperDuperBlade.World.TIle.Tile;
import com.SuperDuperBlade.World.TIle.TileInfo;

import java.awt.*;
import java.io.*;
import java.util.Arrays;



public class Layer {

    private File mapDataLocation;
    private Tile[][] tilemap;



    public Layer(File mapDataLocation){
        this.mapDataLocation = mapDataLocation;
        loadMapData();
    }



    public void drawLayer(Graphics2D g2, Camera camera){

        int tilescale = Main.getWindow().getTileScaled();


        for (int i = 0; i <camera.getTilesToRenderY(); i++){

            int posYOnScreen = (i*tilescale)-camera.getOffsetY();
            int posY = i + camera.getRenderPosStartY();
            for (int j = 0; j < camera.getTilesToRenderX(); j++) {
                try {
                    g2.drawImage(tilemap[posY][j + camera.getRenderPosStartX()].getImage(), (j * tilescale) - camera.getOffsetX(), posYOnScreen, null);
                }catch (ArrayIndexOutOfBoundsException e) {}
            }
        }
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
                int mapDataRow[] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                tilemap[i] = TileInfo.valueOfArray(mapDataRow);
                line = fileReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Main.debug("Time taken to load "+mapDataLocation.getName()+": "+ (System.currentTimeMillis()-start)+"ms");


    }
    //Gets the number of lines in a file
    private int getLinesInFile(File file) {
        int counter  = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) counter++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }


    public Tile[][] getTilemap() {
        return tilemap;
    }
}
