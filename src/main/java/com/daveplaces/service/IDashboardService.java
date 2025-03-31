package com.daveplaces.service;

import java.util.Set;

public interface IDashboardService {

	Set<String> getUnprocessedPhotos();

	Set<String> getProcessedPhotos();

	Set<String> getExceptions();

}