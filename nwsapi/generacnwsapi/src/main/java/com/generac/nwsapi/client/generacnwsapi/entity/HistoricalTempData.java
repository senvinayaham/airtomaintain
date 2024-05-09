package com.generac.nwsapi.client.generacnwsapi.entity;

import lombok.Data;

@Data
public class HistoricalTempData {
	
    private String date_s;
    private String lowTemp;
    private String highTemp;

}
