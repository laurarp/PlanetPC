import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FormEliminarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private AuxiliarAlmacenamiento auxiliar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEliminarProducto frame = new FormEliminarProducto();
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
	public FormEliminarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(280, 0, 170, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setBounds(174, 500, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(198, 497, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		String titulos[] = { "Id ", "Precio", "Tipo", "Garantia", "Marca",
		"Modelo" };
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		table = new JTable(tableModel);
		try {
			auxiliar = new AuxiliarAlmacenamiento("1004s","Pepito","pepito1309");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean intentar2=true;
				if (textField.getText().isEmpty()){
					intentar2 = false;
					JOptionPane.showMessageDialog(contentPane, "No ha ingresado el id del producto para eliminar");
				}
				if (intentar2==true){
				try {
					auxiliar.eliminarProductoCatalogo(textField.getText());
				} catch (Excepciones e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e1.getMessage());
				}
				textField.setText("");
				}
			}
			});
			btnNewButton.setBounds(293, 496, 89, 23);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Cerrar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			btnNewButton_1.setBounds(619, 496, 89, 23);
			contentPane.add(btnNewButton_1);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 34, 698, 455);
			contentPane.add(scrollPane);
			scrollPane.setViewportView(table);
			
			JButton btnMostrar = new JButton("Mostrar");
			btnMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<DescripcionProducto> catalogo = null;

					int rowCount = table.getRowCount();

					for (int i = rowCount - 1; i >= 0; i--) {
						tableModel.removeRow(i);
					}

					try {
						catalogo = auxiliar.mostrarCatalogo();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

					if (catalogo != null) {
						for (int i = 0; i < catalogo.size(); i++) {
							String id = catalogo.get(i).getId();
							String precioVenta = String.valueOf(catalogo.get(i).getPrecioVenta());
							String tipo = catalogo.get(i).getTipo();
							String garantia = String.valueOf(catalogo.get(i).getDiasGarantia());
							String marca = catalogo.get(i).getMarca();
							String modelo = String.valueOf(catalogo.get(i).getModelo());
							
							Object[] objs = { id, precioVenta, tipo, garantia, marca, modelo };
							tableModel.addRow(objs);
						}
					} else {
						JOptionPane.showMessageDialog(null, "no hay productos en el catalogo");
					}
				}		
			});
			btnMostrar.setBounds(10, 496, 89, 23);
			contentPane.add(btnMostrar);
		
	}
}
