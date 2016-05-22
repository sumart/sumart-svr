package com.goodjoon.guppy.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
	protected class ApacheFileUtils extends org.apache.commons.io.FileUtils {
	}
	
	public static void WriteInputStreamToFile(InputStream is, String filePath) throws IOException {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		try {
			fos = new FileOutputStream(filePath);
			bis = new BufferedInputStream(is);
			
			byte[] buffer = new byte[1024];
			int read = 0;
			while ((read = bis.read(buffer)) != -1)
				fos.write(buffer, 0, read);
			
			bis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void forceMkdir(String dirPath) throws IOException{
		forceMkdir(new File(dirPath));
	}
	
	public static void forceMkdir(File file) throws IOException {
		ApacheFileUtils.forceMkdir(file);
	}
	
	public static boolean isFileExists(String filePath) {
		return (new File(filePath)).exists();
	}
}
