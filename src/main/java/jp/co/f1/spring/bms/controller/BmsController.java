package jp.co.f1.spring.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.f1.spring.bms.entity.Book;
import jp.co.f1.spring.bms.repository.BookRepository;

@Controller
public class BmsController {
	
	@Autowired
	private BookRepository bookinfo;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		
		Iterable<Book> book_list = bookinfo.findAll();
		
//		ModelAndViewにviewに渡す変数を格納
		mav.addObject("book_list",book_list);
		
//		これがあることでModelとviewを呼び出せるつまりlist.htmlをよびだすことができる
		
		mav.setViewName("list");
		
		
		return mav;
		
	}
	
//	insertにアクセスがあった場合
	
	@RequestMapping("/insert")
	public ModelAndView insert(ModelAndView mav) {
		
		mav.setViewName("insert");
		
		return mav;
		
	}
	
//	insertに対してぽスト送信された場合
	
	@RequestMapping(value= "/insert", method=RequestMethod.POST)
	
	
//	@ModelAttributeあのテーション　　
	public ModelAndView insertPost(@ModelAttribute Book book, ModelAndView mav) {
		
		bookinfo.saveAndFlush(book);

		mav = new ModelAndView("redirect:/list");
		
		return mav;
		
	}
	
	
	
	
	
	
}
