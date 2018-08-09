package org.jy.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * sqldevelop生成的sql脚本添加日志打印功能
 * @description
 * @author shaomy
 * @ClassName SqlAddLogTip
 * @date 2015-6-19 上午09:34:07
 */
public class SqlLogUtil {
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\test\\Desktop\\datebase\\database\\code");
		for(File f : file.listFiles()){
			String str = FileUtils.readFileToString(f,"gbk");
			str = "spool "+f.getName().substring(0,f.getName().indexOf("."))+".log\r\n"+str;
			str = str+"\r\n spool off";
			str = str+"\r\n exit;";			
			FileUtils.write(f, str, "gbk");
			System.out.println(f.getName()+"处理完成！");
		}
	}
}