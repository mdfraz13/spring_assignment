package com.axiom.assesment.common;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.logging.log4j.util.Strings.isBlank;

import com.axiom.assesment.model.ErrResp;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchParamValidator {

	private static final Logger log = LogManager.getLogger(SearchParamValidator.class);

	public static ErrResp validate(final Map<String, String> params)
	{
		if (params == null || params.isEmpty())
		{
			log.error("invalid search params for headsets in request {}, not proceeding ", params);
			return new ErrResp("INVALID_PARAM", "empty search params in request");
		}

		if (params.containsKey("id")) {
			final String id = params.get("id");
			if (isBlank(id) || !isNumeric(id)) {
				log.error("invalid id params for headsets in request {}, not proceeding ", id);
				return new ErrResp("INVALID_ID", "Invalid id in request param");
			}
		}

		if (params.containsKey("brand")) {
			final String brand = params.get("brand");
			if (isBlank(brand)) {
				log.error("invalid brand params for headsets in request {}, not proceeding ", brand);
				return new ErrResp("INVALID_BRAND", "Invalid brand name in request param");
			}
		}

		if (params.containsKey("phone")) {
			final String phone = params.get("phone");
			if (isBlank(phone)) {
				log.error("invalid phone params for headsets in request {}, not proceeding ", phone);
				return new ErrResp("INVALID_PHONE", "Invalid phone in request param");
			}
		}

		if (params.containsKey("picture")) {
			final String picture = params.get("picture");
			if (isBlank(picture)) {
				log.error("invalid picture params for headsets in request {}, not proceeding ", picture);
				return new ErrResp("INVALID_PICTURE", "Invalid picture in request param");
			}
		}

		if (params.containsKey("sim")) {
			final String sim = params.get("sim");
			if (isBlank(sim)) {
				log.error("invalid sim params for headsets in request {}, not proceeding ", sim);
				return new ErrResp("INVALID_SIM", "Invalid sim in request param");
			}
		}

		if (params.containsKey("resolution")) {
			final String resolution = params.get("resolution");
			if (isBlank(resolution)) {
				log.error("invalid resolution params for headsets in request {}, not proceeding ", resolution);
				return new ErrResp("INVALID_RESOL", "Invalid resolution in request param");
			}
		}

		if (params.containsKey("announceDate")) {
			final String announceDate = params.get("announceDate");
			if (isBlank(announceDate)) {
				log.error("invalid announceDate params for headsets in request {}, not proceeding ", announceDate);
				return new ErrResp("INVALID_ADATE", "Invalid announceDate in request param");
			}
		}

		if (params.containsKey("priceEur")) {
			final String priceEur = params.get("priceEur");
			if (isBlank(priceEur) || !isNumeric(priceEur)) {
				log.error("invalid priceEur params for headsets in request {}, not proceeding ", priceEur);
				return new ErrResp("INVALID_PEUR", "Invalid priceEur in request param");
			}
		}

		if (params.containsKey("audioJack")) {
			final String audioJack = params.get("audioJack");
			if (isBlank(audioJack)) {
				log.error("invalid audioJack params for headsets in request {}, not proceeding ", audioJack);
				return new ErrResp("INVALID_AJACK", "Invalid audioJack in request param");
			}
		}

		if (params.containsKey("gps")) {
			final String gps = params.get("gps");
			if (isBlank(gps)) {
				log.error("invalid gps params for headsets in request {}, not proceeding ", gps);
				return new ErrResp("INVALID_GPS", "Invalid gps in request param");
			}
		}

		if (params.containsKey("battery")) {
			final String battery = params.get("battery");
			if (isBlank(battery)) {
				log.error("invalid battery params for headsets in request {}, not proceeding ", battery);
				return new ErrResp("INVALID_BATTERY", "Invalid battery in request param");
			}
		}

		return null;
	}
}
