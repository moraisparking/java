package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import conexao.Conexao;
import conexao.ConexaoUsuario;
import modelo.Usuario;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField tf_usuario;
	private JPasswordField pf_senha;
	int xx, xy;
	private JTextField tf_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
					frame.setUndecorated(true);
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
	public CadastroUsuario() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox cb_funcionario = new JCheckBox("Funcion\u00E1rios");
		JCheckBox cb_gestor = new JCheckBox("Gestor");
		JCheckBox cb_rh = new JCheckBox("RH");
		
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
		
		JPanel panel_TituloTela = new JPanel();
		panel_TituloTela.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_TituloTela.setBounds(60, 54, 245, 28);
		panel_TituloTela.setBackground(new Color(208, 50, 47));
		panel.add(panel_TituloTela);
		panel_TituloTela.setLayout(null);
		
		JLabel lblCadastroDeVeculos = new JLabel("CADASTRO DE USU\u00C1RIO");
		lblCadastroDeVeculos.setBounds(25, 4, 192, 21);
		panel_TituloTela.add(lblCadastroDeVeculos);
		lblCadastroDeVeculos.setForeground(Color.WHITE);
		lblCadastroDeVeculos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCadastroDeVeculos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/imagens/uniesp pequeno.jpg")));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(-23, -54, 480, 530);
		panel.add(lblNewLabel);
		
		JLabel lbl_usuario = new JLabel("USUARIO");
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(426, 71, 82, 14);
		contentPane.add(lbl_usuario);
		
		tf_usuario = new JTextField();
		tf_usuario.setBounds(426, 96, 319, 30);
		contentPane.add(tf_usuario);
		tf_usuario.setColumns(10);
		
		JLabel lbl_email = new JLabel("EMAIL");
		lbl_email.setBounds(425, 146, 82, 14);
		contentPane.add(lbl_email);
		
		tf_email = new JTextField();
		tf_email.setColumns(10);
		tf_email.setBounds(425, 171, 319, 30);
		contentPane.add(tf_email);
		
		JLabel lbl_senha = new JLabel("SENHA");
		lbl_senha.setBounds(426, 220, 82, 14);
		contentPane.add(lbl_senha);
		
		pf_senha = new JPasswordField();
		pf_senha.setBounds(425, 245, 319, 30);
		contentPane.add(pf_senha);
		
		Button btn_salvarCadastro = new Button("CADASTRAR");
		btn_salvarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Primeiro preciso armazenar em uma variável os valores passados na tela
				String usuario = tf_usuario.getText();
				String email = tf_email.getText();
				String senha = new String(pf_senha.getPassword());
				Usuario usuarioCadastro = new Usuario(usuario, email, senha);
				if(cb_funcionario.isSelected()) {
					usuarioCadastro.setCargo("funcionario");
				}else if(cb_gestor.isSelected()) {
					usuarioCadastro.setCargo("gestor");
				}else if(cb_rh.isSelected()) {
					usuarioCadastro.setCargo("funcionario_rh");
				}
				//Armazenar em um objeto usuairo
				try {
					if(tf_usuario.getText().equals("") || tf_email.getText().equals("") || new String(pf_senha.getPassword()).equals("")) {
						JOptionPane.showMessageDialog(null, "Campos * são obrigatórios!");					
					}else {
						//Criar um objeto do tipo Connection para conectar e conectar ao banco com o método
						Connection conexao = new Conexao().fazer_conexao();
						//Criar um objeto para conectar o usuario
						ConexaoUsuario conectar_usuario = new ConexaoUsuario(conexao);
						conectar_usuario.inserirConexao(usuarioCadastro);
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
						tf_usuario.setText("");
						tf_email.setText("");
						pf_senha.setText("");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btn_salvarCadastro.setForeground(Color.WHITE);
		btn_salvarCadastro.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_salvarCadastro.setBackground(new Color(225, 20, 35));
		btn_salvarCadastro.setBounds(452, 340, 118, 30);
		contentPane.add(btn_salvarCadastro);
		
		Button bnt_voltar = new Button("VOLTAR");
		bnt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Acesso passarTela = new Acesso();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
				
			}
		});
		bnt_voltar.setForeground(Color.WHITE);
		bnt_voltar.setFont(new Font("Dialog", Font.BOLD, 13));
		bnt_voltar.setBackground(new Color(225, 20, 35));
		bnt_voltar.setBounds(606, 340, 118, 30);
		contentPane.add(bnt_voltar);
		
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
		btn_Fechar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/imagens/fechar.png")));
		btn_Fechar.setBounds(770, 11, 16, 16);
		contentPane.add(btn_Fechar);
		cb_rh.setBounds(452, 290, 57, 23);
		contentPane.add(cb_rh);
		
		cb_gestor.setBounds(530, 290, 69, 23);
		contentPane.add(cb_gestor);
		
		
		cb_funcionario.setBounds(618, 290, 106, 23);
		contentPane.add(cb_funcionario);
		
		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(747, 96, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("*");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(747, 171, 48, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(747, 245, 48, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(730, 293, 48, 14);
		contentPane.add(label_2);
		
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
				CadastroUsuario.this.setLocation(x - xx, y - xy);
				
				
			}
		});
	}
}
