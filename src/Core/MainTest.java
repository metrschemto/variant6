package Core;

import static org.junit.Assert.assertEquals;
import javax.swing.*;
import Classes.Product;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
	private JPanel myPanel;

	@Before
	public void setUp() {
		myPanel = new Main().mainPanel;
	}

	@Test
	public void testComboBoxAndCheckBox() {
		JComboBox<Product> comboBox = (JComboBox<Product>) myPanel.getComponent(1);
		comboBox.setSelectedIndex(1);
		
		JTextField textField = (JTextField) myPanel.getComponent(3);
		textField.setText("50");

		JCheckBox checkBox = (JCheckBox) myPanel.getComponent(6);
		checkBox.setSelected(true);

		JButton button = (JButton) myPanel.getComponent(13);
		button.doClick();

		JLabel label = (JLabel) myPanel.getComponent(14);
		assertEquals("Стоимость уборки составит: 18226,00 рублей", label.getText());
	}
}