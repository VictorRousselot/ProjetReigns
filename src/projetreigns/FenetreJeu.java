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
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author etudiant
 */
public class FenetreJeu extends JFrame {
    
    
    private JLabel jl_periode, jl_moment, jl_question, jl_choix1, jl_choix2, jl_profil;
    private JButton bt_choix1, bt_choix2;
    Carte selec;
    PileCartes cartes;

    public FenetreJeu(PileCartes pile) throws PileVideException{
        cartes = pile;
        setTitle("Jeu de chat-ing");
        
        selec = cartes.sommet();
        
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
          
        jl_moment = new JLabel(selec.getActivite());
        jl_moment.setFont(new Font("Serif", Font.BOLD, 20));
        
        jl_moment.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        jp_moment.add(jl_moment, BorderLayout.CENTER);
        
        JPanel jp_choix1 = new JPanel(new BorderLayout());
        jp_choix1.setBackground(Color.GRAY);
        jp_choix1.setPreferredSize(new Dimension(400, 200));
        
        bt_choix1 = new JButton(selec.getChoix1());
        jp_choix1.add(bt_choix1);
        
        bt_choix1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Set<Pretendant> pretendants = selec.getPretendants().keySet();
                for(Pretendant p : pretendants){
                    int[] bonus = selec.getPretendants().get(p);
                    p.setAffinite(p.getAffinite()+bonus[0]);
                    try {
                        p.evolutionRelation(cartes);
                        controleRV(selec);
                        changeCartes();
                    } catch (PileVideException ex) {
                        Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        JPanel jp_img = new JPanel(new BorderLayout());
        
        if(selec.getPretendants().size() == 1){
            Set<Pretendant> pretendants = selec.getPretendants().keySet();
            for(Pretendant p : pretendants){
                jl_profil = new JLabel(p.getImg());
            }
        }
        else {
            jl_profil = new JLabel(new ImageIcon("images/default.jpeg"));
        }
        
        jp_img.add(jl_profil, BorderLayout.CENTER);
        jp_img.setPreferredSize(new Dimension(200, 200));
        
        JPanel jp_choix2 = new JPanel(new BorderLayout());
        jp_choix2.setBackground(Color.GRAY);
        jp_choix2.setPreferredSize(new Dimension(400, 200));
        
        bt_choix2 = new JButton(selec.getChoix2());
        jp_choix2.add(bt_choix2);
        
        bt_choix2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Set<Pretendant> pretendants = selec.getPretendants().keySet();
                for(Pretendant p : pretendants){
                    int[] bonus = selec.getPretendants().get(p);
                    p.setAffinite(p.getAffinite()+bonus[1]);
                    try {
                        p.evolutionRelation(cartes);
                        controleRV(selec);
                        changeCartes();
                    } catch (PileVideException ex) {
                        Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
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
 
    public void changeCartes() throws PileVideException {
        if (!cartes.peutDepiler()) {
            cartes.depiler();
            selec = cartes.sommet();
            bt_choix1.setText(selec.getChoix1());
            bt_choix2.setText(selec.getChoix2());
            jl_question.setText(selec.getQuestion());
            jl_moment.setText(selec.getActivite());
            jl_periode.setIcon(selec.getPeriode().getImage());
        } else {
           JOptionPane.showMessageDialog(null, "Terminé, plus de cartes", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void controleRV(Carte laCarte) throws PileVideException{
        Set<Pretendant> col = laCarte.getPretendants().keySet();
        for(Pretendant p : col){
            if(p.getAffinite() >= 100 && laCarte.getPretendants().size() == 1){
                p.rendezVous(cartes);
            }
        }
    }
}
