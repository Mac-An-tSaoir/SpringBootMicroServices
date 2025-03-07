package com.daveplaces.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DashboardDAO implements IDashboardDAO {
	
	private Set<String> photoOut = new HashSet<String>();
	private Set<String> photoIn = new HashSet<String>();
	private Set<String> photoException = new HashSet<String>();

	@KafkaListener(topics="photoIn", groupId="plantplaces")
	public void processPhotoIn(String path) {
		getPhotoIn().add(path);
	}
	
	@KafkaListener(topics="photoOut", groupId="plantplaces")
	public void processPhotoOut(String path) {
		getPhotoOut().add(path);
	}
	
	@KafkaListener(topics="photoException", groupId="plantplaces")
	public void processPhotoException(String path) {
		getPhotoException().add(path);
	}

	@Override
	public Set<String> getPhotoOut() {
		return photoOut;
	}

	@Override
	public void setPhotoOut(Set photoOut) {
		this.photoOut = photoOut;
	}

	@Override
	public Set<String> getPhotoIn() {
		return photoIn;
	}

	@Override
	public void setPhotoIn(Set photoIn) {
		this.photoIn = photoIn;
	}

	@Override
	public Set<String> getPhotoException() {
		return photoException;
	}

	@Override
	public void setPhotoException(Set photoException) {
		this.photoException = photoException;
	}
}
