/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tugas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author krisna
 */
public class Kamar extends javax.swing.JFrame {

    /**
     * Creates new form Kamar_RS
     */
    
    private Connection con;
    private Statement stat;
    private ResultSet res;
    private String t,kelas;
    public int pilih=0,ik=0,harga=0;
    int pilihan_kelas_1,pilihan_kelas_2,pilihan_kelas_3;
    
    public Kamar() {
        initComponents();
        koneksi();
        kosongkan();
        tabel();
        baru();
        pilihnya.setVisible(false);
        pilihnya1.setVisible(false);
        pilihnya2.setVisible(false);
        harga_ro.setVisible(false);
        jLabel3.setVisible(false);
        id_kamarTF.setVisible(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        try {
            res = stat.executeQuery("select count(no_kamar) from room where kelas='Kelas 1'");
            while (res.next()) {
                 pilihan_kelas_1=Integer.parseInt(res.getString("count(no_kamar)"));
            }
        } catch (Exception e) { 
        JOptionPane.showMessageDialog(rootPane, e); 
        }
        try {
            res = stat.executeQuery("select count(no_kamar) from room where kelas='Kelas 2'");
            while (res.next()) {
                 pilihan_kelas_2=Integer.parseInt(res.getString("count(no_kamar)"));
            }
        } catch (Exception e) { 
        JOptionPane.showMessageDialog(rootPane, e); 
        }
        try {
            res = stat.executeQuery("select count(no_kamar) from room where kelas='Kelas 3'");
            while (res.next()) {
                 pilihan_kelas_3=Integer.parseInt(res.getString("count(no_kamar)"));
            }
        } catch (Exception e) { 
        JOptionPane.showMessageDialog(rootPane, e); 
        }
        
        if(pilihan_kelas_1==4)
        {
            kelas1RB.setVisible(false);
        }
        else if (pilihan_kelas_2==4)
        {
            kelas2RB.setVisible(false);
        }
        else if (pilihan_kelas_3==4)
        {
            kelas3RB.setVisible(false);
        }
        }
        private void koneksi(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/hospital","root", "system512");
        stat=con.createStatement();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
        }
        }
        private void kosongkan()
        {
        baru();
        no_kamarTF.setText("");
        kelas2RB.setSelected(false);
        kelas1RB.setSelected(false);
        kelas3RB.setSelected(false);
        }
        private void tabel(){ 
        DefaultTableModel t= new DefaultTableModel();
 t.addColumn("ID"); 
 t.addColumn("No Kamar");
 t.addColumn("Kelas"); 
 t.addColumn("Status"); 
  t.addColumn("Harga");
 Table.setModel(t); try{ res=stat.executeQuery("select * from room order by kelas asc"); 
 while (res.next()) { 
 t.addRow(new Object[]{ res.getString("id_room"),
  res.getString("no_kamar"), 
  res.getString("kelas"), 
  res.getString("status"),
  res.getString("harga_r")
 }); 
 }
 }catch (Exception e) { 
 JOptionPane.showMessageDialog(rootPane, e); 
 }
        }
        private void baru(){
        int maxID,last = 0;
       try {
            res = stat.executeQuery("select max(id_room) from room");
            while (res.next()) {
                 maxID = res.getInt(1);
                 last = maxID+1;
                 id_kamarTF.setText(""+last);
            }
} 
catch (Exception e) { 
JOptionPane.showMessageDialog(rootPane, e); 
}
        
        }
        
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        kelas3RB = new javax.swing.JRadioButton();
        kelas2RB = new javax.swing.JRadioButton();
        kelas1RB = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        no_kamarTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ch = new javax.swing.JButton();
        pilihnya = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ava = new javax.swing.JComboBox<>();
        id_kamarTF = new javax.swing.JLabel();
        pilihnya1 = new javax.swing.JLabel();
        pilihnya2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        harga_ro = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("KAMAR - RUMAH SAKIT");

