package com.daveplaces.dao;

import java.util.Set;

public interface IDashboardDAO {

	Set<String> getPhotoOut();

	void setPhotoOut(Set<String> photoOut);

	Set<String> getPhotoIn();

	void setPhotoIn(Set<String> photoIn);

	Set<String> getPhotoException();

	void setPhotoException(Set<String> photoException);

}