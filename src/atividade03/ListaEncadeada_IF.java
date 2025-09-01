package atividade03;

/*
 * Interface para implementacao da classe "ListaEncadeada".
 */
public interface ListaEncadeada_IF {
	public boolean isEmpty();
	public int size();
	public void insert(Pessoa element); //deve-se inserir no inicio da lista
	public void remove(Pessoa element) throws Exception; //lancar excecao caso nao encontre
	public Pessoa search(Pessoa element) throws Exception; //lancar excecao caso nao encontre
	public Pessoa[] toArray();
}
