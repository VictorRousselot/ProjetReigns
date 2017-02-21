/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreigns;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author etudiant
 */
public class FenetreJeu extends JFrame {

    private JLabel jl_periode, jl_moment, jl_question, jl_choix1, jl_choix2, jl_profil;
    private JButton bt_choix1, bt_choix2;
    private Player player;
    private JProgressBar maBarre;
    private Carte selec;
    public PileCartes cartes;

    public FenetreJeu(PileCartes pile) throws PileVideException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        cartes = pile;
        setTitle("Quel animal vas-tu ramener du refuge ?");

        selec = cartes.sommet();

        JPanel mainjp = new JPanel(new BorderLayout());
        setContentPane(mainjp);

        MenuBar mb = new MenuBar();
        Menu menu = new Menu("Fichier");
        MenuItem refresh = new MenuItem("Relancer");
        menu.add(refresh);
        MenuItem quit = new MenuItem("Quitter");
        menu.add(quit);
        MenuItem closeMusic = new MenuItem("Couper le son");
        menu.add(closeMusic);

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Main.refreshFenetre();
                } catch (PileVideException ex) {
                    Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                player.close();
            }
        });
        
        closeMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.close();
            }
        });

        mb.add(menu);
        this.setMenuBar(mb);

        JPanel jp_haut = new JPanel(new GridLayout(1, 2));
        jp_haut.setPreferredSize(new Dimension(1500, 120));
        jp_haut.setBorder(BorderFactory.createLineBorder(Color.black, 3));

        JPanel jp_periode = new JPanel();

        jl_periode = new JLabel();
        jp_periode.add(jl_periode, BorderLayout.CENTER);
        jp_periode.setPreferredSize(new Dimension(750, 120));

        JPanel jp_moment = new JPanel(new BorderLayout());
        jp_moment.setBackground(new Color(77, 182, 227));

        jl_moment = new JLabel();
        jl_moment.setFont(new Font("Arial", Font.BOLD, 20));

        jl_moment.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        jp_moment.add(jl_moment, BorderLayout.CENTER);

        JPanel jp_choix1 = new JPanel(new BorderLayout());
        jp_choix1.setPreferredSize(new Dimension(600, 300));
        jp_choix1.setBackground(Color.GRAY);

        bt_choix1 = new JButton();
        bt_choix1.setFont(new Font("Arial", Font.BOLD, 20));
        jp_choix1.add(bt_choix1);

        bt_choix1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionChoix(0);
            }
        });

        JPanel jp_img = new JPanel(new BorderLayout());
        jp_img.setPreferredSize(new Dimension(300, 280));

       jl_profil = new JLabel();
       jl_profil.setHorizontalAlignment(JLabel.CENTER);
       jp_img.add(jl_profil, BorderLayout.CENTER);
       
       
       JPanel jp_barre = new JPanel(new BorderLayout());
       maBarre = new JProgressBar(0, 200);
       //maBarre.setVisible(false);
       jp_barre.add(maBarre, BorderLayout.CENTER);
       jp_barre.setPreferredSize(new Dimension(300, 20));
       
       JPanel jp_centre = new JPanel(new BorderLayout());
       jp_centre.add(jp_img, BorderLayout.CENTER);
       jp_centre.add(jp_barre, BorderLayout.PAGE_END);

        JPanel jp_choix2 = new JPanel(new BorderLayout());
        jp_choix2.setBackground(Color.GRAY);
        jp_choix2.setPreferredSize(new Dimension(600, 300));

        bt_choix2 = new JButton();
        bt_choix2.setFont(new Font("Arial", Font.BOLD, 20));
        jp_choix2.add(bt_choix2);

        bt_choix2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionChoix(1);
            }
        });

        JPanel jp_question = new JPanel(new BorderLayout());
        jp_question.setBackground(Color.WHITE);
        jp_question.setPreferredSize(new Dimension(1500, 100));

        jl_question = new JLabel();
        jl_question.setFont(new Font("Arial", Font.BOLD, 20));

        jl_question.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        jp_question.add(jl_question, BorderLayout.CENTER);

        jp_haut.add(jp_periode);
        jp_haut.add(jp_moment);

        mainjp.add(jp_haut, BorderLayout.PAGE_START);
        mainjp.add(jp_choix1, BorderLayout.LINE_START);
        mainjp.add(jp_centre, BorderLayout.CENTER);
        mainjp.add(jp_choix2, BorderLayout.LINE_END);
        mainjp.add(jp_question, BorderLayout.PAGE_END);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        
        String mp3 = "music.mp3";
        File music = new File(mp3);
        FileInputStream fis = new FileInputStream(music);
        BufferedInputStream bis = new BufferedInputStream(fis);
        
        this.setVisible(true);
        changeCartes(selec);
        
        try {
            player = new Player(bis);
            player.play();
        }
        catch(JavaLayerException e){
            
        }
    }

    public void changeCartes(Carte maCarte) throws PileVideException {
        bt_choix1.setText(maCarte.getChoix1());

        String ch = maCarte.getChoix2();
        int i =0;
        /*while((ch.charAt(i) != ' ')||(i<25)||(i>30)){
            i++;
        } 
        if(ch.charAt(i) == ' '){
            ch = ch.substring(0, i)+"<br />"+ch.substring(i);
        }*/
        bt_choix2.setText(maCarte.getChoix2());
        jl_question.setText(maCarte.getQuestion());
        jl_moment.setText(maCarte.getActivite());
        jl_periode.setIcon(maCarte.getPeriode().getImage());

        if (maCarte.getPretendants().size() > 1) {
            jl_profil.setIcon(new ImageIcon("images/default.jpeg"));
            maBarre.setVisible(false);
        } else {
            Set<Pretendant> pr = maCarte.getPretendants().keySet();
            for (Pretendant p : pr) {
                Image scaledImage = p.getImg().getImage().getScaledInstance(300, 280, Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(scaledImage);
                jl_profil.setIcon(img);
                maBarre.setValue(p.getAffinite()+100);
                maBarre.setVisible(true);
            }
        }
    }

    public void actionChoix(int n) {
        Set<Pretendant> pretendants = selec.getPretendants().keySet();
        for (Pretendant p : pretendants) {
            int[] bonus = selec.getPretendants().get(p);
            p.setAffinite(p.getAffinite() + bonus[n]);
            try {
                selec.actionLancee(cartes);
                p.evolutionRelation(cartes, selec.getPeriode());
                if (cartes.peutDepiler()) {
                    cartes.depiler();
                    changeCartes(cartes.sommet());
                } else {
                    JOptionPane jop = new JOptionPane();
                    int option = jop.showConfirmDialog(null, "Terminé, plus de cartes. Recommencer ?", null, JOptionPane.INFORMATION_MESSAGE);
                    
                    if(option == JOptionPane.OK_OPTION){
                        Main.refreshFenetre();
                    }
                    else {
                        dispose();
                        player.close();
                    }
                }
            } catch (PileVideException ex) {
                Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
