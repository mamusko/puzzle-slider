package Renderer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tile {
        private int row,column;
        private double dimension;
        private int number;

        public Tile(int row,int column,int dimension,int number){
            this.row=row;
            this.column=column;
            this.dimension=dimension;
            this.number=number;
        }

        public void setRow(int row){
            this.row=row;
        }

        public void setColumn(int column){	this.column=column; }

        public void draw(GraphicsContext gc){
            double x = row*dimension;
            double y = column*dimension;

            gc.setFill(Color.AZURE);
            gc.fillRect(x,y,dimension,dimension);
            gc.setStroke(Color.BLACK);
            gc.strokeRect(x,y,dimension,dimension);

            gc.setFill(Color.BLACK);
            gc.fillText(Integer.toString(number),x+dimension/2,y+dimension/2);

        }


}
