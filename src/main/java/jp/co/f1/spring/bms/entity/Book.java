package jp.co.f1.spring.bms.entity;

//entityクラス
//DTO クラス

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

//もしクラス名がテーブル名ならテーブルアノテーションは省略可能

@Table(name="bookinfo")
public class Book {

	//ISBN
	@Id
	@Column(length=20)
	private String isbn;

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	//	title
	@Column(length=100,nullable=true)
	private String title;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	//	price
	@Column(length=11, nullable = true)
	private String price;

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
