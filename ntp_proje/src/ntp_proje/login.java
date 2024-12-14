package ntp_proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_kullaniciadi;
	private JTextField txt_sifre;

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
		
		txt_kullaniciadi = new JTextField();
		txt_kullaniciadi.setColumns(10);
		
		txt_sifre = new JTextField();
		txt_sifre.setColumns(10);
		
		JLabel lbl_kullanıcıad_1 = new JLabel("KULLANICI GİRİSİ");
		lbl_kullanıcıad_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(137)
					.addComponent(lbl_kullanıcıad_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(430))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(lbl_sifre, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addComponent(lbl_kullanıcıad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_giris, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_kullaniciadi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_sifre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(468, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lbl_kullanıcıad_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_kullanıcıad, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_kullaniciadi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_sifre, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_sifre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btn_giris, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(59, Short.MAX_VALUE))
		);
	/*	 
	 * EĞER DOĞRU İSE 
        contentPane.setLayout(gl_contentPane);
		btn_giris.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // İkinci pencereyi oluştur
		        otopark secondWindow = new otopark();
		        secondWindow.setVisible(true);  // İkinci pencereyi aç   
		    }
		});                                       */
	}
}
