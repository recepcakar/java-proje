package ntp_proje;

import java.awt.EventQueue;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class kayit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_Plaka;

	private static final String url = "jdbc:sqlserver://:1433;databaseName=j_proje;encrypt=true;trustServerCertificate=true";
	private static final String user = "";
	private static final String sifre = "";
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kayit frame = new kayit();
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
	public kayit() {
		setTitle("ADD");
		setIconImage(Toolkit.getDefaultToolkit().getImage(kayit.class.getResource("/images/folder-applications-icon.png")));
		setResizable(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setForeground(new Color(50, 205, 50));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 0));
		contentPane.setForeground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JCheckBox check_Engel = new JCheckBox("ENGELLİ");

		txt_Plaka = new JTextField();
		txt_Plaka.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Plaka.setText("PLAKA");
		txt_Plaka.setColumns(10);

		JButton btn_ekle = new JButton("EKLE");
		btn_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean kontrol = check_Engel.isSelected();
				ekle(kontrol); // ekle methodunu çalıştırıyoruz
				dispose(); // EN SON EKRANI KAPATIYORUZ NEDENİ İLK BAŞTA YAPMAMIŞTIM EKRAN AÇIK KALIP ARABA EKLEDİĞİMDE
				//YENİ KAYIT TUŞUNA BASMADIĞIM İÇİN COUNT ARTMIYORDU DAHA GÜZEL ÇÖZÜMLER DE BULUNABİLİRDİ BEN BUNU YAPTIM
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(138)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(check_Engel)
								.addComponent(txt_Plaka, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ekle))
						.addContainerGap(192, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(55)
						.addComponent(txt_Plaka, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(14).addComponent(check_Engel).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btn_ekle).addContainerGap(117, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	public void ekle(boolean kotnrol) {
		String query = "insert into TableCar (plaka,engeldurumu)values(?,?)"; //SORGUMUZU ÇALIŞTIRDIK
		String plaka = txt_Plaka.getText();
		String engeldurumu;
		if (kotnrol) { // CHECKBOX İŞARETLİ İSE ENGELLİ YAZDIRIYORUZ 
			engeldurumu = "engelli";
		} else {
			engeldurumu = "engelsiz";

		}
		boolean arabavarmi = plakavarmi(plaka); // PLAKA VAR MI METHODUNU ÇALIŞTIRDIK
		if (arabavarmi) {
			try (Connection connection = DriverManager.getConnection(url, user, sifre);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, plaka);
				preparedStatement.setString(2, engeldurumu);
				int rowsInserted = preparedStatement.executeUpdate();
				if (rowsInserted > 0) { //EKLEME İŞLEMİ BAŞARILI İSE BURAYA GİRİCEK
					JOptionPane.showMessageDialog(null, "kayıt eklendi.", "bilgi", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e) {
				// Hata yönetimi
				e.printStackTrace();
			}
		}
	}

	public boolean plakavarmi(String plaka) {
		String query = "select plaka from TableCar where plaka=?";
		String plaka1 = plaka;

		try (Connection connection = DriverManager.getConnection(url, user, sifre);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, plaka1);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				JOptionPane.showMessageDialog(null, "araba zaten içeride", "bilgi", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			// Hata yönetimi
			e.printStackTrace();
		}
		return true;
	}

}
