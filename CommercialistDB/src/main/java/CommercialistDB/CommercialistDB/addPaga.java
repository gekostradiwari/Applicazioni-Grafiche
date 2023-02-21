package CommercialistDB.CommercialistDB;

import java.awt.Font;
import java.awt.HeadlessException;
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

public class addPaga extends Frame {
	public String CFcommercialista;
	public int IDclient;
	public int IDadempimento;
	public addPaga(String nomeStudio) throws HeadlessException {
		super("Aggiunta Paga",500,500);
		ArrayList<String> Commercialisti = new ArrayList<String>();
		ArrayList<String> Clienti = new ArrayList<String>();
		JPanel panel = new JPanel(null);
		
		JLabel date = new JLabel("Data Invio: ");
		JTextField data = new JTextField();
		JLabel dataScadenza = new JLabel("Data Scadenza: ");
		JTextField DataScadenza = new JTextField();
		JLabel SelezioneCommercialista = new JLabel("Seleziona commercialista: ");
		JLabel SelezionaCliente = new JLabel("Seleziona cliente: ");
		JLabel oreLav = new JLabel("Inserire Ore Lavorative: ");
		JTextField OreLav = new JTextField();
		JLabel CertificatoDiMalattia = new JLabel("Inserire Cert. malattia: ");
		JTextField certificatoDiMalattia = new JTextField();
		JLabel dataCedolino = new JLabel("Inserisci data cedolino: ");
		JTextField DataCedolino = new JTextField();
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
					CallableStatement clienti = conn.prepareCall("SELECT codiceFiscale,id FROM Cliente WHERE Cliente.Commercialista_Riferimento = ?");
					clienti.setString(1, CF);
					ResultSet rs = clienti.executeQuery();
						while(rs.next()) 
							Clienti.add(rs.getString("codiceFiscale")+","+rs.getString("id"));
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
			}
			
		});
		Inserisci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Paghe paghe = new Paghe("Paga",1,DataScadenza.getText(),data.getText(),Integer.parseInt(OreLav.getText()),certificatoDiMalattia.getText(),DataCedolino.getText());
				IDadempimento  = paghe.getCodiceID();
				Connection conn = getConnection.newConn();
				try {
						CallableStatement fr = conn.prepareCall("INSERT INTO Adempimento(codiceidentificativo,dataInvio,dataScadenza,descrizione,Commercialista_ID) VALUES(?,?,?,?,?)");
						fr.setInt(1, paghe.getCodiceID());
						fr.setString(2, paghe.getDataInvio());
						fr.setString(3, paghe.getDataScadenza());
						fr.setString(4, paghe.getDescrizione());
						fr.setString(5, CFcommercialista);
						fr.execute();
						CallableStatement cs = conn.prepareCall("INSERT INTO Paghe(ID,OreLavorative,certificatiDiMalattia,dataCedolino,codiceidentificativo,Prezzo) VALUES(?,?,?,?,?,?)");
						cs.setInt(1, paghe.getCodiceID());
						cs.setInt(2,paghe.getOreLavorative());
						cs.setString(3,paghe.getCertificatiMalattia());
						cs.setString(4, paghe.getDataCedolino());
						cs.setInt(5, paghe.getCodiceID());
						cs.setDouble(6, paghe.getPrezzo());
						cs.execute();
						CallableStatement cc = conn.prepareCall("INSERT INTO Riferisce(IDadempimento,IDcliente) VALUES (?,?)");
						cc.setInt(1, paghe.getCodiceID());
						cc.setInt(2, IDclient);
						removeAll();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
			}
		});
		
		/*JLabel date = new JLabel("Data Invio: ");
		JTextField data = new JTextField();
		JLabel dataScadenza = new JLabel("Data Scadenza: ");
		JTextField DataScadenza = new JTextField();
		JLabel SelezioneCommercialista = new JLabel("Seleziona commercialista: ");
		JLabel SelezionaCliente = new JLabel("Seleziona cliente: ");
		JLabel oreLav = new JLabel("Inserire Ore Lavorative: ");
		JTextField OreLav = new JTextField();
		JLabel CertificatoDiMalattia = new JLabel("Inserire certificato di malattia: ");
		JTextField certificatoDiMalattia = new JTextField();
		JLabel dataCedolino = new JLabel("Inserisci data cedolino: ");
		JTextField DataCedolino = new JTextField();
		JButton Inserisci = new JButton("Inserisci!");*/
		
		date.setFont(new Font("Date Font",Font.BOLD,20));
		date.setBounds(10, 100, 170, 30);
		data.setBounds(280, 100, 200, 30);
		dataScadenza.setFont(date.getFont());
		dataScadenza.setBounds(10, 150, 200, 30);
		DataScadenza.setBounds(280, 150, 200, 30);
		oreLav.setFont(date.getFont());
		oreLav.setBounds(10, 200, 250, 30);
		OreLav.setBounds(280, 200, 200, 30);
		CertificatoDiMalattia.setFont(date.getFont());
		CertificatoDiMalattia.setBounds(10, 250, 250, 30);
		certificatoDiMalattia.setBounds(280, 250, 200, 30);
		dataCedolino.setFont(date.getFont());
		dataCedolino.setBounds(10, 300, 250, 30);
		DataCedolino.setBounds(280, 300, 200, 30);
		SelezioneCommercialista.setFont(new Font("commercialist",Font.BOLD,20));
		SelezioneCommercialista.setBounds(10, 10, 270, 50);
		CommercialistiList.setBounds(280, 20, 200, 30);
		SelezionaCliente.setFont(new Font("Selezione CLiente",Font.BOLD,20));
		SelezionaCliente.setBounds(10, 50, 250, 50);
		ClientiListi.setBounds(280, 60, 200, 30);
		Inserisci.setBounds(165, 350, 150, 50);
		panel.add(dataCedolino);
		panel.add(DataCedolino);
		panel.add(CertificatoDiMalattia);
		panel.add(certificatoDiMalattia);
		panel.add(date);
		panel.add(data);
		panel.add(dataScadenza);
		panel.add(DataScadenza);
		panel.add(oreLav);
		panel.add(OreLav);
		panel.add(SelezioneCommercialista);
		panel.add(CommercialistiList);
		panel.add(SelezionaCliente);
		panel.add(ClientiListi);
		panel.add(Inserisci);
		add(panel);
	}
	public String getCFcommercialista() {
		return CFcommercialista;
	}
	public int getIDclient() {
		return IDclient;
	}
	public int getIDadempimento() {
		return IDadempimento;
	}
	
	
	
	
	
	

}
