package com.yedam.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@Value("${file.upload.path}")
	public String uploadPath;
	
//	@GetMapping("getUploadPath")
//	@ResponseBody
//	public String getUploadPaht() {
//		return uploadPath;
//	}
	
	@GetMapping("upload")
	public void getUploadPath() {
		
	}
	
	@PostMapping("/uploadsAjax")
	@ResponseBody
	public void uploadFile(@RequestPart MultipartFile[] uploadFiles) {
		
	    for(MultipartFile uploadFile : uploadFiles){

	    	if(uploadFile.getContentType().startsWith("image") == false){
	    		System.err.println("this file is not image type");
	    		return;
	        } // 한꺼번에 처리하겠다 할 때는 생략해도 되는 부분.
	  
	    	
	    	//파일 정보를 가져오는.
	        String originalName = uploadFile.getOriginalFilename();
	        String fileName = originalName.substring(originalName.lastIndexOf("//")+1); //정보를 받게 되면 //가 붙는다. 
	        //1. 파일 이름 가져오고.
	        
	        System.out.println("fileName : " + fileName);
	    

	        //우리서버 내에서 경로가 겹치지 않도록 작업을 하는게 folderPath와 uuid.
	        //날짜 폴더 생성
	        String folderPath = makeFolder();
	        //UUID 
	        String uuid = UUID.randomUUID().toString(); //큰 의미는 없고 유니크 값임. 랜덤으로 해서 값을 만들어 냈다. 
	        
	        //저장할 파일 이름 중간에 "_"를 이용하여 구분
	        String uploadFileName = folderPath + File.separator + uuid + "_" + fileName;
	        
	        
	        String saveName = uploadPath + File.separator + uploadFileName;
	        //saveName -> 해당경로.
	        
	        //2. 업로드 경로와 파일 이름 매치 시켜서 Path에 집어 넣고.
	        Path savePath = Paths.get(saveName); //해당 경로를 기반으로 해서 실제로 만들어지는 경로가 온다.
	        //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
	        System.out.println("path : " + saveName);
	        try{
	        	//3. 내부에 있는거 보내고.
	        	uploadFile.transferTo(savePath); //얘가 핵심. 넘겨온 파일을 서버에 집어 넣는 핵심적인 기능.
	            //uploadFile에 파일을 업로드 하는 메서드 transferTo(file) transfertTo -> Path가 가지고 있는 경로로 보내준다.
	        } catch (IOException e) {
	             e.printStackTrace();	             
	        }
	        
	        //DB에 해당 경로 저장
	        //1) 사용자가 업로드할 때 사용한 파일명
	        //2) 실제 서버에 업로드할 때 사용한 경로
	        //1),2) 같이 움직여야함.
	        String imagePath = uploadFileName.replace(File.separator, "/");
	        System.out.println(uploadFileName);  //확인용
	        System.out.println(imagePath); //확인용
	        
	     }
	}

	private String makeFolder() {

		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator);
		//자바는 이것을 사용해야함.

		File uploadPathFoler = new File(uploadPath, folderPath);
		//File 클래스. 단순히 문자열이었던 것을 시스템이 인식하는 파일형태로 변형 시킨 것. 
		// File newFile= new File(dir,"파일명");


		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}
	
//	private String setImagePath(String uploadFileName) {
//		return uploadFileName.replace(File.separator, "/");
//	}
}
