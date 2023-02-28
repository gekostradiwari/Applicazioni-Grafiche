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

public class addDDIVA extends Frame {
	private String nomeStudio;
	private int IDclient;
	private String nomeClient;
	private String cognomeClient;
	private String CFcommercialista;
	private Double detrazioni = 0.0;
	private int idAdempimento;
	
	public addDDIVA(String title, int x, int y,String nomeStudio) {
		super(title, x, y);
		this.nomeStudio = nomeStudio;
		ArrayList<String> clientiPrivati = new ArrayList<String>();
		ArrayList<String> Commercialisti = new ArrayList<String>();
		ArrayList<String> Clienti = new ArrayList<String>();
		JPanel panel = new JPanel(null);
		JLabel listaComm = new JLabel("Seleziona commercialista: ");
		JComboBox ListaComm = new JComboBox();
		listaComm.setFont(new Font("font",Font.BOLD,20));
		listaComm.setBounds(10,10,270,50);
		ListaComm.setBounds(280, 20, 200, 30);
		JLabel ListaClienti = new JLabel("Seleziona un Cliente: ");
		JComboBox listaClienti = new JComboBox();
		ListaClienti.setFont(listaComm.getFont());
		ListaClienti.setBounds(10, 50, 250, 50);
		listaClienti.setBounds(280,60,200,30);
		JLabel InserisciIVA = new JLabel("IVA vendite: ");
		JTextField inserisciIVA = new JTextField();
		InserisciIVA.setFont(ListaClienti.getFont());
		InserisciIVA.setBounds(10,100,250,50);
		inserisciIVA.setBounds(280, 110, 200, 30);
		JLabel InserisciIVa = new JLabel("IVA acquisti: ");
		JTextField inserisciIVa = new JTextField();
		InserisciIVa.setFont(ListaClienti.getFont());
		InserisciIVa.setBounds(10, 150, 250, 50);
		inserisciIVa.setBounds(280, 160, 200, 30);
		JLabel inseriscidata = new JLabel ("Inserisci data invio: ");
		JTextField Inseriscidata = new JTextField();
		inseriscidata.setFont(ListaClienti.getFont());
		inseriscidata.setBounds(10, 200, 250, 50);
		Inseriscidata.setBounds(280, 210, 200, 30);
		JLabel inserisciscadenza = new JLabel("Inserisci scadenza: ");
		JTextField Inserisciscadenza = new JTextField();
		inserisciscadenza.setFont(ListaClienti.getFont());
		inserisciscadenza.setBounds(10, 250, 250, 50);
		Inserisciscadenza.setBounds(280, 260, 200, 30);
		JButton Inserisci = new JButton("Inserisci");
		Inserisci.setFont(listaComm.getFont());
		Inserisci.setBounds(175,350,150,50);
		Connection conn =  getConnection.newConn();
		try {
			CallableStatement commercialisti = conn.prepareCall("SELECT nome,cognome,codiceFiscale FROM Commercialista WHERE Commercialista.id_studio = (SELECT id FROM Studio WHERE Studio.nome = ?)");
			commercialisti.setString(1,nomeStudio);
			ResultSet rs = commercialisti.executeQuery();
			while(rs.next())
				Commercialisti.add(rs.getString("nome")+","+rs.getString("cognome"));
			for(String a : Commercialisti)
				ListaComm.addItem(a);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ListaComm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeCommercialista = (String) ListaComm.getSelectedItem();
				String[] nome = nomeCommercialista.split(",");
				String CF = "";
				Connection conn =  getConnection.newConn();
				try {
					CallableStatement CFquery = conn.prepareCall("SELECT codiceFiscale FROM Commercialista WHERE Commercialista.id_studio = (SELECT id FROM Studio WHERE Studio.nome = ?) AND Commercialista.nome = ? AND Commercialista.cognome = ?");
					CFquery.setString(1,nomeStudio);
					CFquery.setString(2, nome[0]);
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
					CallableStatement ClientQuery = conn.prepareCall("SELECT codiceFiscale FROM Cliente WHERE Cliente.Commercialista_Riferimento = ?");
					ClientQuery.setString(1, CFcommercialista);
					ResultSet rs = ClientQuery.executeQuery();
					while(rs.next())
						listaClienti.addItem(rs.getString("codiceFiscale"));
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}			
		});
		
		listaClienti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeCliente = (String) listaClienti.getSelectedItem();
				//String nomeClients[] = nomeCliente.split(",");
				//nomeClient = nomeClients[0];
				//cognomeClient = nomeClients[1];
				
				try {
					CallableStatement ClientQuery = conn.prepareCall("SELECT id FROM Cliente WHERE Cliente.codiceFiscale = ?");
					ClientQuery.setString(1, nomeCliente);
					//ClientQuery.setString(2, cognomeClient);
					ResultSet rs = ClientQuery.executeQuery();
					if(!rs.next())
						;
					else
						IDclient = rs.getInt("id");
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}		
		});
		Inserisci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DDIVA ddiva = new DDIVA("ddiva",2,Inserisciscadenza.getText(),Inseriscidata.getText(),Double.parseDouble(inserisciIVa.getText()),Double.parseDouble(inserisciIVA.getText()));
				Connection conn = getConnection.newConn();
				try {
						CallableStatement fs = conn.prepareCall("INSERT INTO Riferisce(IDadempimento,IDcliente) VALUES(?,?)");
						fs.setInt(1, ddiva.getCodiceID());
						fs.setInt(2, IDclient);
						fs.executeQuery();
						CallableStatement cs = conn.prepareCall("{call insertDDIVA(?,?,?,?,?)}");
						cs.setInt(1, ddiva.getCodiceID());
						cs.setDouble(2,ddiva.getImportoIVAvendite());
						cs.setDouble(3, ddiva.getImportoIVAacquisti());
						cs.setInt(4, ddiva.getCodiceID());
						cs.setDouble(5,ddiva.getPrezzo());
						cs.executeQuery();	
						idAdempimento = ddiva.getCodiceID();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				removeAll();
			}
			
		});
				
		panel.add(listaComm);
		panel.add(ListaComm);
		panel.add(ListaClienti);
		panel.add(listaClienti);
		panel.add(InserisciIVA);
		panel.add(inserisciIVA);
		panel.add(InserisciIVa);
		panel.add(inserisciIVa);
		panel.add(Inserisci);
		panel.add(inseriscidata);
		panel.add(Inseriscidata);
		panel.add(inserisciscadenza);
		panel.add(Inserisciscadenza);
		
		super.add(panel);
	}

	public String getNomeStudio() {
		return nomeStudio;
	}

	public int getIDclient() {
		return IDclient;
	}

	public String getNomeClient() {
		return nomeClient;
	}

	public String getCognomeClient() {
		return cognomeClient;
	}

	public String getCFcommercialista() {
		return CFcommercialista;
	}

	public Double getDetrazioni() {
		return detrazioni;
	}

	public int getIdAdempimento() {
		return idAdempimento;
	}
	

}
