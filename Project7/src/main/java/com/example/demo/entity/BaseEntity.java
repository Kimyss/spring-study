package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
//등록시간과 최종시간 담당할 엔티티클래스. 상속 시키고 등록/ 수정시간 자동으로 추가하게끔 요망


@MappedSuperclass	
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
	
	@CreatedDate	//데이터 *생성*되면 컬럼에 현재시간 저장. 한번 변경
	LocalDateTime regDate;
	
	@LastModifiedDate	//데이터 *수정*되면 컬럼에 현재시간저장. 여러번 변경
	LocalDateTime modDate;

}

//@MappedSuperclass	
//해당 클래스는 엔티티로 처리안함. 
//부모클래스로 사용됨 JPA한테 알려줌 부모클래스로 사용할 것이며 테이블로 사용할 것이 아니다
//@EntityListeners(value = {AuditingEntityListener.class})
//데이터가 등록되거나 수정되는지 변화를 감지하는 리스너
//main함수 부분에도 이벤트 기능 활성화 기능 작성요망
