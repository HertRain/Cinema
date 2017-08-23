package com.cinema.datadao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.cinema.datadao.MovieDao;
import com.cinema.enitity.Movie;
import com.cinema.enitity.MovieType;
import com.cinema.enitity.Person;
import com.cinema.enitity.Schedule;
import com.cinema.enitity.ScheduleItem;
import com.cinema.tools.MovieTools;

public class MovieBiz implements MovieDao{
	File file=new File("src/com/cinema/file/Movie.xml");
	@Override
	public Schedule getAllMovie() {
		// TODO Auto-generated method stub
		Document doc=MovieTools.getDocument(file);
		List<ScheduleItem> items=new ArrayList<ScheduleItem>();
		
		if(doc!=null) {
			Element root=doc.getRootElement();
			List<Element> movies=root.elements("Movie");
			
			for (Element eMovie : movies) {
				List<Person> persons=new ArrayList<Person>();
				
				Movie movie=new Movie();
				movie.setMovieName(eMovie.elementText("Name"));//电影名字
				movie.setPoster(eMovie.elementText("Poster"));//电影英文名
				movie.setPrice(Double.parseDouble(eMovie.elementText("Price")));//电影票价格
				persons.add(new Person(eMovie.elementText("Director"), eMovie.element("Director").getName()));//电影导演
				movie.setMovieType(MovieTools.getMovieType(eMovie.elementText("Type")));//电影导演
				List<Element> actors=eMovie.element("Actors").elements("Actor");
				for (Element element : actors) {
					persons.add(new Person(element.getText(),element.getName()));//电影演员
				}
				movie.setList(persons);
				
				List<Element> sItem=eMovie.element("Schedule").elements("Item");
				for (Element element : sItem) {
					items.add(new ScheduleItem(element.getText(), movie));
				}
			}
		}
		return new Schedule(items);
		
	}

}
