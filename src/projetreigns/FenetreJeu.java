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
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author etudiant
 */
public class FenetreJeu extends JFrame {
    
    
    private JLabel jl_periode, jl_moment, jl_question, jl_choix1, jl_choix2, jl_profil;
    PileCartes cartes;

    
    public FenetreJeu(PileCartes pile) throws PileVideException{
        cartes = pile;
        setTitle("Jeu de chat-ing");
        
        Carte selec = cartes.sommet();
        cartes.depiler();
        
        JPanel mainjp = new JPanel(new BorderLayout());
        setContentPane(mainjp);
        
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("Fichier");
        MenuItem refresh = new MenuItem("Relancer");
        menu.add(refresh);
        MenuItem quit = new MenuItem("Quitter");
        menu.add(quit);
                
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jl_moment.setText("A la maison");
            }
        });
        
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        
        mb.add(menu);
        this.setMenuBar(mb);
   
        JPanel jp_haut = new JPanel(new GridLayout(1, 2));
        jp_haut.setPreferredSize(new Dimension(1000, 100));
        jp_haut.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        
        JPanel jp_periode = new JPanel();
       // jp_periode.setBackground(Color.BLACK);
        
        jl_periode = new JLabel(selec.getPeriode().getImage());
        jp_periode.add(jl_periode, BorderLayout.CENTER);
        jp_periode.setPreferredSize(new Dimension(500, 100));
        
        JPanel jp_moment = new JPanel(new BorderLayout());
        jp_moment.setBackground(Color.cyan);
          
        jl_moment = new JLabel("A la maison");
        jl_moment.setFont(new Font("Serif", Font.BOLD, 15));
        
        jl_moment.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        jp_moment.add(jl_moment, BorderLayout.CENTER);
        
        JPanel jp_choix1 = new JPanel(new BorderLayout());
        jp_choix1.setBackground(Color.GRAY);
        jp_choix1.setPreferredSize(new Dimension(400, 200));
        
        JButton bt_choix1 = new JButton(selec.getChoix1());
        jp_choix1.add(bt_choix1);
        
        bt_choix1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(Pretendant pret : selec.getPretendants()){
                    try {
                        pret.evolutionRelation(cartes);
                    } catch (PileVideException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur : La pile est vide", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        JPanel jp_img = new JPanel(new BorderLayout());
        
        if(selec.getPretendants().size() == 1){
            Pretendant tmp = selec.getPretendants().get(0);
            jl_profil = new JLabel(tmp.getImage());
            jp_img.add(jl_profil, BorderLayout.CENTER);
        }
        jp_img.setPreferredSize(new Dimension(200, 200));
        
        JPanel jp_choix2 = new JPanel(new BorderLayout());
        jp_choix2.setBackground(Color.GRAY);
        jp_choix2.setPreferredSize(new Dimension(400, 200));
        
        JButton bt_choix2 = new JButton(selec.getChoix2());
        jp_choix2.add(bt_choix2);
        
        JPanel jp_question = new JPanel(new BorderLayout());
        jp_question.setBackground(Color.WHITE);
        jp_question.setPreferredSize(new Dimension(1000, 100));
        
        jl_question = new JLabel(selec.getQuestion());
        jl_question.setFont(new Font("Serif", Font.BOLD, 18));
        
        jl_question.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        jp_question.add(jl_question, BorderLayout.CENTER);
        
        jp_haut.add(jp_periode);
        jp_haut.add(jp_moment);
        
        mainjp.add(jp_haut, BorderLayout.PAGE_START);
        mainjp.add(jp_choix1, BorderLayout.LINE_START);
        mainjp.add(jp_img, BorderLayout.CENTER);
        mainjp.add(jp_choix2, BorderLayout.LINE_END);
        mainjp.add(jp_question, BorderLayout.PAGE_END);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        
        this.setVisible(true); 
    }
    
    public void setImg(ImageIcon img){
        jl_profil = new JLabel(img);
    }
    
    public void setQuestion(String q){
        jl_question = new JLabel(q);
    }
    
    public void setChoix1(String ch){
        jl_choix1 = new JLabel(ch);
    }
    
    public void setChoix2(String ch){
        jl_choix2 = new JLabel(ch);
    }
    
    public void setPeriode(Periode p){
        jl_periode = new JLabel(p.getImage());
    }
    
    public void setActivite(String ch){
        jl_moment = new JLabel(ch);
    }
}
