package com.zsgs.knowledgehub.repository.dto;

public class Book {
    private String Id;
    private String Name;
    private String Genre;
    private byte Volume;
    private Integer PublishedYear;
    public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public byte getVolume() {
		return Volume;
	}
	public void setVolume(byte volume) {
		Volume = volume;
	}
	public Integer getPublishedYear() {
		return PublishedYear;
	}
	public void setPublishedYear(Integer publishedYear) {
		PublishedYear = publishedYear;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public Byte getNoOfCopy() {
		return NoOfCopy;
	}
	public void setNoOfCopy(byte noOfCopy) {
		NoOfCopy = noOfCopy;
	}
	public Byte getAvailableCount() {
		return AvailableCount;
	}
	public void setAvailableCount(byte availableCount) {
		AvailableCount = availableCount;
	}
	private String Author;
    private Byte NoOfCopy;
    private Byte AvailableCount;
	
}
