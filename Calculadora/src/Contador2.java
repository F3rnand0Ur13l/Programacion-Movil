import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Contador2 extends JFrame {
    JButton btnIniciar;
    JButton btnLimpiar;
    JLabel lblContador;
    //int contador=10;
   
    Thread hilo;
    boolean ejecutando;
   
    public Contador2(){
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
               iniciarContador();
            }
        });
       
        btnLimpiar.addActionListener(e->reiniciarContador());
       
       
        add(panelBotones,BorderLayout.NORTH);
        add(lblContador, BorderLayout.CENTER);
    }
   
    public static void main(String[] args) {
        Contador2 c2 = new Contador2();
        c2.setVisible(true);
    }
   
    public void iniciarContador(){
       
            if(ejecutando){
                return;
            }
       
            ejecutando=true;
           
            hilo = new Thread(()->{
                for(int i=10;i>=0 && ejecutando;i--){
                    final int num = i;
                    SwingUtilities.invokeLater(()->{
                        lblContador.setText(String.valueOf(num));
                    });      
                      try{
                        Thread.sleep(1000);
                     }catch(Exception exx){
                         Thread.currentThread().interrupt();
                         break;
                     }
                     }
            });  
           
           
         
           
            hilo.start();
    }    

    private void reiniciarContador() {
            lblContador.setText(10+"");
    }
}