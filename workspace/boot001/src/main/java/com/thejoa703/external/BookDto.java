package com.thejoa703.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

// xml + json 두랃 호환가능

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // 알 수 없는 필드는 무시
@JacksonXmlRootElement(localName="item") // xml <item> 매핑
public class BookDto {
	
	@JsonProperty("title")
	@JacksonXmlProperty(localName="title")
	private String title;
	
	@JsonProperty("image")
	@JacksonXmlProperty(localName="image")
	private String image;
	
	@JsonProperty("author")
	@JacksonXmlProperty(localName="author")
	private String author;	
}
