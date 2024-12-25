package ntp_proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class otopark extends JFrame {

	private static final String url = "jdbc:sqlserver://RecepsLenovo:1433;databaseName=j_proje;encrypt=true;trustServerCertificate=true";
	private static final String user = "sa";
	private static final String password = "300322";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					otopark frame = new otopark();
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
	public otopark() {
		setForeground(new Color(255, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(otopark.class.getResource("/images/Apps-counter-strike-icon.png")));
		setTitle("CS 1.6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 617);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(51, 153, 102));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(otopark.class.getResource("/images/1.png")));

		JButton btn_sorgu = new JButton("YER SORGULAMA");
		btn_sorgu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorgu(); // sorgu methody çalışır
				if (count < 17) {
					JOptionPane.showMessageDialog(null, (17 - count) + " tane boş yer vardır ", "Bilgi",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "boş yer yoktur", "Bilgi", JOptionPane.ERROR_MESSAGE);
				} 
				// ilk sorgu methodunda tanımlamıştım fakat bu sefer yeni kayıt ekranındayken countu saymıyordu
			}
		});
	
		btn_sorgu.setBackground(new Color(255, 204, 0));

		JButton btn_kayit = new JButton("YENİ KAYIT");
		btn_kayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yenikayit(); // yenikayıt methodu calısıyor
			}
		});
		btn_kayit.setBackground(new Color(102, 204, 51));

		JButton btn_cikis = new JButton("ÇIKIŞ");
		btn_cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cikis(); // cikis methodu çalışıyor
			}
		});
		btn_cikis.setBackground(new Color(204, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("ÜCRET TARİFELERİ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_2 = new JLabel("");

		JLabel lblNewLabel_3 = new JLabel("0-1 SAAT 100TL");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_3_1 = new JLabel("0-2 SAAT 180TL");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_3_2 = new JLabel("0-3 SAAT 250TL");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_3_3 = new JLabel(" >3 =>SAAT*50TL +100");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_4 = new JLabel("ENGELLİLERE %15 ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNewLabel_4_1 = new JLabel("İNDİRİM! ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(btn_sorgu, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(btn_kayit, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(btn_cikis, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 736, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3_3)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_sorgu, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_kayit, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_cikis, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public static int count; // count değerini class parantezzinde belirtiyoruz sonradan erişebilmek adına

	public static void sorgu() {  // sorgu butonuna tıklayınca açılan method

		String query = "Select COUNT(*) From TableCar"; // sql sorgumuz 
		try (Connection connection = DriverManager.getConnection(url, user, password); //önceki sayfada belirttiğim baplantı testimiz
				Statement statement = connection.createStatement();   //sorgumuz basit olduğundan bu fonks kullanabiliriz
				ResultSet resultSet = statement.executeQuery(query)) { //az önceki sayfada belirttiğim 

			// Sonuçları işleme
			if (resultSet.next()) {
				count = resultSet.getInt(1); // COUNT(*) sonucu ilk sütunda bulunur
			}
			
		} catch (SQLException e) {
			e.printStackTrace();  
		}
	}

	public static void yenikayit() {
	   sorgu();
	   if(count<17) { 
		   
		new kayit().setVisible(true);  // otoparkımız 17 arabalık  eğer 17 arabayı geçmezse kayıt yapıyor
	
	    }
	   else {
		   JOptionPane.showMessageDialog(null, "boş yer yoktur", "Bilgi", JOptionPane.ERROR_MESSAGE);
	   }
   
	}

	public void cikis() {
		new cikis().setVisible(true);
		
	}
}
