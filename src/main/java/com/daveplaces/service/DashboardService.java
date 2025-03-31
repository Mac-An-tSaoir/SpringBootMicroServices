package com.daveplaces.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daveplaces.dao.IDashboardDAO;

@Service
public class DashboardService implements IDashboardService {
	
	@Autowired
	private IDashboardDAO dashboardDAO;
	
	@Override
	public Set<String> getUnprocessedPhotos() {
		Set<String> difference = new HashSet<String>(dashboardDAO.getPhotoIn());
		difference.removeAll(dashboardDAO.getPhotoOut());
		return difference;
		
	}
	
	@Override
	public Set<String> getProcessedPhotos() {
		Set<String> intersection = new HashSet<String>(dashboardDAO.getPhotoIn());
		intersection.retainAll(dashboardDAO.getPhotoOut());
		return intersection;
		
	}
	
	@Override
	public Set<String> getExceptions() {
		return dashboardDAO.getPhotoException();
		
	}

}
