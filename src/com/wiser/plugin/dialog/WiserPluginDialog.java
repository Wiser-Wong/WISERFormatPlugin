package com.wiser.plugin.dialog;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wiser.plugin.InflateClass;

import javax.swing.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.lang.*;

/**
 * @author Wiser
 * 
 *         插件弹窗
 */
public class WiserPluginDialog extends JDialog {

	private JPanel				contentPane;

	private JButton				buttonOK;

	private JButton				buttonCancel;

	private JTextField			textClassName;

	private ButtonGroup			group;

	private JRadioButton		radioButtonView;

	private JRadioButton		radioButtonAdapter;

	private JRadioButton		radioButtonService;

	private JComboBox<String>	comboBoxExpand;

	private JCheckBox 			checkBoxIsBiz;

	private String				selectExpandClassName	= "WISERActivity";

	private int					type 					= -1;

	private final String[]		views					= new String[] { "WISERActivity", "WISERFragment", "WISERDialogFragment" };

	private final String[]		adapters				= new String[] { "WISERRVAdapter" };

	private final String[]		services				= new String[] { "WISERService" };

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

			@Override public void actionPerformed(ActionEvent actionEvent) {
				switchClassType(0);
			}
		});

		radioButtonAdapter.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent actionEvent) {
				switchClassType(1);
			}
		});

		radioButtonService.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent actionEvent) {
				switchClassType(2);
			}
		});

		checkBoxIsBiz.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent actionEvent) {
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
		switch (type){
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
//		Enumeration<AbstractButton> radioButtons = group.getElements();
//		while (radioButtons.hasMoreElements()) {
//			JRadioButton jr = (JRadioButton) radioButtons.nextElement();
//			if (jr.isSelected()) {
//				JOptionPane.showMessageDialog(null, "填写的类名是：" + textClassName.getText() + "选择的类型是:" + jr.getText() + "选择继承类是：" + selectExpandClassName);
//			}
//		}

		new InflateClass(event).writeAction(textClassName.getText(),(selectExpandClassName == views[0] ? 1 : selectExpandClassName == views[1] ? 2 : selectExpandClassName == views[2] ? 3 : selectExpandClassName == adapters[0] ? 4 : selectExpandClassName == services[0] ? 5 : 1), checkBoxIsBiz.isSelected());

		dispose();

	}

	// 取消
	private void onCancel() {
		dispose();
	}

	public static void showPluginDialog(AnActionEvent event) {
		WiserPluginDialog dialog = new WiserPluginDialog(event);
//		dialog.setSize(340, 220);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
