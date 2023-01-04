package com.example.pmdm_ejercicionavidad.modelos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("videoGames")
	private List<Object> videoGames;

	@SerializedName("parkAttractions")
	private List<Object> parkAttractions;

	@SerializedName("films")
	private List<Object> films;

	@SerializedName("shortFilms")
	private List<Object> shortFilms;

	@SerializedName("tvShows")
	private List<Object> tvShows;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("enemies")
	private List<Object> enemies;

	@SerializedName("_id")
	private int id;

	@SerializedName("allies")
	private List<Object> allies;

	@SerializedName("url")
	private String url;

	public void setVideoGames(List<Object> videoGames){
		this.videoGames = videoGames;
	}

	public List<Object> getVideoGames(){
		return videoGames;
	}

	public void setParkAttractions(List<Object> parkAttractions){
		this.parkAttractions = parkAttractions;
	}

	public List<Object> getParkAttractions(){
		return parkAttractions;
	}

	public void setFilms(List<Object> films){
		this.films = films;
	}

	public List<Object> getFilms(){
		return films;
	}

	public void setShortFilms(List<Object> shortFilms){
		this.shortFilms = shortFilms;
	}

	public List<Object> getShortFilms(){
		return shortFilms;
	}

	public void setTvShows(List<Object> tvShows){
		this.tvShows = tvShows;
	}

	public List<Object> getTvShows(){
		return tvShows;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEnemies(List<Object> enemies){
		this.enemies = enemies;
	}

	public List<Object> getEnemies(){
		return enemies;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAllies(List<Object> allies){
		this.allies = allies;
	}

	public List<Object> getAllies(){
		return allies;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"videoGames = '" + videoGames + '\'' + '\n' +
			",parkAttractions = '" + parkAttractions + '\n' +  '\n' +
			",films = '" + films + '\'' + + '\n' +
			",shortFilms = '" + shortFilms + '\'' + + '\n' +
			",tvShows = '" + tvShows + '\'' +  '\n' +
			",imageUrl = '" + imageUrl + '\'' + + '\n' +
			",name = '" + name + '\'' + '\n' +
			",enemies = '" + enemies + '\'' +  '\n' +
			",_id = '" + id + '\'' + '\n' +
			",allies = '" + allies + '\'' + '\n' +
			",url = '" + url + '\'' + '\n' +
			"}";
		}
}