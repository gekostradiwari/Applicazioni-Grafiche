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

public class calcoloIVA extends Frame {
	private String nomeStudio;
	private int IDclient;
	private String nomeClient;
	private String cognomeClient;
	private String CFcommercialista;
	private Double calcoloIVA = 0.0;
	public calcoloIVA(String title, int x, int y,String nomeStudio) {
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
		JLabel ListaClienti = new JLabel("Seleziona una Ditta: ");
		JComboBox listaClienti = new JComboBox();
		ListaClienti.setFont(listaComm.getFont());
		ListaClienti.setBounds(10, 50, 250, 50);
		listaClienti.setBounds(280,60,200,30);
		JButton Inserisci = new JButton("Calcola");
		Inserisci.setFont(listaComm.getFont());
		Inserisci.setBounds(175,200,150,50);
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
					CallableStatement ClientQuery = conn.prepareCall("SELECT partitaIva FROM Ditta,Cliente WHERE Ditta.id = Cliente.id AND Cliente.Commercialista_Riferimento = ?");
					ClientQuery.setString(1, CFcommercialista);
					ResultSet rs = ClientQuery.executeQuery();
					while(rs.next())
						listaClienti.addItem(rs.getString("partitaIva"));
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}			
		});
		
		listaClienti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeCliente = (String) listaClienti.getSelectedItem();
				nomeClient = nomeCliente;
				try {
					CallableStatement ClientQuery = conn.prepareCall("SELECT id FROM Ditta WHERE Ditta.partitaIva = ?");
					ClientQuery.setString(1, nomeCliente);
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
				Connection conn = getConnection.newConn();
				try {
						CallableStatement cs = conn.prepareCall("SELECT Ditta.id,SUM(DDIVA.ivaAcquisti) - SUM(DDIVA.ivaVendite) FROM DDIVA,Ditta,Cliente,Commercialista,Adempimento WHERE Ditta.id = Cliente.id AND Cliente.Commercialista_Riferimento = ? AND  Adempimento.Commercialista_ID = ? AND Adempimento.codiceIdentificativo = DDIVA.codiceidentificativo GROUP BY Ditta.id");
						cs.setString(1, CFcommercialista);
						cs.setString(2,CFcommercialista);
						ResultSet rs = cs.executeQuery();			
						while(rs.next()) {
							if(IDclient == rs.getInt("Ditta.id")) {
								calcoloIVA = rs.getDouble(2);							
							}
						}
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
		panel.add(Inserisci);
		
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

	public Double getCalcoloIVA() {
		return calcoloIVA;
	}
	
	

}
