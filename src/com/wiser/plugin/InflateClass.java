package com.wiser.plugin;

import com.intellij.ide.IdeView;
import com.intellij.ide.fileTemplates.JavaTemplateUtil;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;

import java.lang.*;

/**
 * @author Wiser
 * 
 *         创建类工具
 */
public class InflateClass {

	private Project			project;

	private AnActionEvent	event;

	public InflateClass(AnActionEvent event) {
		this.event = event;
		this.project = event.getProject();
	}

	// 根据代码创建类
	private void createClassFromCode(String className, int type, boolean isCreateBiz) throws Exception {
		// 获取鼠标选中的目录
		IdeView ideView = event.getRequiredData(LangDataKeys.IDE_VIEW);
		PsiDirectory directory = ideView.getOrChooseDirectory();
		PsiPackage psiPackage = JavaDirectoryService.getInstance().getPackage(directory);

		//创建Java类
		createJavaClassFromCode(psiPackage, directory, className, type, isCreateBiz);

		if (isCreateBiz)
			//创建Java业务类Biz
			createJavaBizClassFromCode(psiPackage, directory, className, type);

		if (type == 5) return;
		//同时创建xml布局
		createXmlFromCode(className,type);

	}

	// 根据代码创建Java类
	private void createJavaClassFromCode(PsiPackage psiPackage, PsiDirectory directory, String className, int type, boolean isCreateBiz) throws Exception {
		// 没有就创建一个，第一次使用代码字符串创建个类
		PsiFile javaFile = PsiFileFactory.getInstance(project).createFileFromText(
				className + (type == 1 ? "Activity" : type == 2 ? "Fragment" : type == 3 ? "DialogFragment" : type == 4 ? "Adapter" : type == 5 ? "Service" : "") + ".java", JavaFileType.INSTANCE,
				(type == 1 ? CodeTool.WISERActivityCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 2 ? CodeTool.WISERFragmentCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 3 ? CodeTool.WISERDialogFragmentCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 4 ? CodeTool.WISERRVAdapter(psiPackage.getQualifiedName(), className) : type == 5 ? CodeTool.WISERServiceCode(psiPackage.getQualifiedName(), className, isCreateBiz) : CodeTool.WISERActivityCode(psiPackage.getQualifiedName(), className, isCreateBiz)));
		PsiManager.getInstance(project).findDirectory(directory.getVirtualFile()).add(javaFile);

	}

	// 根据代码创建Java 业务类Biz
	private void createJavaBizClassFromCode(PsiPackage psiPackage, PsiDirectory directory, String className, int type) throws Exception {
		// Adapter 没有业务类
		if (type == 4) return;
		// 没有就创建一个，第一次使用代码字符串创建个类
		PsiFile javaFile = PsiFileFactory.getInstance(project).createFileFromText(
				className + (type == 1 ? "ActivityBiz" : type == 2 ? "FragmentBiz" : type == 3 ? "DialogFragmentBiz" : type == 5 ? "ServiceBiz" : "") + ".java", JavaFileType.INSTANCE,
				(type == 1 ? CodeTool.WISERActivityBizCode(psiPackage.getQualifiedName(), className)
						: type == 2 ? CodeTool.WISERFragmentBizCode(psiPackage.getQualifiedName(), className)
						: type == 3 ? CodeTool.WISERDialogFragmentBizCode(psiPackage.getQualifiedName(), className)
						: type == 5 ? CodeTool.WISERServiceBizCode(psiPackage.getQualifiedName(), className) : CodeTool.WISERActivityBizCode(psiPackage.getQualifiedName(), className)));
		PsiManager.getInstance(project).findDirectory(directory.getVirtualFile()).add(javaFile);

	}

	// 根据代码创建xml
	private void createXmlFromCode(String className, int type) throws Exception {
		// 没有就创建一个，第一次使用代码字符串创建个类
		PsiFile javaFile = PsiFileFactory.getInstance(project).createFileFromText(
				(type == 1 ? "activity_" : type == 2 ? "fragment_" : type == 3 ? "dialog_fragment_" : type == 4 ? "item_" : "") + className.toLowerCase() + ".xml", JavaFileType.INSTANCE,
				((type == 1 || type == 2 || type == 3) ? CodeTool.WISERViewXmlCode()
						: type == 4 ? CodeTool.WISERRVAdapterItemXmlCode()
								: CodeTool.WISERViewXmlCode()));
		PsiManager.getInstance(project).findDirectory(DirTool.getAppLayoutDir(project)).add(javaFile);
	}

	// 根据鼠标所在位置创建Java类
	private PsiClass createJavaClassFromName(String className) throws Exception {

		// 获取鼠标选中的目录
		IdeView ideView = event.getRequiredData(LangDataKeys.IDE_VIEW);
		PsiDirectory directory = ideView.getOrChooseDirectory();

		// 创建Java类
		JavaDirectoryService myDirectoryService = JavaDirectoryService.getInstance();
		PsiClass psiClass = myDirectoryService.createClass(directory, className, JavaTemplateUtil.INTERNAL_CLASS_TEMPLATE_NAME);

		// 设置包名
		PsiJavaFile javaFile = (PsiJavaFile) psiClass.getContainingFile();
		PsiPackage psiPackage = myDirectoryService.getPackage(directory);
		javaFile.setPackageName(psiPackage.getQualifiedName());

		// 设置类的权限
		psiClass.getModifierList().setModifierProperty(PsiModifier.PUBLIC, true);

		return psiClass;
	}

	// 开始写
	public void writeAction(String className, int type, boolean isCreateBiz) {
		WriteCommandAction.runWriteCommandAction(project, new Runnable() {

			@Override public void run() {
				try {
					createClassFromCode(className, type, isCreateBiz);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
