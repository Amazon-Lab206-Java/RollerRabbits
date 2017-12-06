package com.cadence.Books.models;

public class Book {
	private String title;
	private String description;
	private String language;
	private int numberOfPages;
	
	public Book() {
	}
		
		public Book(String title, String desc, String lang, int pages) {
			this.title=title;
			this.description=desc;
			this.language=lang;
			this.numberOfPages=pages;
		}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language=language;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages=numberOfPages;
	}
		
	
	public class Book {
	    @Size(min = 3, max = 20)
	    private String title;
	    
	    @Size(min = 5, max = 200)
	    private String description;
	    
	    @Size(min = 3, max = 40)
	    private String language;
	    
	    @Min(100)
	    private int numberOfPages;
}
