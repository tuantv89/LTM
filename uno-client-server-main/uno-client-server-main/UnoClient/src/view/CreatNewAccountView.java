package view;

import controller.LoginController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.UserModel;

public class CreatNewAccountView extends javax.swing.JFrame {
    
    public CreatNewAccountView() {        
        try{
            BufferedImage myImage = ImageIO.read(new File("D:\\codeLtm\\UnoClient\\src\\images\\backgroundLogin.jpg"));
            setContentPane(new ImagePanel(myImage));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        initComponents();
        setLocationRelativeTo(null);
        
        txtPass.setEchoChar((char)0);
        txtRetype.setEchoChar((char)0);
        labelTitle.requestFocusInWindow();
        setPass();
    }
    
    
    
    class ImagePanel extends JComponent {
        private Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPasswordField1 = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioRules = new javax.swing.JRadioButton();
        labelTitle = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtRetype = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtUsername.setFont(new java.awt.Font("#9Slide03 Jura", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(153, 153, 153));
        txtUsername.setText("  Tên đăng nhập");
        txtUsername.setToolTipText("Username");
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Breul Grotesk A Light", 0, 18)); // NOI18N
        btnLogin.setText("Đăng kí");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoLogin.png"))); // NOI18N

        jRadioRules.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioRules.setSelected(true);
        jRadioRules.setText("Tôi đồng ý với các điều khoản của UNO game.");

        labelTitle.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        labelTitle.setText("TẠO TÀI KHOẢN UNO");

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPass.setForeground(new java.awt.Color(153, 153, 153));
        txtPass.setText("  Mật khẩu");
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        txtPass.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtPassInputMethodTextChanged(evt);
            }
        });

        txtRetype.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRetype.setForeground(new java.awt.Color(153, 153, 153));
        txtRetype.setText("  Nhập lại mật khẩu");
        txtRetype.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRetypeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRetypeFocusLost(evt);
            }
        });
        txtRetype.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtRetypeInputMethodTextChanged(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hidePass.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hidePass.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioRules, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRetype, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRetype, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jRadioRules)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsername.getText();
        String pass = txtPass.getText();
        String retypePass = txtPass.getText();
        
        if (username.equals("  Tên đăng nhập"))
            username = "";
        if (pass.equals("  Mật khẩu"))
            pass = "";
        if (retypePass.equals("  Nhập lại mật khẩu"))
            retypePass = "";
        
        if (username.equals("") || pass.equals("") ||  retypePass.equals(""))
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ các trường.");
        else if (username.contains(" ") || pass.contains(" "))
            JOptionPane.showMessageDialog(rootPane, "Tên tài khoản và mật khẩu không chứa khoảng trống.");
        else if (!pass.equals(retypePass))
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu không khớp.");
        else if (!jRadioRules.isSelected())
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chấp nhận điều khoản.");
        else {
            UserModel user = new UserModel(username, pass);   
            LoginController control = new LoginController();
            
            if (control.registerUser(user)) {
                JOptionPane.showMessageDialog(rootPane, "Đăng kí thành công! Bạn sẽ được chuyển "
                        + "đến giao diện đăng nhập");
                
                try {
                    Thread.sleep(2000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                
                LoginView loginView = new LoginView();
                loginView.setVisible(true);
                loginView.getTxtUsername().setText(username);
                this.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(rootPane, "Đăng kí không thành công do tên đăng nhập không "
                        + "hợp lệ hoặc lỗi hệ thống!");
            
            control.close();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        if (txtUsername.getText().equals("  Tên đăng nhập")) {
            txtUsername.setText("");
            txtUsername.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        if (txtUsername.getText().equals("")) {
            txtUsername.setText("  Tên đăng nhập");
            txtUsername.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        ImageIcon show = new ImageIcon(getClass().getResource("/images/showPass.png"));
        ImageIcon hide = new ImageIcon(getClass().getResource("/images/hidePass.png"));

        if (((ImageIcon)jLabel1.getIcon()).toString().equals(show.toString())) {
            jLabel1.setIcon(hide);
            txtPass.setEchoChar('*');
        }
        else {
            jLabel1.setIcon(show);
            txtPass.setEchoChar((char)0);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        ImageIcon show = new ImageIcon(getClass().getResource("/images/showPass.png"));
        ImageIcon hide = new ImageIcon(getClass().getResource("/images/hidePass.png"));

        if (((ImageIcon)jLabel2.getIcon()).toString().equals(show.toString())) {
            jLabel2.setIcon(hide);
            txtRetype.setEchoChar('*');
        }
        else {
            jLabel2.setIcon(show);
            txtRetype.setEchoChar((char)0);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        if (String.valueOf(txtPass.getPassword()).equals("  Mật khẩu")) {
            txtPass.setText("");
            txtPass.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtPassFocusGained

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost
        if (String.valueOf(txtPass.getPassword()).equals("")) {
            txtPass.setText("  Mật khẩu");
            txtPass.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtPassFocusLost

    private void txtRetypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRetypeFocusGained
        if (String.valueOf(txtRetype.getPassword()).equals("  Nhập lại mật khẩu")) {
            txtRetype.setText("");
            txtRetype.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtRetypeFocusGained

    private void txtRetypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRetypeFocusLost
        if (String.valueOf(txtRetype.getPassword()).equals("")) {
            txtRetype.setText("  Nhập lại mật khẩu");
            txtRetype.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtRetypeFocusLost

    private void txtPassInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPassInputMethodTextChanged
        ImageIcon show = new ImageIcon(getClass().getResource("/images/showPass.png"));
        ImageIcon hide = new ImageIcon(getClass().getResource("/images/hidePass.png"));
        
        if (((ImageIcon)jLabel1.getIcon()).toString().equals(show.toString()))
            txtPass.setEchoChar((char)0);
        else
            txtPass.setEchoChar('*');
    }//GEN-LAST:event_txtPassInputMethodTextChanged

    private void txtRetypeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtRetypeInputMethodTextChanged
        ImageIcon show = new ImageIcon(getClass().getResource("/images/showPass.png"));
        ImageIcon hide = new ImageIcon(getClass().getResource("/images/hidePass.png"));
        
        if (((ImageIcon)jLabel1.getIcon()).toString().equals(show.toString()))
            txtPass.setEchoChar((char)0);
        else
            txtPass.setEchoChar('*');
    }//GEN-LAST:event_txtRetypeInputMethodTextChanged

    public void setPassByIcon() {
        ImageIcon show = new ImageIcon(getClass().getResource("/images/showPass.png"));
        ImageIcon hide = new ImageIcon(getClass().getResource("/images/hidePass.png"));
        
        if (((ImageIcon)jLabel1.getIcon()).toString().equals(show.toString()))
            txtPass.setEchoChar((char)0);
        else
            txtPass.setEchoChar('*');
        
        if (((ImageIcon)jLabel2.getIcon()).toString().equals(show.toString()))
            txtRetype.setEchoChar((char)0);
        else
            txtRetype.setEchoChar('*');
    }
    
    public void setPass() {
        txtPass.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setPassByIcon();
            }           
            @Override
            public void removeUpdate(DocumentEvent e) {
                setPassByIcon();
            }
            @Override
            public void changedUpdate(DocumentEvent e) { /* do nothing */ }
        });
        
        txtRetype.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setPassByIcon();
            }           
            @Override
            public void removeUpdate(DocumentEvent e) {
                setPassByIcon();
            }
            @Override
            public void changedUpdate(DocumentEvent e) { /* do nothing */ }
        });
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreatNewAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatNewAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatNewAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatNewAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatNewAccountView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButton jRadioRules;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtRetype;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
