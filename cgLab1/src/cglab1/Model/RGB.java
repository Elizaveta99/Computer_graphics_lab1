/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cglab1.Model;

import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author User
 */
public class RGB {
    private double r;
    private double g;
    private double b;
    private int ri;
    private int gi;
    private int bi;
    
    private JTextField rTextField;
    private JTextField gTextField;
    private JTextField bTextField;
    private JSlider rSlider;
    private JSlider gSlider;
    private JSlider bSlider;
    
    public RGB(double rd, double gd, double bd)
    {
        r = rd;
        g = gd;
        b = bd;
    }
    
    public RGB(int rd, int gd, int bd)
    {
        ri = rd;
        gi = gd;
        bi = bd;
    }
    
    public void setRi(int rd) {
        ri = rd;
    }
    
    public void setGi(int gd) {
        gi = gd;
    }
    
    public void setBi(int bd) {
        bi = bd;
    }
    
    public int getRi() {
        return ri;
    }
    
    public int getGi() {
        return gi;
    }
    
    public int getBi() {
        return bi;
    }
    
    public void setR(int rd) {
        r = rd / 255.0;
    }
    
    public void setG(int gd) {
        g = gd / 255.0;
    }
    
    public void setB(int bd) {
        b = bd / 255.0;
    }
    
    public double getR() {
        return r;
    }
    
    public double getG() {
        return g;
    }
    
    public double getB() {
        return b;
    }
    
    public RGB(JTextField rt, JTextField gt, JTextField bt, JSlider rs, JSlider gs, JSlider bs)
    {
        rTextField = rt;
        gTextField = gt;
        bTextField = bt;
        rSlider = rs;
        gSlider = gs;
        bSlider = bs;
    }
    
    public HSL toHSL() {        
        
        // проверить, точно ли дробные надо
        
        double max = Math.max(r, Math.max(r, b));
        double min = Math.min(r, Math.min(r, b));
        double delta = max - min;
        
        double h = 0;
        double s = 0;
        double l = (max + min) / 2;
        
        if (delta == 0) {
            // gray color
            h = 0;
            s = 0.0d;
        }
        else
        {
            // get saturation value
            s = (l <= 0.5) ? (delta / (max + min)) : (delta / (2 - max - min ));

            // get hue value
            double hue;
            if (r == max)
            {
                hue = ((g - b) / 6) / delta;
            }
            else if (g == max)
            {
                hue = (1.0d / 3) + ((b - r) / 6) / delta; 
            }
            else
            {
                hue = (2.0d / 3) + ((r - g) / 6) / delta;
            }

            // correct hue if needed
            if (hue < 0) {
                hue += 1;
                cglab1.Main.info.setText("from RGB to HSL out of ranges\n");  // DEATAIL information
            }
            if (hue > 1) {
                hue -= 1;
                cglab1.Main.info.setText("from RGB to HSL out of ranges\n");  // DEATAIL information
            }

            h = (int)(hue * 360);
        }
        
        HSL hsl = new HSL((int)h, s, l);
        return hsl;
    }
    
    public LAB toLAB() {
        double l = 0, a = 0, b = 0;
        
        // RGB to XYZ        
        //R
        if (r > 0.04045)
            r = (double)Math.pow(((r + 0.055d) / 1.055d), 2.4d);
        else
            r /= 12.92d;
        
        //G
        if (g > 0.04045)
            g = (double)Math.pow(((g + 0.055d) / 1.055d), 2.4d);
        else
            g /= 12.92d;
        
        //B
        if (b > 0.04045)
            b = (double)Math.pow(((b + 0.055d) / 1.055d), 2.4d);
        else
            b /= 12.92d;
        
        r *= 100;
        g *= 100;
        b *= 100;
        
        double x = 0.412453d * r + 0.35758d * g + 0.180423d * b;
        double y = 0.212671d * r + 0.71516d * g + 0.072169d * b;
        double z = 0.019334d * r + 0.119193d * g + 0.950227d * b;
        
        
        // XYZ to LAB
        x /= 95.047;
        y /= 100.0;
        z /= 108.883;
        
        if (x > 0.008856)
            x = (double)Math.pow(x, 0.33d);
        else
            x = (7.787d * x) + (0.1379310344827586d);
        
        if (y > 0.008856)
            y = (float)Math.pow(y, 0.33d);
        else
            y = (7.787d * y) + (0.1379310344827586d);
        
        if (z > 0.008856)
            z = (float)Math.pow(z, 0.33d);
        else
            z = (7.787d * z) + (0.1379310344827586d);
        
        l = (116 * y) - 16;
        a = 500 * (x - y);
        b = 200 * (y - z);
        
        LAB lab = new LAB(l, a, b);
                
        return lab;
    }

}
