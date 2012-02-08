package com.jtristan.parcelable.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.jtristan.parcelable.model.CabeceraPedido;
import com.jtristan.parcelable.model.LineaPedido;

public class SegundaPantallaActivity extends Activity {
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     //setContentView(R.layout.main);
	     
	     CabeceraPedido pedido = new CabeceraPedido();
	     LineaPedido linea = new LineaPedido();
	     ArrayList<LineaPedido> lineas = new ArrayList<LineaPedido>();
	     	     
	     Bundle extra = this.getIntent().getExtras();
	     
	     pedido.setId(extra.getLong("com.jtristan.parcelable.ID_PEDIDO"));
	     pedido.setDireccion(extra.getString("com.jtristan.parcelable.DIRECCION"));
	     int numero_lineas_pedido = extra.getInt("com.jtristan.parcelable.NUMERO_LINEAS");
	   		
         Log.i("PEDIDO", pedido.getId().toString() + " " + pedido.getDireccion() + " "
        		 + String.valueOf(numero_lineas_pedido));
	     
	     pedido = extra.getParcelable("com.jtristan.parcelable.PEDIDO");	     
	     
	     Log.i("PEDIDO", pedido.getId().toString() + " " + pedido.getNombre() + " " 
	    		 + pedido.getDireccion() + " " 
	    		 + pedido.isServido());
	     
	     lineas = pedido.getLineas();
	     for (int i=0; i<lineas.size();i++){
	    	 linea = lineas.get(i);
	    	 Log.i("LINEA", linea.getId().toString() + " " + linea.getMaterial() + " " 
	    			 + linea.getCantidad().toString() + " " + linea.getPrecio().toString());
	    	 
	     }
	 }    

}

