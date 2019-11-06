package org.zerock.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.dto.BoardDTO;
import org.zerock.dto.Member;

@Controller
public class SampleController {

	@RequestMapping("/ex1")
	public void ex1(int[] arr) {
		// public void ex1(String p1) {
		// 파라미터명이 같기만하면 상관 x
		System.out.println(Arrays.toString(arr));
	}
	
	@GetMapping("/exUpload")
	public void exUploadGET() {
		
	}
	
	@PostMapping("/exUpload")
	public void exUploadPOST(ArrayList<MultipartFile> files) {
		
		// 파일을 하나도 올리지 않았을 때는 아무것도 하지않는다.
		if(files.size() <= 0) {
			return;
		}
		
		// 받은 파일 배열을 반복문으로 돌린다.
		files.forEach(file -> {
			
			System.out.println(file);
			System.out.println(file.getSize());
			System.out.println(file.getOriginalFilename());
			
			// 파일이 있을 때만 저장하도록 한다. ( 파일의 크기가 0보다 클 때는 파일을 올리지 않았다는 것이므로 )
			if(file.getSize() > 0) {
				
				// 파일의 이름을 가져온다.
				String fileName = file.getOriginalFilename();
				
				// 파일을 저장할 경로를 지정하고 해당 파일이름으로 저장하도록 파일 타입의 변수 선언해준다.
				File target = new File("C:\\zzz", fileName);
				
				try {
					// 파일을 위에서 지정한 폴더의 지정한 이름으로 저장시킨다.
					FileCopyUtils.copy(file.getBytes(), target);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		System.out.println("=========================================");
		
	}
	
	@RequestMapping("/ex2")
	public void ex2(BoardDTO dto) {
		System.out.println(dto);
		
	}
	
	@PostMapping("/ex3")
	public void ex3(Member vo) {
		System.out.println(vo);
		
	}
	
	@GetMapping("/ex3")
	public void ex3get(Member vo) {
		System.out.println(vo);
		
	}
	
}
