import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Contador_HiloBloqueado extends JFrame {
    JButton btnIniciar;
    JButton btnLimpiar;
    JLabel lblContador;
    int contador=10;
   
    public Contador_HiloBloqueado(){
        setTitle("Contador Regresivo");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        lblContador = new JLabel("10", SwingConstants.CENTER);
     
        btnIniciar = new JButton("Iniciar");
        btnLimpiar = new JButton("Reiniciar");
       
        JPanel panelBotones =  new JPanel();
        panelBotones.add(btnIniciar);
        panelBotones.add(btnLimpiar);
       
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                System.out.println("iniciando");
                try{
                Thread.sleep(1000);
                    contador--;
                    while(true){                  
                    lblContador.setText(String.valueOf(contador));
                        if(contador==0){
                            break;
                        }                    
                    }//fin while
                }catch(Exception ed){}
            }
        });
       
       
        add(panelBotones,BorderLayout.NORTH);
        add(lblContador, BorderLayout.CENTER);
    }
   
    public static void main(String[] args) {
        Contador_HiloBloqueado c = new Contador_HiloBloqueado();
        c.setVisible(true);
    }
   
}