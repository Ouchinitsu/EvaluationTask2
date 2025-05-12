package com.example.bugfix;

class InputCheck {

	private String str;

	public InputCheck(String str) {
		if (str == null) {
			str = "";
		}
		// 元コード：str = str;
		// 問題点：インスタンス変数が初期化されない
		// 修正：this.str = str;
		this.str = str;
	}

	protected boolean isNumeric() {

		// 元コード：if (this.str == "")
		// 問題点：Javaで文字列比較は==では不適切
		// 修正：if (this.str.equals(""))
		if (this.str.equals("")) {
			return false;
		}

		for (int i = 0; i < this.str.length(); i++) {
			char c = this.str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	protected boolean checkSize() {
		if (this.str.length() <= 10) {
			if (Math.abs(Integer.parseInt(this.str)) <= 1024 * 1024 * 100) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
}
