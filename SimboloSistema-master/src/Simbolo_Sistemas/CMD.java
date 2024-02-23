package Simbolo_Sistemas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
public class CMD extends javax.swing.JFrame {

    public CMD() {
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        CMD = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 520, 30));

        CMD.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        CMD.setForeground(new java.awt.Color(255, 255, 255));
        CMD.setText("CMD");
        jPanel1.add(CMD, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 60, 30));

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 650, 380));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setText("Enter");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String command = jTextField1.getText();
        String[] tokens = command.split(" ");

        File DirecActual = new File(System.getProperty("user.dir"));
        if (tokens.length == 0) {
            jTextArea1.append("\nError: Comando vacio\n");
            return;
        }
        String DirecName = tokens[0];
        switch (tokens[0]) {
            case "mkdir":
                if (tokens.length > 1) {
                    String folderName = tokens[1];
                    String newFolderPath = DirecActual.getAbsolutePath() + File.separator + folderName;
                    File newFolder = new File(newFolderPath);
                    if (newFolder.mkdir()) {
                       jTextArea1.append("\nCarpeta creada: " + newFolder.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError al crear la carpeta.\n");
            }
        } else {
            jTextArea1.append("\nError: Nombre de carpeta no proporcionado.\n");
        }
        break;

            case "mfile":
                  if (tokens.length > 1) {
                 String fileName = tokens[1];
                 String newFilePath = DirecActual.getAbsolutePath() + File.separator + fileName;
                 File newFile = new File(newFilePath);
                 try {
                     if (newFile.createNewFile()) {
                     jTextArea1.append("\nArchivo creado: " + newFile.getAbsolutePath() + "\n");
                 } else {
                     jTextArea1.append("\nEl archivo ya existe o ha ocurrido un error.\n");
                 }
             } catch (IOException e) {
                 jTextArea1.append("\nError al crear el archivo.\n");
             }
          } else {
              jTextArea1.append("\nError: Nombre de archivo no proporcionado.\n");
          }
        break;

            case "rm":
                 if (tokens.length > 1) {
                DirecName = tokens[1];

                String rutaCarpetaAEliminar = DirecActual.getAbsolutePath() + File.separator + DirecName;
                File carpetaAEliminar = new File(rutaCarpetaAEliminar);

                if (carpetaAEliminar.delete()) {
                    jTextArea1.append("\nCarpeta eliminada: " + carpetaAEliminar.getAbsolutePath() + "\n");
                } else {
                    jTextArea1.append("\nError al eliminar la carpeta\n");
                }
                 }
                break;

            case "cd":
                DirecName = tokens[1];

                File carpetaACambiar = new File(DirecName);
                if (carpetaACambiar.isDirectory()) {
                    System.setProperty("user.dir", carpetaACambiar.getAbsolutePath());
                    jTextArea1.append("\nCarpeta actual: " + carpetaACambiar.getAbsolutePath() + "\n");
                } else {
                    jTextArea1.append("\nError: " + DirecName + " no es una carpeta\n");
                }
                break;
            case "...":
                File carpetaAnterior = new File(System.getProperty("user.dir")).getParentFile();
                System.setProperty("user.dir", carpetaAnterior.getAbsolutePath());
                jTextArea1.append("\nCarpeta actual: " + carpetaAnterior.getAbsolutePath() + "\n");
                break;
            case "dir":
                File[] archivos = DirecActual.listFiles();
                Arrays.sort(archivos);

                String formatoFecha = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);

                String tabla = String.format("%-50s%-20s\n", "Nombre", "Fecha de creación");
                tabla += "------------------------------------------------------------------\n";

                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        String fecha = sdf.format(new Date(archivo.lastModified()));
                        tabla += String.format("%-50s%-20s\n", archivo.getName(), fecha);
                    }
                }
                jTextArea1.setText(tabla);

                break;
                 case "date":
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                jTextArea1.append("\nFecha actual: " + dateFormat.format(date) + "\n");
                break;
            case "time":
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                Date time = new Date();
                jTextArea1.append("\nHora actual: " + timeFormat.format(time) + "\n");
                break;
            default:
                jTextArea1.append("\nError: comando desconocido\n");
                break;
         case "wr":
   try {
        if (tokens.length > 1) {
            String nombreArchivo = tokens[1].trim();  
            if (!nombreArchivo.isEmpty()) { 
                int startIndex = command.indexOf(nombreArchivo) + nombreArchivo.length();
                String contenido = command.substring(startIndex).trim();

                if (!contenido.isEmpty()) { 
                    FileWriter escribir = new FileWriter(nombreArchivo);
                    escribir.write(contenido);
                    escribir.close();

                    jTextArea1.append("Texto escrito en el archivo.\n");
                } else {
                    jTextArea1.append("Texto vacio, no se escribio dato.\n");
                }
            } else {
                jTextArea1.append("Nombre de archivo invalido.\n");
            }
        } else {
            jTextArea1.append("Nombre de archivo faltante.\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    break;
case "rd":
    try {
        if (tokens.length > 1) {
            String fileName = tokens[1]; 

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedlector = new BufferedReader(fileReader);

            String line;
            StringBuilder fileContent = new StringBuilder("Contenido del archivo:\n");
            while ((line = bufferedlector.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            bufferedlector.close();

            jTextArea1.append(fileContent.toString());
        } else {
            jTextArea1.append("Nombre de archivo faltante.\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    break;

        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CMD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CMD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
