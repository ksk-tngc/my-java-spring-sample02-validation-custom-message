package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

/**
 * 請求書画面用のModelです。
 */
@Data
public class Invoice {

	/**
	 * お客様名
	 * 必須、60文字まで
	 */
	@NotNull
	@Size(min = 1, max = 60)
	private String name;

	/**
	 * 住所
	 * 必須、254文字まで
	 */
	@NotNull
	@Size(min = 1, max = 254)
	private String address;

	/**
	 * 電話番号
	 * 必須、半角数字かハイフン
	 */
	@NotNull
	@Pattern(regexp = "^[0-9]+-[0-9]+-[0-9]+$")
	private String phoneNumber;

	/**
	 * 金額 (円)
	 * 必須、1000円以上、数値に変換
	 */
	@NotNull
	@Min(1000)
	@NumberFormat(pattern = "#,###")
	private BigDecimal price;

	/**
	 * 支払期日
	 * 必須、日付に変換
	 */
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate paymentDeadline;

}
