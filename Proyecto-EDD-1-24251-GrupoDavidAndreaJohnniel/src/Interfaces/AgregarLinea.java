/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Lista;
import static Interfaces.Inicio.gestionApp;
import static Interfaces.Inicio.redGrafo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AgregarLinea extends javax.swing.JFrame {

    DefaultComboBoxModel modeloEstacionesNuevas = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloEstacionesRed = new DefaultComboBoxModel();
    private Lista nombresEstacionesNuevas = new Lista();

    public AgregarLinea() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.llenarCombo();
    }

    private void llenarCombo() {
        modeloEstacionesNuevas.removeAllElements();
        modeloEstacionesRed.removeAllElements();
        if (!nombresEstacionesNuevas.EsVacio()) {
            for (int i = 0; i < nombresEstacionesNuevas.getSize(); i++) {
                modeloEstacionesNuevas.addElement(nombresEstacionesNuevas.getValor(i));
            }
        }

        Lista nombresRed = gestionApp.nombresEstaciones(redGrafo);

        for (int i = 0; i < nombresRed.getSize(); i++) {
            modeloEstacionesRed.addElement(nombresRed.getValor(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputNombreEstacion = new javax.swing.JTextField();
        addEstacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        estacionesAgg = new javax.swing.JTextArea();
        estacionesLinea = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        estacionesRed = new javax.swing.JComboBox<>();
        aggLinea = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Agregar Linea");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));
        jPanel1.add(inputNombreEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 260, -1));

        addEstacion.setText("Agregar Estacion");
        addEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEstacionActionPerformed(evt);
            }
        });
        jPanel1.add(addEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        estacionesAgg.setColumns(20);
        estacionesAgg.setRows(5);
        jScrollPane1.setViewportView(estacionesAgg);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 260, 120));

        estacionesLinea.setModel(modeloEstacionesNuevas);
        estacionesLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estacionesLineaActionPerformed(evt);
            }
        });
        jPanel1.add(estacionesLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 260, -1));

        jLabel2.setText("Ingrese el Nombre de la Estacion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel3.setText("Paso 1");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel4.setText("Paso 2");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        estacionesRed.setModel(modeloEstacionesRed);
        jPanel1.add(estacionesRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 260, -1));

        aggLinea.setText("Agregar Linea");
        aggLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggLineaActionPerformed(evt);
            }
        });
        jPanel1.add(aggLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 380, -1));

        volver.setText("volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estacionesLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estacionesLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estacionesLineaActionPerformed

    private void addEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEstacionActionPerformed
        if (!inputNombreEstacion.getText().isEmpty()) {
            String nombreNuevo = (String) inputNombreEstacion.getText();
            if(!gestionApp.nombreEnLinea(nombresEstacionesNuevas, nombreNuevo)){
                nombresEstacionesNuevas.insertarFinal(nombreNuevo);
                this.llenarCombo();
                estacionesAgg.setText(nombresEstacionesNuevas.Transformar());
            }else{
                JOptionPane.showMessageDialog(null, "La estacion ya esta en la linea");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El input esta vacio");
        }
    }//GEN-LAST:event_addEstacionActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Menu menu = new Menu();
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void aggLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggLineaActionPerformed
        Lista vertices = new Lista();
        gestionApp.conectarEstacionesLinea(nombresEstacionesNuevas, vertices); 
        gestionApp.aggVertices(redGrafo, vertices);
        
        String nombreInicio = (String) estacionesLinea.getSelectedItem();
        String nombreFin = (String) estacionesRed.getSelectedItem();
        
        redGrafo.agregarConexion(nombreInicio, nombreFin);
    }//GEN-LAST:event_aggLineaActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarLinea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarLinea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEstacion;
    private javax.swing.JButton aggLinea;
    private javax.swing.JTextArea estacionesAgg;
    private javax.swing.JComboBox<String> estacionesLinea;
    private javax.swing.JComboBox<String> estacionesRed;
    private javax.swing.JTextField inputNombreEstacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
