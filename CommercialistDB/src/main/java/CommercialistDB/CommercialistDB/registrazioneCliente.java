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

public class registrazioneCliente extends Frame {
	private String nomeStudio;
	private int IDclient;
	private String nomeClient;
	private String cognomeClient;
	private String CFcommercialista;
	
	public registrazioneCliente(String title, int x, int y,String nomeStudio) {
		super(title, x, y);
		this.nomeStudio = nomeStudio;
		ArrayList<String> Commercialisti = new ArrayList<String>();
		JPanel panel = new JPanel(null);
		JLabel listaComm = new JLabel("Seleziona commercialista: ");
		JComboBox ListaComm = new JComboBox();
		listaComm.setFont(new Font("font",Font.BOLD,20));
		listaComm.setBounds(10,10,270,50);
		ListaComm.setBounds(280, 20, 200, 30);
		String[] tipiCliente = {"Privato","Condominio","Ditta"};
		JComboBox tipiClienti = new JComboBox(tipiCliente);
		JLabel selezionatipo = new JLabel("Seleziona tipo cliente: ");
		selezionatipo.setFont(listaComm.getFont());
		selezionatipo.setBounds(10, 50, 270, 50);
		tipiClienti.setBounds(280, 60, 200, 30);
		
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
		Inserisci.setBounds(175,400,150,50);
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
			}			
		});
		
		
		
		tipiClienti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tipiClienti.getSelectedItem().equals(tipiCliente[0])) {
					panel.remove(selezionatipo);
					panel.remove(tipiClienti);
					JLabel cf = new JLabel("Inserisci codice fiscale: ");
					cf.setFont(listaComm.getFont());
					cf.setBounds(10, 100, 270, 50);
					JTextField CF = new JTextField();
					CF.setBounds(280, 110, 200, 30);
					JLabel indirizzo = new JLabel("Inserisci indirizzo: ");
					indirizzo.setFont(listaComm.getFont());
					indirizzo.setBounds(10, 150, 270, 50);
					JTextField Indirizzo = new JTextField();
					Indirizzo.setBounds(280, 160, 200, 30);
					JLabel nome = new JLabel("Nome:");
					JTextField Nome = new JTextField();
					nome.setFont(listaComm.getFont());
					nome.setBounds(10, 200, 270, 50);
					Nome.setBounds(280, 210, 200, 30);
					JLabel cognome = new JLabel("Cognome:");
					JTextField Cognome = new JTextField();
					cognome.setFont(listaComm.getFont());
					cognome.setBounds(10, 250, 270, 50);
					Cognome.setBounds(280, 260, 200, 30);
					JLabel Telefono = new JLabel("Telefono:");
					JTextField telefono = new JTextField();
					Telefono.setFont(listaComm.getFont());
					Telefono.setBounds(10, 300, 270, 50);
					telefono.setBounds(280, 310, 200, 30);
					Inserisci.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Privato privato = new Privato(CF.getText(),Indirizzo.getText(),Nome.getText(),Cognome.getText(),telefono.getText());
							Connection conn = getConnection.newConn();
							try {
									CallableStatement fs = conn.prepareCall("INSERT INTO Cliente(id,codiceFiscale,indirizzo,Commercialista_Riferimento) VALUES (?,?,?,?)");
									fs.setInt(1, privato.getId());
									fs.setString(2, privato.getCodiceFiscale());
									fs.setString(3, privato.getIndirizzo());
									fs.setString(4, CFcommercialista);
									fs.execute();
									CallableStatement cs = conn.prepareCall("INSERT INTO Privato(cognome,nome,recapitoTelefonico,id) VALUES (?,?,?,?)");
									cs.setString(1, privato.getCognome());
									cs.setString(2,privato.getNome());
									cs.setString(3, privato.getRecapitoTelefonico());
									cs.setInt(4, privato.getId());
									cs.execute();	
									IDclient = privato.getId();
									//idAdempimento = ddiva.getCodiceID();
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							removeAll();
						}
						
					});
					panel.add(cf);
					panel.add(CF);
					panel.add(indirizzo);
				    panel.add(Indirizzo);
					panel.add(Inserisci);
					panel.add(nome);
					panel.add(Nome);
					panel.add(cognome);
					panel.add(Cognome);
					panel.add(Telefono);
					panel.add(telefono);
					panel.repaint();
				}
				else if(tipiClienti.getSelectedItem().equals(tipiCliente[1])) {
					panel.remove(selezionatipo);
					panel.remove(tipiClienti);
					JLabel cf = new JLabel("Inserisci codice fiscale: ");
					cf.setFont(listaComm.getFont());
					cf.setBounds(10, 100, 270, 50);
					JTextField CF = new JTextField();
					CF.setBounds(280, 110, 200, 30);
					JLabel indirizzo = new JLabel("Inserisci indirizzo: ");
					indirizzo.setFont(listaComm.getFont());
					indirizzo.setBounds(10, 150, 270, 50);
					JTextField Indirizzo = new JTextField();
					Indirizzo.setBounds(280, 160, 200, 30);
					JLabel nome = new JLabel("Denominazione:");
					JTextField Nome = new JTextField();
					nome.setFont(listaComm.getFont());
					nome.setBounds(10, 200, 270, 50);
					Nome.setBounds(280, 210, 200, 30);
					JLabel cognome = new JLabel("Unità abitative:");
					JTextField Cognome = new JTextField();
					cognome.setFont(listaComm.getFont());
					cognome.setBounds(10, 250, 270, 50);
					Cognome.setBounds(280, 260, 200, 30);
					JLabel Telefono = new JLabel("Fornitori (separati da ','):");
					JTextField telefono = new JTextField();
					Telefono.setFont(listaComm.getFont());
					Telefono.setBounds(10, 300, 270, 50);
					telefono.setBounds(280, 310, 200, 30);
					JLabel quote = new JLabel("Quote condominio:");
					JTextField Quote = new JTextField();
					quote.setFont(listaComm.getFont());
					quote.setBounds(10, 350, 270, 50);
					Quote.setBounds(280, 360, 200, 30);
					Inserisci.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Condominio condominio = new Condominio(CF.getText(),Indirizzo.getText(),Nome.getText(),Integer.parseInt(Cognome.getText()),Double.parseDouble(Quote.getText()),Indirizzo.getText(),telefono.getText());
							Connection conn = getConnection.newConn();
							try {
									CallableStatement fs = conn.prepareCall("INSERT INTO Cliente(id,codiceFiscale,indirizzo,Commercialista_Riferimento) VALUES (?,?,?,?)");
									fs.setInt(1, condominio.getId());
									fs.setString(2, condominio.getCodiceFiscale());
									fs.setString(3, condominio.getIndirizzo());
									fs.setString(4, CFcommercialista);
									fs.execute();
									CallableStatement cs = conn.prepareCall("INSERT INTO Condominio(denominazione,indirizzo,unitaAbitative,fornitori,quoteCondominio,id) VALUES (?,?,?,?,?,?)");
									cs.setString(1, condominio.getDenominazione());
									cs.setString(2,condominio.getIndirizzi());
									cs.setInt(3, condominio.getUnitaAbitative());
									cs.setString(4, telefono.getText());
									cs.setDouble(5, condominio.getQuoteCondominiali());
									cs.setInt(6, condominio.getId());
									cs.execute();	
									IDclient = condominio.getId();
									//idAdempimento = ddiva.getCodiceID();
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							removeAll();
						}
						
					});
					panel.add(cf);
					panel.add(CF);
					panel.add(indirizzo);
				    panel.add(Indirizzo);
					panel.add(Inserisci);
					panel.add(nome);
					panel.add(Nome);
					panel.add(cognome);
					panel.add(Cognome);
					panel.add(Telefono);
					panel.add(telefono);
					panel.add(quote);
					panel.add(Quote);
					panel.repaint();
				}
				else {
					panel.remove(selezionatipo);
					panel.remove(tipiClienti);
					JLabel cf = new JLabel("Inserisci codice fiscale: ");
					cf.setFont(listaComm.getFont());
					cf.setBounds(10, 100, 270, 50);
					JTextField CF = new JTextField();
					CF.setBounds(280, 110, 200, 30);
					JLabel indirizzo = new JLabel("Inserisci indirizzo: ");
					indirizzo.setFont(listaComm.getFont());
					indirizzo.setBounds(10, 150, 270, 50);
					JTextField Indirizzo = new JTextField();
					Indirizzo.setBounds(280, 160, 200, 30);
					JLabel nome = new JLabel("Denominazione:");
					JTextField Nome = new JTextField();
					nome.setFont(listaComm.getFont());
					nome.setBounds(10, 200, 270, 50);
					Nome.setBounds(280, 210, 200, 30);
					JLabel cognome = new JLabel("Partita IVA:");
					JTextField Cognome = new JTextField();
					cognome.setFont(listaComm.getFont());
					cognome.setBounds(10, 250, 270, 50);
					Cognome.setBounds(280, 260, 200, 30);
					JLabel Telefono = new JLabel("Camera di Commercio:");
					JTextField telefono = new JTextField();
					Telefono.setFont(listaComm.getFont());
					Telefono.setBounds(10, 300, 270, 50);
					telefono.setBounds(280, 310, 200, 30);
					JLabel quote = new JLabel("Tipo:");
					JTextField Quote = new JTextField();
					quote.setFont(listaComm.getFont());
					quote.setBounds(10, 350, 270, 50);
					Quote.setBounds(280, 360, 200, 30);
					Inserisci.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Ditta ditta = new Ditta(CF.getText(),Indirizzo.getText(),Nome.getText(),Cognome.getText(),Quote.getText(),telefono.getText());
							Connection conn = getConnection.newConn();
							try {
									CallableStatement fs = conn.prepareCall("INSERT INTO Cliente(id,codiceFiscale,indirizzo,Commercialista_Riferimento) VALUES (?,?,?,?)");
									fs.setInt(1, ditta.getId());
									fs.setString(2, ditta.getCodiceFiscale());
									fs.setString(3, ditta.getIndirizzo());
									fs.setString(4, CFcommercialista);
									fs.execute();
									CallableStatement cs = conn.prepareCall("INSERT INTO Ditta(partitaIva,denominazione,iscrizioneCameraDiCommercio,tipo,id) VALUES (?,?,?,?,?)");
									cs.setString(1, ditta.getPartitaIVA());
									cs.setString(2,ditta.getDenominazione());
									cs.setString(3, ditta.getIscrizioneCameraCommercio());
									cs.setString(4, ditta.getTipo());
									cs.setInt(5, ditta.getId());
									cs.execute();	
									IDclient = ditta.getId();
									//idAdempimento = ddiva.getCodiceID();
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							removeAll();
						}
						
					});
					panel.add(cf);
					panel.add(CF);
					panel.add(indirizzo);
				    panel.add(Indirizzo);
					panel.add(Inserisci);
					panel.add(nome);
					panel.add(Nome);
					panel.add(cognome);
					panel.add(Cognome);
					panel.add(Telefono);
					panel.add(telefono);
					panel.add(quote);
					panel.add(Quote);
					panel.repaint();
					
				}
				
			}
			
		});
				
		panel.add(listaComm);
		panel.add(ListaComm);
		panel.add(selezionatipo);
		panel.add(tipiClienti);
		//panel.add(ListaClienti);
		//panel.add(listaClienti);
		/*panel.add(InserisciIVA);
		panel.add(inserisciIVA);
		panel.add(InserisciIVa);
		panel.add(inserisciIVa);
		
		panel.add(inseriscidata);
		panel.add(Inseriscidata);
		panel.add(inserisciscadenza);
		panel.add(Inserisciscadenza);
		*/
		//panel.add(Inserisci);
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
