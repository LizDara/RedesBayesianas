/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redbayesiana.Grafos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lizda
 */
public class GrafoPesado implements Serializable {

    private List<Vertice> listaDeVertices;
    private List<Vertice> listaDeHechos;
    private List<Vertice> listaDeMetas;
    private List<List<AdyacenteConPeso>> listasDeAdyacencias;
    public static int POSICION_INVALIDA = -1;
    public static final double INFINITO = Double.MAX_VALUE;

    public GrafoPesado() {
        listasDeAdyacencias = new ArrayList<>();
        listaDeVertices = new ArrayList<>();
        listaDeHechos = new ArrayList<>();
        listaDeMetas = new ArrayList<>();
    }

    public List<Vertice> getListaDeVertices() {
        return listaDeVertices;
    }

    public List<List<AdyacenteConPeso>> getListasDeAdyacencias() {
        return listasDeAdyacencias;
    }

    public List<Vertice> getListaDeMetas() {
        return listaDeMetas;
    }

    public boolean insertarVertice(Vertice vertice) {
        if (this.existeVertice(vertice)) {
            return false;
        }
        this.listaDeVertices.add(vertice);
        List<AdyacenteConPeso> listaDeAdyacentesDelVertice = new ArrayList<>();
        this.listasDeAdyacencias.add(listaDeAdyacentesDelVertice);
        return true;
    }

    public boolean existeVertice(Vertice vertice) {
        return this.obtenerPosicionDeVertice(vertice) != POSICION_INVALIDA;
    }

    public int obtenerPosicionDeVertice(Vertice vertice) {
        for (int i = 0; i < listaDeVertices.size(); i++) {
            Vertice verticeEnTurno = this.listaDeVertices.get(i);
            if (vertice.compareTo(verticeEnTurno) == 0) {
                return i;
            }
        }
        return POSICION_INVALIDA;
    }

    public Vertice obtenerVertice(String nombre) {
        for (Vertice vertice : this.listaDeVertices) {
            if (vertice.getNombre().equals(nombre)) {
                return vertice;
            }
        }
        return null;
    }

    public int cantidadDeVertices() {
        return this.listaDeVertices.size();
    }

    public boolean insertarArista(Vertice verticeOrigen, Vertice verticeDestino, double probabilidad, int x1, int y1, int x2, int y2) {
        if (!this.existeVertice(verticeOrigen)) {
            return false;
        }
        if (!this.existeVertice(verticeDestino)) {
            return false;
        }
        if (this.existeArista(verticeOrigen, verticeDestino)) {
            return false;
        }
        int posicionDeOrigen = this.obtenerPosicionDeVertice(verticeOrigen);
        int posicionDeDestino = this.obtenerPosicionDeVertice(verticeDestino);
        List<AdyacenteConPeso> listaDeAdyacentesDelOrigen
                = this.listasDeAdyacencias.get(posicionDeOrigen);
        AdyacenteConPeso adyacenteDelOrigen = new AdyacenteConPeso(posicionDeDestino, probabilidad);
        adyacenteDelOrigen.setX1(x1);
        adyacenteDelOrigen.setY1(y1);
        adyacenteDelOrigen.setX2(x2);
        adyacenteDelOrigen.setY2(y2);
        listaDeAdyacentesDelOrigen.add(adyacenteDelOrigen);
        Collections.sort(listaDeAdyacentesDelOrigen);
        return true;
    }

    public boolean existeArista(Vertice verticeOrigen, Vertice verticeDestino) {
        int posicionDeOrigen = this.obtenerPosicionDeVertice(verticeOrigen);
        int posicionDeDestino = this.obtenerPosicionDeVertice(verticeDestino);
        List<AdyacenteConPeso> listaDeAdyacentesDelOrigen
                = this.listasDeAdyacencias.get(posicionDeOrigen);
        AdyacenteConPeso adyacenteDelOrigen = new AdyacenteConPeso(posicionDeDestino, 0);
        return listaDeAdyacentesDelOrigen.contains(adyacenteDelOrigen);
    }

    public boolean eliminarArista(Vertice verticeOrigen, Vertice verticeDestino) {
        if (!this.existeArista(verticeOrigen, verticeDestino)) {
            return false;
        }
        int posicionVerticeOrigen = this.obtenerPosicionDeVertice(verticeOrigen);
        int posicionVerticeDestino = this.obtenerPosicionDeVertice(verticeDestino);
        List<AdyacenteConPeso> adyacentesDeVertice
                = this.listasDeAdyacencias.get(posicionVerticeOrigen);
        int indiceDeVerticeDestino = -1;
        for (int i = 0; i < adyacentesDeVertice.size(); i++) {
            AdyacenteConPeso adyacente = adyacentesDeVertice.get(i);
            if (posicionVerticeDestino == adyacente.getIndiceVertice()) {
                indiceDeVerticeDestino = i;
                i = adyacentesDeVertice.size();
            }
        }
        adyacentesDeVertice.remove(indiceDeVerticeDestino);
        return true;
    }

    public boolean eliminarVertice(Vertice verticeAEliminar) {
        if (!this.existeVertice(verticeAEliminar)) {
            return false;
        }
        int posicionDeVertice = this.obtenerPosicionDeVertice(verticeAEliminar);
        this.listaDeVertices.remove(verticeAEliminar);
        eliminarVerticeEnListaDeAdyacencia(posicionDeVertice);
        this.listasDeAdyacencias.remove(posicionDeVertice);
        return true;
    }

