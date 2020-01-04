package com.wiser.plugin.dialog;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.wiser.plugin.InflateClass;

import javax.swing.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.lang.*;

/**
 * @author Wiser
 * <p>
 * 插件弹窗
 */
public class WiserPluginDialog extends JDialog {

	private JPanel contentPane;

	private JButton buttonOK;

	private JButton buttonCancel;

	private JTextField textClassName;

	private ButtonGroup group;

	private JRadioButton radioButtonView;

	private JRadioButton radioButtonAdapter;

	private JRadioButton radioButtonService;

	private JComboBox comboBoxExpand;

	private JCheckBox checkBoxIsBiz;

	private String selectExpandClassName = "WISERActivity";

	private int type = -1;

	private final String[] views = new String[]{"WISERActivity", "WISERFragment", "WISERDialogFragment"};

	private final String[] adapters = new String[]{"WISERRVAdapter"};

	private final String[] services = new String[]{"WISERService"};

	private AnActionEvent event;

	public WiserPluginDialog(AnActionEvent event) {
		this.event = event;
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);

		// 单选框View和Adapter
		group = new ButtonGroup();
		radioButtonView.setSelected(true);
		group.add(radioButtonView);
		group.add(radioButtonAdapter);
		group.add(radioButtonService);

		// 默认下拉窗View
		switchClassType(0);

		radioButtonView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				switchClassType(0);
			}
		});

		radioButtonAdapter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				switchClassType(1);
			}
		});

		radioButtonService.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				switchClassType(2);
			}
		});

		checkBoxIsBiz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
			}
		});

		comboBoxExpand.addItemListener(new java.awt.event.ItemListener() {

			public void itemStateChanged(ItemEvent itemEvent) {
				selectExpandClassName = (String) itemEvent.getItem();
			}
		});

		buttonOK.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				onOK();
			}
		});

		buttonCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		});

		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});

		// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

	}

	// 切换单选按钮下拉窗替换数据
	private void switchClassType(int type) {
		if (this.type == type) return;
		this.type = type;
		comboBoxExpand.removeAllItems();
		switch (type) {
			case 0:// view
				checkBoxIsBiz.setVisible(true);
				for (String view : views) {
					comboBoxExpand.addItem(view);
				}
				break;
			case 1:// adapter
				checkBoxIsBiz.setVisible(false);
				for (String view : adapters) {
					comboBoxExpand.addItem(view);
				}
				break;
			case 2:// service
				checkBoxIsBiz.setVisible(true);
				for (String view : services) {
					comboBoxExpand.addItem(view);
				}
				break;
		}
	}

	// 确定
	private void onOK() {
		if (textClassName == null || textClassName.getText() == null || "".equals(textClassName.getText())) {
			JOptionPane.showMessageDialog(null, "请填写要创建的类名");
			return;
		}
		// Enumeration<AbstractButton> radioButtons = group.getElements();
		// while (radioButtons.hasMoreElements()) {
		// JRadioButton jr = (JRadioButton) radioButtons.nextElement();
		// if (jr.isSelected()) {
		// JOptionPane.showMessageDialog(null, "填写的类名是：" + textClassName.getText() +
		// "选择的类型是:" + jr.getText() + "选择继承类是：" + selectExpandClassName);
		// }
		// }

		new InflateClass(event).writeAction(textClassName.getText(),
				(selectExpandClassName == views[0] ? 1
						: selectExpandClassName == views[1] ? 2 : selectExpandClassName == views[2] ? 3 : selectExpandClassName == adapters[0] ? 4 : selectExpandClassName == services[0] ? 5 : 1),
				checkBoxIsBiz.isSelected());

		dispose();

	}

	// 取消
	private void onCancel() {
		dispose();
	}

	public static void showPluginDialog(AnActionEvent event) {
		WiserPluginDialog dialog = new WiserPluginDialog(event);
		// dialog.setSize(340, 220);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		contentPane = new javax.swing.JPanel();
		contentPane.setLayout(new GridLayoutManager(4, 2, new java.awt.Insets(15, 15, 15, 15), -1, -1));
		final javax.swing.JPanel panel1 = new javax.swing.JPanel();
		panel1.setLayout(new GridLayoutManager(1, 1, new java.awt.Insets(10, 0, 0, 0), -1, -1));
		contentPane.add(panel1, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
		final javax.swing.JPanel panel2 = new javax.swing.JPanel();
		panel2.setLayout(new GridLayoutManager(1, 4, new java.awt.Insets(0, 0, 0, 0), -1, -1));
		panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		buttonOK = new javax.swing.JButton();
		panel2.add(buttonOK, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		buttonCancel = new javax.swing.JButton();
		panel2.add(buttonCancel, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		checkBoxIsBiz = new javax.swing.JCheckBox();
		panel2.add(checkBoxIsBiz, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final Spacer spacer1 = new Spacer();
		panel2.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		final javax.swing.JPanel panel3 = new javax.swing.JPanel();
		panel3.setLayout(new GridLayoutManager(1, 4, new java.awt.Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel3, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final javax.swing.JLabel label1 = new javax.swing.JLabel();
		panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		textClassName = new javax.swing.JTextField();
		panel3.add(textClassName, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new java.awt.Dimension(150, -1), null, 0, false));
		final javax.swing.JPanel panel4 = new javax.swing.JPanel();
		panel4.setLayout(new GridLayoutManager(1, 4, new java.awt.Insets(10, 0, 0, 0), -1, -1));
		contentPane.add(panel4, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final javax.swing.JLabel label2 = new javax.swing.JLabel();
		panel4.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		radioButtonView = new javax.swing.JRadioButton();
		panel4.add(radioButtonView, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		radioButtonAdapter = new javax.swing.JRadioButton();
		panel4.add(radioButtonAdapter, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		radioButtonService = new javax.swing.JRadioButton();
		panel4.add(radioButtonService, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final javax.swing.JPanel panel5 = new javax.swing.JPanel();
		panel5.setLayout(new GridLayoutManager(1, 2, new java.awt.Insets(10, 0, 0, 0), -1, -1));
		contentPane.add(panel5, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final javax.swing.JLabel label3 = new javax.swing.JLabel();
		panel5.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		comboBoxExpand = new javax.swing.JComboBox();
		panel5.add(comboBoxExpand, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}

	/**
	 * @noinspection ALL
	 */
	public javax.swing.JComponent $$$getRootComponent$$$() {
		return contentPane;
	}

}
