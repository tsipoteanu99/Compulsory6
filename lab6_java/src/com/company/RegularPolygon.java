package com.company;

import java.awt.*;
/**
 * Aici e o functie luata de pe slideuri, nu stiu ce sa zic, e peste abilitatile mele matematice
 * **/
public class RegularPolygon extends Polygon {

    public RegularPolygon( int x0, int y0, int radius, int sides){

        double alpha = 2* Math.PI / sides;
        for(int i=0; i< sides; i++){
            double x= x0+radius*Math.cos(alpha*i);
            double y= y0+radius*Math.sin(alpha*i);
            this.addPoint((int) x, (int) y);
        }
    }
}
