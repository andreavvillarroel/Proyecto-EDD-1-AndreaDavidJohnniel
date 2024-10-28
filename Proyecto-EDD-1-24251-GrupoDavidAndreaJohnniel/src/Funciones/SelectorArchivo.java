/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SelectorArchivo {
    private JFrame cargar;
    private JTextField ruta;

    public SelectorArchivo(JFrame cargar, JTextField ruta) {
        this.cargar = cargar;
        this.ruta = ruta;
    }
    
    public String buscarArchivoJson() {
        JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");
        fc.setFileFilter(filtro);
        fc.setAcceptAllFileFilterUsed(false);

        
        int seleccion = fc.showOpenDialog(cargar);

        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            ruta.setText(fichero.getAbsolutePath());
            
            return ruta.getText();

        } else {
            JOptionPane.showMessageDialog(cargar, "No se ha seleccionado ningún archivo.");
            return null;
        }
    }
}
