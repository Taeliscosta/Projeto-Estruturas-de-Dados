package atividade03;

import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {
    private final int tabelaTam;
    private LinkedList<Pessoa>[] tabela;

    @SuppressWarnings("unchecked")
    public TabelaHash(final int tabelaTam) {
        this.tabelaTam = tabelaTam;
		tabela = new LinkedList[tabelaTam];
        for (int i = 0; i < tabelaTam; i++) {
            tabela[i] = new LinkedList<Pessoa>();
        }
    }

    private int hash(long cpf) {
        return (int) (cpf % tabelaTam);
    }

    @Override
    public void insert(Pessoa element) {
        int index = hash(element.getCpf());
        LinkedList<Pessoa> lista = tabela[index];
        if (!lista.contains(element)) {
            lista.add(element);
        }
    }

    @Override
    public void remove(Pessoa element) throws Exception {
        int index = hash(element.getCpf());
        LinkedList<Pessoa> lista = tabela[index];
        if (!lista.remove(element)) {
            throw new Exception("Elemento não encontrado");
        }
    }

    @Override
    public Pessoa search(Pessoa element) throws Exception {
        int index = hash(element.getCpf());
        LinkedList<Pessoa> lista = tabela[index];
        int pos = lista.indexOf(element);
        if (pos == -1) {
            throw new Exception("Elemento não encontrado");
        }
        return lista.get(pos);
    }

    @Override
    public String print() {
        StringBuilder resultado = new StringBuilder();
        for (int index = 0; index < tabelaTam; index++) {
            resultado.append(index).append(": ");
            LinkedList<Pessoa> lista = tabela[index];
            if (!lista.isEmpty()) {
                for (int i = lista.size() - 1; i >= 0; i--) {
                    resultado.append(lista.get(i).getCpf()).append(", ");
                }
                resultado.setLength(resultado.length() - 2);
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

}