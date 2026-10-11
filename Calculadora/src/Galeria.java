import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Galeria extends JFrame{
    JButton btnAtras, btnAdelante, btnPlay;
    JPanel panelBotones, panelImagen;
    ImageIcon [] imagenes;
    int imagenActual;
    JLabel etiquetaImagen;
   
    Timer timer;
    boolean reproduciendo;
    String[] titulos;
    JLabel etiquetaTitulos;
   
    public Galeria(){
        setTitle("Fernando Uriel Díaz de la Cruz");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
       
        panelBotones = new JPanel();        
        panelImagen = new JPanel();        
        btnAtras = new JButton("Atras");
        btnAdelante = new JButton("Adelante");
        btnPlay = new JButton("Reproducir");
       
        imagenes = new ImageIcon[10];
        titulos = new String[10];
       
        imagenes[0] = new ImageIcon(getClass().getResource("image/Abismo Negro.jpeg"));        
        imagenes[1] = new ImageIcon(getClass().getResource("image/Blue Demon sr y El Santo sr.jpeg"));
        imagenes[2] = new ImageIcon(getClass().getResource("image/Canek and Dos Caras.jpeg"));
        imagenes[3] = new ImageIcon(getClass().getResource("image/Fishman.jpeg"));
        imagenes[4] = new ImageIcon(getClass().getResource("image/Fray Tormenta.jpeg"));
        imagenes[5] = new ImageIcon(getClass().getResource("image/Los Brazos.jpeg"));
        imagenes[6] = new ImageIcon(getClass().getResource("image/MilMascaras.jpeg"));
        imagenes[7] = new ImageIcon(getClass().getResource("image/Mistico.jpeg"));
        imagenes[8] = new ImageIcon(getClass().getResource("image/Tinieblas y Aluche.jpeg"));
        imagenes[9] = new ImageIcon(getClass().getResource("image/LA Park.jpeg"));
       
        titulos[0] = "Abismo Negro";
        titulos[1] = "Blue Demon Sr. y El Santo Sr.";
        titulos[2] = "Canek y Dos Caras";
        titulos[3] = "Fishman";
        titulos[4] = "Fray Tormenta";
        titulos[5] = "Los Brazos";
        titulos[6] = "Mil Mascaras";
        titulos[7] = "Místico";
        titulos[8] = "Tinieblas y Aluche";
        titulos[9] = "L.A. Park";
        
        etiquetaImagen = new JLabel();
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        
        etiquetaTitulos = new JLabel();
        etiquetaTitulos.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulos.setFont(new Font("Arial", Font.BOLD, 18));
        
        panelImagen.add(etiquetaImagen);
        panelImagen.add(etiquetaTitulos, BorderLayout.NORTH);
        
       
        mostrarImagen();
       

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(imagenActual==0){
                        imagenActual = imagenes.length -1;
                    }else{
                        imagenActual--;
                    }
                    mostrarImagen();
            }
        });
       
        btnAdelante.addActionListener(e -> {
    if(imagenActual == imagenes.length - 1){
        imagenActual = 0;
    }else{
        imagenActual++;
    }
    mostrarImagen();
});
       
        btnPlay.addActionListener(e->{
           
            if(!reproduciendo){
                btnPlay.setText("Detener");
                reproduciendo=true;
                timer.start();
            }else{                
                btnPlay.setText("Reproducir");
                reproduciendo=false;
                timer.stop();
            }            
        });
       
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(imagenActual== imagenes.length -1){
                        imagenActual = 0;
                    }else{
                        imagenActual++;
                    }
                    mostrarImagen();
            }
        });
       
        panelBotones.add(btnAtras);
        panelBotones.add(btnAdelante);        
        panelBotones.add(btnPlay);

        add(panelImagen, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);        
    }

    public static void main(String[] args) {
        Galeria g = new Galeria();
        g.setVisible(true);
    }
   
     public void mostrarImagen() {
        ImageIcon icono = imagenes[imagenActual];
        Image imagen = icono.getImage();
        Image imagenEscalada = imagen.getScaledInstance(
                380,
                380,
                Image.SCALE_SMOOTH
        );
        
        etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
        etiquetaTitulos.setText(titulos[imagenActual]);

        etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
    }

}