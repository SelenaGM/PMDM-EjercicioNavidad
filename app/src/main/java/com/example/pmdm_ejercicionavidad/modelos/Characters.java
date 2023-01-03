package com.example.pmdm_ejercicionavidad.modelos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Characters{

	@SerializedName("data")
	private List<DataItem> data;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"Characters{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}