package jp.co.f1.spring.bms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.f1.spring.bms.entity.Book;

//おそらくrailsでいうところのアクティブレコードのようなものこれでメソッドを色々使うことができる
//jpa以外にもmybatis・hibernateが用意システムごとに使い分けられる。
//基本的にEntity毎にRepositoryを作成します。
@Repository
public interface BookRepository extends JpaRepository<Book,String> {   //DTOクラスと型
	
	
	//findByIsbnメソッドisbn番号を引数にしてBookインスタンスを取り出すメソッド
//	Bookクラスから自動で検索してきてくれる。
//	findByIsbn
//	↓
//	"find" "By" "Isbn"(引数)
//	↓
//	select * from テーブル　where isbn = 引数；
//	
	
	
	
	
//	しかし戻り値がOptionalとなってるnullでも何とかしてくれる
	
	
	
	
	public Optional<Book> findByIsbn(String isbn);

}
