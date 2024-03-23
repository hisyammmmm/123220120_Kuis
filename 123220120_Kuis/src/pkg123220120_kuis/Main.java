/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg123220120_kuis;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author HP
 */


class login extends JFrame implements ActionListener {
    JButton btnLogin, btnExit;
    JTextField tfUsername;
    JLabel lbUsername, lbPassword;
    JPasswordField pw;
    
    login(){
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");
        
        tfUsername = new JTextField();
        
        pw = new JPasswordField();
        
        lbUsername = new JLabel("Username:  ");
        lbPassword = new JLabel("Password:  ");
        
        setLayout(new GridLayout(3,2));
        add(lbUsername);
        add(tfUsername);
        add(lbPassword);
        add(pw);
        add(btnLogin);
        btnLogin.addActionListener(this);
        add(btnExit);
        btnExit.addActionListener(this);
        setSize(350,100);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnLogin){
//        if ("123220120".equals(tfUsername) && "111".equals(String.valueOf(pw.getPassword()))){
            this.dispose();
            new guiLogin();
//        } else {
//            JOptionPane.showMessageDialog(null, "Username atau Password salah");
//            this.dispose();
        } else if (e.getSource() == btnExit){
            this.dispose();
        }
    }
}



class guiLogin extends JFrame implements ActionListener{
    JButton btnSubmit, btnKeluar;
    JTextField tfNama, tfNim, tfTugas, tfKuis, tfTipeKelas;
    JLabel lbNama, lbNim, lbMatkul, lbKelas, lbTugas, lbKuis, lb;
    JRadioButton rbTeori, rbPrak;
    
    guiLogin(){
        setTitle("Input Nilai");
        btnSubmit = new JButton("Submit");
        btnKeluar = new JButton("Keluar");
        
        tfNama = new JTextField();
        tfNim = new JTextField(30);
        tfTugas = new JTextField(30);
        tfKuis = new JTextField(30);
        tfTipeKelas = new JTextField(30);
        
        lbNama = new JLabel("NAMA: ");
        lbNim = new JLabel("NIM:    ");
        lbKelas = new JLabel("KELAS:                   ");
        lbTugas = new JLabel("Nilai Tugas:  ");
        lbKuis = new JLabel("Nilai Kuis:   ");
        lb = new JLabel("-");
        
        rbTeori = new JRadioButton("Kelas Teori");
        rbPrak = new JRadioButton("Kelas Praktikum");
        
        setLayout(new GridLayout(7,2));
        add(lbNama);
        add(tfNama);
        add(lbNim);
        add(tfNim);
        add(lbKelas);
        add(rbTeori);
        rbTeori.addActionListener(this);
        add(lb);
        add(rbPrak);
        rbPrak.addActionListener(this);
        add(lbTugas);
        add(tfTugas);
        add(lbKuis);
        add(tfKuis);
        add(btnSubmit);
        btnSubmit.addActionListener(this);
        add(btnKeluar);
        btnKeluar.addActionListener(this);
        
        setSize(500,300);
        setVisible(true);
        setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rbTeori){
            tfTipeKelas.setText("Kelas Teori");
        } else if (e. getSource() == rbPrak){
            tfTipeKelas.setText("Kelas Praktikum");
        }
        
        if(e.getSource() == btnSubmit){
            this.dispose();
            new guiTranskrip(tfNama.getText(), tfNim.getText(), tfTipeKelas.getText(), tfTugas.getText(), tfKuis.getText());
    } else if (e.getSource() == btnKeluar){
        this.dispose();
    }
    
    
    
}
}

class guiTranskrip extends JFrame implements ActionListener {
    JTextField tfNama, tfNim, tfTugas, tfKuis, tfKelas, tfTipeKelas, tfLulus, tfNilai;
    JLabel lbNama, lbNim, lbKelas, lbTugas, lbKuis, lbLulus, lbNilai, lb;
    JButton btnKembali, btnKeluar;
    
    
    
    guiTranskrip(String na, String ni, String ti, String tu, String ku){
        
        setTitle("Hasil Transkrip");
        lbNama = new JLabel("NAMA: ");
        lbNim = new JLabel("NIM:    ");
        lbKelas = new JLabel("KELAS:                   ");
        lbTugas = new JLabel("Nilai Tugas:  ");
        lbKuis = new JLabel("Nilai Kuis:   ");
        lbNilai = new JLabel("NILAI:    ");
        lbLulus = new JLabel();
        lb = new JLabel("-");
        
        tfNama = new JTextField();
        tfNim = new JTextField(30);
        tfTugas = new JTextField(30);
        tfKuis = new JTextField(30);
        tfTipeKelas = new JTextField(30);
        tfNilai = new JTextField();
        
        btnKembali = new JButton("Kembali");
        btnKeluar = new JButton("Keluar");
        
        double hasilAkhirT = (Integer.parseInt(tu)*0.7)+(Integer.parseInt(ku)*0.3);
        double hasilAkhirP = (Integer.parseInt(tu)*0.3)+(Integer.parseInt(ku)*0.7);
        
        setLayout(new GridLayout(8,2));
        add(lbNama);
        add(tfNama);
        tfNama.setText(na);
        add(lbNim);
        add(tfNim);
        tfNim.setText(ni);
        add(lbKelas);
        add(tfTipeKelas);
        tfTipeKelas.setText(ti);
        add(lbTugas);
        add(tfTugas);
        tfTugas.setText(tu);
        add(lbKuis);
        add(tfKuis);
        tfKuis.setText(ku);
        add(lbNilai);
        add(lbNilai);
        add(tfNilai);
        if ("Kelas Teori".equals(tfTipeKelas)){
        tfNilai.setText(String.valueOf(hasilAkhirT));            
        } else {
        tfNilai.setText(String.valueOf(hasilAkhirP));
        }

        add(lb);
        add(lbLulus);
        if (hasilAkhirT >= 85){
            lbLulus.setText("LULUS");
        } else {
            lbLulus.setText("COBA LAGI");
        }
        add(btnKembali);
        btnKembali.addActionListener(this);
        add(btnKeluar);
        btnKeluar.addActionListener(this);
        
        
        
        setSize(350,200);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnKembali){
        this.dispose();
        new guiLogin();
    } else if (e.getSource() == btnKeluar){
        this.dispose();
    }
    }
}
    
    
public class Main {
    public static void main(String[] args) {
        new login();
    }
    
}
