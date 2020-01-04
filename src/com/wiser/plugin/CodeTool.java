package com.wiser.plugin;

import java.lang.*;

/**
 * @author Wiser
 * 
 *         代码工具
 */
public class CodeTool {

    /**
     * WISERActivity 生成代码
     *
     * @param dir 目录
     * @param className 类名
     * @return
     */
    public static String WISERActivityCode(String dir, String className, boolean isCreateBiz) {

        return "package "+ dir +";\n" +
                "\n" +
                "import android.content.Intent;\n" +
                "\n" +
                "import com.wiser.library.base.WISERActivity;\n" +
                "import com.wiser.library.base.WISERBuilder;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "Activity" + " 描述\n" +
                " */" +
                "\n" +
                "public class "+ className + "Activity" +" extends WISERActivity" + (isCreateBiz ? "<" + className + "ActivityBiz" + ">" : "") + " {\n" +
                "\n" +
                "\t@@Override protected WISERBuilder build(WISERBuilder builder) {\n" +
                "\t    builder.layoutId(R.layout." + "activity_" + className.toLowerCase() + ");\n" +
                "\t\treturn builder;\n" +
                "\t}\n" +
                "\n" +
                "\t@Override protected void initData(Intent intent) {\n" +
                "\n" +
                "\t}\n" +
                "}\n";
    }

