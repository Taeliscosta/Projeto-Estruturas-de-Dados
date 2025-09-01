package atividade03;

/*
 * Interface para implementacao da classe "TabelaHash"
 * (deve ser implementada usando enderecamento fechado e metodo da divisao)
 */
public interface TabelaHash_IF {
	public void insert(Pessoa element);
	public void remove(Pessoa element) throws Exception; //lancar excecao caso o element nao esteja na tabela
	public Pessoa search(Pessoa element) throws Exception; //lancar excecao caso o element nao esteja na tabela
	public String print();
	
	/*
	 OBSERVACAO:
	 O metodo print() deve mostrar todos os elementos (CPFs) de cada posicao da tabela.
	 Exemplo (com uma tabela de 8 posicoes):
	 0: 24, 16
	 1: 
	 2: 10
	 3: 19, 11, 3
	 4: 12, 4
	 5: 
	 6: 22, 14, 6
	 7: 15
	 */
}