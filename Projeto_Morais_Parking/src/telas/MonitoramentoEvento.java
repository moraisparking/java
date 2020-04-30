package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import conexao.Conexao;
import conexao.ConexaoEventos;
import modelo.Eventos;
import telas_extras.Erro;
import java.awt.Checkbox;
import java.awt.Button;
import javax.swing.JTextArea;

public class MonitoramentoEvento extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String status;
	int xx;
	int xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonitoramentoEvento frame = new MonitoramentoEvento();
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
	public MonitoramentoEvento() {
		setType(Type.POPUP);
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(225, 20, 35));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 616, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_Sair = new JButton("");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btn_Sair.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/fechar.png")));
		btn_Sair.setBounds(580, 5, 16, 16);
		panel.add(btn_Sair);
		
		JLabel lblCadastroDeEventos = new JLabel("Monitoramento Eventos");
		lblCadastroDeEventos.setBounds(12, 5, 120, 14);
		panel.add(lblCadastroDeEventos);
		
		JPanel panel_Salvar = new JPanel();
		panel_Salvar.setBackground(Color.LIGHT_GRAY);
		panel_Salvar.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Salvar.setBounds(10, 40, 589, 130);
		contentPane.add(panel_Salvar);
		panel_Salvar.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		JComboBox comboBox_Bloco = new JComboBox();
		
		
		comboBox_Bloco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_Bloco.getSelectedItem().equals("Selecionar...")){
					
				}else if(comboBox_Bloco.getSelectedItem().equals("Finalizados")){
					status = "finalizado";
					
				}else if(comboBox_Bloco.getSelectedItem().equals("Em Andamento")){
					status = "em_andamento";
				}else if(comboBox_Bloco.getSelectedItem().equals("Futuros")){
					status = "futuro";
				}
				
			}
		});
		comboBox_Bloco.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Finalizados", "Em Andamento", "Futuros"}));
		comboBox_Bloco.setBounds(62, 11, 150, 23);
		panel_Salvar.add(comboBox_Bloco);
		
		JLabel lblBloco = new JLabel("Bloco:");
		lblBloco.setBounds(21, 15, 48, 14);
		panel_Salvar.add(lblBloco);
		
		Button button = new Button("Extrair");
		button.setBounds(497, 98, 70, 22);
		panel_Salvar.add(button);
		
		Button button_1 = new Button("Pesquisar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				while(dtm.getRowCount() != 0) {
					dtm.removeRow(0);
				}
				try {
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoEventos pesquisarEvento = new ConexaoEventos(conexao);
					for(Eventos x: pesquisarEvento.pesquisarEvento(status)) {
						Object [] dados = {
								x.getNomeEvento(),sdf.format(x.getDataInicio()),sdf.format(x.getDataFim()),x.getBlocoRealizado(),x.getVagasConsumidas(),
								x.getVagaExtras(),x.getStatus()};
						dtm.addRow(dados);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro em conectar ao banco" + e1);
				}
				
	
			}
		});
		button_1.setBounds(421, 98, 70, 22);
		panel_Salvar.add(button_1);
		
		JPanel panel_Tabela = new JPanel();
		panel_Tabela.setBackground(Color.LIGHT_GRAY);
		panel_Tabela.setLayout(null);
		panel_Tabela.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Tabela.setBounds(10, 177, 589, 181);
		contentPane.add(panel_Tabela);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(10, 11, 565, 159);
		panel_Tabela.add(scrollPane);

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Evento", "Inicio", "Fim", "Local", "Total Vagas", "Vagas Extras", "Status"
			}
		));
		scrollPane.setViewportView(table);
		JLabel lbl_Mover_Tela = new JLabel("");
		lbl_Mover_Tela.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				xx = e.getX();
				xy = e.getY();
			}
		});
		lbl_Mover_Tela.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				MonitoramentoEvento.this.setLocation(x - xx, y - xy);
				
			}
		});
		lbl_Mover_Tela.setBounds(0, 0, 605, 386);
		contentPane.add(lbl_Mover_Tela);
		

	}
}
