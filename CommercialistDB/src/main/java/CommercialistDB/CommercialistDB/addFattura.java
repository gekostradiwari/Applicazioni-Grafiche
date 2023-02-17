package CommercialistDB.CommercialistDB;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class addFattura extends Frame {
	public String CFcommercialista;
	public int IDclient;

	public addFattura(String nomeStudio) {
		super("Aggiunta Fattura",500,500);
		ArrayList<String> Commercialisti = new ArrayList<String>();
		ArrayList<String> Clienti = new ArrayList<String>();
		JPanel panel = new JPanel(null);
		
		JLabel date = new JLabel("Data Emissione: ");
		JTextField data = new JTextField();
		JLabel importo = new JLabel("Importo: ");
		JLabel Importo = new JLabel("0");
		JLabel SelezioneCommercialista = new JLabel("Seleziona commercialista: ");
		JLabel SelezionaCliente = new JLabel("Seleziona cliente: ");
		JButton Inserisci = new JButton("Inserisci!");
		Connection conn =  getConnection.newConn();
		try {
			CallableStatement commercialisti = conn.prepareCall("SELECT nome,cognome FROM Commercialista WHERE Commercialista.id_studio = (SELECT id FROM Studio WHERE Studio.nome = ?)");
			commercialisti.setString(1,nomeStudio);
			ResultSet rs = commercialisti.executeQuery();
			while(rs.next())
				Commercialisti.add(rs.getString("nome")+","+rs.getString("cognome"));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		JComboBox CommercialistiList = new JComboBox(Commercialisti.toArray());
		JComboBox ClientiListi = new JComboBox();
		CommercialistiList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeCommercialista = (String) CommercialistiList.getSelectedItem();
				String[] nome = nomeCommercialista.split(",");
				String CF = "";
				Connection conn =  getConnection.newConn();
				try {
					CallableStatement CFquery = conn.prepareCall("SELECT codiceFiscale FROM Commercialista WHERE Commercialista.id_studio = (SELECT id FROM Studio WHERE Studio.nome = ?) AND Commercialista.nome = ? AND Commercialista.cognome = ?");
					CFquery.setString(1,nomeStudio);
					CFquery.setString(2,	nome[0]);
					CFquery.setString(3, nome[1]);
					ResultSet rs = CFquery.executeQuery();
					if(!rs.next())
						;
					else {
						CF = rs.getString("codiceFiscale");
						CFcommercialista = CF;
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					CallableStatement clienti = conn.prepareCall("SELECT codiceFiscale FROM Cliente WHERE Cliente.Commercialista_Riferimento = ?");
					clienti.setString(1, CF);
					ResultSet rs = clienti.executeQuery();
						while(rs.next()) 
							Clienti.add(rs.getString("codiceFiscale"));
					for(String a : Clienti)
						ClientiListi.addItem(a);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ClientiListi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String Cliente = (String) ClientiListi.getSelectedItem();
				int IDcliente = 0;
				int IDadempimento = 0;
				Connection conn = getConnection.newConn();
				try {
					CallableStatement clienti = conn.prepareCall("SELECT id FROM Cliente WHERE Cliente.codiceFiscale = ?");
					clienti.setString(1, Cliente);
					ResultSet rs = clienti.executeQuery();
						if(!rs.next())
							;
						else {
							IDcliente = rs.getInt("id");
							IDclient = IDcliente;
						}
						CallableStatement id = conn.prepareCall("SELECT IDadempimento FROM Riferisce WHERE IDcliente = ?");
						id.setInt(1, IDcliente);
						ResultSet rid = id.executeQuery();
						if(!rid.next())
							;
						else
							IDadempimento = rid.getInt("IDadempimento");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					CallableStatement importo = conn.prepareCall("SELECT SUM(Contabilità.Prezzo) + SUM(DDIVA.Prezzo)+SUM(DDR.Prezzo)+SUM(Imu.Prezzo)+SUM(Paghe.Prezzo) AS Importo FROM Contabilità,DDIVA,DDR,Imu,Paghe WHERE Contabilità.codiceidentificativo = ? OR DDIVA.codiceidentificativo = ? OR DDR.codiceidentificativo = ? OR Imu.codiceidentificativo = ? OR Paghe.codiceidentificativo = ?");
					importo.setInt(1, IDadempimento);
					importo.setInt(2, IDadempimento);
					importo.setInt(3, IDadempimento);
					importo.setInt(4, IDadempimento);
					importo.setInt(5, IDadempimento);
					ResultSet rimporto = importo.executeQuery();
						if(!rimporto.next())
							;
						else {
							double imp;
							imp = rimporto.getDouble("Importo");
							Importo.setText(Double.toString(imp));
						}				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		Inserisci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Fattura fattura = new Fattura(data.getText(),Double.parseDouble(Importo.getText())) ;
				Connection conn = getConnection.newConn();
				try {
						CallableStatement cs = conn.prepareCall("{call EmissioneFattura(?,?,?,?,?)}");
						cs.setInt(1, fattura.getId());
						cs.setString(2,fattura.getData());
						cs.setDouble(3, fattura.getImporto());
						cs.setString(4, CFcommercialista);
						cs.setInt(5, IDclient);
						cs.execute();
						CallableStatement cc = conn.prepareCall("INSERT INTO Cliente(Fattura_Attribuita) VALUES (?) WHERE Cliente.id = IDclient");
						cc.setInt(1, fattura.getId());
						removeAll();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			
		});
		
		date.setFont(new Font("Date Font",Font.BOLD,20));
		date.setBounds(10, 250, 170, 30);
		data.setBounds(210, 250, 230, 30);
		SelezioneCommercialista.setFont(new Font("commercialist",Font.BOLD,20));
		SelezioneCommercialista.setBounds(10, 10, 270, 50);
		CommercialistiList.setBounds(280, 20, 200, 30);
		SelezionaCliente.setFont(new Font("Selezione CLiente",Font.BOLD,20));
		SelezionaCliente.setBounds(10, 50, 250, 50);
		ClientiListi.setBounds(280, 60, 200, 30);
		
		importo.setBounds(10, 282, 170,50);
		importo.setFont(new Font("Font Importo",Font.BOLD,20));
		Importo.setBounds(210,	 290, 230, 30);
		Importo.setFont(importo.getFont());
		Inserisci.setBounds(165, 350, 150, 50);
		Inserisci.setFont(importo.getFont());
		
		panel.add(importo);
		panel.add(Importo);
		panel.add(date);
		panel.add(data);
		panel.add(SelezioneCommercialista);
		panel.add(CommercialistiList);
		panel.add(SelezionaCliente);
		panel.add(ClientiListi);
		panel.add(Inserisci);
		add(panel);
	}
	
	

}
