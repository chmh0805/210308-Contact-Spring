package com.hyuk.contact.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyuk.contact.domain.Contact;
import com.hyuk.contact.service.ContactService;
import com.hyuk.contact.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ContactController {

	private final ContactService contactService;
	
	@GetMapping("/phone")
	public CMRespDto<?> findAll() {
		return new CMRespDto<>(1, contactService.전체보기());
	}
	
	@GetMapping("/phone/{id}")
	public CMRespDto<?> findById(@PathVariable Long id) {
		return new CMRespDto<>(1, contactService.상세보기(id));
	}
	
	@DeleteMapping("/phone/{id}")
	public CMRespDto<?> deleteById(@PathVariable Long id) {
		contactService.한건삭제하기(id);
		return new CMRespDto<>(1, null);
	}
	
	@PutMapping("/phone/{id}")
	public CMRespDto<?> update(@PathVariable Long id, @RequestBody Contact contact) {
		return new CMRespDto<>(1, contactService.수정하기(id, contact));
	}
	
	@PostMapping("/phone")
	public CMRespDto<?> save(@RequestBody Contact contact) {
		return new CMRespDto<>(1, contactService.저장하기(contact));
	}
}
