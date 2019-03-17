package com.jaceksysiak.spring.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaceksysiak.spring.web.dao.Offer;
import com.jaceksysiak.spring.web.dao.OffersDao;

@Service("offersService")
public class OffersService {
	
	private OffersDao offersDao;
	
	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent() {
		return offersDao.getOffers();
	}

	public void create(@Valid Offer offer) {
		 
		offersDao.create(offer);
	}

	public void throwTestException() {
		
		offersDao.getOffer(9999);
		
	}
}



































