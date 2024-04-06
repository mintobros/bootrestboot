package com.rest.api.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR="D:\\Java by Durgesh Sir\\eclipse_new\\bootrestboot\\src\\main\\resources\\static\\images";

	public boolean uploadFile(MultipartFile multipartFile) {
		
		boolean f=false;
		
		try {
			
			InputStream is=multipartFile.getInputStream();
			byte data[]=new byte[is.available()];
			is.read(data);
			
			
			//write....
			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
			fos.write(data);
			
			fos.flush();
			fos.close();
			f=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}

}
