/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Grafo;
import Funciones.CargarArchivo;
import Funciones.SelectorArchivo;


public class Inicio extends javax.swing.JFrame {

    public static Grafo redGrafo = new Grafo();
    public static int valorT = 0;
    
    public Inicio() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        iniciarIniciar = new javax.swing.JButton();
        ruta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("BIENVENIDOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        iniciarIniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        iniciarIniciar.setText("Iniciar Programa");
        iniciarIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(iniciarIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 240, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 280));

        ruta.setText("jTextField1");
        getContentPane().add(ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarIniciarActionPerformed
        SelectorArchivo selector = new SelectorArchivo(this, ruta);
        CargarArchivo cargarJSON = new CargarArchivo(redGrafo);
        
        String rutaJSON = selector.buscarArchivoJson();
        cargarJSON.cargarArchivoJSON(rutaJSON);
        
        EstablecerT establecerT = new EstablecerT();
        this.dispose();
        
//        System.out.println(cargarJSON.getGrafo().toString());
//        System.out.println();
//        System.out.println();
//        System.out.println(redGrafo.toString());
    }//GEN-LAST:event_iniciarIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciarIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField ruta;
    // End of variables declaration//GEN-END:variables
}
