package com.daveplaces.dao;

import java.util.Set;

public interface IDashboardDAO {

	Set getPhotoOut();

	void setPhotoOut(Set photoOut);

	Set getPhotoIn();

	void setPhotoIn(Set photoIn);

	Set getPhotoException();

	void setPhotoException(Set photoException);

}