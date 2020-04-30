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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import conexao.Conexao;
import conexao.ConexaoEventos;
import conexao.ConexaoVeiculo;
import modelo.UsuarioVeiculo;
import telas_extras.Erro;

public class RemoverVeiculo extends JFrame {

	private JPanel contentPane;
	int xx;
	int xy;
	private JTextField tf_matricula;
	private JTextField tf_placa;
	private JTextField tf_nome;
	private JTextField tf_marca;
	private JTextField tf_tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverVeiculo frame = new RemoverVeiculo();
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
	public RemoverVeiculo() {
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
		
		JButton btn_Fechar = new JButton("");
		btn_Fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_Fechar.setIcon(new ImageIcon(RemoverVeiculo.class.getResource("/imagens/fechar.png")));
		btn_Fechar.setBounds(770, 11, 16, 16);
		contentPane.add(btn_Fechar);
		
		tf_matricula = new JTextField();
		tf_matricula.setBounds(424, 129, 319, 30);
		contentPane.add(tf_matricula);
		tf_matricula.setColumns(10);
		
		
		Button btn_salvarCadastro = new Button("REMOVER");
		btn_salvarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String placa = tf_placa.getText();
				if(tf_placa.getText().equals("")) {
					Erro erro = new Erro();
				}else {
					try {
						UsuarioVeiculo pesquisarPlaca = new UsuarioVeiculo(placa);
						Connection conexao = new Conexao().fazer_conexao();
						ConexaoVeiculo removerVeiculo = new ConexaoVeiculo(conexao);
						removerVeiculo.removerVeiculo(pesquisarPlaca);
						JOptionPane.showMessageDialog(null, "Veículo removido com sucesso!");
						tf_matricula.setText("");
						tf_nome.setText("");
						tf_placa.setText("");
						tf_marca.setText("");
						tf_tipo.setText("");
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco" + e1);
					}
				}
			
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
		
		tf_placa = new JTextField();
		tf_placa.setColumns(10);
		tf_placa.setBounds(424, 63, 319, 30);
		contentPane.add(tf_placa);
		
		tf_nome = new JTextField();
		tf_nome.setColumns(10);
		tf_nome.setBounds(424, 196, 319, 30);
		contentPane.add(tf_nome);
		
		tf_marca = new JTextField();
		tf_marca.setColumns(10);
		tf_marca.setBounds(426, 268, 319, 30);
		contentPane.add(tf_marca);
		
		tf_tipo = new JTextField();
		tf_tipo.setColumns(10);
		tf_tipo.setBounds(424, 334, 319, 30);
		contentPane.add(tf_tipo);
		
		JLabel lblPlaca = new JLabel("PLACA");
		lblPlaca.setBounds(424, 38, 48, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblMatrcula = new JLabel("MATR\u00CDCULA");
		lblMatrcula.setBounds(424, 104, 86, 14);
		contentPane.add(lblMatrcula);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(424, 171, 48, 14);
		contentPane.add(lblNome);
		
		JLabel lblMarcaDoVeculo = new JLabel("MARCA DO VE\u00CDCULO");
		lblMarcaDoVeculo.setBounds(424, 243, 164, 14);
		contentPane.add(lblMarcaDoVeculo);
		
		JLabel lblTipoDoVeculo = new JLabel("TIPO DO VE\u00CDCULO");
		lblTipoDoVeculo.setBounds(424, 311, 129, 14);
		contentPane.add(lblTipoDoVeculo);
		
		JButton btn_Lupa = new JButton("");
		btn_Lupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = tf_placa.getText();
				UsuarioVeiculo veiculo = new UsuarioVeiculo(placa);
				
				try {
					if (tf_placa.getText().equals("")) {

					}else {
						Connection conexao = new Conexao().fazer_conexao();
						ConexaoVeiculo pesquisarVeiculo = new ConexaoVeiculo(conexao);
						pesquisarVeiculo.pesquisarVeiculo(veiculo);
						if (!veiculo.getStatus().equalsIgnoreCase("AUSENTE")) {
							tf_matricula.setText(veiculo.getMatricula());
							tf_nome.setText(veiculo.getNome());
							tf_marca.setText(veiculo.getMarca());
							tf_tipo.setText(veiculo.getTipo());
						}
						
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_Lupa.setBackground(Color.WHITE);
		btn_Lupa.setIcon(new ImageIcon(RemoverVeiculo.class.getResource("/imagens/magnifier.png")));
		btn_Lupa.setBounds(745, 67, 16, 16);
		contentPane.add(btn_Lupa);
		
			
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
				RemoverVeiculo.this.setLocation(x - xx, y - xy);
				
				
			}
		});
		
	}
}
