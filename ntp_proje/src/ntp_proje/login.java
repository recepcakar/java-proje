package ntp_proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_kullaniciadi;
	private JTextField txt_sifre;

	private static final String url = "jdbc:sqlserver://RecepsLenovo:1433;databaseName=j_proje;encrypt=true;trustServerCertificate=true";
	private static final String user = "sa";
	private static final String sifre = "300322";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));

		setContentPane(contentPane);

		JLabel lbl_kullanıcıad = new JLabel("Kullanıcı adı :");
		lbl_kullanıcıad.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLabel lbl_sifre = new JLabel("Şifre :");
		lbl_sifre.setFont(new Font("Tahoma", Font.BOLD, 17));

		JButton btn_giris = new JButton("Giris");
		btn_giris.setFont(new Font("Stencil", Font.BOLD, 20));
		btn_giris.setForeground(new Color(255, 128, 0));
		btn_giris.addActionListener(e -> authenticateUser());

		txt_kullaniciadi = new JTextField();
		txt_kullaniciadi.setColumns(10);

		txt_sifre = new JTextField();
		txt_sifre.setColumns(10);

		JLabel lbl_kullanıcıad_1 = new JLabel("KULLANICI GİRİSİ");
		lbl_kullanıcıad_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(80)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lbl_kullanıcıad_1)
								.addComponent(btn_giris)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lbl_kullanıcıad).addComponent(lbl_sifre))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(txt_kullaniciadi, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_sifre, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(394, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(19).addComponent(lbl_kullanıcıad_1).addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_kullaniciadi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_kullanıcıad))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_sifre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_sifre))
						.addGap(34).addComponent(btn_giris).addContainerGap(76, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		/*
		 * EĞER DOĞRU İSE contentPane.setLayout(gl_contentPane);
		 * 
		 * }); btn_giris.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { // İkinci pencereyi oluştur otopark
		 * secondWindow = new otopark(); secondWindow.setVisible(true); // İkinci
		 * pencereyi aç }
		 */
	}

	private void authenticateUser() {
		String username = txt_kullaniciadi.getText();
		String password = txt_sifre.getText();

		// SQL sorgusunu kullanarak veritabanından kullanıcıyı kontrol et
		String query = "SELECT kullaniciadi,sifre FROM kullanicigiris WHERE kullaniciadi = ? AND sifre = ?";

		try (Connection connection = DriverManager.getConnection(url, user, sifre);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Eğer giriş başarılıysa ikinci ekrana geçiş yap
				JOptionPane.showMessageDialog(this, "Giriş başarılı!");
				new otopark().setVisible(true); // İkinci ekranı aç
				this.setVisible(false); // İlk ekranı kapat
			} else {
				JOptionPane.showMessageDialog(null, "Geçersiz kullanıcı adı veya şifre.", "Hata",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Veritabanı hatası: " + e.getMessage(), "Hata",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
