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
public class Vertice implements Comparable<Vertice>, Serializable{
    private int x, y;
    public static final int d = 40;
    private String nombre;
    private double CF;
    
    public Vertice(String nombre) {
        this.nombre = nombre;
        this.CF = -1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCF() {
        return CF;
    }

    public void setCF(double CF) {
        this.CF = CF;
    }
 
    public void pintar(Graphics g) {
        g.drawOval(x - d/2, y - d/2, d, d);
        g.drawString(nombre, x, y);
    }
    
    @Override
    public int compareTo(Vertice vert) {
        String esteVertice = this.nombre;
        String elOtroVertice = vert.nombre;
        return esteVertice.compareTo(elOtroVertice);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.x + this.y;
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
        Vertice other = (Vertice) otro;
        return this.nombre == other.nombre;
    }
}
