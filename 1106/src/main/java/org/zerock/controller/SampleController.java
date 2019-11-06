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
		
		if(files.size() <= 0) {
			return;
		}
		 
		files.forEach(file -> {
			System.out.println(file);
			System.out.println(file.getSize());
			System.out.println(file.getOriginalFilename());
			
			if(file.getSize() > 0) {
				String fileName = file.getOriginalFilename();
				File target = new File("C:\\zzz", fileName);
				
				try {
					FileCopyUtils.copy(file.getBytes(), target);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
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
