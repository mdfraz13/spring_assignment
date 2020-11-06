package com.axiom.assesment.services;

import com.axiom.assesment.model.MobileHandset;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MobileHandsetSearchService {

	private static final Logger log = LogManager.getLogger(MobileHandsetSearchService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CacheManager cacheManager;

	@Value("${mobile.handsets.endpoint}")
	private String mobileHandsetsUrl;

	@Cacheable("allmobiles")
	public List<MobileHandset> getAllMobiles()
	{
		log.info("calling the mobile handset api ");
		final MobileHandset[] mobileHandSets = restTemplate.getForObject(mobileHandsetsUrl, MobileHandset[].class);

		if (mobileHandSets != null && mobileHandSets.length > 0) {
			log.info("recieved response from the mobile handset api, {} records", mobileHandSets.length);
			return Arrays.asList(mobileHandSets);
		}

		log.warn("no records returning null");
		return null;
	}

	public void invalidateCache() {
		log.info("invalidating the caches");
		for (final String name : cacheManager.getCacheNames()) {
			final Cache cache = cacheManager.getCache(name);
			if (cache != null) {
				cache.invalidate();
			}
		}
	}

}
