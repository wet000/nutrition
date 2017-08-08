package com.wet.api.nutrition.service;

import com.wet.api.common.service.CommonService;
import com.wet.api.nutrition.model.Source;

public interface SourceService extends CommonService 
{
    public Source create(String releaseVersion);
}