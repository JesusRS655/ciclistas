package application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.entity.News;
import application.model.NewsModel;
import application.repository.NewsRepository;
import application.service.NewsService;

@Service("newsServiceImpl")
public class NewsServiceImpl implements NewsService {

	@Autowired
	@Qualifier("newsRepository")
	private NewsRepository newsRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public List<NewsModel> listNews() {
		List<News> nList = newsRepository.findAll();
		List<NewsModel> nModelList = new ArrayList<>();
		for (News n : nList) {
			NewsModel nModel = transform(n);
			nModelList.add(nModel);
		}
		return nModelList;
	}

	@Override
	public NewsModel addNews(NewsModel newsModel) {
		News news = transform(newsModel);
		return transform(newsRepository.save(news));
	}

	@Override
	public int removeNews(int id) {
		newsRepository.deleteById(id);
		return 0;
	}

	@Override
	public News transform(NewsModel newsModel) {
		return config.mapper().map(newsModel, News.class);
	}

	@Override
	public NewsModel transform(News news) {
		return config.mapper().map(news, NewsModel.class);
	}

}
