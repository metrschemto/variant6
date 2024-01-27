package Core;

import javax.swing.*;
import javax.swing.JOptionPane;

import Classes.AdditionalServices;
import Classes.Application;
import Classes.Product;
import Classes.Rate;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

	public JPanel mainPanel;
	private JTextField areaTextField;
	private JButton calculateButton;
	private JButton clearButton;
	private JLabel resultLabel;

	public Main() {
		setTitle("Калькулятор клининговых услуг");
		setSize(370, 320);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		add(mainPanel);

		Product eco_tariff = new Rate(135.50, "Экономный");
		Product bussines_tariff = new Rate(352.52, "Бизнес");
		Product vip_tariff = new Rate(1000, "VIP");

		ArrayList<Product> objectsList = new ArrayList<>();
		objectsList.add(eco_tariff);
		objectsList.add(bussines_tariff);
		objectsList.add(vip_tariff);

		DefaultComboBoxModel<Product> comboBoxModel = new DefaultComboBoxModel<>();
		for (Product obj : objectsList) {
			comboBoxModel.addElement(obj);
		}

		JComboBox<Product> comboBox = new JComboBox<>(comboBoxModel);
		mainPanel.add(new JLabel("Выберите тариф:"));
		mainPanel.add(comboBox);

		areaTextField = new JTextField(10);
		areaTextField.setText("0");
		areaTextField.setName("Area");
		mainPanel.add(new JLabel("Площадь офиса (в кв. м.):"));
		mainPanel.add(areaTextField);
		

		Product services1 = new AdditionalServices(500, "Уборка ванн и туалетов");
		Product services2 = new AdditionalServices(600, "Чистка ковров");
		Product services3 = new AdditionalServices(750, "Мойка окон");
		Product services4 = new AdditionalServices(450, "Дезинфекция");
		Product services5 = new AdditionalServices(1000, "Уборка после ремонта");
		Product services6 = new AdditionalServices(800, "Чистка мебели");
		Product services7 = new AdditionalServices(400, "Уборка кухни");
		Product services8 = new AdditionalServices(450, "Уборка вентиляционных систем");

		List<Product> services = new ArrayList<>();

		services.add(services1);
		services.add(services2);
		services.add(services3);
		services.add(services4);
		services.add(services5);
		services.add(services6);
		services.add(services7);
		services.add(services8);

		mainPanel.add(new JLabel("Выберите дополнительные услуги:"));
		List<JCheckBox> checkBoxes = new ArrayList<>();
		for (Product service : services) {
			JCheckBox checkBox = new JCheckBox(service.toString());
			checkBoxes.add(checkBox);
			mainPanel.add(checkBox);
		}

		calculateButton = new JButton("Рассчитать");
		calculateButton.setName("Callculate");
		mainPanel.add(calculateButton);

		resultLabel = new JLabel("");
		resultLabel.setName("Result");
		mainPanel.add(resultLabel);

		clearButton = new JButton("Очистить");
		
		mainPanel.add(clearButton);
		clearButton.setVisible(false);
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText("");
				areaTextField.setText("");
				clearButton.setVisible(false);
				comboBox.setSelectedIndex(0);
				for (JCheckBox checkBox : checkBoxes) {
					checkBox.setSelected(false); // Сбрасываем все чекбоксы
				}
			}
		});

		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Product Rate = (Product) comboBox.getSelectedItem();
				try {
					double area = Double.parseDouble(areaTextField.getText());
					if (Rate != null) {
						if (area > 0) {
							ArrayList<Product> selectedServices = new ArrayList<>();
							for (int i = 0; i < checkBoxes.size(); i++) {
								if (checkBoxes.get(i).isSelected()) {
									selectedServices.add(services.get(i));
								}
							}
							Application newApplic = new Application(area, Rate, selectedServices);
							double price = newApplic.Calculate();
							String nprice = String.format("%.2f", price);
							resultLabel.setText("Стоимость уборки составит: " + nprice + " рублей");
							Color greenColor = new Color(14, 209, 69);
							resultLabel.setForeground(greenColor);
							clearButton.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Произошла ошибка! Площадь должна быть больше 0 кв/м",
									"Ошибка", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Произошла ошибка!", "Ошибка", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Произошла ошибка! Площадь должна быть указана как число!!!",
							"Ошибка", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

}