    private void eliminarVerticeEnListaDeAdyacencia(int posicionDeVertice) {
        for (int posicion = 0; posicion < this.cantidadDeVertices(); posicion++) {
            List<AdyacenteConPeso> adyacentesDeVerticeEnTurno
                    = this.listasDeAdyacencias.get(posicion);
            for (int j = 0; j < adyacentesDeVerticeEnTurno.size(); j++) {
                AdyacenteConPeso adyacente = adyacentesDeVerticeEnTurno.get(j);
                int posicionDeAdyacenteEnTurno = adyacente.getIndiceVertice();
                if (posicionDeAdyacenteEnTurno > posicionDeVertice) {
                    adyacente.setIndiceVertice(posicionDeAdyacenteEnTurno - 1);
                    adyacentesDeVerticeEnTurno.set(j, adyacente);
                }
                if (posicionDeAdyacenteEnTurno == posicionDeVertice) {
                    adyacentesDeVerticeEnTurno.remove(j);
                }
            }
        }
    }

    public boolean verificarGrafo() {
        for (int i = 0; i < this.listaDeVertices.size(); i++) {
            double total = 0;
            int count = 0;
            for (List<AdyacenteConPeso> adyacentes : this.listasDeAdyacencias) {
                for (AdyacenteConPeso adyacenteConPeso : adyacentes) {
                    if (adyacenteConPeso.getIndiceVertice() == i) {
                        total += adyacenteConPeso.getProbabilidad();
                        count++;
                    }
                }
            }
            if (count == 0) {
                if (!this.listaDeHechos.contains(this.listaDeVertices.get(i))) {
                    this.listaDeHechos.add(this.listaDeVertices.get(i));
                }
            } else if (total != 1) {
                System.out.println("Total mal: " + total);
                return false;
            }
        }
        for (int i = 0; i < this.listaDeVertices.size(); i++) {
            if (this.listasDeAdyacencias.get(i).isEmpty()) {
                if (!this.listaDeMetas.contains(this.listaDeVertices.get(i))) {
                    this.listaDeMetas.add(this.listaDeVertices.get(i));
                }
            }
        }
        return true;
    }

    private boolean isHecho(Vertice vertice) {
        return listaDeHechos.contains(vertice);
    }

    private double pregunta(Vertice vertice) {
        String CF = JOptionPane.showInputDialog("Ingrese el Factor de Certeza del vertice " + vertice.getNombre() + ":");
        return (CF != null) ? Double.parseDouble(CF) : 0;
    }

    private Vertice[] getAdyacentes(Vertice vertice) {
        int indiceDestino = obtenerPosicionDeVertice(vertice);
        int indiceOrigen = 0;
        List<Vertice> listaAdyacentes = new ArrayList<>();
        for (List<AdyacenteConPeso> adyacentes : this.listasDeAdyacencias) {
            for (AdyacenteConPeso adyacenteConPeso : adyacentes) {
                if (adyacenteConPeso.getIndiceVertice() == indiceDestino) {
                    listaAdyacentes.add(this.listaDeVertices.get(indiceOrigen));
                }
            }
            indiceOrigen++;
        }
        Vertice A[] = new Vertice[listaAdyacentes.size()];
        for (int i = 0; i < listaAdyacentes.size(); i++) {
            A[i] = listaAdyacentes.get(i);
        }
        return A;
    }

    public double probabilidad(Vertice verticeOrigen, Vertice verticeDestino) {
        int indiceOrigen = obtenerPosicionDeVertice(verticeOrigen);
        int indiceDestino = obtenerPosicionDeVertice(verticeDestino);
        for (AdyacenteConPeso adyacenteConPeso : this.listasDeAdyacencias.get(indiceOrigen)) {
            if (adyacenteConPeso.getIndiceVertice() == indiceDestino) {
                return adyacenteConPeso.getProbabilidad();
            }
        }
        return 0;
    }

    public double CF(Vertice vertice) {
        if (isHecho(vertice)) {
            if (vertice.getCF() == -1) {
                vertice.setCF(pregunta(vertice));
            }
            return vertice.getCF();
        }
        Vertice A[] = getAdyacentes(vertice);
        double ac = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i].getCF() == -1) {
                A[i].setCF(CF(A[i]));
            }
            ac += A[i].getCF() * probabilidad(A[i], vertice);
        }
        vertice.setCF(ac);
        return ac;
    }

    public double segundaOportunidad(Vertice vertice) {
        if (isHecho(vertice)) {
            if (vertice.getCF() == -1) {
                vertice.setCF(pregunta(vertice));
            }
            return vertice.getCF();
        }
        Vertice A[] = getAdyacentes(vertice);
        double ac = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i].getCF() == -1) {
                A[i].setCF(segundaOportunidad(A[i]));
            }
            ac += A[i].getCF() * probabilidad(A[i], vertice);
        }
        if (ac == 0) {
            boolean todosHechos = true;
            for (int i = 0; i < A.length; i++) {
                if (!isHecho(A[i])) {
                    todosHechos = false;
                }
            }
            if (todosHechos) {
                ac = pregunta(vertice);
            }
        }
        vertice.setCF(ac);
        return ac;
    }
}
