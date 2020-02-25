package application.service;

import java.util.List;

import application.entity.News;
import application.model.NewsModel;

public interface NewsService {
	
	public abstract List<NewsModel> listNews();

	public abstract NewsModel addNews(NewsModel newsModel);

	public abstract int removeNews(int id);

	public abstract News transform(NewsModel newsModel);

	public abstract NewsModel transform(News news);

}
