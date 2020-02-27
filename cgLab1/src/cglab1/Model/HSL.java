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
public class HSL {
    private int h;
    private double s;
    private double l;
//    private int hi;
//    private int si;
//    private int li;
    
    private JTextField hTextField;
    private JTextField sTextField;
    private JTextField lTextField;
    private JSlider hSlider;
    private JSlider sSlider;
    private JSlider lSlider;
    
    public HSL(int hd, double sd, double ld)
    {
        h = hd;
        s = sd;
        l = ld;
    }
    
//    public HSL(int hd, int sd, int ld)
//    {
//        hi = hd;
//        si = sd;
//        li  = ld;
//    }
    
    public int getH() {
        return (int)h;
    }
    
    public int getS() {
        return (int)s;
    }
    
    public int getL() {
        return (int)l;
    }
    
//    public HSL(HSL hsl)
//    {
//        hTextField.setText(hsl.h.toString());
//        sTextField = st;
//        lTextField = lt;
//        hSlider = hs;
//        sSlider = ss;
//        lSlider = ls;
//    }
    
    public HSL(JTextField ht, JTextField st, JTextField lt, JSlider hs, JSlider ss, JSlider ls)
    {
        hTextField = ht;
        sTextField = st;
        lTextField = lt;
        hSlider = hs;
        sSlider = ss;
        lSlider = ls;
    }
    
    public double Hue_to_RGB(double v1, double v2, double vH) {
        if (vH < 0) {
            vH += 1;
            cglab1.Main.info.setText("from HSL to RGB out of ranges\n");  // DEATAIL information
        }
        if (vH > 1) {
            vH -= 1;
            cglab1.Main.info.setText("from HSL to RGB out of ranges\n");  // DEATAIL information
        }
        if ((6 * vH) < 1)
            return (v1 + (v2 - v1) * 6 * vH);
        if ((2 * vH) < 1)
            return v2;
        if ((3 * vH) < 2)
            return (v1 + (v2 - v1) * ((2.0d / 3) - vH) * 6);
        return v1;
    }
    
    public RGB toRGB() {
        double r = 0, g = 0, b = 0;
        
        if (s == 0)
        {
            // gray values
            r = g = b = (int)(l * 255);
        }
        else
        {
            double v1, v2;
            double h_temp = (double) h / 360;

            v2 = (l < 0.5) ? (l * (1.0 + s)) : ((l + s) - (l * s));
            v1 = 2 * l - v2;

            r = (int)(255 * Hue_to_RGB(v1, v2, h_temp + (1.0d / 3)));
            g = (int)(255 * Hue_to_RGB(v1, v2, h_temp));
            b = (int)(255 * Hue_to_RGB(v1, v2, h_temp - (1.0d / 3)));
        }
        
        RGB rgb = new RGB((int)r, (int)g, (int)b);

        return rgb;
    }
    
    public LAB toLAB() {
        RGB rgb = toRGB();
        int ri = rgb.getRi();
        int gi = rgb.getGi();
        int bi = rgb.getBi();
        rgb.setR(ri);
        rgb.setG(gi);
        rgb.setB(bi);
        // с дробными коорд передаю
        LAB lab = rgb.toLAB(); // проверить, что новые значения из полей класса; иначе параметры вл все функции перевода добавить
        return lab;
    }
    
}
