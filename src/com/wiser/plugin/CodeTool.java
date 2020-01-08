package com.wiser.plugin;

/**
 * @author Wiser
 * 
 *         代码工具
 */
public class CodeTool {

    /**
     * WISERActivity java生成代码
     *
     * @param dir 目录
     * @param className 类名
     * @return
     */
    public static String WISERActivityJavaCode(String dir, String className, boolean isCreateBiz) {

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
                "\t@Override protected WISERBuilder build(WISERBuilder builder) {\n" +
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
     * WISERActivity kotlin生成代码
     *
     * @param dir 目录
     * @param className 类名
     * @return
     */
    public static String WISERActivityKotlinCode(String dir, String className, boolean isCreateBiz) {

        return "package " + dir + "\n" +
                "\n" +
                "import android.content.Intent\n" +
                "import com.wiser.library.base.WISERActivity\n" +
                "import com.wiser.library.base.WISERBuilder\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "Activity" + " 描述\n" +
                " */\n" +
                "class "+ className + "Activity" +" : WISERActivity" + (isCreateBiz ? "<" + className + "ActivityBiz?" + ">()" : "<Nothing?>()") + "{\n" +
                "\n" +
                "    override fun build(builder: WISERBuilder): WISERBuilder {\n" +
                "        builder.layoutId(R.layout." + "activity_" + className.toLowerCase() + ")\n" +
                "        return builder\n" +
                "    }\n" +
                "\n" +
                "    override fun initData(intent: Intent) {\n" +
                "\n" +
                "    }\n" +
                "}";
    }

    /**
     * WISERActivityBiz java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERActivityBizJavaCode(String dir, String className){
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
     * WISERActivityBiz kotlin代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERActivityBizKotlinCode(String dir, String className){
        return "package " + dir + "\n" +
                "\n" +
                "import android.content.Intent\n" +
                "import com.wiser.library.base.WISERBiz\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "ActivityBiz" + " 描述\n" +
                " */" +
                "\n" +
                "class " + className + "ActivityBiz" + " : WISERBiz<" + className + "Activity?>() {\n" +
                "\n" +
                "    override fun initBiz(intent: Intent) {\n" +
                "        super.initBiz(intent)\n" +
                "    }\n" +
                "    \n" +
                "}";
    }

    /**
     * WISERFragment java生成代码
     *
     * @param dir 目录
     * @param className 类名
     * @return
     */
    public static String WISERFragmentJavaCode(String dir, String className, boolean isCreateBiz){
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
                "public class " + className + "Fragment" + " extends WISERFragment" + (isCreateBiz ? "<" + className + "FragmentBiz" + ">" : "") + " {\n" +
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
     * WISERFragment kotlin生成代码
     *
     * @param dir 目录
     * @param className 类名
     * @return
     */
    public static String WISERFragmentKotlinCode(String dir, String className, boolean isCreateBiz){
        return "package " + dir + "\n" +
                "\n" +
                "import android.os.Bundle\n" +
                "import com.wiser.library.base.WISERBuilder\n" +
                "import com.wiser.library.base.WISERFragment\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "Fragment" + " 描述\n" +
                " */" +
                "\n" +
                "class " + className + "Fragment" + " : WISERFragment" + (isCreateBiz ? "<" + className + "FragmentBiz?" + ">()" : "<Nothing?>()") + " {\n" +
                "    \n" +
                "    override fun build(builder: WISERBuilder): WISERBuilder {\n" +
                "        builder.layoutId(R.layout." + "fragment_" + className.toLowerCase() + ")\n" +
                "        return builder\n" +
                "    }\n" +
                "\n" +
                "    override fun initData(savedInstanceState: Bundle) {\n" +
                "        \n" +
                "    }\n" +
                "}";
    }

    /**
     * WISERFragmentBiz java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERFragmentBizJavaCode(String dir, String className){
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
     * WISERFragmentBiz java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERFragmentBizKotlinCode(String dir, String className){
        return "package " + dir + "\n" +
                "\n" +
                "import android.os.Bundle\n" +
                "import com.wiser.library.base.WISERBiz\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "FragmentBiz" + " 描述\n" +
                " */" +
                "\n" +
                "class " + className + "FragmentBiz" + " : WISERBiz<" + className + "Fragment?>() {\n" +
                "\n" +
                "    override fun initBiz(bundle: Bundle) {\n" +
                "        super.initBiz(bundle)\n" +
                "    }\n" +
                "    \n" +
                "}";
    }

