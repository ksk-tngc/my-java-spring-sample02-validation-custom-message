package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Invoice;

/**
 * トップページ用のコントローラです。
 */
@Controller
public class HomeController {

	/**
	 * トップページのGETリクエストを処理します。
	 *
	 * @param invoice リクエストパラメータがバインドされたオブジェクト
	 * @return 遷移後の画面（index.html）
	 */
	@GetMapping("/")
	public String index(@ModelAttribute Invoice invoice) {
		return "index";
	}

	/**
	 * トップページのPOSTリクエストを処理します。
	 *
	 * @param invoice リクエストパラメータがバインドされたオブジェクト
	 * @param bindingResult バインド結果
	 * @return 遷移後の画面
	 */
	@PostMapping("/")
	public String confirm(@Validated @ModelAttribute Invoice invoice,
			BindingResult bindingResult) {
		// バリデーションエラーがある場合はindex.htmlに戻る
		if (bindingResult.hasErrors()) {
			return "index";
		}
		return "confirm";
	}

}
