/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/

package org.jy.util;  //包名

import java.io.File;
/**
 * 统计文件夹内文件数量和文件绝对路径
* @描述 
* @作者 shaomy
* @版本 1.0
* @时间:2014-10-30 下午02:57:19
* @版权所有 深圳金证科技
 */
public class SumFileCount {
	int count=0; //用来记录文件和文件夹的总和
	static int b=0; //用来记录文件夹的数目
	String dizhi;   //用来保存你输入的要查询的目录
	boolean flag=true;  //定义个开关防止覆盖dizhi的值
	public static void main(String[] args) {
		SumFileCount fc=new SumFileCount();
		fc.findFiles("E:\\金证补丁\\hsqh\\V002_HSQH_WEIXIN_20180802",null);  //输入你要查询的目录.
		fc.outB(); //输出查询结果
	}

	public void findFiles(String filePath,String key){
		if(flag){  //获取到你输入的目录.只获取一次后就关闭开关,否则递归一次就覆盖一次.
			dizhi=filePath;
			flag=false;
		}
		File file = new File(filePath);

		if(file.isFile()){
			String path = file.getAbsolutePath();
			path.replace("\\", "/");
			System.out.println(file.getAbsolutePath());  //输出查询到的文件的绝对地址
			return ;  //如果是个文件则返回
		}

		//否则是目录，继续遍历里面的文件
		File[] files = file.listFiles(); //这里添加一个实现FilenameFilter接口的类的实例，以关键字key，过滤文件名
		if(files!=null){  //不限制这里查询根目录就会有空指针异常.
			for(int i=0; i<files.length; i++){
				findFiles(files[i].getAbsolutePath(),key);  //递归查询 将得到的文件夹地址递归再次进入查询
				count+=1; //查询到结果后就+1,用来记录文件和文件夹的总和
			}
		}
		b=b+1;  //递归一次,文件夹数加①
	}
	public void outB(){
		System.out.println("在你指定的  "+dizhi+" 的目录里共有"+count+"个文件和文件夹!");
		System.out.println("在你所指定的目录下有"+(count-(b-1))+"个是文件!");
		System.out.println("共有"+(b-1)+"个是文件夹");
	}
}
