package com.teste.primeiroexemplo.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository_old;

@Service
public class ProdutoService {
	
	@Autowired //instancia
	private ProdutoRepository_old produtoRepository;
	
	/**
	 * Metodo para retornar uma lista de produtos
	 * @return Lista de produtos
	 */
	public List<Produto> obterTodos(){
		return produtoRepository.obterTodos();
	}
	
	/**
	 * Método que retorna o produto encontrado pelo seu ID
	 * @param id do produto que será localizado
	 * @return Retorna um produto caso seja encontrado
	 */
	/*Optional se não encontrar algo dentro da lista, ele vai devolver algo nulo, algo que nao de erro*/
	public Optional<Produto> obterPorId(Integer id){
		return produtoRepository.obterPorId(id);
	}
	
	/**
	 * Metodo para adicionar produto na lista
	 * @param produto que será adicionado
	 * @return Retorna o produto que foi adicionado na lista
	 */
	public Produto adicionar(Produto produto) {
		// Poderia ter alguma regra de negocio aqui para validar um produto.(regra de negocio)
		return produtoRepository.adicionar(produto);
	}
	
	/**
	 * Metodo para deletar o produto por ID
	 * @param id do produto a ser deletado
	 */
	public void deletar(Integer id) {
		//Poderia ter alguma regra de negocio aqui para validar um produto.(regra de negocio)
		produtoRepository.deletar(id);
	}
	
	/** 
	 * Metodo para atualizar o produto na lista
	 * @param produto que será atualizado
	 * @return Retorna o produto após atualizar a lista
	 */
	public Produto atualizar(Integer id,Produto produto) {
		//poderia ter alguma validação no ID
		produto.setId(id);
		
		return produtoRepository.atualizar(produto);
	}
}
