package telas_extras;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import telas.CadastroUsuario;


public class Sucesso extends JFrame {
	
	int xx;
	int xy;
	
	ImageIcon imagem = new ImageIcon(getClass().getResource("cadastro_sucesso.png"));
	JLabel label = new JLabel(imagem);
	JLabel lb = new JLabel("");
	JLabel tf2 = new JLabel("Cadastro realizado");
	JLabel tf3 = new JLabel("com sucesso!");
	JLabel tf4 = new JLabel("Obrigado!");

	
	public Sucesso() {
		
		add(label);
		
		tf2.setSize(150,35);
		tf2.setLocation(25,170);
		tf3.setSize(300,35);
		tf3.setLocation(50,190);
		tf4.setSize(300,35);
		tf4.setLocation(65,226);

		tf2.setForeground(Color.WHITE);
		tf3.setForeground(Color.WHITE);
		tf2.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 13));
		tf3.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 13));
		tf4.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 11));
		lb.setSize(115,28);
		lb.setLocation(36,227);
		lb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		label.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				xx = e.getX();
				xy = e.getY();

			}
		});
		label.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {

				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Sucesso.this.setLocation(x - xx, y - xy);

			}
		});
		label.add(lb);
		label.add(tf2);
		label.add(tf3);
		label.add(tf4);
		setSize(190,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Sucesso();
	}

}