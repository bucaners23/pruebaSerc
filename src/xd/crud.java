package xd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class crud {

	private JFrame frmCelular;
	private JTextField txtId;
	private JTextField txtMar;
	private JTextField txtMod;
	private JTextField txtSis;
	private JTextField txtPro;
	private JButton btnBor;
	private JButton btnEliminar;
	private JButton btnIns;
	private JButton btnCargar;
	private JButton btnActualizar;
	datacelular cel = new datacelular();

	public static void main(String[] args) {
		crud x = new crud();
		x.frmCelular.setVisible(true);
	}

	public crud() {
		initialize();
	}

	private void initialize() {
		frmCelular = new JFrame();
		frmCelular.setIconImage(Toolkit.getDefaultToolkit().getImage(crud.class.getResource("/xd/6073873.png")));
		frmCelular.setTitle("CELULAR");
		frmCelular.setBounds(100, 100, 571, 330);
		frmCelular.setLocationRelativeTo(null);
		frmCelular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCelular.getContentPane().setLayout(null);

		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(21, 57, 100, 28);
		frmCelular.getContentPane().add(lblId);

		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtId.getText().length() > 11) {
					e.consume();
				}
			}
		});
		txtId.setBounds(148, 63, 139, 20);
		frmCelular.getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(21, 96, 100, 28);
		frmCelular.getContentPane().add(lblMarca);

		txtMar = new JTextField();
		txtMar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtMar.getText().length() > 50) {
					e.consume();
				}
			}
		});
		txtMar.setColumns(10);
		txtMar.setBounds(148, 102, 139, 20);
		frmCelular.getContentPane().add(txtMar);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModelo.setBounds(21, 138, 100, 28);
		frmCelular.getContentPane().add(lblModelo);

		txtMod = new JTextField();
		txtMod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtMod.getText().length() > 50) {
					e.consume();
				}
			}
		});
		txtMod.setColumns(10);
		txtMod.setBounds(148, 144, 139, 20);
		frmCelular.getContentPane().add(txtMod);

		JLabel lblSistema = new JLabel("Sistema");
		lblSistema.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSistema.setBounds(21, 185, 100, 28);
		frmCelular.getContentPane().add(lblSistema);

		txtSis = new JTextField();
		txtSis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtSis.getText().length() > 50) {
					e.consume();
				}
			}
		});
		txtSis.setColumns(10);
		txtSis.setBounds(148, 191, 139, 20);
		frmCelular.getContentPane().add(txtSis);

		JLabel lblProcesador = new JLabel("Procesador");
		lblProcesador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProcesador.setBounds(21, 224, 100, 28);
		frmCelular.getContentPane().add(lblProcesador);

		txtPro = new JTextField();
		txtPro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPro.getText().length() > 50) {
					e.consume();
				}
			}
		});
		txtPro.setColumns(10);
		txtPro.setBounds(148, 230, 139, 20);
		frmCelular.getContentPane().add(txtPro);

		btnIns = new JButton("Insertar");
		btnIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					datacelular c = new datacelular();
					c.setId(Integer.parseInt(txtId.getText()));
					c.setMarca(txtMar.getText());
					c.setModelo(txtMod.getText());
					c.setSistema(txtSis.getText());
					c.setProcesador(txtPro.getText());
					if (c.insertar()) {
						JOptionPane.showMessageDialog(null, "Ok");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnIns.setBounds(315, 85, 89, 23);
		frmCelular.getContentPane().add(btnIns);

		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(JOptionPane.showInputDialog("ID a cargar"));
					cel.setId(id);
					if (cel.cargar()) {
						txtId.setText("" + cel.getId());
						txtMar.setText(cel.getMarca());
						txtMod.setText(cel.getModelo());
						txtPro.setText(cel.getProcesador());
						txtSis.setText(cel.getSistema());
						JOptionPane.showMessageDialog(null, "SE CARGO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "Error 404");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error 404");
				}
			}
		});
		btnCargar.setBounds(429, 85, 89, 23);
		frmCelular.getContentPane().add(btnCargar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(JOptionPane.showInputDialog("ID a cargar"));
					cel.setId(id);
					if (cel.eliminar()) {
						JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "Error 404");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error 404");
				}
			}
		});
		btnEliminar.setBounds(315, 119, 89, 23);
		frmCelular.getContentPane().add(btnEliminar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cel.setId(Integer.parseInt(txtId.getText()));
					cel.setMarca(txtMar.getText());
					cel.setModelo(txtMod.getText());
					cel.setSistema(txtSis.getText());
					cel.setProcesador(txtPro.getText());
					if (cel.actualizar()) {
						JOptionPane.showMessageDialog(null, "Ok");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnActualizar.setBounds(429, 119, 89, 23);
		frmCelular.getContentPane().add(btnActualizar);

		btnBor = new JButton("Borrar");
		btnBor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}

			public void limpiar() {
				txtId.setText("");
				txtMar.setText("");
				txtMod.setText("");
				txtPro.setText("");
				txtSis.setText("");

			}
		});
		btnBor.setBounds(315, 153, 89, 23);
		frmCelular.getContentPane().add(btnBor);
	}
}
