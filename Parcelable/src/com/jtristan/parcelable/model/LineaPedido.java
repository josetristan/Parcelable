package com.jtristan.parcelable.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LineaPedido implements Parcelable {
	
	private Long id;
	private String material;
	private Integer cantidad;
	private Double precio;
	
	public LineaPedido(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	public LineaPedido(Parcel parcel){
		readToParcel(parcel);
	}
	
	public static final Parcelable.Creator<LineaPedido> CREATOR = 
				new Parcelable.Creator<LineaPedido>() {

		public LineaPedido createFromParcel(Parcel source) {
			return new LineaPedido(source);
		}

		public LineaPedido[] newArray(int size) {
			return new LineaPedido[size];
		}
				
	
	};
	
	public int describeContents() {
		return 0;
	}
	
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeLong(id);
		parcel.writeString(material);
		parcel.writeInt(cantidad);
		parcel.writeDouble(precio);		
	}
	
	public void readToParcel(Parcel parcel){
		id = parcel.readLong();
		material = parcel.readString();
		cantidad = parcel.readInt();
		precio = parcel.readDouble();
	}
	
	
	
}
