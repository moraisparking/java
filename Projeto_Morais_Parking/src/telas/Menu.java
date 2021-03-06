package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexao.Conexao;
import conexao.ConexaoVeiculo;
import modelo.UsuarioVeiculo;
import modelo.Vagas;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


public class Menu extends JFrame {

	private JPanel contentPane;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JTable table;

	int xx;
	int xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(208, 50, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Total:");
		JTextPane tp_tvagas = new JTextPane();
		JLabel lblVagasEspeciis = new JLabel("Carros:");
		JTextPane tp_carros = new JTextPane();
		JLabel lblVagasMotos = new JLabel("Especiais:");
		JLabel lblNewLabel_1 = new JLabel("Motos:");
		JTextPane tp_motos = new JTextPane();
		JTextPane tp_especiais = new JTextPane();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 811, 22);
		contentPane.add(menuBar);
		
		JMenu m_arquivo = new JMenu("Arquivo");
		menuBar.add(m_arquivo);
		
		JMenuItem m_deslogar = new JMenuItem("Deslogar");
		m_deslogar.setIcon(new ImageIcon(Menu.class.getResource("/imagens/delogar.png")));
		m_deslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acesso passarTela = new Acesso();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
				
			}
		});
		m_arquivo.add(m_deslogar);
		
		JMenuItem m_fechar_app = new JMenuItem("Fechar");
		m_fechar_app.setIcon(new ImageIcon(Menu.class.getResource("/imagens/fechar.png")));
		m_fechar_app.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		m_arquivo.add(m_fechar_app);
		
				
				
				JMenu m_funcoes = new JMenu("A\u00E7\u00F5es");
				menuBar.add(m_funcoes);
				
				JMenuItem mi_remover_veiculo = new JMenuItem("Remover Ve\u00EDculos");
				mi_remover_veiculo.setIcon(new ImageIcon(Menu.class.getResource("/imagens/remover.png")));
				mi_remover_veiculo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						RemoverVeiculo passarTela = new RemoverVeiculo();
						passarTela.setUndecorated(true);
						passarTela.setLocationRelativeTo(null);
						passarTela.setVisible(true);
						setVisible(false);
					}
				});
				
				JMenuItem mi_InserirVeiculo = new JMenuItem("Identificar Ve\u00EDculo");
				mi_InserirVeiculo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IdentificarVeiculos passarTela = new IdentificarVeiculos();
						passarTela.setUndecorated(true);
						passarTela.setLocationRelativeTo(null);
						passarTela.setVisible(true);
						setVisible(false);
						
					}
				});
				mi_InserirVeiculo.setIcon(new ImageIcon(Menu.class.getResource("/imagens/paste_plain.png")));
				m_funcoes.add(mi_InserirVeiculo);
				m_funcoes.add(mi_remover_veiculo);
				
				JMenuItem mi_cadastrar_veiculo = new JMenuItem("Cadastrar Ve\u00EDculos");
				mi_cadastrar_veiculo.setIcon(new ImageIcon(Menu.class.getResource("/imagens/cadastrar.png")));
				mi_cadastrar_veiculo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CadastroVeiculo passarTela = new CadastroVeiculo();
						passarTela.setUndecorated(true);
						passarTela.setLocationRelativeTo(null);
						passarTela.setVisible(true);
						setVisible(false);
					}
				});
				m_funcoes.add(mi_cadastrar_veiculo);
				
				JMenuItem mi_cadastrar_evento = new JMenuItem("Cadastrar Eventos");
				mi_cadastrar_evento.setIcon(new ImageIcon(Menu.class.getResource("/imagens/add.png")));
				mi_cadastrar_evento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CadastroEvento abrirTela = new CadastroEvento();
						abrirTela.setUndecorated(true);
						abrirTela.setLocationRelativeTo(null);
						abrirTela.setVisible(true);
					}
				});
				m_funcoes.add(mi_cadastrar_evento);
				
				JMenuItem mi_cadastrar_ocorrencia = new JMenuItem("Cadastrar Ocorr\u00EAncias");
				mi_cadastrar_ocorrencia.setIcon(new ImageIcon(Menu.class.getResource("/imagens/exclamation.png")));
				m_funcoes.add(mi_cadastrar_ocorrencia);
				
				JMenuItem mntmPesquisarPorData = new JMenuItem("Pesquisar por Data");
				mntmPesquisarPorData.setIcon(new ImageIcon(Menu.class.getResource("/imagens/magnifier.png")));
				m_funcoes.add(mntmPesquisarPorData);
				
				JMenu m_Monitoramento = new JMenu("Monitoramento");
				menuBar.add(m_Monitoramento);
				
				JMenuItem mi_eventoMon = new JMenuItem("Eventos");
				mi_eventoMon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MonitoramentoEvento passarTela = new MonitoramentoEvento();
						passarTela.setUndecorated(true);
						passarTela.setLocationRelativeTo(null);
						passarTela.setVisible(true);
						
					}
				});
				mi_eventoMon.setIcon(new ImageIcon(Menu.class.getResource("/imagens/eye.png")));
				m_Monitoramento.add(mi_eventoMon);
				
				JMenuItem mi_OcorrenciaMon = new JMenuItem("Ocorr\u00EAncia");
				mi_OcorrenciaMon.setIcon(new ImageIcon(Menu.class.getResource("/imagens/eye.png")));
				m_Monitoramento.add(mi_OcorrenciaMon);
				
				JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
				menuBar.add(mnRelatrios);
				
				JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
				mntmVisualizar.setIcon(new ImageIcon(Menu.class.getResource("/imagens/pdf.png")));
				mnRelatrios.add(mntmVisualizar);
				
				JMenuItem mntmExtrair = new JMenuItem("Extrair");
				mntmExtrair.setIcon(new ImageIcon(Menu.class.getResource("/imagens/pdf.png")));
				mnRelatrios.add(mntmExtrair);
				
				JPanel panel_Tablea = new JPanel();
				panel_Tablea.setBackground(Color.LIGHT_GRAY);
				panel_Tablea.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
				panel_Tablea.setBounds(10, 149, 775, 307);
				contentPane.add(panel_Tablea);
				panel_Tablea.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 755, 285);
				panel_Tablea.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setBounds(0,165, 811, 277);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Matricula", "Nome", "Placa", "Marca", "Tipo", "Data", "Hora", "Status", "Bloco"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(64);
				
				JPanel panel = new JPanel();
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBounds(10, 33, 775, 105);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lbl_blocos = new JLabel("Blocos:");
				lbl_blocos.setBounds(10, 15, 61, 14);
				panel.add(lbl_blocos);
				lbl_blocos.setForeground(Color.BLACK);
				
								JComboBox combob_blocos = new JComboBox();
								combob_blocos.setBounds(72, 11, 142, 22);
								panel.add(combob_blocos);
								combob_blocos.setBackground(Color.WHITE);
								combob_blocos.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										DefaultTableModel dtm = (DefaultTableModel) table.getModel();
										
										
										//if e elses para trazer as informa��es do banco relacionados ao estacionamento por bloco
										if(combob_blocos.getSelectedItem().equals("Selecionar...")){
											
										}else if(combob_blocos.getSelectedItem().equals("Bloco A")){
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											bloco.setBloco("bloco_A");
											Vagas vagas = new Vagas("bloco_A");
											//zera a tabela quando muda de bloco
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												//faz a conexao
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												//m�todo para setar a quantidade de vagas em seus devidos campos
												lista.qntDeVagasPorBloco(vagas);
												tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
												tp_carros.setText(Integer.toString(vagas.totalVagasCarro()));
												tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagas()));
												//for para adicionar os elementos na tabela
												for(UsuarioVeiculo x:lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),sdf.format(x.getData()),x.getHora(),x.getStatus(),x.getBloco()};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}

										}else if(combob_blocos.getSelectedItem().equals("Bloco B")){
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											bloco.setBloco("bloco_B");
											Vagas vagas = new Vagas("bloco_B");
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												lista.qntDeVagasPorBloco(vagas);
												tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
												tp_carros.setText(Integer.toString(vagas.totalVagasCarro()));
												tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagas()));
												
												for(UsuarioVeiculo x:lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),x.getData(),x.getHora(),x.getStatus(),x.getBloco(),};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}else if(combob_blocos.getSelectedItem().equals("Bloco C")){
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											bloco.setBloco("bloco_C");
											Vagas vagas = new Vagas("bloco_C");
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												lista.qntDeVagasPorBloco(vagas);
												tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
												tp_carros.setText(Integer.toString(vagas.totalVagasCarro()));
												tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagas()));
												
												for(UsuarioVeiculo x:lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),sdf.format(x.getData()),x.getHora(),x.getStatus(),x.getBloco(),};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}else if(combob_blocos.getSelectedItem().equals("Bloco D")){
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											bloco.setBloco("bloco_D");
											Vagas vagas = new Vagas("bloco_D");
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												lista.qntDeVagasPorBloco(vagas);
												tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
												tp_carros.setText(Integer.toString(vagas.totalVagasCarro()));
												tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagas()));
												
												for(UsuarioVeiculo x:lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),x.getData(),x.getHora(),x.getStatus(),x.getBloco(),};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}else if(combob_blocos.getSelectedItem().equals("Bloco E")){
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											bloco.setBloco("bloco_E");
											Vagas vagas = new Vagas("bloco_E");
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												lista.qntDeVagasPorBloco(vagas);
												tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
												tp_carros.setText(Integer.toString(vagas.totalVagasCarro()));
												tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagas()));
												
												for(UsuarioVeiculo x:lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),x.getData(),x.getHora(),x.getStatus(),x.getBloco(),};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}else if(combob_blocos.getSelectedItem().equals("Bloco F")){
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											bloco.setBloco("bloco_F");
											Vagas vagas = new Vagas("bloco_F");
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												lista.qntDeVagasPorBloco(vagas);
												tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
												tp_carros.setText(Integer.toString(vagas.totalVagasCarro()));
												tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagas()));
												
												for(UsuarioVeiculo x:lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),x.getData(),x.getHora(),x.getStatus(),x.getBloco(),};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}else if(combob_blocos.getSelectedItem().equals("Bloco G")){
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											Vagas vagas = new Vagas("bloco_G");
											bloco.setBloco("bloco_G");											
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												lista.qntDeVagasPorBloco(vagas);
												tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
												tp_carros.setText(Integer.toString(vagas.totalVagasCarro()));
												tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagas()));
												
												for(UsuarioVeiculo x:lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),x.getData(),x.getHora(),x.getStatus(),x.getBloco(),};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
											
										}else if(combob_blocos.getSelectedItem().equals("Bloco Central")){
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											bloco.setBloco("bloco_central");
											Vagas vagas = new Vagas("bloco_central");
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												lista.qntDeVagasPorBloco(vagas);
												tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
												tp_carros.setText(Integer.toString(vagas.totalVagasCarro()));
												tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagas()));
												
												for(UsuarioVeiculo x:lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),x.getData(),x.getHora(),x.getStatus(),x.getBloco(),};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}
											
									}
								});
								combob_blocos.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", 
										"Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G"}));
								
								JPanel panel_Vagas = new JPanel();
								panel_Vagas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_Vagas.setBackground(Color.LIGHT_GRAY);
								panel_Vagas.setBounds(341, 11, 229, 83);
								panel.add(panel_Vagas);
								panel_Vagas.setLayout(null);
								
								
								
								lblNewLabel_4.setBounds(10, 18, 51, 14);
								panel_Vagas.add(lblNewLabel_4);
								lblNewLabel_4.setForeground(Color.BLACK);
								
								
								tp_tvagas.setBounds(65, 11, 37, 22);
								panel_Vagas.add(tp_tvagas);
								tp_tvagas.setEditable(false);
								
								
								
								lblVagasEspeciis.setBounds(10, 51, 51, 14);
								panel_Vagas.add(lblVagasEspeciis);
								lblVagasEspeciis.setForeground(Color.BLACK);
								
								tp_carros.setBounds(65, 45, 37, 22);
								panel_Vagas.add(tp_carros);
								tp_carros.setEditable(false);
								
								
								lblVagasMotos.setBounds(112, 18, 64, 14);
								panel_Vagas.add(lblVagasMotos);
								lblVagasMotos.setForeground(Color.BLACK);
								
								tp_especiais.setBounds(176, 11, 37, 22);
								panel_Vagas.add(tp_especiais);
								tp_especiais.setEditable(false);
								
								
								lblNewLabel_1.setBounds(112, 51, 60, 14);
								panel_Vagas.add(lblNewLabel_1);
								lblNewLabel_1.setForeground(Color.BLACK);
								
								tp_motos.setBounds(176, 45, 37, 22);
								panel_Vagas.add(tp_motos);
								tp_motos.setEditable(false);
								
								JLabel lblVagasDiponveis = new JLabel("Vagas Dipon\u00EDveis:");
								lblVagasDiponveis.setBounds(228, 15, 113, 14);
								panel.add(lblVagasDiponveis);								
								
				
				//fun��es para muver a tela ao clicar
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(0, 0, 811, 471);
				contentPane.add(lblNewLabel);
				
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						xx = e.getX();
						xy = e.getY();
						
						
					}
				});
				lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						
						int x = e.getXOnScreen();
						int y = e.getYOnScreen();
						Menu.this.setLocation(x - xx, y - xy);
					}
				});
	}
}
