import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bolita_Botones extends JPanel{
    int x, y;
    public Bolita_Botones(){
        setSize(300,300);
       x=50;
        setBackground(Color.green);
    }
   
    public void moverIzquierda(){
        x=x-20;
        repaint();
    }
    public void moverDerecha(){
        x=x+20;
        repaint();
    }
   
    public void moverArriba(){
        y=y-20;
        repaint();
    }
   
    public void moverAbajo(){
        y=y+20;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, y, 40, 40);
    }
}
    class Ventana extends JFrame{
        Bolita_Botones bolita;        
        JPanel panelBotones;
        JButton btnIzquierda, btnDerecha, btnArriba,btnAbajo;
        public Ventana(){
            setSize(450,430);
            setTitle("Bolita 01");            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                    
           
            bolita = new Bolita_Botones();          
            add(bolita, BorderLayout.CENTER);

            btnIzquierda = new JButton("izquierda");  
           
            btnIzquierda.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bolita.moverIzquierda();
                    System.out.println("mover izquierda " + bolita.x);                    
                }
            });
           
            btnDerecha = new JButton("derecha");  
           
            btnDerecha.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bolita.moverDerecha();                
                }
            });
           
            btnArriba = new JButton("Arriba");
           
            btnArriba.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bolita.moverArriba();
                }
            });
           
           
            btnAbajo = new JButton("Abajo");
           
            btnAbajo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bolita.moverAbajo();
                }
            });
           
            panelBotones = new JPanel(new BorderLayout());
            panelBotones.add(btnArriba, BorderLayout.NORTH);
            panelBotones.add(btnIzquierda, BorderLayout.WEST);            
            panelBotones.add(btnDerecha, BorderLayout.EAST);            
            panelBotones.add(btnAbajo, BorderLayout.SOUTH);
            add(panelBotones, BorderLayout.SOUTH);
        }    
        public static void main(String[] args) {
            Ventana v = new Ventana();
            v.setVisible(true);          
        }
 }
