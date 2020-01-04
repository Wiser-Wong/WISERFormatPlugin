package com.wiser.plugin.action;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.wiser.plugin.dialog.WiserPluginDialog;

/**
 * @author Wiser
 * 
 *         Action
 */
public class WISERAction extends AnAction {

	WISERAction() {
		super("Wiser Format Class");
	}

	@java.lang.Override public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
		WiserPluginDialog.showPluginDialog(anActionEvent);
	}
}
