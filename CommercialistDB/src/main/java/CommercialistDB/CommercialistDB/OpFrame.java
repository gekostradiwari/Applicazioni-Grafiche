package CommercialistDB.CommercialistDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class OpFrame extends Frame {
	String nomeStudio;
	public OpFrame(String title,int x, int y,String nomeStudio) {
		super(title,x,y);
		this.nomeStudio = nomeStudio;
		OpFrame clone = this;
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setBounds(10, 10, 320, 2000);
		JScrollPane scrollbar = new JScrollPane(panel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollbar.setBounds(10, 10, 310, 950);
		
		
		
		JPanel panel2 = new JPanel(null);
		panel2.setBounds(320, 10, 670, 1000);	
		JTextArea output = new JTextArea();
		output.setBounds(0, 0, 670, 1000);
		output.setEditable(false);
		output.setBackground(Color.black);
		output.setForeground(Color.green);
		output.setFont(new Font("newFont", Font.BOLD + Font.ITALIC,20));
		String twoLines = "Selezionare il numero di clienti \n di un determinato commercialista";
		String twoLines1 ="Contabilizzazione certificazione\n unica";
		String twoLines2 ="Calcolo fattura in base agli\n adempimenti commissionati dal cliente";
		String twoLines3 ="Elaborazione ed invio \n dichiarazione IVA";
		String twoLines4 ="Elaborazione bilancio per\n  dichiarazione dei redditi";
		String twoLines5 ="Elaborazione e calcolo\n redditi di fabbricati";
		String twoLines6 ="Inserimento commercialista\n  in un albo";
		String twoLines7 ="Inserimento incasso\n quote condominiali";
		String twoLines8 ="Inserimento corso di \n formazione e relativo attestato";
		String twoLines9 ="Selezionare il nome degli studi i quali"
				+ "	commercialisti assistono un numero di"
				+ "	clienti maggiore o uguale a 5";

		JButton op1 = new JButton("Emissione fattura");
		op1.setPreferredSize(new Dimension(290,70));
		op1.setMaximumSize(new Dimension(290,70));		
		op1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addFattura fattura = new addFattura(nomeStudio);
				clone.setVisible(false);
				fattura.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						clone.setVisible(true);
						fattura.dispose();
						super.windowClosed(e);
					}
				});
				fattura.addContainerListener(new ContainerListener() {

					@Override
					public void componentAdded(ContainerEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void componentRemoved(ContainerEvent e) {
						fattura.dispose();
						output.setText("Fattura inserita con successo:\n");
						Connection conn = getConnection.newConn();
						try {
							CallableStatement cs = conn.prepareCall("SELECT * FROM Fattura WHERE Fattura.Cliente_Intestata = ?");
							cs.setInt(1, fattura.getIDclient());
							ResultSet fatture = cs.executeQuery();
							output.append("ID"+"  "+"Data"+"    "+"Imp"+"    "+"Commercialista"+"  "+"Cliente"+"\n");
							while(fatture.next())							
								output.append(fatture.getInt("numeroProgresivo")+"  "+fatture.getString("data")+"  "+fatture.getDouble("importo")+"  "+fatture.getString("Commercialista_Impiegato")+"  "+fatture.getInt("Cliente_Intestata")+"\n");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
				
			}		
		});

		JButton op2 = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
		op2.setPreferredSize(new Dimension(290,70));
		op2.setMaximumSize(new Dimension(290,70));
		op2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clone.setVisible(false);
				Frame selezionaCommercialista = new Frame("Seleziona Commercialista",600,500);
				selezionaCommercialista.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						clone.setVisible(true);
						selezionaCommercialista.dispose();
						super.windowClosed(e);
					}
				});
				JPanel panel = new JPanel(null);
				ArrayList<String> Commercialisti = new ArrayList<String>();
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
				JComboBox commercialistiList = new JComboBox(Commercialisti.toArray());
				commercialistiList.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						clone.setVisible(false);
						String nomeCompleto = (String) commercialistiList.getSelectedItem();
						String[] nome = nomeCompleto.split(",");
						String CF = "";
						Connection conn = getConnection.newConn();
						try {
							CallableStatement tmp = conn.prepareCall("SELECT codiceFiscale FROM Commercialista WHERE Commercialista.nome = ? AND Commercialista.cognome = ?");
							tmp.setString(1, nome[0]);
							tmp.setString(2, nome[1]);
							ResultSet rs = tmp.executeQuery();
							if(!rs.next())
								;
							else
								CF = rs.getString("codiceFiscale");
						}catch(SQLException e1){
							e1.printStackTrace();					
						}
						int  numeroClienti = 0;
						try {
							CallableStatement tmp1 = conn.prepareCall("{call SelezioneClienti(?)}");
							tmp1.setString(1, CF);
							ResultSet rc = tmp1.executeQuery();
							if(!rc.next())
								;
							else
							numeroClienti = rc.getInt("NumeroClienti");
							output.setText(rc.getString("nome"));
							output.append("  " + Integer.toString(numeroClienti));
							selezionaCommercialista.dispose();
							clone.setVisible(true);				
						}catch(SQLException e1) {
							e1.printStackTrace();
						}
						
					}
					
				});
				commercialistiList.setBounds(200, 90, 200, 50);
				panel.add(commercialistiList);
				selezionaCommercialista.add(panel);
			}
			
		});

		JButton op3 = new JButton("Stampa commercialisti");
		op3.setPreferredSize(new Dimension(290,70));
		op3.setMaximumSize(new Dimension(290,70));
		op3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn =  getConnection.newConn();
				try {
					CallableStatement commercialisti = conn.prepareCall("SELECT nome,cognome,codiceFiscale FROM Commercialista WHERE Commercialista.id_studio = (SELECT id FROM Studio WHERE Studio.nome = ?)");
					commercialisti.setString(1,nomeStudio);
					ResultSet rs = commercialisti.executeQuery();
					output.setText("");
					while(rs.next())
						output.append(rs.getString("nome")+" , "+rs.getString("cognome") + " , "+rs.getString("codiceFiscale")+"\n");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}			
		});

		JButton op4 = new JButton("Contabilizzazione paghe");
		op4.setPreferredSize(new Dimension(290,70));
		op4.setMaximumSize(new Dimension(290,70));
		op4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clone.setVisible(false);
				addPaga paga = new addPaga(nomeStudio);
				paga.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						clone.setVisible(true);
						paga.dispose();
						super.windowClosed(e);
					}
				});
				paga.addContainerListener(new ContainerListener() {

					@Override
					public void componentAdded(ContainerEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void componentRemoved(ContainerEvent e) {
						paga.dispose();
						output.setText("Paga inserita con successo:\n");
						Connection conn = getConnection.newConn();
						try {
							CallableStatement cs = conn.prepareCall("SELECT * FROM Paghe WHERE  Paghe.codiceidentificativo = ?");
							cs.setInt(1, paga.getIDadempimento());
							ResultSet fatture = cs.executeQuery();
							output.append("ID"+"  "+"OreLav"+"    "+"CertificatiMalattia"+"    "+"dataCedolino"+"  "+"CodID"+"  "+"Prezzo"+"\n");
							while(fatture.next())							
								output.append(fatture.getInt("ID")+"  "+fatture.getInt("OreLavorative")+"  "+fatture.getString("certificatiDiMalattia")+"  "+fatture.getString("dataCedolino")+"  "+fatture.getInt("codiceidentificativo")+"  "+ fatture.getDouble("Prezzo")+"\n");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
			}
			
		});
		

		JButton op5 = new JButton("<html>" + twoLines1.replaceAll("\\n", "<br>") + "</html>");
		op5.setPreferredSize(new Dimension(290,70));
		op5.setMaximumSize(new Dimension(290,70));

		JButton op6 = new JButton("Calcolo credito e debito IVA");
		op6.setPreferredSize(new Dimension(290,70));
		op6.setMaximumSize(new Dimension(290,70));

		JButton op7 = new JButton("Calcolo spese detraibili");
		op7.setPreferredSize(new Dimension(290,70));
		op7.setMaximumSize(new Dimension(290,70));

		JButton op8 = new JButton("<html>" + twoLines2.replaceAll("\\n", "<br>") + "</html>");
		op8.setPreferredSize(new Dimension(290,70));
		op8.setMaximumSize(new Dimension(290,70));

		JButton op9 = new JButton("<html>" + twoLines3.replaceAll("\\n", "<br>") + "</html>");
		op9.setPreferredSize(new Dimension(290,70));
		op9.setMaximumSize(new Dimension(290,70));
		JButton op10 = new JButton("Elaborazione cedolini paghe");
		op10.setPreferredSize(new Dimension(290,70));
		op10.setMaximumSize(new Dimension(290,70));

		JButton op11 = new JButton("<html>" + twoLines4.replaceAll("\\n", "<br>") + "</html>");
		op11.setPreferredSize(new Dimension(290,70));
		op11.setMaximumSize(new Dimension(290,70));

		JButton op12 = new JButton("<html>" + twoLines5.replaceAll("\\n", "<br>") + "</html>");
		op12.setPreferredSize(new Dimension(290,70));
		op12.setMaximumSize(new Dimension(290,70));
		JButton op13 = new JButton("Registrazione cliente");
		op13.setPreferredSize(new Dimension(290,70));
		op13.setMaximumSize(new Dimension(290,70));

		JButton op14 = new JButton("Registrazione fatture A / V");
		op14.setPreferredSize(new Dimension(290,70));
		op14.setMaximumSize(new Dimension(290,70));

		JButton op15 = new JButton("Registrazione acquisti");
		op15.setPreferredSize(new Dimension(290,70));
		op15.setMaximumSize(new Dimension(290,70));

		JButton op16 = new JButton("Registrazione vendite");
		op16.setPreferredSize(new Dimension(290,70));
		op16.setMaximumSize(new Dimension(290,70));

		JButton op17 = new JButton("Registrazione pagamenti fornitori");
		op17.setPreferredSize(new Dimension(290,70));
		op17.setMaximumSize(new Dimension(290,70));

		JButton op18 = new JButton("<html>" + twoLines6.replaceAll("\\n", "<br>") + "</html>");
		op18.setPreferredSize(new Dimension(290,70));
		op18.setMaximumSize(new Dimension(290,70));
		JButton op19 = new JButton("Inserimento fabbricati e terreni");
		op19.setPreferredSize(new Dimension(290,70));
		op19.setMaximumSize(new Dimension(290,70));

		JButton op20 = new JButton("<html>" + twoLines7.replaceAll("\n", "<br>") + "</html>");
		op20.setPreferredSize(new Dimension(290,70));
		op20.setMaximumSize(new Dimension(290,70));

		JButton op21 = new JButton("<html>" + twoLines8.replaceAll("\n", "<br>") + "</html>");
		op21.setPreferredSize(new Dimension(290,70));
		op21.setMaximumSize(new Dimension(290,70));

		JButton op22 = new JButton("Inserimento contributi");
		op22.setPreferredSize(new Dimension(290,70));
		op22.setMaximumSize(new Dimension(290,70));

		JButton op23 = new JButton("Cancellazione cliente da uno studio");
		op23.setPreferredSize(new Dimension(290,70));
		op23.setMaximumSize(new Dimension(290,70));

		JButton op24 = new JButton("<html>" + twoLines9.replaceAll("\n", "<br>") + "</html>");
		op24.setPreferredSize(new Dimension(290,70));
		op24.setMaximumSize(new Dimension(290,70));
		
		panel.add(op1);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op2);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op3);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op4);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op5);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op6);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op7);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op8);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op9);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op10);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op11);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op12);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op13);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op14);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op15);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op16);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op17);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op18);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op19);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op20);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op21);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op22);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op23);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op24);
		panel.add(Box.createVerticalStrut(10));
		
		
		panel2.add(output);
	
		
		add(scrollbar);
		//add(panel);
		add(panel2);	
	}
	
	

}
