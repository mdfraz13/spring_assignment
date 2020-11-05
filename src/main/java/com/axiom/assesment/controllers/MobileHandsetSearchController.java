package com.axiom.assesment.controllers;

import static com.axiom.assesment.common.MobileHandsetHelper.calculatePredicate;
import static com.axiom.assesment.common.SearchParamValidator.validate;

import com.axiom.assesment.model.ErrResp;
import com.axiom.assesment.model.MobileHandset;
import com.axiom.assesment.model.SearchResp;
import com.axiom.assesment.services.MobileHandsetSearchService;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile")
public class MobileHandsetSearchController {

	private static final Logger log = LogManager.getLogger(MobileHandsetSearchController.class);

	@Autowired
	private MobileHandsetSearchService searchService;

	@GetMapping("/search")
	public SearchResp searchMobiles(@RequestParam Map<String, String> params) {
		log.info("calling search handsets ");

		final ErrResp errResp = validate(params);

		if (errResp != null)
		{
			log.error("found validation error {} for params {} ", errResp, params);
			new SearchResp(errResp);
		}

		final List<MobileHandset> listMobile = searchService.getAllMobiles();
		if (listMobile == null)
		{
			log.error("found no data from service, not proceeding ");
			return new SearchResp(new ErrResp("INVALID_DATA", "No records found from api"));
		}

		log.info("found total {} handsets from api ", listMobile.size());

		final Predicate<MobileHandset> mobileHandsetPredicate = calculatePredicate(params);

		log.info("applying filter to the list ");
		final List<MobileHandset> resultedSet = listMobile.stream()
														  .filter(mobileHandsetPredicate)
														  .collect(Collectors.toList());

		if (resultedSet.isEmpty())
		{
			log.error("found no data after applying filter, not proceeding ");
			return new SearchResp(new ErrResp("NO_DATA", "No records with the searched params"));
		}

		log.info("total items found with search params {} ", resultedSet.size());

		return new SearchResp(resultedSet);
	}

	@DeleteMapping("/invalidate/cache")
	public void invalidateCache() {
		searchService.invalidateCache();
	}

}
