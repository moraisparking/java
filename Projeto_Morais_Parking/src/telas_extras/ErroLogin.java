package telas_extras;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import telas.CadastroUsuario;


public class ErroLogin extends JFrame {
	
	int xx;
	int xy;
	
	ImageIcon imagem = new ImageIcon(getClass().getResource("campos_obrigatorios.png"));
	JLabel label = new JLabel(imagem);
	JLabel lb = new JLabel("");
	JLabel tf1 = new JLabel("OPS!");
	JLabel tf2 = new JLabel("Usuário/Senha inválido");
	JLabel tf3 = new JLabel("ou caixa desmarcada!");
	JLabel tf4 = new JLabel("Tente de Novo");

	
	public ErroLogin() {
		
		add(label);
		tf1.setSize(98,35);
		tf1.setLocation(80,160);
		tf2.setSize(155,35);
		tf2.setLocation(20,180);
		tf3.setSize(300,35);
		tf3.setLocation(30,200);
		tf4.setSize(300,35);
		tf4.setLocation(50,226);
		tf1.setForeground(Color.WHITE);
		tf2.setForeground(Color.WHITE);
		tf3.setForeground(Color.WHITE);
		tf1.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 14));
		tf2.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 12));
		tf3.setFont(new Font("Source Code Pro Medium", Font.PLAIN, 12));
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
				ErroLogin.this.setLocation(x - xx, y - xy);

			}
		});
		label.add(lb);
		label.add(tf1);
		label.add(tf2);
		label.add(tf3);
		label.add(tf4);
		setSize(190,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setUndecorated(true);
		setVisible(true);
		
		
		
	}

}
