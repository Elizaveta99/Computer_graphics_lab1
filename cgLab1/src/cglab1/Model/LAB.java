/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cglab1.Model;

import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class LAB {
    private double l;
    private double a;
    private double b;
    
    private JTextField lTextField;
    private JTextField aTextField;
    private JTextField bTextField;
    private JSlider lSlider;
    private JSlider aSlider;
    private JSlider bSlider;
    
    public LAB(double ld, double ad, double bd)
    {
        if (ld < 0) {
            ld = 0;
            cglab1.Main.info.setText("L coordinate from LAB is out of bounds");
        }
        if (ld > 100) {
            ld = 100;
            cglab1.Main.info.setText("L coordinate from LAB is out of bounds");
        }
        if (ad < -128) {
            ad = -128;
            cglab1.Main.info.setText("A coordinate is out of bounds");
        }
        if (ad > 128) {
            ad = 128;
            cglab1.Main.info.setText("A coordinate is out of bounds");
        }
        if (bd < -128) {
            bd = -128;
            cglab1.Main.info.setText("B coordinate from LAB is out of bounds");
        }
        if (bd > 128) {
            bd = 128;
            cglab1.Main.info.setText("B coordinate from LAB is out of bounds");
        }
        l = ld;
        a = ad;
        b = bd;
    }
    
    public LAB(JTextField lt, JTextField at, JTextField bt, JSlider ls, JSlider as, JSlider bs)
    {
        lTextField = lt;
        aTextField = at;
        bTextField = bt;
        lSlider = ls;
        aSlider = as;
        bSlider = bs;
    }
    
    public int getL() {
        return (int)l;
    }
    
    public int getA() {
        return (int)a;
    }
    
    public int getB() {
        return (int)b;
    }
    
    public RGB toRGB() {
        // LAB to XYZ      
        double y = (l + 16d) / 116d;
        double x = a / 500d + y;
        double z = y - b / 200d;
        
        //Y
        if (Math.pow(y, 3) > 0.008856)
            y = (double)Math.pow(y, 3);
        else
            y = (double)((y - 16 / 116) / 7.787);
        
        //X
        if (Math.pow(x, 3) > 0.008856)
            x = (double)Math.pow(x, 3);
        else
            x = (double)((x - 16 / 116) / 7.787);
        
        // Z
        if (Math.pow(z, 3) > 0.008856)
            z = (double)Math.pow(z, 3);
        else
            z = (double)((z - 16 / 116 ) / 7.787);
        
        x = x * 95.047;
        y = y * 100.0;
        z = z * 108.883;
        
        //XYZ to RGB        
        x /= 100;
        y /= 100;
        z /= 100;
        
        double r = 3.240479d * x - 1.53715d * y - 0.498535d * z;
        double g = -0.969256d * x + 1.875991d * y + 0.041556d * z;
        double b = 0.055648d * x - 0.204043d * y + 1.057311d * z;
        
        if (r > 0.0031308)
            r = 1.055d * ((double)Math.pow(r, 0.4166d)) - 0.055d;
        else
            r = 12.92d * r;
        
        if (g > 0.0031308)
            g = 1.055d * ((double)Math.pow(g, 0.4166d)) - 0.055d;
        else
            g = 12.92d * g;
        
        if (b > 0.0031308)
            b = 1.055d * ((double)Math.pow(b, 0.4166d)) - 0.055d;
        else
            b = 12.92d * b;
       
                
        RGB rgb = new RGB((int)(r * 255), (int)(g * 255), (int)(b * 255));
        
        return rgb;
    }
    
    public HSL toHSL() {
        RGB rgb = toRGB();
        int ri = rgb.getRi();
        int gi = rgb.getGi();
        int bi = rgb.getBi();
        rgb.setR(ri);
        rgb.setG(gi);
        rgb.setB(bi);
        HSL hsl = rgb.toHSL();
        return hsl;
    }
}
