package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.service.SourceDaoService;
import com.wet.api.nutrition.service.SourceService;

@Service
public class SourceServiceImpl implements SourceService 
{
	@Autowired
	SourceDaoService sourceDaoService;
}