package com.jtristan.parcelable.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jtristan.parcelable.R;
import com.jtristan.parcelable.model.CabeceraPedido;
import com.jtristan.parcelable.model.LineaPedido;

public class PrimeraPantallaActivity extends Activity{
	
	Context context;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        CabeceraPedido pedido = new CabeceraPedido();
        LineaPedido linea = new LineaPedido();
        
        pedido.setId(new Long(1));
        pedido.setNombre("Juan López");
        pedido.setDireccion("C. Las acacias");
        pedido.setServido(false);
        
        linea.setId(new Long(1));
        linea.setMaterial("TORNILLOS");
        linea.setCantidad(1000);
        linea.setPrecio(0.0025);
        pedido.addLinea(linea);
        linea = new LineaPedido();
        linea.setId(new Long(2));
        linea.setMaterial("ARANDELAS");
        linea.setCantidad(1000);
        linea.setPrecio(0.001);
        pedido.addLinea(linea);
        
        pedido.setLinea(linea);
        
                
        Intent intent = new Intent(this, SegundaPantallaActivity.class);
        
        intent.putExtra("com.jtristan.parcelable.ID_PEDIDO", pedido.getId());
        intent.putExtra("com.jtristan.parcelable.DIRECCION", pedido.getDireccion());
        intent.putExtra("com.jtristan.parcelable.NUMERO_LINEAS", pedido.getLineas().size());
        
        intent.putExtra("com.jtristan.parcelable.PEDIDO", pedido);
        startActivity(intent);
        
       
    }
}