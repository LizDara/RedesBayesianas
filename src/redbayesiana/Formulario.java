/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redbayesiana;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import redbayesiana.Grafos.AdyacenteConPeso;
import redbayesiana.Grafos.GrafoPesado;
import redbayesiana.Grafos.Vertice;

/**
 *
 * @author lizda
 */
public class Formulario extends javax.swing.JFrame {

    GrafoPesado grafo;
    Point p1, p2;
    Vertice verticeOrigen, verticeDestino, verticeMover;
    int indiceVerticeMover;

    /**
     * Creates new form Formulario
     */
    public Formulario() {
        initComponents();
        grafo = new GrafoPesado();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Vertice vertice : grafo.getListaDeVertices()) {
            vertice.pintar(panel.getGraphics());
        }
        for (List<AdyacenteConPeso> adyacentes : grafo.getListasDeAdyacencias()) {
            for (AdyacenteConPeso adyacenteConPeso : adyacentes) {
                adyacenteConPeso.pintar(panel.getGraphics());
            }
        }
    }

    private boolean isEncimaVertice(Point p) {
        Rectangle figura = new Rectangle(p.x - Vertice.d / 2, p.y - Vertice.d / 2, Vertice.d, Vertice.d);
        for (Vertice vertice : grafo.getListaDeVertices()) {
            if (new Rectangle(vertice.getX() - Vertice.d / 2, vertice.getY() - Vertice.d / 2, Vertice.d, Vertice.d).intersects(figura)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        fileNuevo = new javax.swing.JMenuItem();
        fileAbrir = new javax.swing.JMenuItem();
        fileGuardar = new javax.swing.JMenuItem();
        menuOptions = new javax.swing.JMenu();
        optionListo = new javax.swing.JMenuItem();
        optionMetas = new javax.swing.JMenuItem();
        optionEditarProbabilidad = new javax.swing.JMenuItem();
        optionEliminarVertice = new javax.swing.JMenuItem();
        optionEliminarArista = new javax.swing.JMenuItem();
        optionInicializar = new javax.swing.JMenuItem();
        optionSegundaOportunidad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelMouseMoved(evt);
            }
        });
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        menuFile.setText("File");

        fileNuevo.setText("Nuevo");
        fileNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNuevoActionPerformed(evt);
            }
        });
        menuFile.add(fileNuevo);

        fileAbrir.setText("Abrir");
        fileAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileAbrirActionPerformed(evt);
            }
        });
        menuFile.add(fileAbrir);

        fileGuardar.setText("Guardar");
        fileGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileGuardarActionPerformed(evt);
            }
        });
        menuFile.add(fileGuardar);

        jMenuBar1.add(menuFile);

        menuOptions.setText("Options");

        optionListo.setText("Calcular CF De Un Vertice");
        optionListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionListoActionPerformed(evt);
            }
        });
        menuOptions.add(optionListo);

        optionMetas.setText("Calcular Todo");
        optionMetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionMetasActionPerformed(evt);
            }
        });
        menuOptions.add(optionMetas);

        optionEditarProbabilidad.setText("Editar Probabilidad");
        optionEditarProbabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionEditarProbabilidadActionPerformed(evt);
            }
        });
        menuOptions.add(optionEditarProbabilidad);

        optionEliminarVertice.setText("Eliminar Vertice");
        optionEliminarVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionEliminarVerticeActionPerformed(evt);
            }
        });
        menuOptions.add(optionEliminarVertice);

        optionEliminarArista.setText("Eliminar Arista");
        optionEliminarArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionEliminarAristaActionPerformed(evt);
            }
        });
        menuOptions.add(optionEliminarArista);

        optionInicializar.setText("Inicializar Grafo");
        optionInicializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionInicializarActionPerformed(evt);
            }
        });
        menuOptions.add(optionInicializar);

        optionSegundaOportunidad.setText("Segunda Oportunidad");
        optionSegundaOportunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionSegundaOportunidadActionPerformed(evt);
            }
        });
        menuOptions.add(optionSegundaOportunidad);

        jMenuBar1.add(menuOptions);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) { //VERTICE
            if (!isEncimaVertice(evt.getPoint())) {
                String nombre = JOptionPane.showInputDialog("Ingrese nombre vertice:");
                if (nombre != null) {
                    Vertice nuevoVertice = new Vertice(nombre);
                    nuevoVertice.setX(evt.getX());
                    nuevoVertice.setY(evt.getY());
                    if (!grafo.insertarVertice(nuevoVertice)) {
                        JOptionPane.showMessageDialog(this, "Ya existe un vertice con ese nombre.");
                    }
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(this, "Debe insertar un nombre para el nuevo vertice.");
                }
            }
        }
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) { //ADYACENTE
            for (Vertice vertice : grafo.getListaDeVertices()) {
                if (new Rectangle(vertice.getX() - Vertice.d / 2, vertice.getY() - Vertice.d / 2, Vertice.d, Vertice.d).contains(evt.getPoint())) {
                    if (p1 == null) {
                        verticeOrigen = vertice;
                        p1 = new Point(vertice.getX(), vertice.getY());
                    } else {
                        verticeDestino = vertice;
                        p2 = new Point(vertice.getX(), vertice.getY());
                        String probabilidad = JOptionPane.showInputDialog("Ingrese la probabilidad:");
                        if (probabilidad != null) {
                            grafo.insertarArista(verticeOrigen, verticeDestino, Double.parseDouble(probabilidad), p1.x, p1.y, p2.x, p2.y);
                            repaint();
                        } else {
                            JOptionPane.showMessageDialog(this, "Debe insertar la probabilidad.");
                        }
                        p1 = null;
                        p2 = null;
                    }
                }
            }
        }
    }//GEN-LAST:event_panelMouseClicked

    private void panelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelMouseMoved

    private void panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMousePressed
        int indice = 0;
        for (Vertice vertice : grafo.getListaDeVertices()) {
            if (new Rectangle(vertice.getX() - Vertice.d / 2, vertice.getY() - Vertice.d / 2, Vertice.d, Vertice.d).contains(evt.getPoint())) {
                verticeMover = vertice;
                indiceVerticeMover = indice;
                break;
            }
            indice++;
        }
    }//GEN-LAST:event_panelMousePressed

    private void panelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseReleased
        verticeMover = null;
        indiceVerticeMover = -1;
    }//GEN-LAST:event_panelMouseReleased

    private void panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseDragged
        if (verticeMover != null) {
            grafo.getListaDeVertices().get(indiceVerticeMover).setX(evt.getX());
            grafo.getListaDeVertices().get(indiceVerticeMover).setY(evt.getY());
            for (List<AdyacenteConPeso> adyacentes : grafo.getListasDeAdyacencias()) {
                for (AdyacenteConPeso adyacenteConPeso : adyacentes) {
                    if (new Rectangle(adyacenteConPeso.getX1() - Vertice.d / 2, adyacenteConPeso.getY1() - Vertice.d / 2, Vertice.d, Vertice.d).contains(evt.getPoint())) {
                        adyacenteConPeso.setX1(evt.getX());
                        adyacenteConPeso.setY1(evt.getY());
                    } else if (new Rectangle(adyacenteConPeso.getX2() - Vertice.d / 2, adyacenteConPeso.getY2() - Vertice.d / 2, Vertice.d, Vertice.d).contains(evt.getPoint())) {
                        adyacenteConPeso.setX2(evt.getX());
                        adyacenteConPeso.setY2(evt.getY());
                    }
                }
            }
        }
        repaint();
    }//GEN-LAST:event_panelMouseDragged

    private void optionListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionListoActionPerformed
        if (grafo.verificarGrafo()) {
            String nombre = JOptionPane.showInputDialog("Inserte el nombre del vertice que quiere calcular el CF:");
            if (nombre != null) {
                Vertice vertice = grafo.obtenerVertice(nombre);
                if (vertice != null) {
                    double CF = grafo.CF(vertice);
                    JOptionPane.showMessageDialog(this, "El CF del vertice " + nombre + " es " + CF);
                } else {
                    JOptionPane.showMessageDialog(this, "No existe un vertice con ese nombre.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe insertar el nombre del vertice que quiere calcular el CF.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La Red Bayesiana no est?? bien hecha.");
        }
        repaint();
    }//GEN-LAST:event_optionListoActionPerformed

    private void optionEliminarVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionEliminarVerticeActionPerformed
        String nombre = JOptionPane.showInputDialog("Inserte el nombre del vertice que quiere eliminar:");
        if (nombre != null) {
            Vertice vertice = grafo.obtenerVertice(nombre);
            if (vertice != null) {
                grafo.eliminarVertice(vertice);
            } else {
                JOptionPane.showMessageDialog(this, "No existe un vertice con ese nombre.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe insertar el nombre del vertice que quiere eliminar.");
        }
        repaint();
    }//GEN-LAST:event_optionEliminarVerticeActionPerformed

    private void optionEliminarAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionEliminarAristaActionPerformed
        String nombreOrigen = JOptionPane.showInputDialog("Inserte el nombre del vertice origen:");
        if (nombreOrigen != null) {
            String nombreDestino = JOptionPane.showInputDialog("Ingrese el nombre del vertice destino:");
            if (nombreDestino != null) {
                Vertice verticeOrigen = grafo.obtenerVertice(nombreOrigen);
                Vertice verticeDestino = grafo.obtenerVertice(nombreDestino);
                if (verticeOrigen != null && verticeDestino != null) {
                    grafo.eliminarArista(verticeOrigen, verticeDestino);
                } else {
                    JOptionPane.showMessageDialog(this, "No existe un vertice origen o vertice destice con ese nombre.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe insertar el nombre del vertice destino.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe insertar el nombre del vertice origen.");
        }
        repaint();
    }//GEN-LAST:event_optionEliminarAristaActionPerformed

    private void optionEditarProbabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionEditarProbabilidadActionPerformed
        String nombreOrigen = JOptionPane.showInputDialog("Inserte el nombre del vertice origen:");
        if (nombreOrigen != null) {
            String nombreDestino = JOptionPane.showInputDialog("Ingrese el nombre del vertice destino:");
            if (nombreDestino != null) {
                Vertice verticeOrigen = grafo.obtenerVertice(nombreOrigen);
                Vertice verticeDestino = grafo.obtenerVertice(nombreDestino);
                if (verticeOrigen != null && verticeDestino != null) {
                    if (grafo.existeArista(verticeOrigen, verticeDestino)) {
                        int indiceOrigen = grafo.obtenerPosicionDeVertice(verticeOrigen);
                        int indiceDestino = grafo.obtenerPosicionDeVertice(verticeDestino);
                        for (AdyacenteConPeso adyacenteConPeso : grafo.getListasDeAdyacencias().get(indiceOrigen)) {
                            if (adyacenteConPeso.getIndiceVertice() == indiceDestino) {
                                String probabilidad = JOptionPane.showInputDialog("Inserte la probabilidad:");
                                if (probabilidad != null) {
                                    adyacenteConPeso.setProbabilidad(Float.parseFloat(probabilidad));
                                    repaint();
                                    break;
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No existe una arista entre esos vertices.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No existe un vertice origen o vertice destice con ese nombre.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe insertar el nombre del vertice destino.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe insertar el nombre del vertice origen.");
        }
        repaint();
    }//GEN-LAST:event_optionEditarProbabilidadActionPerformed

    private void fileNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNuevoActionPerformed
        grafo = new GrafoPesado();
        repaint();
    }//GEN-LAST:event_fileNuevoActionPerformed

    private void fileGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileGuardarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.RB", "RB");
        fileChooser.setFileFilter(filter);
        int selection = fileChooser.showSaveDialog(this);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FileOutputStream fichero = null;
            try {
                fichero = new FileOutputStream(file.getAbsolutePath());
                ObjectOutputStream outputStream = new ObjectOutputStream(fichero);
                outputStream.writeObject(grafo);
                grafo = new GrafoPesado();
                repaint();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fichero.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_fileGuardarActionPerformed

    private void fileAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileAbrirActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.RB", "RB");
        fileChooser.setFileFilter(filter);
        int selection = fileChooser.showOpenDialog(this);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FileInputStream fichero = null;
            try {
                fichero = new FileInputStream(file.getAbsolutePath());
                ObjectInputStream inputStream = new ObjectInputStream(fichero);
                grafo = (GrafoPesado) inputStream.readObject();
                repaint();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_fileAbrirActionPerformed

    private void optionMetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionMetasActionPerformed
        if (grafo.verificarGrafo()) {
            String resultado = "Las CF calculadas son: ";
            for (Vertice vertice : grafo.getListaDeMetas()) {
                double CF = grafo.CF(vertice);
                resultado += vertice.getNombre() + "=" + CF + "; ";
            }
            JOptionPane.showMessageDialog(this, resultado);
        } else {
            JOptionPane.showMessageDialog(this, "La Red Bayesiana no est?? bien hecha.");
        }
        repaint();
    }//GEN-LAST:event_optionMetasActionPerformed

    private void optionInicializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionInicializarActionPerformed
        for (Vertice vertice : grafo.getListaDeVertices()) {
            vertice.setCF(-1);
        }
        JOptionPane.showMessageDialog(this, "Se inicializ?? todos los vertices a CF = -1. Puede iniciar un nuevo c??lculo.");
        repaint();
    }//GEN-LAST:event_optionInicializarActionPerformed

    private void optionSegundaOportunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionSegundaOportunidadActionPerformed
        if (grafo.verificarGrafo()) {
            String nombre = JOptionPane.showInputDialog("Inserte el nombre del vertice que quiere calcular el CF:");
            if (nombre != null) {
                Vertice vertice = grafo.obtenerVertice(nombre);
                if (vertice != null) {
                    double CF = grafo.segundaOportunidad(vertice);
                    JOptionPane.showMessageDialog(this, "El CF del vertice " + nombre + " es " + CF);
                } else {
                    JOptionPane.showMessageDialog(this, "No existe un vertice con ese nombre.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe insertar el nombre del vertice que quiere calcular el CF.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "La Red Bayesiana no est?? bien hecha.");
        }
        repaint();
    }//GEN-LAST:event_optionSegundaOportunidadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem fileAbrir;
    private javax.swing.JMenuItem fileGuardar;
    private javax.swing.JMenuItem fileNuevo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JMenuItem optionEditarProbabilidad;
    private javax.swing.JMenuItem optionEliminarArista;
    private javax.swing.JMenuItem optionEliminarVertice;
    private javax.swing.JMenuItem optionInicializar;
    private javax.swing.JMenuItem optionListo;
    private javax.swing.JMenuItem optionMetas;
    private javax.swing.JMenuItem optionSegundaOportunidad;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