        jLabel3.setText("Id Kamar");

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        kelas3RB.setText("Kelas 3");
        kelas3RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas3RBActionPerformed(evt);
            }
        });

        kelas2RB.setText("Kelas 2");
        kelas2RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas2RBActionPerformed(evt);
            }
        });

        kelas1RB.setText("Kelas 1");
        kelas1RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas1RBActionPerformed(evt);
            }
        });

        jLabel2.setText("Kamar");

        jLabel5.setText("No Kamar");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jButton2.setText("Change Status");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Untitled-2.jpg"))); // NOI18N

        ch.setText("Check");
        ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActionPerformed(evt);
            }
        });

        pilihnya.setText("Ini");

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Status");

        ava.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "With Patient" }));
        ava.setSelectedIndex(-1);
        ava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaActionPerformed(evt);
            }
        });

        id_kamarTF.setText(" ");

        pilihnya1.setText("Ini");

        pilihnya2.setText("Ini");

        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        harga_ro.setText("Ini");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(no_kamarTF)
                                            .addComponent(ava, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(111, 111, 111)
                                                .addComponent(ch))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(kelas1RB)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(kelas2RB)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(kelas3RB))
                                                    .addComponent(id_kamarTF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(pilihnya1)
                                                .addGap(24, 24, 24)
                                                .addComponent(pilihnya2))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(pilihnya)
                                                    .addGap(126, 126, 126))
                                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(harga_ro)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(harga_ro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id_kamarTF)
                    .addComponent(pilihnya1)
                    .addComponent(pilihnya2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kelas1RB)
                    .addComponent(kelas2RB)
                    .addComponent(kelas3RB)
                    .addComponent(pilihnya))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(no_kamarTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(ch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Action");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Home");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kelas1RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas1RBActionPerformed
        // TODO add your handling code here:
        pilih=1;
        kelas="Kelas 1";
        harga=500000;
        kelas2RB.setSelected(false);
        kelas3RB.setSelected(false);
        
        pilihnya.setText(""+kelas); 
        harga_ro.setText(""+harga); 
        
    }//GEN-LAST:event_kelas1RBActionPerformed

    private void kelas2RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas2RBActionPerformed
        // TODO add your handling code here:
        pilih=2;
        kelas="Kelas 2";
        harga=350000;
        kelas1RB.setSelected(false);
        kelas3RB.setSelected(false);
        
        pilihnya.setText(""+kelas); 
        harga_ro.setText(""+harga); 
    }//GEN-LAST:event_kelas2RBActionPerformed

    private void kelas3RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas3RBActionPerformed
        // TODO add your handling code here:
        pilih=3;
        kelas="Kelas 3";
        harga=150000;
        kelas2RB.setSelected(false);
        kelas1RB.setSelected(false);
        
        pilihnya.setText(""+kelas); 
        harga_ro.setText(""+harga); 
    }//GEN-LAST:event_kelas3RBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
        stat.executeUpdate("insert into room values ("
            + "'" + id_kamarTF.getText()+"',"
            + "'" + no_kamarTF.getText()+"',"
            + "'" + pilihnya.getText()+"'," 
            + "'" + ava.getSelectedItem() + "')");
    kosongkan();
    JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);        
    }
      tabel();  
      baru();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActionPerformed
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("ID"); 
    t.addColumn("No Kamar");
    t.addColumn("Kelas"); 
    Table.setModel(t); try{ res=stat.executeQuery("select * from room where status='" + ava.getSelectedItem() + "'"); 
    while (res.next()) { 
    t.addRow(new Object[]{ 
    res.getString("id_room"),
    res.getString("no_kamar"), 
    res.getString("kelas")
    }); 
    }
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(rootPane, e); 
    }  

    }//GEN-LAST:event_chActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int i = Table.getSelectedRow();
    if(i==-1){
    return;
    }
    String code = (String)Table.getValueAt(i,0);
    String code1 = (String)Table.getValueAt(i,1);
    String code2 = (String)Table.getValueAt(i,2);
    String code3 = (String)Table.getValueAt(i,3);
    String code4 = (String)Table.getValueAt(i,4);
    id_kamarTF.setText(code);
    no_kamarTF.setText(code1);
    pilihnya.setText(code2);
    ava.setSelectedItem(code3);
    harga_ro.setText(code4);
    }//GEN-LAST:event_TableMouseClicked

    private void avaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avaActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
    new Rumahsakit().setVisible(true);
    dispose();  
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try{
    String sql="update room set id_room=?,no_kamar=?,kelas=?,status=? where id_room='"+id_kamarTF.getText()+"'";
    PreparedStatement st=con.prepareStatement(sql);
    try
    {
    st.setString(1,id_kamarTF.getText());
    st.setString(2,no_kamarTF.getText());
    st.setString(3,pilihnya.getText());
    st.setString(4,(String) ava.getSelectedItem());
    st.executeUpdate();
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(rootPane, e); }
    }       catch (SQLException ex) {
            Logger.getLogger(Kamar.class.getName()).log(Level.SEVERE, null, ex);
        }
    kosongkan();
    tabel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    kosongkan();
    tabel();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try{
    String sql="DELETE FROM room where id_room='"+id_kamarTF.getText()+"'";
    PreparedStatement st=con.prepareStatement(sql);
    try
    {
    st.executeUpdate();
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(rootPane, e); }
    }catch (SQLException ex) {
            Logger.getLogger(Kamar.class.getName()).log(Level.SEVERE, null, ex);
    }
    kosongkan();
    tabel();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kamar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JComboBox<String> ava;
    private javax.swing.JButton ch;
    private javax.swing.JLabel harga_ro;
    private javax.swing.JLabel id_kamarTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton kelas1RB;
    private javax.swing.JRadioButton kelas2RB;
    private javax.swing.JRadioButton kelas3RB;
    private javax.swing.JTextField no_kamarTF;
    private javax.swing.JLabel pilihnya;
    private javax.swing.JLabel pilihnya1;
    private javax.swing.JLabel pilihnya2;
    // End of variables declaration//GEN-END:variables
}
