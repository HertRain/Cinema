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
	 * ͨ������xml�ļ����һ��Document����
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
	 * �Ѹ�����docд��file�ļ���
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
		case "����":	
			return MovieType.Action;
		case "Comedy":
		case "ϲ��":
			return MovieType.Comedy;
		case "����":
		case "Romanc":
			return MovieType.Romance;
		case "Cartoon":
		case "��ͨ����":
			return MovieType.Cartoon;
		case "�ֲ�":
		case "Thriller":
			return MovieType.Thriller;
		case "War":
		case "����":
			return MovieType.War;
		}
		return null;
		
	}
}
