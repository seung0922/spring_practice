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
		// �Ķ���͸��� ���⸸�ϸ� ��� x
		System.out.println(Arrays.toString(arr));
	}
	
	@GetMapping("/exUpload")
	public void exUploadGET() {
		
	}
	
	@PostMapping("/exUpload")
	public void exUploadPOST(ArrayList<MultipartFile> files) {
		
		// ������ �ϳ��� �ø��� �ʾ��� ���� �ƹ��͵� �����ʴ´�.
		if(files.size() <= 0) {
			return;
		}
		
		// ���� ���� �迭�� �ݺ������� ������.
		files.forEach(file -> {
			
			System.out.println(file);
			System.out.println(file.getSize());
			System.out.println(file.getOriginalFilename());
			
			// ������ ���� ���� �����ϵ��� �Ѵ�. ( ������ ũ�Ⱑ 0���� Ŭ ���� ������ �ø��� �ʾҴٴ� ���̹Ƿ� )
			if(file.getSize() > 0) {
				
				// ������ �̸��� �����´�.
				String fileName = file.getOriginalFilename();
				
				// ������ ������ ��θ� �����ϰ� �ش� �����̸����� �����ϵ��� ���� Ÿ���� ���� �������ش�.
				File target = new File("C:\\zzz", fileName);
				
				try {
					// ������ ������ ������ ������ ������ �̸����� �����Ų��.
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
