package com.cinema.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.cinema.enitity.MovieType;

public class MovieTools {
	/**
	 * 通过给定xml文件获得一个Document对象
	 * @param file
	 * @return	Document
	 */
	public static Document getDocument(File file) {
		if(!file.exists()) {
			return null;
		}
		SAXReader sax=new SAXReader();
		Document doc=null;
		try {
			doc=sax.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
	/**
	 * 把给定的doc写进file文件中
	 * @param doc
	 * @param file
	 * @return boolean
	 */
	public static boolean writerDoc(Document doc,File file) {
		
		OutputFormat format=new OutputFormat();
		format.setEncoding("GBK");
		format.setXHTML(true);
		format.setNewlines(true);
		if(!file.exists()) {
			return false;
		}
		try {
			if(doc==null) {
				return false;
			}
			XMLWriter xw=new XMLWriter(new FileWriter(file), format);
			xw.write(doc);
			xw.flush();
			xw.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
		
	}
	public static MovieType getMovieType(String movieType) {
		switch(movieType) {
		case "Action":
		case "动作":	
			return MovieType.Action;
		case "Comedy":
		case "喜剧":
			return MovieType.Comedy;
		case "爱情":
		case "Romanc":
			return MovieType.Romance;
		case "Cartoon":
		case "卡通动漫":
			return MovieType.Cartoon;
		case "恐怖":
		case "Thriller":
			return MovieType.Thriller;
		case "War":
		case "军事":
			return MovieType.War;
		}
		return null;
		
	}
}
