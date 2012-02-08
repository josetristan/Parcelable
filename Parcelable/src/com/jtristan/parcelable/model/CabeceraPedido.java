package com.jtristan.parcelable.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class CabeceraPedido implements Parcelable {

	private Long id;
	private String nombre;
	private String direccion;
	private boolean servido;
	private LineaPedido linea;
	private ArrayList<LineaPedido> lineas;
	
	public CabeceraPedido(){
		linea = new LineaPedido();
		lineas = new ArrayList<LineaPedido>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isServido() {
		return servido;
	}

	public void setServido(boolean servido) {
		this.servido = servido;
	}

	public ArrayList<LineaPedido> getLineas() {
		return lineas;
	}

	public void addLinea(LineaPedido linea) {		 
		 lineas.add(linea);
	}

	
	public LineaPedido getLinea() {
		return linea;
	}

	public void setLinea(LineaPedido linea) {
		this.linea = linea;
	}
	
	public CabeceraPedido(Parcel parcel){
		this();
		readToParcel(parcel);
	}
		
	public static final Parcelable.Creator<CabeceraPedido> CREATOR = 
								new Parcelable.Creator<CabeceraPedido>() {

		public CabeceraPedido createFromParcel(Parcel parcel) {
			return new CabeceraPedido(parcel);
		}

		public CabeceraPedido[] newArray(int size) {
			return new CabeceraPedido[size];
		}
		
		
	};
	
	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeLong(id);
		parcel.writeString(nombre);
		parcel.writeString(direccion);
		parcel.writeString(String.valueOf(servido));			
		parcel.writeTypedList(lineas);
		parcel.writeParcelable(linea, flags);
	}
	
	public void readToParcel(Parcel parcel){
		String servido;
		
		id = parcel.readLong();
		nombre = parcel.readString();
		direccion = parcel.readString();
		servido = parcel.readString();
		if (servido.equals("true"))
			this.servido = true;
		else 
			this.servido = false;		
		parcel.readTypedList(lineas, LineaPedido.CREATOR);
		linea = parcel.readParcelable(LineaPedido.class.getClassLoader());		
		
	}
	
	
}
