/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import koneksi.koneksi;

/**
 *
 * @author ITAdmin
 */
public class InventarisKeluar extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    public String idinvmsk, kdbrg, nmbrg, ktgbrg, mrk, uk, kdlok, nmlok;
    private DefaultTableModel tabmode;
    /**
     * Creates new form InventarisKeluar
     */
    public InventarisKeluar() {
        initComponents();
        String KD = UserID.getUserLogin();
        iduser.setText(KD);        
        kosong();
        aktif();
        autonumber();
        nama();
        datatable();
        
        txtinvmsk.setEditable(false);
        txtnm.setEditable(false);
        txtkd.setEditable(false);
        txtktg.setEditable(false);
        txtmrk.setEditable(false);
        txtuk.setEditable(false);
        txtkdlok.setEditable(false);
        txtnmlok.setEditable(false);
    }
    
     protected void nama() {
        try {
            String sql = "SELECT * FROM mst_user WHERE id_user='" + iduser.getText() + "'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                nmuser.setText(hasil.getString("nama"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil " + e);
        }
    }

    protected void aktif() {
        txtinvmsk.requestFocus();
        jtgl.setEditor(new JSpinner.DateEditor(jtgl, "yyyy/MM/dd"));
//        Object[] baris = {"KD Barang", "Nama", "Harga Beli", "Harga Jual", "Qty", "Total"};
//        tabmode = new DefaultTableModel(null, baris);
//        tableinvmsk.setModel(tabmode);
    }

    protected void kosong() {
        txtinvmsk.setText("");
        txtkd.setText("");
        txtnm.setText("");
        txtktg.setText("");
        txtmrk.setText("");
        txtuk.setText("");        
        txtkdlok.setText("");
        txtnmlok.setText("");
        txtjml.setText("");
        txtket.setText("");
    }

    protected void autonumber() {
        try {
            String sql = "SELECT kd_inventaris_keluar FROM trx_inventaris_keluar ORDER BY kd_inventaris_keluar DESC LIMIT 1";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            txtidinv.setText("OUT0001");
            while (hasil.next()) {
                System.out.println(hasil.getString("kd_inventaris_keluar").substring(3));
                String id_inventori = hasil.getString("kd_inventaris_keluar").substring(3);
                int AN = Integer.parseInt(id_inventori) + 1;
                String Nol = "";

                if (AN < 10) {
                    Nol = "000";
                } else if (AN < 100) {
                    Nol = "00";
                } else if (AN < 1000) {
                    Nol = "0";
                } else if (AN < 10000) {
                    Nol = "";
                }

                txtidinv.setText("OUT" + Nol + AN);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto number gagal " + e);
        }
    }
    
    public void invMasukTerpilih() {
        PopupInventoriMasuk pp = new PopupInventoriMasuk();
        pp.invmsk = this;
        txtinvmsk.setText(idinvmsk);
        txtkd.setText(kdbrg);
        txtnm.setText(nmbrg);
        txtktg.setText(ktgbrg);
        txtmrk.setText(mrk);
        txtuk.setText(uk);
        txtkdlok.setText(kdlok);
        txtnmlok.setText(nmlok);
    }
    
    protected void datatable(){
        Object[] Baris = {"ID Inventaris Keluar", "ID Inventaris Masuk", "Jumlah","Tanggal Keluar","Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = txtcari.getText();            
        try{
            String sql = "SELECT * FROM trx_inventaris_keluar WHERE kd_inventaris_keluar like '%"+cariitem+"%' order by kd_inventaris_keluar asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                });
            }
            tableinvklr.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal di panggil"+e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtidinv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtktg = new javax.swing.JTextField();
        txtnm = new javax.swing.JTextField();
        txtkd = new javax.swing.JTextField();
        txtinvmsk = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtkdlok = new javax.swing.JTextField();
        txtjml = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        bcariinv = new javax.swing.JButton();
        txtmrk = new javax.swing.JTextField();
        txtuk = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtnmlok = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtket = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableinvklr = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        bkeluar = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        iduser = new javax.swing.JLabel();
        nmuser = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("INVENTARIS KELUAR");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("ID User");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("ID Inventaris Keluar");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Nama User");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Tanggal Keluar");

        jtgl.setModel(new javax.swing.SpinnerDateModel());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Kode Inventaris");

        jLabel3.setText("kode Barang");

        jLabel5.setText("Nama Barang");

        jLabel7.setText("Kategori Barang");

        txtinvmsk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinvmskActionPerformed(evt);
            }
        });

        jLabel12.setText("Kode Lokasi");

        jLabel13.setText("Nama Lokasi");

        bcariinv.setBackground(new java.awt.Color(204, 204, 255));
        bcariinv.setText("Cari");
        bcariinv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariinvActionPerformed(evt);
            }
        });

        jLabel15.setText("Merek");

        jLabel16.setText("Ukuran");

        jLabel17.setText("Jumlah");

        jLabel18.setText("Keterangan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(64, 64, 64))
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(61, 61, 61)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtinvmsk, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bcariinv, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtjml, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addComponent(txtkdlok, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtktg, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnm, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtkd, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnmlok, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtuk, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(86, 86, 86)
                                .addComponent(txtmrk)))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtket, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtinvmsk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bcariinv, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtmrk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtktg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtuk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkdlok, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(txtnmlok, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjml, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtket, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        tableinvklr.setModel(new javax.swing.table.DefaultTableModel(
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
        tableinvklr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableinvklrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableinvklr);

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel14.setText("List Data Inventaris Keluar :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        bkeluar.setBackground(new java.awt.Color(255, 51, 51));
        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        bbatal.setBackground(new java.awt.Color(255, 102, 0));
        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bhapus.setBackground(new java.awt.Color(204, 204, 0));
        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bubah.setBackground(new java.awt.Color(153, 153, 255));
        bubah.setText("Ubah");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bsimpan.setBackground(new java.awt.Color(51, 204, 0));
        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        iduser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        iduser.setText("ID User");

        nmuser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nmuser.setText("Nam User");

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iduser)
                            .addComponent(txtidinv, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nmuser)
                            .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bkeluar))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(iduser)
                    .addComponent(nmuser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidinv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtinvmskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinvmskActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtinvmskActionPerformed

    private void tableinvklrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableinvklrMouseClicked
        int bar = tableinvklr.getSelectedRow();
        String id_inv = tabmode.getValueAt(bar, 0).toString();
        String id_inv_msk = tabmode.getValueAt(bar, 1).toString();
        String jml = tabmode.getValueAt(bar, 2).toString();
        String tgl = tabmode.getValueAt(bar, 3).toString();
        String ket = tabmode.getValueAt(bar, 4).toString();
        try{
//            String sql = "SELECT a.kd_inventaris_masuk as 'kd_inventaris_masuk', b.kd_barang as 'kd_barang', b.kategori_barang as kategori_barang, "
//                    + "b.nama_barang as nama_barang, b.merek as merek, b.ukuran as ukuran"
//                    + ", c.kd_lokasi as kd_lokasi, c.nama_lokasi as nama_lokasi FROM trx_inventaris_masuk a"
//                    + " JOIN mst_barang b ON a.kd_barang=b.kd_barang"
//                    + " JOIN mst_lokasi c ON a.kd_lokasi=c.kd_lokasi"
//                    + " WHERE a.kd_inventaris_masuk='%"+id_inv_msk+"%'";
//            String sql = "SELECT a.*, b.*,c.* FROM trx_inventaris_masuk a JOIN mst_barang b ON a.kd_barang=b.kd_barang JOIN mst_lokasi c ON a.kd_lokasi=c.kd_lokasi WHERE a.kd_inventaris_masuk='%"+id_inv_msk+"%'";
            String sql = "SELECT a.*,b.*,c.* FROM trx_inventaris_masuk a, mst_barang b, mst_lokasi c WHERE a.kd_barang=b.kd_barang AND a.kd_lokasi=c.kd_lokasi AND a.kd_inventaris_masuk='"+id_inv_msk+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                txtinvmsk.setText(hasil.getString("kd_inventaris_masuk"));
                txtkd.setText(hasil.getString("kd_barang"));
                txtnm.setText(hasil.getString("nama_barang"));
                txtktg.setText(hasil.getString("kategori_barang"));
                txtmrk.setText(hasil.getString("merek"));
                txtuk.setText(hasil.getString("ukuran"));
                txtkdlok.setText(hasil.getString("kd_lokasi"));
                txtnmlok.setText(hasil.getString("nama_lokasi"));
                txtidinv.setText(id_inv);
                txtinvmsk.setText(id_inv_msk);
                txtjml.setText(jml);
                txtket.setText(ket);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil " + e);
        }
        
//        jtgl.setValue(tgl);
    }//GEN-LAST:event_tableinvklrMouseClicked

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            datatable();
        }
    }//GEN-LAST:event_txtcariKeyPressed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable();
    }//GEN-LAST:event_bcariActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        datatable();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin menghapus data ini?", "konfirm dialog", JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "DELETE FROM trx_inventaris_keluar WHERE kd_inventaris_keluar='"+txtidinv.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
                kosong();
                txtinvmsk.requestFocus();
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal di hapus"+e);
            }
            datatable();
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        String sql = "UPDATE trx_inventaris_keluar SET kd_inventaris_masuk=?,jumlah=?,tanggal_keluar=?,keterangan=? WHERE kd_inventaris_keluar='"+txtidinv.getText()+"'";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fd = sdf.format(jtgl.getValue());
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtinvmsk.getText());
            stat.setString(2, txtjml.getText());
            stat.setString(3, fd);
            stat.setString(4, txtket.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            kosong();
            txtinvmsk.requestFocus();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal di ubah"+e);
        }
        datatable();
    }//GEN-LAST:event_bubahActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "INSERT INTO trx_inventaris_keluar VALUES (?,?,?,?,?,?)";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fd = sdf.format(jtgl.getValue());
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtidinv.getText());
            stat.setString(2, txtinvmsk.getText());
            stat.setString(3, txtjml.getText());
            stat.setString(4, fd);
            stat.setString(5, txtket.getText());
            stat.setString(6, iduser.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data berhasil di simpan");
            kosong();
            txtinvmsk.requestFocus();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal di simapan"+e);
        }
        datatable();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bcariinvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariinvActionPerformed
        PopupInventoriMasuk pp = new PopupInventoriMasuk();
        pp.invmsk = this;
        pp.setVisible(true);
        pp.setResizable(false);
    }//GEN-LAST:event_bcariinvActionPerformed

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
            java.util.logging.Logger.getLogger(InventarisKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarisKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarisKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarisKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarisKeluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bcariinv;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JLabel iduser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JLabel nmuser;
    private javax.swing.JTable tableinvklr;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtidinv;
    private javax.swing.JTextField txtinvmsk;
    private javax.swing.JTextField txtjml;
    private javax.swing.JTextField txtkd;
    private javax.swing.JTextField txtkdlok;
    private javax.swing.JTextField txtket;
    private javax.swing.JTextField txtktg;
    private javax.swing.JTextField txtmrk;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txtnmlok;
    private javax.swing.JTextField txtuk;
    // End of variables declaration//GEN-END:variables
}
