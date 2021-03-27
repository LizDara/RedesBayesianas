/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redbayesiana.Grafos;

import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author lizda
 */
public class AdyacenteConPeso implements Comparable<AdyacenteConPeso>, Serializable {

    private int x1, y1, x2, y2;
    private int indiceVertice;
    private double probabilidad;

    public AdyacenteConPeso(int indiceVertice, double probabilidad) {
        this.indiceVertice = indiceVertice;
        this.probabilidad = probabilidad;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getIndiceVertice() {
        return indiceVertice;
    }

    public void setIndiceVertice(int indiceVertice) {
        this.indiceVertice = indiceVertice;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }

    public void pintar(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
        if (x1 > x2 && y1 > y2) {
            g.drawString(String.valueOf(probabilidad), x1 - Math.abs((x1 - x2) / 2), y1 - Math.abs((y1 - y2) / 2));
        }
        if (x1 < x2 && y1 < y2) {
            g.drawString(String.valueOf(probabilidad), x2 - Math.abs((x1 - x2) / 2), y2 - Math.abs((y1 - y2) / 2));
        }
        if (x1 > x2 && y1 < y2) {
            g.drawString(String.valueOf(probabilidad), x1 - Math.abs((x1 - x2) / 2), y2 - Math.abs((y1 - y2) / 2));
        }
        if (x1 < x2 && y1 > y2) {
            g.drawString(String.valueOf(probabilidad), x2 - Math.abs((x1 - x2) / 2), y1 - Math.abs((y1 - y2) / 2));
        }
    }

    @Override
    public int compareTo(AdyacenteConPeso vert) {
        Integer esteVertice = this.indiceVertice;
        Integer elOtroVertice = vert.indiceVertice;
        return esteVertice.compareTo(elOtroVertice);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.indiceVertice;
        return hash;
    }

    @Override
    public boolean equals(Object otro) {
        /*if (this == otro) {
            return true;
        }*/
        if (otro == null) {
            return false;
        }
        if (getClass() != otro.getClass()) {
            return false;
        }
        AdyacenteConPeso other = (AdyacenteConPeso) otro;
        return this.indiceVertice == other.indiceVertice;
    }
}
