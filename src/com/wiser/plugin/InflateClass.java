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
import java.util.Objects;

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
	private void createClassFromCode(String className, int type, boolean isCreateBiz,boolean isJava) throws Exception {
		// 获取鼠标选中的目录
		IdeView ideView = event.getRequiredData(LangDataKeys.IDE_VIEW);
		PsiDirectory directory = ideView.getOrChooseDirectory();
		assert directory != null;
		PsiPackage psiPackage = JavaDirectoryService.getInstance().getPackage(directory);

		if (isJava)
			//创建Java类
			createJavaClassFromCode(psiPackage, directory, className, type, isCreateBiz);
		else
			//创建Kotlin类
			createKotlinClassFromCode(psiPackage, directory, className, type, isCreateBiz);

		if (isCreateBiz)
			if (isJava)
				//创建Java业务类Biz
				createJavaBizClassFromCode(psiPackage, directory, className, type);
			else
				//创建Kotlin业务类Biz
				createKotlinBizClassFromCode(psiPackage,directory,className,type);

		if (type == 5) return;
		//同时创建xml布局
		createXmlFromCode(className,type);

	}

	// 根据代码创建Java类
	private void createJavaClassFromCode(PsiPackage psiPackage, PsiDirectory directory, String className, int type, boolean isCreateBiz) throws Exception {
		// 没有就创建一个，第一次使用代码字符串创建个类
		PsiFile javaFile = PsiFileFactory.getInstance(project).createFileFromText(
				className + (type == 1 ? "Activity" : type == 2 ? "Fragment" : type == 3 ? "DialogFragment" : type == 4 ? "Adapter" : type == 5 ? "Service" : "") + ".java", JavaFileType.INSTANCE,
				(type == 1 ? CodeTool.WISERActivityJavaCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 2 ? CodeTool.WISERFragmentJavaCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 3 ? CodeTool.WISERDialogFragmentJavaCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 4 ? CodeTool.WISERRVAdapterJavaCode(psiPackage.getQualifiedName(), className)
						: type == 5 ? CodeTool.WISERServiceJavaCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: CodeTool.WISERActivityJavaCode(psiPackage.getQualifiedName(), className, isCreateBiz)));
		Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(directory.getVirtualFile())).add(javaFile);
	}

	// 根据代码创建Java 业务类Biz
	private void createJavaBizClassFromCode(PsiPackage psiPackage, PsiDirectory directory, String className, int type) throws Exception {
		// Adapter 没有业务类
		if (type == 4) return;
		// 没有就创建一个，第一次使用代码字符串创建个类
		PsiFile javaFile = PsiFileFactory.getInstance(project).createFileFromText(
				className + (type == 1 ? "ActivityBiz" : type == 2 ? "FragmentBiz" : type == 3 ? "DialogFragmentBiz" : type == 5 ? "ServiceBiz" : "") + ".java", JavaFileType.INSTANCE,
				(type == 1 ? CodeTool.WISERActivityBizJavaCode(psiPackage.getQualifiedName(), className)
						: type == 2 ? CodeTool.WISERFragmentBizJavaCode(psiPackage.getQualifiedName(), className)
						: type == 3 ? CodeTool.WISERDialogFragmentBizJavaCode(psiPackage.getQualifiedName(), className)
						: type == 5 ? CodeTool.WISERServiceBizJavaCode(psiPackage.getQualifiedName(), className)
						: CodeTool.WISERActivityBizJavaCode(psiPackage.getQualifiedName(), className)));
		Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(directory.getVirtualFile())).add(javaFile);
	}

	// 根据代码创建Kotlin类
	private void createKotlinClassFromCode(PsiPackage psiPackage, PsiDirectory directory, String className, int type, boolean isCreateBiz) throws Exception {
		// 没有就创建一个，第一次使用代码字符串创建个类
		PsiFile javaFile = PsiFileFactory.getInstance(project).createFileFromText(
				className + (type == 1 ? "Activity" : type == 2 ? "Fragment" : type == 3 ? "DialogFragment" : type == 4 ? "Adapter" : type == 5 ? "Service" : "") + ".kt", JavaFileType.INSTANCE,
				(type == 1 ? CodeTool.WISERActivityKotlinCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 2 ? CodeTool.WISERFragmentKotlinCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 3 ? CodeTool.WISERDialogFragmentKotlinCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: type == 4 ? CodeTool.WISERRVAdapterKotlinCode(psiPackage.getQualifiedName(), className)
						: type == 5 ? CodeTool.WISERServiceKotlinCode(psiPackage.getQualifiedName(), className, isCreateBiz)
						: CodeTool.WISERActivityKotlinCode(psiPackage.getQualifiedName(), className, isCreateBiz)));
		Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(directory.getVirtualFile())).add(javaFile);
	}

	// 根据代码创建Kotlin 业务类Biz
	private void createKotlinBizClassFromCode(PsiPackage psiPackage, PsiDirectory directory, String className, int type) throws Exception {
		// Adapter 没有业务类
		if (type == 4) return;
		// 没有就创建一个，第一次使用代码字符串创建个类
		PsiFile javaFile = PsiFileFactory.getInstance(project).createFileFromText(
				className + (type == 1 ? "ActivityBiz" : type == 2 ? "FragmentBiz" : type == 3 ? "DialogFragmentBiz" : type == 5 ? "ServiceBiz" : "") + ".kt", JavaFileType.INSTANCE,
				(type == 1 ? CodeTool.WISERActivityBizKotlinCode(psiPackage.getQualifiedName(), className)
						: type == 2 ? CodeTool.WISERFragmentBizKotlinCode(psiPackage.getQualifiedName(), className)
						: type == 3 ? CodeTool.WISERDialogFragmentBizKotlinCode(psiPackage.getQualifiedName(), className)
						: type == 5 ? CodeTool.WISERServiceBizKotlinCode(psiPackage.getQualifiedName(), className)
						: CodeTool.WISERActivityBizKotlinCode(psiPackage.getQualifiedName(), className)));
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
		Objects.requireNonNull(PsiManager.getInstance(project).findDirectory(Objects.requireNonNull(DirTool.getAppLayoutDir(project)))).add(javaFile);
	}

	// 根据鼠标所在位置创建Java类
	private PsiClass createJavaClassFromName(String className) throws Exception {

		// 获取鼠标选中的目录
		IdeView ideView = event.getRequiredData(LangDataKeys.IDE_VIEW);
		PsiDirectory directory = ideView.getOrChooseDirectory();

		// 创建Java类
		JavaDirectoryService myDirectoryService = JavaDirectoryService.getInstance();
		assert directory != null;
		PsiClass psiClass = myDirectoryService.createClass(directory, className, JavaTemplateUtil.INTERNAL_CLASS_TEMPLATE_NAME);

		// 设置包名
		PsiJavaFile javaFile = (PsiJavaFile) psiClass.getContainingFile();
		PsiPackage psiPackage = myDirectoryService.getPackage(directory);
		assert psiPackage != null;
		javaFile.setPackageName(psiPackage.getQualifiedName());

		// 设置类的权限
		Objects.requireNonNull(psiClass.getModifierList()).setModifierProperty(PsiModifier.PUBLIC, true);

		return psiClass;
	}

	// 开始写
	public void writeAction(String className, int type, boolean isCreateBiz,boolean isJava) {
		WriteCommandAction.runWriteCommandAction(project, () -> {
			try {
				createClassFromCode(className, type, isCreateBiz,isJava);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