    /**
     * WISERDialogFragment java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERDialogFragmentJavaCode(String dir, String className, boolean isCreateBiz){
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
                "public class "+ className + "DialogFragment" +" extends WISERDialogFragment" + (isCreateBiz ? "<" + className + "DialogFragmentBiz" + ">" : "") + " {\n" +
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
     * WISERDialogFragment kotlin代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERDialogFragmentKotlinCode(String dir, String className, boolean isCreateBiz){
        return "package " + dir + "\n" +
                "\n" +
                "import android.os.Bundle\n" +
                "import com.wiser.library.base.WISERBuilder\n" +
                "import com.wiser.library.base.WISERDialogFragment\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "DialogFragment" + " 描述\n" +
                " */" +
                "\n" +
                "class "+ className + "DialogFragment" +" : WISERDialogFragment" + (isCreateBiz ? "<" + className + "DialogFragmentBiz?" + ">()" : "<Nothing?>()") + " {\n" +
                "\n" +
                "    override fun build(builder: WISERBuilder): WISERBuilder {\n" +
                "        builder.layoutId(R.layout." + "dialog_fragment_" + className.toLowerCase() + ")\n" +
                "        return builder\n" +
                "    }\n" +
                "\n" +
                "    override fun initData(savedInstanceState: Bundle) {\n" +
                "        \n" +
                "    }\n" +
                "\n" +
                "    override fun dialogWeight(): Int {\n" +
                "        return 0\n" +
                "    }\n" +
                "\n" +
                "    override fun dialogTheme(): Int {\n" +
                "        return 0\n" +
                "    }\n" +
                "\n" +
                "    override fun isWidthFullScreen(): Boolean {\n" +
                "        return false\n" +
                "    }\n" +
                "\n" +
                "    override fun isCloseOnTouchOutside(): Boolean {\n" +
                "        return false\n" +
                "    }\n" +
                "\n" +
                "    override fun isCloseOnTouchBack(): Boolean {\n" +
                "        return false\n" +
                "    }\n" +
                "}";
    }

    /**
     * WISERDialogFragmentBiz java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERDialogFragmentBizJavaCode(String dir, String className){
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
     * WISERDialogFragmentBiz kotlin代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERDialogFragmentBizKotlinCode(String dir, String className){
        return "package " + dir + "\n" +
                "\n" +
                "import android.os.Bundle\n" +
                "import com.wiser.library.base.WISERBiz\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "DialogFragmentBiz" + " 描述\n" +
                " */" +
                "\n" +
                "class " + className + "DialogFragmentBiz" + " : WISERBiz<" + className + "DialogFragment?>() {\n" +
                "\n" +
                "    override fun initBiz(bundle: Bundle) {\n" +
                "        super.initBiz(bundle)\n" +
                "    }\n" +
                "\n" +
                "}";
    }

    /**
     * WISERRVAdapter Java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERRVAdapterJavaCode(String dir, String className){
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
     * WISERRVAdapter kotlin代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERRVAdapterKotlinCode(String dir, String className){
        return "package " + dir + "\n" +
                "\n" +
                "import android.view.View\n" +
                "import android.view.ViewGroup\n" +
                "import com.wiser.library.adapter.WISERHolder\n" +
                "import com.wiser.library.adapter.WISERRVAdapter\n" +
                "import com.wiser.library.base.WISERActivity\n" +
                "\n" +
                "import android.support.annotation.NonNull\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "Adapter" + " 描述\n" +
                " */" +
                "\n" +
                "class "+ className + "Adapter" + "(wiserActivity: WISERActivity<*>?) : WISERRVAdapter<" + className + "Adapter" + "." + className + "Model?, " + className + "Adapter" + "." + className + "Holder" + ">(wiserActivity) {\n" +
                "\n" +
                "    override fun newViewHolder(viewGroup: ViewGroup, type: Int): " + className + "Holder" + " {\n" +
                "        return " + className + "Holder" + "(inflate(viewGroup, R.layout." + "item_" + className.toLowerCase() + "))\n" +
                "    }\n" +
                "\n" +
                "    inner class " + className + "Holder" + " internal constructor(@NonNull itemView: View?) : WISERHolder<" + className + "Model" + "?>(itemView!!) {\n" +
                "        override fun bindData(model: " + className + "Model" + "?, position: Int) {\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    class " + className + "Model" + "\n" +
                "}";
    }

    /**
     * WISERService java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERServiceJavaCode(String dir, String className, boolean isCreateBiz){
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
     * WISERService kotlin代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERServiceKotlinCode(String dir, String className, boolean isCreateBiz){
        return "package " + dir + "\n" +
                "\n" +
                "import android.content.Intent\n" +
                "import com.wiser.library.service.WISERService\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "Service" + " 描述\n" +
                " */" +
                "\n" +
                "class " + className + "Service" + " : WISERService" + (isCreateBiz ? "<" + className + "ServiceBiz?" + ">()" : "<Nothing?>()") + " {\n" +
                "    \n" +
                "    override fun running(intent: Intent, flags: Int, startId: Int) {\n" +
                "        \n" +
                "    }\n" +
                "    \n" +
                "    override fun initData() {\n" +
                "        \n" +
                "    }\n" +
                "}";
    }

    /**
     * WISERServiceBiz java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERServiceBizJavaCode(String dir, String className){
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
     * WISERServiceBiz java代码
     * @param dir
     * @param className
     * @return
     */
    public static String WISERServiceBizKotlinCode(String dir, String className){
        return "package " + dir + "\n" +
                "\n" +
                "import android.content.Intent\n" +
                "import com.wiser.library.base.WISERBiz\n" +
                "\n" +
                "/**\n" +
                " * @author\n" +
                " *\n" +
                " * \t\t" + className + "ServiceBiz" + " 描述\n" +
                " */" +
                "\n" +
                "class " + className + "ServiceBiz" + " : WISERBiz<" + className + "Service?>() {\n" +
                "    \n" +
                "    override fun initBiz(intent: Intent) {\n" +
                "        super.initBiz(intent)\n" +
                "    }\n" +
                "    \n" +
                "}";
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
