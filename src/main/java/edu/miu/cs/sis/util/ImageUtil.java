package edu.miu.cs.sis.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ImageUtil {

	public static final String IMAGE_UPLOAD_BASE_PATH = "C://Users//Babita//Documents//Image-Upload";
	public static final int BUFFER_SIZE = 1024;

	public static String writeImageToDisk(CommonsMultipartFile file) {
		String imageUrl = IMAGE_UPLOAD_BASE_PATH + "/" + file.getOriginalFilename();
		try (FileOutputStream fos = new FileOutputStream(imageUrl)) {

			byte[] bytes = file.getBytes();
			fos.write(bytes);
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageUrl;

	}

	public static void readImageFromDisk(String url, HttpServletResponse response) {
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(url), BUFFER_SIZE);
				BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream(), BUFFER_SIZE);

		) {
			int len;
			byte[] bytes = new byte[BUFFER_SIZE];
			while ((len = in.read(bytes)) != -1) {
				out.write(bytes, 0, len);
				out.flush();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
