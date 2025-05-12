package com.example.bugfix;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class CreateFile {

	protected static boolean createDummyFile(int byteSize) {
		File file = new File("./DummyFile");
		file.delete();

		// 元コード：try (RandomAccessFile rFile = new RandomAccessFile(file.getPath(), "rw"))
		// 問題点：パッケージインポートされてない
		// 修正：import java.io.RandomAccessFile;を追加
		try (RandomAccessFile rFile = new RandomAccessFile(file.getPath(), "rw")) {
			rFile.setLength(byteSize);
			rFile.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}