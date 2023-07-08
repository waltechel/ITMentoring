package com.ssamz.jblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "POSTS")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "post_id")
	private Long id;
	
	@Column(nullable = false, length = 100, name = "post_title")
	private String title; 
	
	// 대용량 데이터 저장을 위해 @Lob로 설정함
	// 나중에 summernote를 적용하면 많은 <html> 태그들이 포함된다.
	@Lob 
	@Column(name = "post_content", columnDefinition = "LONGTEXT")
	private String content; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private UserEntity user; 
	
	@Column(name = "post_cnt")
	private int cnt; 

}
