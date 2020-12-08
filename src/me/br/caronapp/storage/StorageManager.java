package me.br.caronapp.storage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import me.br.caronapp.carona.Carona;
import me.br.caronapp.usuario.Usuario;

/*
 * Author: Sérgio Ricardo
 */

public class StorageManager implements Storable{

	@Override
	public void salva(ArrayList<Usuario> listaUsuarios, ArrayList<Carona> listaCaronas) {
		try {
			FileOutputStream usuariosFile = new FileOutputStream("usuarios.bin");
			FileOutputStream caronasFile = new FileOutputStream("caronas.bin");
			ObjectOutputStream usuariosOutputStream = new ObjectOutputStream(usuariosFile);
			ObjectOutputStream caronasOutputStream = new ObjectOutputStream(caronasFile);
			for (Usuario usuario : listaUsuarios) {
				usuariosOutputStream.writeObject(usuario);
			}
			for (Carona carona : listaCaronas) {
				caronasOutputStream.writeObject(carona);
			}
			usuariosOutputStream.close();
			caronasOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void carrega(ArrayList<Usuario> listaUsuarios, ArrayList<Carona> listaCaronas) {
		try {
			FileInputStream usuariosFile = new FileInputStream("usuarios.bin");
			FileInputStream caronasFile = new FileInputStream("caronas.bin");
			ObjectInputStream usuariosInputStream = new ObjectInputStream(usuariosFile);
			ObjectInputStream caronasInputStream = new ObjectInputStream(caronasFile);
			try {
				while(true) {
					listaUsuarios.add((Usuario) usuariosInputStream.readObject());
				}
			} catch (EOFException e) {
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				while(true) {
					listaCaronas.add((Carona) caronasInputStream.readObject());
				}
			} catch (EOFException e) {
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			usuariosInputStream.close();
			caronasInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
