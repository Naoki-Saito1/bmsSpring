package jp.co.f1.spring.bms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.f1.spring.bms.entity.Book;
import jp.co.f1.spring.bms.repository.BookRepository;

@Controller
public class BmsController {
	
	
	
	@Autowired
	private BookRepository bookinfo;
	
	
	
	
	
	
	@RequestMapping("/insert")
	public ModelAndView insert(ModelAndView mav) {
		
		mav.setViewName("insert");
		
		return mav;
		
	}
	
//	insertにアクセスがあった場合
	
	@RequestMapping(value= "/insert", method=RequestMethod.POST)
	
	
//	@ModelAttributeあのテーション
	//postmedhotで送信されたデータをBookインスタンスで受け取る。
	//Book book = new book として1つずつセットしてもいい。
	
	public ModelAndView insertPost(@ModelAttribute Book book, ModelAndView mav) {
		
//		bookinfoというでーたベースにbookインスタンスで送られてきたデータを自動で
//		保存してくれる
		bookinfo.saveAndFlush(book);

//		forwardの場合もforward:と記述する。
		
		
		
		mav = new ModelAndView("redirect:/list");
		
		return mav;
		
	}
	
//	insertに対してぽスト送信された場合
	
//	@Repository
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		
		Iterable<Book> book_list = bookinfo.findAll();
		
//		ModelAndViewにviewに渡す変数を格納
		mav.addObject("book_list",book_list);
		
//		これがあることでModelとviewを呼び出せるつまりlist.htmlをよびだすことができる
		
		mav.setViewName("list");
		
		
		return mav;
		
	}
	
//	@RequestMapping(value= "/detail")
//	public ModelAndView detail(@ModelAttribute Book book, ModelAndView mav) {
//		
//		Optional<Book> book1 = bookinfo.findByIsbn(book.getIsbn());
//		
////		取得したエンティティクラス（viewから送られてきた値をもとに
////		bookインスタンスを取得する）
//		
////		取得したエンティティをviewに渡す
//		
//		mav.addObject("book",book1.get());
//		
//		mav.setViewName("detail");
//		
//		
//		return mav;
//	}
	
	
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam("isbn") String isbn, ModelAndView mav) {
		
		Optional<Book> book1 = bookinfo.findByIsbn(isbn);
		
		mav.addObject("book",book1.get());
		mav.setViewName("detail");
		
		return mav;
	}
	
	
}
