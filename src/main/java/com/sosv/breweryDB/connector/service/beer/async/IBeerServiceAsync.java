/*
Copyright 2013 Sven Sommerfeld (svensommerfeld1982@gmail.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.sosv.breweryDB.connector.service.beer.async;

import java.util.List;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.async.IResultCallback;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;

/**
 * Interface for the services for beers
 * 
 * @author Sven
 * 
 */
public interface IBeerServiceAsync {

	/**
	 * Get all beers (really all! Pages are gone through to get all beers in one
	 * list!) This is a premium function
	 * 
	 * @param callback
	 *            The callback which is called if the method is done
	 */
	void getAllBeers(IResultCallback<List<Beer>> callback);

	/**
	 * Get beers for a page. You can get the amount of pages with
	 * {@link BeerResultPage#getNumberOfPages()} and the current page with
	 * {@link BeerResultPage#getCurrentPage()}. If you want the first page you
	 * can use null as parameter
	 * 
	 * @param pageNumber
	 *            The number of the page. First page can be retrieved with null.
	 * @param callback
	 */
	void getPagesBeers(Number pageNumber,
			IResultCallback<BeerResultPage> callback);

	/**
	 * Get all beers with a filter applied
	 * 
	 * @param beerFilter
	 *            The filter to apply
	 * @param callback
	 */
	void getAllBeers(IBeersFilter beerFilter,
			IResultCallback<List<Beer>> callback);

	/**
	 * Get beers for specific filter. The page indicates the number of the page
	 * requested
	 * 
	 * @param beerFilter
	 *            The filter to apply
	 * @param pageNumber
	 *            The page number => for page 1 provide NULL
	 * @param callback
	 */
	void getPagesBeers(Number pageNumber, IBeersFilter beerFilter,
			IResultCallback<BeerResultPage> callback);

	/**
	 * Get a beer by its id
	 * 
	 * @param id
	 *            Id of the beer
	 */
	void getBeerById(String id, IResultCallback<Beer> callback);

	/**
	 * Get a beer by its id with a filter (e.g. with breweries)
	 * 
	 * @param id
	 * @param filter
	 */
	void getBeerById(String id, IBeerFilter filter, IResultCallback<Beer> callback);
}
