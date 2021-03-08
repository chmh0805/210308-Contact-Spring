package com.hyuk.contact.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyuk.contact.domain.Contact;
import com.hyuk.contact.domain.ContactRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ContactService {

	private final ContactRepository contactRepository;
	
	public List<Contact> 전체보기() {
		return contactRepository.findAll();
	}

	public Contact 상세보기(Long id) {
		return contactRepository.findById(id).get();
	}

	@Transactional
	public void 한건삭제하기(Long id) {
		contactRepository.deleteById(id);
	}

	@Transactional
	public Contact 수정하기(Long id, Contact contact) {
		// 영속화
		Contact contactEntity = contactRepository.findById(id).get();
		
		// 영속화된 객체를 수정
		contactEntity.setName(contact.getName());
		contactEntity.setPhone(contact.getPhone());
		
		return contactEntity;
	} // 서비스 종료 시에 영속성 컨텍스트가 변경을 감지해서 flush()로 DB에 반영함

	@Transactional
	public Contact 저장하기(Contact contact) {
		return contactRepository.save(contact);
	}
}
