package ntp_proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class cikis extends JFrame {
	private static final String url = "jdbc:sqlserver://:1433;databaseName=j_proje;encrypt=true;trustServerCertificate=true";
	private static final String user = "";
	private static final String sifre = "";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_Plaka;
    public double ucret;
    public String getirilenplaka; // kayıt getirme sonrasında textbox değiştiğinde eski getirilen kaydı sileriz 
    private JTextField txtTutar;
    private JTextField txt_engel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cikis frame = new cikis();
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
	public cikis() {
		setResizable(false);
		setTitle("cikis");
		setIconImage(Toolkit.getDefaultToolkit().getImage(cikis.class.getResource("/images/Apps-system-software-update-icon.png")));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btn_ucret = new JButton("ÜCRET HESAPLA");
		btn_ucret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			kayitgetir();
			}
		});

		JButton btn_CİK = new JButton("ÜCRET ÖDENDİ");
		btn_CİK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullanicisil();
			}
		});

		txt_Plaka = new JTextField();
		txt_Plaka.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Plaka.setText("PLAKA");
		txt_Plaka.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("=>");
		
		txtTutar = new JTextField();
		txtTutar.setText("TUTAR");
		txtTutar.setHorizontalAlignment(SwingConstants.CENTER);
		txtTutar.setColumns(10);
		
		txt_engel = new JTextField();
		txt_engel.setText("EngelDurumu");
		txt_engel.setHorizontalAlignment(SwingConstants.CENTER);
		txt_engel.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txt_Plaka, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(btn_ucret, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_engel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTutar, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addGap(50))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(123)
					.addComponent(btn_CİK, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
					.addGap(153))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_Plaka, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_engel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_ucret)
						.addComponent(lblNewLabel)
						.addComponent(txtTutar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(btn_CİK)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
	
	}
	
	 
	public  boolean kayitgetir() {
	
		String query = "SELECT engeldurumu , DATEDIFF(MINUTE, GirisTarihi, GETDATE())  FROM TableCar where plaka=?";
		String plaka1 = txt_Plaka.getText();
		getirilenplaka =plaka1;
		try (Connection connection = DriverManager.getConnection(url, user, sifre);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, plaka1);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				   String engelDurumu = resultSet.getString(1);
				   txt_engel.setText(engelDurumu);
				   int saat =(resultSet.getInt(2))/(60);
				   ucrethesapla(engelDurumu,saat+1);
					String ucretStr = Double.toString(ucret);
				   txtTutar.setText(ucretStr);
				
				return false;
			} else {
				JOptionPane.showMessageDialog(null, "araba içeride değil", "bilgi", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}

		} catch (SQLException e) {
			// Hata yönetimi
			e.printStackTrace();
		}
		return true;
	}
	public void kayitbilgilerigetir() 
	{
		
		
	}
	
		
	
	public void ucrethesapla(String engeldurumu,int saat) {
	    int saat1=saat;
	    if ("engelli".equals(engeldurumu)) {
	        ucret = 0.85 * hesapla(saat1);
	    }

		else {
			ucret =hesapla(saat1);
		}
	
	}
	public int hesapla(int saat) {
		if( saat>0 && saat <=1 ) {
			return 100;
		}
		else if(saat>1 && saat<=2) {
			return 180;
		}
		else if(saat>2 &&saat<=3) {
			return  250;
		}
		else {
			return 250+(saat-3)*50;
		}
	}
	
		 public void kullanicisil() {
			 String query = "delete from TableCar where plaka=?";
			 String plaka=getirilenplaka;
			 try (Connection connection = DriverManager.getConnection(url, user, sifre);
			         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			        // Plaka parametresini sorguya ekleyin
			        preparedStatement.setString(1, plaka);

			        // Sorguyu çalıştırın (silme işlemi)
			        int rowsAffected = preparedStatement.executeUpdate();

			        // İşlemin başarılı olup olmadığını kontrol et
			        if (rowsAffected > 0) {
			            JOptionPane.showMessageDialog(null, "Kayıt başarıyla silindi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
			        } else {
			            JOptionPane.showMessageDialog(null, "Kayıt bulunamadı.", "Hata", JOptionPane.ERROR_MESSAGE);
			        }

			    } catch (SQLException e) {
			        // Hata yönetimi
			        e.printStackTrace();
			        JOptionPane.showMessageDialog(null, "Bir hata oluştu: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
			    }
			}
}
