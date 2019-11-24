package org.seung.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.seung.domain.BoardAttachVO;
import org.seung.service.AttachService;
import org.seung.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {

	@Autowired
	private AttachService attachService;
	
	private PathUtil pathUtil = new PathUtil();

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {
		boolean result = false;

		try {
			String mimeType = Files.probeContentType(file.toPath());

			System.out.println("mimeType: " + mimeType);

			result = mimeType.startsWith("image");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@GetMapping("/uploadForm")
	public void ddd() {
		log.info("fileupload");
	}

	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> uploadAjaxPost(MultipartFile[] uploadFile) {

		log.info(uploadFile.length);

		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
		String uploadFolder = "C:\\upload";

		String uploadFolderPath = getFolder();

		// make folder --------
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		log.info("upload path: " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		// make yyyy/MM/dd folder
		for (MultipartFile multipartFile : uploadFile) {

			BoardAttachVO attachVO = new BoardAttachVO();

			log.info("-------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);

			log.info("only file name: " + uploadFileName);

			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;

			// File saveFile = new File(uploadFolder, uploadFileName);
			File saveFile = new File(uploadPath, uploadFileName);

			try {
				multipartFile.transferTo(saveFile);

				boolean isImage = checkImageType(saveFile);

				if (isImage) {
					System.out.println("이미지 파일이 업로드 되었고, 썸네일 작업");

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}

				attachVO.setFileName(multipartFile.getOriginalFilename());
				attachVO.setUuid(uuid.toString());
				attachVO.setUploadPath(pathUtil.sTh(uploadFolderPath));
				attachVO.setFileType(isImage);

				log.info("어그로곱창: " + pathUtil.sTh(uploadFolderPath));
				log.info("어그로껍데기 : " + attachVO);

				list.add(attachVO);

			} catch (Exception e) {
				log.error(e.getMessage());
			} // end catch
		} // end for

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<byte[]> downloadFile(BoardAttachVO vo) {
//		PathUtil pathUtil = new PathUtil();
		log.info("변환전 ================= " + vo.getUploadPath());

		String chgPath = pathUtil.hTs(vo.getUploadPath());

		log.info("변환후 ================= " + chgPath);

		log.info("fname ============================== " + vo.getFileName());
		log.info(vo.getUploadPath() + "=====================");
		File file = new File("C:\\upload\\" + chgPath, vo.getUuid() + "_" + vo.getFileName());
		log.info("==================================>" + file.toString());

		HttpHeaders header = new HttpHeaders();
		try {

			header.add("Content-Disposition",
					"attachment; filename=" + new String(vo.getFileName().getBytes("UTF-8"), "ISO-8859-1"));

			byte[] data = FileCopyUtils.copyToByteArray(file);
			return new ResponseEntity<byte[]>(data, header, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	@GetMapping("/viewFile")
	@ResponseBody
	public ResponseEntity<byte[]> viewFile(String fname, String uploadPath) {

		log.info("uploadPath : " + uploadPath);
		
		uploadPath = pathUtil.hTs(uploadPath);
		
		log.info("바꿈 .............. uploadPath : " + uploadPath);
		
		File file = new File("C:\\upload\\" + uploadPath, fname);

		try {
			String mimeType = Files.probeContentType(file.toPath());

			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", mimeType);

			byte[] data = FileCopyUtils.copyToByteArray(file);

			return new ResponseEntity<>(data, header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String uploadPath, String fileName, boolean type){
		
		log.info("deleteFile : " + fileName);
		log.info("type: " + type);
		
		File file;
		
		try {
			
			file = new File("C:\\upload\\" + pathUtil.hTs(uploadPath), fileName);
			
			log.info("ㅍㅏ일파일아파일ㄹ:  " + file);
			
			file.delete();
			
			if(type) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				
				log.info("largeFileName: " + largeFileName);
				
				file = new File(largeFileName);
				
				file.delete();
			}
			
		} catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		log.info("aa");
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
}