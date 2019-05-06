package pers.arrayli.utils;

import java.io.File;

/**
 * @author lzj13 图片资源操作类
 */
public class PictureUtils {
	public static String PicPath = "D:\\PakringResources\\upload";

	public static void delPicture(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除" + fileName + "成功！");

			} else {
				System.out.println("删除" + fileName + "失败！");

			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");

		}
	}

}
