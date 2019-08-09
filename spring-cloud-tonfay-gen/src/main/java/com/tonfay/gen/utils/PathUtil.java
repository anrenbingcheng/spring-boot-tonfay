package com.tonfay.gen.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 路径工具类
 *
 */
public class PathUtil {
	/**
	 * 获取模板路径
	 * @param courseFile
	 * @return
	 */
	public static String getTemplatePath(String courseFile) {
		String templateDir = courseFile + "/template/";
		return templateDir;
	}

	/**
	 * 获取输出路径
	 * @param courseFile
	 * @return
	 */
	public static String getOutDirPath(String courseFile) {
		Date dt = new Date();   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
		String outDir = courseFile + "/testrepid/" + sdf.format(dt) + "/project_";
		String uuid = java.util.UUID.randomUUID().toString();
		outDir = outDir + uuid + "/";
		return outDir;
	}

	/**
	 * 获取项目路径
	 * @return
	 * @throws IOException
	 */
	public static String getProjectPath() throws IOException {
		//获取当前项目路径
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		return courseFile;
	}
	
	/**
	 * 删除文件夹
	 * @param folder
	 * @return
	 */
	public static boolean delFile(String folder) {
		File file = new File(folder);
        if (!file.exists()) {
            return false;
        }

        if (file.isFile()) {
            return file.delete();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
            return file.delete();
        }
    }
	/**
	 * 删除文件夹
	 * @param file
	 * @return
	 */
	public static boolean delFile(File file) {
        if (!file.exists()) {
            return false;
        }

        if (file.isFile()) {
            return file.delete();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
            return file.delete();
        }
    }
}