    /**
     * WISERActivityBiz 代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERActivityBizCode(String dir,String className){
        return "package " + dir + ";\n" +
                "\n" +
                "import android.content.Intent;\n" +
                "\n" +
                "import com.wiser.library.base.WISERBiz;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "ActivityBiz" + " 描述\n" +
                " */" +
                "\n" +
                "public class " + className + "ActivityBiz" + " extends WISERBiz<" + className + "Activity" + "> {\n" +
                "\n" +
                "    @Override public void initBiz(Intent intent) {\n" +
                "        super.initBiz(intent);\n" +
                "    }\n" +
                "}\n";
    }

    /**
     * WISERFragment 生成代码
     *
     * @param dir 目录
     * @param className 类名
     * @return
     */
    public static String WISERFragmentCode(String dir,String className, boolean isCreateBiz){
        return "package "+ dir +";\n" +
                "\n" +
                "import android.os.Bundle;\n" +
                "\n" +
                "import com.wiser.library.base.WISERBuilder;\n" +
                "import com.wiser.library.base.WISERFragment;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "Fragment" + " 描述\n" +
                " */" +
                "\n" +
                "public class "+ className + "Fragment" +" extends WISERFragment"+ (isCreateBiz ? "<" + className + "FragmentBiz" + ">" : "") + " {\n" +
                "\n" +
                "\t@Override protected WISERBuilder build(WISERBuilder builder) {\n" +
                "\t    builder.layoutId(R.layout." + "fragment_" + className.toLowerCase() + ");\n" +
                "\t\treturn builder;\n" +
                "\t}\n" +
                "\n" +
                "\t@Override protected void initData(Bundle savedInstanceState) {\n" +
                "\n" +
                "\t}\n" +
                "}\n";
    }

    /**
     * WISERFragmentBiz 代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERFragmentBizCode(String dir,String className){
        return "package " + dir + ";\n" +
                "\n" +
                "import android.os.Bundle;\n" +
                "\n" +
                "import com.wiser.library.base.WISERBiz;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "FragmentBiz" + " 描述\n" +
                " */" +
                "\n" +
                "public class " + className + "FragmentBiz" + " extends WISERBiz<" + className + "Fragment" + "> {\n" +
                "\n" +
                "    @Override public void initBiz(Bundle bundle) {\n" +
                "        super.initBiz(bundle);\n" +
                "    }\n" +
                "}\n";
    }

    /**
     * WISERDialogFragment 代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERDialogFragmentCode(String dir,String className, boolean isCreateBiz){
        return "package "+ dir +";\n" +
                "\n" +
                "import android.os.Bundle;\n" +
                "\n" +
                "import com.wiser.library.base.WISERBuilder;\n" +
                "import com.wiser.library.base.WISERDialogFragment;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "DialogFragment" + " 描述\n" +
                " */" +
                "\n" +
                "public class "+ className + "DialogFragment" +" extends WISERDialogFragment"+ (isCreateBiz ? "<" + className + "DialogFragmentBiz" + ">" : "") + " {\n" +
                "\n" +
                "\t@Override protected WISERBuilder build(WISERBuilder builder) {\n" +
                "\t    builder.layoutId(R.layout." + "dialog_fragment_" + className.toLowerCase() + ");\n" +
                "\t\treturn builder;\n" +
                "\t}\n" +
                "\n" +
                "\t@Override protected void initData(Bundle savedInstanceState) {\n" +
                "\n" +
                "\t}\n" +
                "\n" +
                "\t@Override protected int dialogWeight() {\n" +
                "\t\treturn 0;\n" +
                "\t}\n" +
                "\n" +
                "\t@Override protected int dialogTheme() {\n" +
                "\t\treturn 0;\n" +
                "\t}\n" +
                "\n" +
                "\t@Override protected boolean isWidthFullScreen() {\n" +
                "\t\treturn false;\n" +
                "\t}\n" +
                "\n" +
                "\t@Override protected boolean isCloseOnTouchOutside() {\n" +
                "\t\treturn false;\n" +
                "\t}\n" +
                "\n" +
                "\t@Override protected boolean isCloseOnTouchBack() {\n" +
                "\t\treturn false;\n" +
                "\t}\n" +
                "}\n";
    }

    /**
     * WISERDialogFragmentBiz 代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERDialogFragmentBizCode(String dir,String className){
        return "package " + dir + ";\n" +
                "\n" +
                "import android.os.Bundle;\n" +
                "\n" +
                "import com.wiser.library.base.WISERBiz;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "DialogFragmentBiz" + " 描述\n" +
                " */" +
                "\n" +
                "public class " + className + "DialogFragmentBiz" + " extends WISERBiz<" + className + "DialogFragment" + "> {\n" +
                "\n" +
                "    @Override public void initBiz(Bundle bundle) {\n" +
                "        super.initBiz(bundle);\n" +
                "    }\n" +
                "}\n";
    }

    /**
     * WISERRVAdapter 代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERRVAdapter(String dir,String className){
        return "package "+ dir +";\n" +
                "\n" +
                "import com.wiser.library.adapter.WISERHolder;\n" +
                "import com.wiser.library.adapter.WISERRVAdapter;\n" +
                "import com.wiser.library.base.WISERActivity;\n" +
                "\n" +
                "import android.support.annotation.NonNull;\n" +
                "import android.view.View;\n" +
                "import android.view.ViewGroup;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "Adapter" + " 描述\n" +
                " */" +
                "\n" +
                "public class "+ className + "Adapter" + " extends WISERRVAdapter<" + className + "Adapter" + "." + className + "Model" + ", " + className + "Adapter" + "." + className + "Holder" + "> {\n" +
                "\n" +
                "\tpublic " + className + "Adapter" + "(WISERActivity wiserActivity) {\n" +
                "\t\tsuper(wiserActivity);\n" +
                "\t}\n" +
                "\n" +
                "\t@Override public " + className + "Holder" + " newViewHolder(ViewGroup viewGroup, int type) {\n" +
                "\t\treturn new " + className + "Holder" + "(inflate(viewGroup,R.layout." + "item_" + className.toLowerCase() + "));\n" +
                "\t}\n" +
                "\n" +
                "\tpublic class "+ className + "Holder" + " extends WISERHolder<" + className + "Model" + "> {\n" +
                "\n" +
                "\t\t" + className + "Holder" + "(@NonNull View itemView) {\n" +
                "\t\t\tsuper(itemView);\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t@Override public void bindData(" + className + "Model" + " model, int position) {\n" +
                "\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\n" +
                "\tpublic static class " + className + "Model" + " {\n" +
                "\n" +
                "\t}\n" +
                "}\n";
    }

    /**
     * WISERService 代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERServiceCode(String dir,String className, boolean isCreateBiz){
        return "package " + dir + ";\n" +
                "\n" +
                "import android.content.Intent;\n" +
                "import com.wiser.library.service.WISERService;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "Service" + " 描述\n" +
                " */" +
                "\n" +
                "public class " + className + "Service" + " extends WISERService" + (isCreateBiz ? "<" + className + "ServiceBiz" + ">" : "") + " {\n" +
                "\n" +
                "    @Override protected void running(Intent intent, int flags, int startId) {\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    @Override protected void initData() {\n" +
                "\n" +
                "    }\n" +
                "}\n";
    }

    /**
     * WISERServiceBiz 代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERServiceBizCode(String dir,String className){
        return "package " + dir + ";\n" +
                "\n" +
                "import android.os.Bundle;\n" +
                "\n" +
                "import com.wiser.library.base.WISERBiz;\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "ServiceBiz" + " 描述\n" +
                " */" +
                "\n" +
                "public class " + className + "ServiceBiz" + " extends WISERBiz<" + className + "Service" + "> {\n" +
                "\n" +
                "    @Override public void initBiz(Intent intent) {\n" +
                "        super.initBiz(intent);\n" +
                "    }\n" +
                "}\n";
    }

    /**
     * WISER View xml 代码
     * @return
     */
    public static String WISERViewXmlCode(){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    android:orientation=\"vertical\">\n" +
                "\n" +
                "</LinearLayout>";
    }

    /**
     * WISERRVAdapter xml 代码
     * @return
     */
    public static String WISERRVAdapterItemXmlCode(){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "    android:orientation=\"vertical\">\n" +
                "\n" +
                "</LinearLayout>";
    }

}
