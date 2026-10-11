import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JFrame {

    JComboBox<String> comboColores;
    JPanel panelDibujo, panelSuperior;
    JButton btnLimpiar;

    BufferedImage imagen;
    BufferedImage imagenOriginal;
    Graphics2D g2;

    int xAnterior, yAnterior;

    public Dibujo() {

        setTitle("Fernando Uriel Díaz de la Cruz");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        comboColores = new JComboBox<>();

        comboColores.addItem("Rojo");
        comboColores.addItem("Verde");
        comboColores.addItem("Azul");

        btnLimpiar = new JButton("Limpiar");

        panelSuperior = new JPanel();

        panelSuperior.add(comboColores);
        panelSuperior.add(btnLimpiar);

        add(panelSuperior, BorderLayout.NORTH);

        //carga de la imagen
        ImageIcon icono = new ImageIcon(
                getClass().getResource("/image/perro.jpeg")
        );

        imagenOriginal = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        Graphics2D gOriginal = imagenOriginal.createGraphics();
        
        gOriginal.drawImage(icono.getImage(),0,0,300,300,null);
        gOriginal.dispose();

        imagen = new BufferedImage(
                300,
                300,
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D gInicial = imagen.createGraphics();

        gInicial.drawImage(
                imagenOriginal,
                0,
                0,
                null
        );

        gInicial.dispose();

        g2 = imagen.createGraphics();
        g2.setColor(Color.red);

        panelDibujo = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                g.drawImage(
                        imagen,
                        40,
                        10,
                        null
                );
            }
        };

        panelDibujo.setBackground(Color.orange);

        comboColores.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int colorSeleccionado =
                        comboColores.getSelectedIndex();

                System.out.println(colorSeleccionado);

                switch (colorSeleccionado) {

                    case 0:
                        g2.setColor(Color.red);
                        break;

                    case 1:
                        g2.setColor(Color.green);
                        break;

                    case 2:
                        g2.setColor(Color.blue);
                        break;
                }
            }
        });

        //boton pa limpiar
        btnLimpiar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Restaurar imagen
                g2.drawImage(
                        imagenOriginal,
                        0,
                        0,
                        null
                );

                // Actualizar panel
                panelDibujo.repaint();
            }
        });

        //Mouse Presionado
        panelDibujo.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                xAnterior = e.getX() - 40;
                yAnterior = e.getY() - 10;
            }
        });

        //Movimiento de Mouse
        panelDibujo.addMouseMotionListener(
                new MouseMotionAdapter() {

                    @Override
                    public void mouseDragged(MouseEvent e) {

                        int x = e.getX() - 40;
                        int y = e.getY() - 10;

                        g2.drawLine(
                                xAnterior,
                                yAnterior,
                                x,
                                y
                        );

                        xAnterior = x;
                        yAnterior = y;

                        panelDibujo.repaint();
                    }
                }
        );

        add(panelDibujo, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        Dibujo d = new Dibujo();

        d.setVisible(true);
    }
}