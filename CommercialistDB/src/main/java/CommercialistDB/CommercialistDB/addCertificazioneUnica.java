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

public class addCertificazioneUnica extends Frame {
	private String nomeStudio;
	private int IDclient;
	private String nomeClient;
	private String cognomeClient;
	private String CFcommercialista;

	public addCertificazioneUnica(String title, int x, int y,String nomeStudio) {
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
		JLabel ListaClienti = new JLabel("Seleziona un Privato: ");
		JComboBox listaClienti = new JComboBox();
		ListaClienti.setFont(listaComm.getFont());
		ListaClienti.setBounds(10, 50, 250, 50);
		listaClienti.setBounds(280,60,200,30);
		JLabel ValoreCert = new JLabel("Inserisci valore CU: ");
		JTextField valoreCert = new JTextField();
		ValoreCert.setFont(listaComm.getFont());
		ValoreCert.setBounds(10, 100, 250, 50);
		valoreCert.setBounds(280, 110, 200, 30);
		JButton Inserisci = new JButton("Inserisci");
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
					CallableStatement ClientQuery = conn.prepareCall("SELECT nome,cognome FROM Privato,Cliente WHERE Privato.id = Cliente.id AND Cliente.Commercialista_Riferimento = ?");
					ClientQuery.setString(1, CFcommercialista);
					ResultSet rs = ClientQuery.executeQuery();
					while(rs.next())
						listaClienti.addItem(rs.getString("nome")+","+rs.getString("cognome"));
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}			
		});
		
		listaClienti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeCliente = (String) listaClienti.getSelectedItem();
				String[] nomeclient = nomeClient.split(",");
				nomeClient = nomeclient[0];
				cognomeClient = nomeclient[1];
				try {
					CallableStatement ClientQuery = conn.prepareCall("SELECT id FROM Privato WHERE Privato.nome = ? AND Privato.cognome = ?");
					ClientQuery.setString(1, nomeClient);
					ClientQuery.setString(2, cognomeClient);
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
				CU certificazione = new CU(Double.parseDouble(valoreCert.getText()));
				Connection conn = getConnection.newConn();
				try {
						CallableStatement cs = conn.prepareCall("{call insertCU(?,?,?,?)}");
						cs.setInt(1, certificazione.getNumeroCertificazione());
						cs.setDouble(2,certificazione.getValoreCertificazione());
						cs.setString(3, nomeClient);
						cs.setString(4, cognomeClient);
						cs.execute();									
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
		panel.add(ValoreCert);
		panel.add(valoreCert);
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
	
	

}
