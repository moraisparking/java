package telas;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import conexao.Conexao;
import conexao.ConexaoUsuario;
import modelo.Usuario;
import telas_extras.ErroLogin;
import javax.swing.JButton;

public class Acesso extends JFrame {

	private JPanel contentPane;
	private JTextField tf_usuario;
	private JPasswordField pf_senha;
	int xx, xy;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acesso frame = new Acesso();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Acesso() {
		setType(Type.POPUP);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox cb_rh = new JCheckBox("RH");
		JCheckBox cb_gestor = new JCheckBox("Gestor");
		JCheckBox cb_funcionario = new JCheckBox("Funcion\u00E1rio");
		
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 365, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMoraisParking = new JLabel("Projeto Morais Parking");
		lblMoraisParking.setForeground(Color.WHITE);
		lblMoraisParking.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		lblMoraisParking.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoraisParking.setBounds(161, 428, 239, 48);
		panel.add(lblMoraisParking);
		
		JLabel lbl_imgLogoUniesp = new JLabel("");
		lbl_imgLogoUniesp.setIcon(new ImageIcon(Acesso.class.getResource("/imagens/uniesp pequeno.jpg")));
		lbl_imgLogoUniesp.setVerticalAlignment(SwingConstants.TOP);
		lbl_imgLogoUniesp.setBounds(-23, -54, 480, 541);
		panel.add(lbl_imgLogoUniesp);
		
		JLabel lbl_usuario = new JLabel("USU\u00C1RIO");
		lbl_usuario.setBounds(426, 82, 82, 14);
		contentPane.add(lbl_usuario);
		
		tf_usuario = new JTextField();
		tf_usuario.setBounds(426, 107, 319, 30);
		contentPane.add(tf_usuario);
		tf_usuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setBounds(427, 173, 82, 14);
		contentPane.add(lblSenha);
		
		pf_senha = new JPasswordField();
		pf_senha.setBounds(426, 198, 319, 30);
		contentPane.add(pf_senha);
		
		Button btn_entrar = new Button("ENTRAR");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = tf_usuario.getText();
				String senha = new String(pf_senha.getPassword());
				Usuario usuarioAcesso = new Usuario(usuario, senha);
				if(cb_funcionario.isSelected()) {
					usuarioAcesso.setCargo("funcionario");
				}else if(cb_gestor.isSelected()) {
					usuarioAcesso.setCargo("gestor");
				}else if(cb_rh.isSelected()) {
					usuarioAcesso.setCargo("funcionario_rh");
				}
				
				
				try {
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoUsuario verifica_usuario = new ConexaoUsuario(conexao);
					boolean validacao = verifica_usuario.verificarUsuario(usuarioAcesso);
					if(validacao != true) {
						ErroLogin erro = new ErroLogin();
						
					}else {
						Menu menu = new Menu();
						menu.setUndecorated(true);
						menu.setLocationRelativeTo(null);
						menu.setVisible(true);
						setVisible(false);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btn_entrar.setForeground(Color.WHITE);
		btn_entrar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_entrar.setBackground(new Color(225, 20, 35));
		btn_entrar.setBounds(446, 292, 118, 30);
		contentPane.add(btn_entrar);
		
		Button btn_cadastrar = new Button("CADASTRAR");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroUsuario passarTela = new CadastroUsuario();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
				
			}
		});
		btn_cadastrar.setForeground(Color.WHITE);
		btn_cadastrar.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_cadastrar.setBackground(new Color(225, 20, 35));
		btn_cadastrar.setBounds(600, 292, 118, 30);
		contentPane.add(btn_cadastrar);
		
		
		cb_funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_gestor.setSelected(false);
				cb_rh.setSelected(false);
			}
		});
		cb_gestor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_funcionario.setSelected(false);
				cb_rh.setSelected(false);
			}
		});
		
		cb_rh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_funcionario.setSelected(false);
				cb_gestor.setSelected(false);
			}
		});
		
		JButton btn_Fechar = new JButton("");
		btn_Fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_Fechar.setIcon(new ImageIcon(Acesso.class.getResource("/imagens/fechar.png")));
		btn_Fechar.setBounds(770, 11, 16, 16);
		contentPane.add(btn_Fechar);
		cb_rh.setBounds(467, 248, 53, 23);
		contentPane.add(cb_rh);
		
		
		cb_gestor.setBounds(533, 248, 75, 23);
		contentPane.add(cb_gestor);
		
		
		cb_funcionario.setBounds(610, 248, 111, 23);
		contentPane.add(cb_funcionario);
		
		JLabel lbl_mover_janela = new JLabel("");
		lbl_mover_janela.setBounds(0, 0, 827, 432);
		contentPane.add(lbl_mover_janela);
		
		
		
		lbl_mover_janela.addMouseListener(new MouseAdapter() {
			
			//Mover janela
			public void mousePressed(MouseEvent e) {
				
				xx = e.getX();
				xy = e.getY();
				
			}
		});
		lbl_mover_janela.addMouseMotionListener(new MouseMotionAdapter() {
			//Mover janela
			public void mouseDragged(MouseEvent e) {
				
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Acesso.this.setLocation(x - xx, y - xy);
				
				
			}
		});
	}
}
