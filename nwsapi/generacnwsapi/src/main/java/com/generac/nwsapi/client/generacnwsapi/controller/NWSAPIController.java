package com.generac.nwsapi.client.generacnwsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.generac.nwsapi.client.generacnwsapi.entity.HistoricalTempData;

import jakarta.validation.constraints.NotEmpty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author senthilvinayahammurugan
 *
 */

@RestController
@RequestMapping(path="/api", produces= {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class NWSAPIController {

	private static final Logger logger = LoggerFactory.getLogger(NWSAPIController.class);
	
	@GetMapping("getLowAndHighTemp")
	public ResponseEntity<List<HistoricalTempData>> getHighAndLowTempForLocation(@NotEmpty @RequestParam String latitude, @NotEmpty @RequestParam String longitude) throws JSONException, ParseException {
		return ResponseEntity.status(HttpStatus.OK)
		.body(getLowAndHighTempEachDay(latitude, longitude));
	}
	
	
	
	private String getForecast(String x, String y) {
		String URI="https://api.weather.gov/points/"+ x +","+ y;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(URI, toString().getClass());
		JSONObject json = new JSONObject(result);
		JSONObject properties = json.getJSONObject("properties");
        String forecast = properties.getString("forecast");
		return forecast;
	}
	
	//"39.7456","-97.0892"
	private List<HistoricalTempData> getLowAndHighTempEachDay(String latitude, String longitude) throws JSONException, ParseException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(getForecast(latitude, longitude), toString().getClass());
		JSONObject json = new JSONObject(result);
		JSONObject properties = json.getJSONObject("properties");
		JSONArray periods = properties.getJSONArray("periods");
		List<HistoricalTempData> lstHistoricalTempData = new ArrayList<HistoricalTempData>();
		
		for(int i =0; i < periods.length(); i++) {
			HistoricalTempData historicalTempData = new HistoricalTempData();
			if(i % 2 != 0) {
				historicalTempData.setDate_s(periods.getJSONObject(i).get("startTime").toString());
				historicalTempData.setHighTemp(periods.getJSONObject(i).get("temperature").toString()+" "+ periods.getJSONObject(i).get("temperatureUnit").toString());
				lstHistoricalTempData.add(historicalTempData);
			}
		}
		int index=0;
		for(int i =0; i < periods.length(); i++) {
			if(i % 2 == 0) {
				lstHistoricalTempData.get(index)
					.setLowTemp(periods.getJSONObject(i).get("temperature").toString()+" "+ periods.getJSONObject(i).get("temperatureUnit").toString());
				index++;
			}
		}
			
		return lstHistoricalTempData;
	}
	
	
	private String dateConversion(String date_s) throws ParseException {
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
		Date date = dt.parse(date_s); 
		SimpleDateFormat dt1 = new SimpleDateFormat("mm-dd-yyyy");
		return dt1.format(date);
	}
	

	
	public ResponseEntity<String> getHighAndLowTempForLocationFallback(Throwable throwable){
		
		logger.debug("getHighAndLowTempForLocationFallback Method Invoked");

		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Internal error");
		
	}
	
}
