package telas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.util.Date;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import conexao.Conexao;
import conexao.ConexaoUsuario;
import conexao.ConexaoVeiculo;
import modelo.Usuario;
import modelo.UsuarioVeiculo;
import telas_extras.Erro;
import telas_extras.Sucesso;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CadastroVeiculo extends JFrame {

	private JPanel contentPane;
	int xx;
	int xy;
	private JTextField tf_matricula;
	private JTextField tf_nome;
	private JTextField tf_placa;
	private JTextField tf_marca;
	private JTextField tf_tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculo frame = new CadastroVeiculo();
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
	public CadastroVeiculo() {
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
		
		JLabel lbl_matricula = new JLabel("MATR\u00CDCULA");
		lbl_matricula.setBounds(424, 38, 82, 14);
		contentPane.add(lbl_matricula);
		
		tf_matricula = new JTextField();
		tf_matricula.setBounds(424, 63, 319, 30);
		contentPane.add(tf_matricula);
		tf_matricula.setColumns(10);
		
		JButton btn_Fechar = new JButton("");
		btn_Fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_Fechar.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/imagens/fechar.png")));
		btn_Fechar.setBounds(770, 11, 16, 16);
		contentPane.add(btn_Fechar);
	
		
		JLabel lbl_nome = new JLabel("NOME");
		lbl_nome.setBounds(424, 110, 82, 14);
		contentPane.add(lbl_nome);
		
		tf_nome = new JTextField();
		tf_nome.setColumns(10);
		tf_nome.setBounds(424, 135, 319, 30);
		contentPane.add(tf_nome);
		
		JLabel lbl_placa = new JLabel("PLACA");
		lbl_placa.setBounds(424, 180, 82, 14);
		contentPane.add(lbl_placa);
		
		tf_placa = new JTextField();
		tf_placa.setColumns(10);
		tf_placa.setBounds(424, 205, 118, 30);
		contentPane.add(tf_placa);
		
		JLabel lbl_marca = new JLabel("MARCA DO VE\u00CDCULO");
		lbl_marca.setBounds(424, 252, 153, 14);
		contentPane.add(lbl_marca);
		
		tf_marca = new JTextField();
		tf_marca.setColumns(10);
		tf_marca.setBounds(424, 277, 319, 30);
		contentPane.add(tf_marca);
		
		JLabel lbl_tipo = new JLabel("TIPO DO VE\u00CDCULO");
		lbl_tipo.setBounds(424, 321, 108, 14);
		contentPane.add(lbl_tipo);
		
		tf_tipo = new JTextField();
		tf_tipo.setColumns(10);
		tf_tipo.setBounds(424, 346, 319, 30);
		contentPane.add(tf_tipo);
		
		JComboBox combob_bloco = new JComboBox();
		Button btn_salvarCadastro = new Button("CADASTRAR");
		btn_salvarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricula = tf_matricula.getText();
				String nome = tf_nome.getText();
				String placa = tf_placa.getText();
				String marca = tf_marca.getText();
				String tipo = tf_tipo.getText();
				

				UsuarioVeiculo veiculo = new UsuarioVeiculo(matricula, nome, placa, marca, tipo);

				try {
					if (tf_matricula.getText().equals("") || tf_nome.getText().equals("")
							|| tf_placa.getText().equals("") || tf_marca.getText().equals("")
							|| tf_tipo.getText().equals("")) {
						Erro erro = new Erro();
					}else {
						if(combob_bloco.getSelectedItem().equals("Selecionar...")) {
							Erro erro = new Erro();
						}else if(combob_bloco.getSelectedItem().equals("Bloco A")) {
							veiculo.setBloco("bloco_A");
						}else if(combob_bloco.getSelectedItem().equals("Bloco B")) {
							veiculo.setBloco("bloco_B");
						}else if(combob_bloco.getSelectedItem().equals("Bloco C")) {
							veiculo.setBloco("bloco_C");
						}else if(combob_bloco.getSelectedItem().equals("Bloco D")) {
							veiculo.setBloco("bloco_D");
						}else if(combob_bloco.getSelectedItem().equals("Bloco E")) {
							veiculo.setBloco("bloco_E");
						}else if(combob_bloco.getSelectedItem().equals("Bloco F")) {
							veiculo.setBloco("bloco_F");
						}else if(combob_bloco.getSelectedItem().equals("Bloco G")) {
							veiculo.setBloco("bloco_G");
						}else if(combob_bloco.getSelectedItem().equals("Bloco Central")) {
							veiculo.setBloco("bloco_central");
						}
						Connection conexao = new Conexao().fazer_conexao();
						ConexaoVeiculo cadastrar_Veiculo = new ConexaoVeiculo(conexao);
						cadastrar_Veiculo.inserirVeiculo(veiculo);
						Sucesso sucesso = new Sucesso();
						tf_matricula.setText("");
						tf_nome.setText("");
						tf_placa.setText("");
						tf_marca.setText("");
						tf_tipo.setText("");
					}
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				combob_bloco.setSelectedIndex(0);
				
				
				
			}
		});
		btn_salvarCadastro.setForeground(Color.WHITE);
		btn_salvarCadastro.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_salvarCadastro.setBackground(new Color(225, 20, 35));
		btn_salvarCadastro.setBounds(451, 402, 118, 30);
		contentPane.add(btn_salvarCadastro);
		
		Button bnt_voltar = new Button("MENU");
		bnt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu passarTela = new Menu();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
				
			}
		});
		bnt_voltar.setForeground(Color.WHITE);
		bnt_voltar.setFont(new Font("Dialog", Font.BOLD, 13));
		bnt_voltar.setBackground(new Color(225, 20, 35));
		bnt_voltar.setBounds(605, 402, 118, 30);
		contentPane.add(bnt_voltar);
		
		JLabel lbl_bloco = new JLabel("BLOCO");
		lbl_bloco.setBounds(625, 180, 48, 14);
		contentPane.add(lbl_bloco);
		
		
		combob_bloco.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G"}));
		combob_bloco.setBounds(625, 205, 118, 30);
		contentPane.add(combob_bloco);
		
		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(747, 57, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(747, 128, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(543, 200, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(747, 200, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(747, 270, 48, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(747, 339, 48, 14);
		contentPane.add(lblNewLabel_5);
		
		
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
				CadastroVeiculo.this.setLocation(x - xx, y - xy);
				
				
			}
		});
		
		
		
	}
}
