package controllers;

import java.util.List;

import models.Postagem;
import play.mvc.Controller;

public class Postagens extends Controller {
	
	public static void listar() {
		List<Postagem> postagens = Postagem.findAll();
		render(postagens);
	}
	
	public static void salvar(Postagem p) {
		
		if(p.data != null) {
			p.save();
			flash.success("Postagem Cadastrada com sucesso!");
			listar();
		} else {
			flash.success("Por favor selecione uma data");
			form();
		}
	}
	
	public static void form() {
		render();
	}
	
	public static void remover(Long id) {
		Postagem p = Postagem.findById(id);
		p.delete();
		flash.success("Postagem removida com sucesso!");
		listar();
	}
	
}
