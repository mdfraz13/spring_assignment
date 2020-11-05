package com.axiom.assesment.common;

import com.axiom.assesment.model.MobileHandset;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MobileHandsetHelper {

	private static final Logger log = LogManager.getLogger(MobileHandsetHelper.class);

	public static Predicate<MobileHandset> calculatePredicate(Map<String, String> params) {

		Predicate<MobileHandset> mobileHandsetPredicate = mobileHandset -> true;

		if (params.containsKey("id")) {
			final String id = params.get("id");
			log.info("param id : {} ", id);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getId() == Long.parseLong(id);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("brand")) {
			final String brand = params.get("brand");
			log.info("param brand : {} ", brand);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getBrand() != null
																		&& contains(mobileHandset.getBrand(), brand);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("phone")) {
			final String phone = params.get("phone");
			log.info("param phone : {} ", phone);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getPhone() != null
																		&& contains(mobileHandset.getPhone(), phone);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("picture")) {
			final String picture = params.get("picture");
			log.info("param picture : {} ", picture);
			final Predicate<MobileHandset> brandPredicate = mobileHandset -> mobileHandset.getPicture() != null
																			 && contains(mobileHandset.getPicture(), picture);
			mobileHandsetPredicate = mobileHandsetPredicate.and(brandPredicate);
		}

		if (params.containsKey("sim")) {
			final String sim = params.get("sim");
			log.info("param sim : {} ", sim);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getSim() != null
																		&& contains(mobileHandset.getSim(), sim);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("resolution")) {
			final String resolution = params.get("resolution");
			log.info("param resolution : {} ", resolution);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getResolution() != null
																		&& contains(mobileHandset.getResolution(), resolution);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("announceDate")) {
			final String announceDate = params.get("announceDate");
			log.info("param announceDate : {} ", announceDate);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getRelease() != null
																		&& contains(mobileHandset.getRelease().getAnnounceDate(), announceDate);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("priceEur")) {
			final String priceEur = params.get("priceEur");
			log.info("param priceEur : {} ", priceEur);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getRelease() != null
																		&& contains(mobileHandset.getRelease().getPriceEur(), priceEur);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("audioJack")) {
			final String audioJack = params.get("audioJack");
			log.info("param audioJack : {} ", audioJack);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getHardware() != null
																		&& contains(mobileHandset.getHardware().getAudioJack(), audioJack);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("gps")) {
			final String gps = params.get("gps");
			log.info("param gps : {} ", gps);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getHardware() != null
																		&& contains(mobileHandset.getHardware().getGps(), gps);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		if (params.containsKey("battery")) {
			final String battery = params.get("battery");
			log.info("param battery : {} ", battery);
			final Predicate<MobileHandset> predicate = mobileHandset -> mobileHandset.getHardware() != null
																		&& contains(mobileHandset.getHardware().getBattery(), battery);
			mobileHandsetPredicate = mobileHandsetPredicate.and(predicate);
		}

		return mobileHandsetPredicate;
	}

	public static boolean contains(String strA , String strB) {
		return (strA != null && strB != null && strA.toLowerCase().contains(strB.toLowerCase()));
	}
}
