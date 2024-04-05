package com.app.hotel.service.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

	private String hotelId;

	private String name;

	private String location;

	private String about;

}
