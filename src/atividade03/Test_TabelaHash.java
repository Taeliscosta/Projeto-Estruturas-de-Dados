package atividade03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Test_TabelaHash {
    private TabelaHash_IF tabela;
    private final long basecpf = 99955511100L;

    @Before
    public void setUp() {
        tabela = new TabelaHash(19);
    }

	@Test(expected = Exception.class)
	public void testSearch1() throws Exception{
		tabela.search(new Pessoa(0, basecpf, "Ana"));
	}
	
    @Test
    public void testInsertAndSearch1() throws Exception {
        Pessoa pessoa1 = new Pessoa(25, 12345678900L, "João");
        Pessoa pessoa2 = new Pessoa(30, 98765432100L, "Maria");
        tabela.insert(pessoa1);
        tabela.insert(pessoa2);
        assertEquals(pessoa1, tabela.search(pessoa1));
        assertEquals(pessoa2, tabela.search(pessoa2));
    }
    
    @Test
    public void testInsertAndSearch2() throws Exception {
    	for(int i = 0; i < 999; i++){
    		tabela.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
    		assertEquals( new Pessoa(i, basecpf+i, "Xxx"+i), tabela.search( new Pessoa(i, basecpf+i, "Xxx"+i) ));
    	}
    }
    
	@Test(expected = Exception.class)
	public void testRemove1() throws Exception{
		tabela.remove(new Pessoa(0, basecpf, "Ana"));
	}

    @Test
    public void testRemove2() throws Exception {
    	for(int i = 0; i < 999; i++) tabela.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
    	for(int i = 0; i < 999; i++) if (i%2 != 0) tabela.remove( new Pessoa(i, basecpf+i, "Xxx"+i) );
    	for(int i = 0; i < 999; i+=2) assertEquals( new Pessoa(i, basecpf+i, "Xxx"+i), tabela.search( new Pessoa(i, basecpf+i, "Xxx"+i) ));
    }
    
    @Test
    public void testRemove3() throws Exception {
    	tabela = new TabelaHash(2);
    	for(int i = 0; i < 999; i++) tabela.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
    	for(int i = 0; i < 999; i++) if (i%2 == 0) tabela.remove( new Pessoa(i, basecpf+i, "Xxx"+i) );
        assertTrue(tabela.print().contains("0: \n"));
    }

    @Test
    public void testPrintSimples() {
        Pessoa pessoa1 = new Pessoa(25, basecpf-1, "João");
        Pessoa pessoa2 = new Pessoa(30, basecpf+1, "Maria");
        tabela.insert(pessoa1);
        tabela.insert(pessoa2);
        String output = tabela.print();
        assertTrue(output.contains(String.valueOf(basecpf-1)));
        assertTrue(output.contains(String.valueOf(basecpf+1)));
    }
    
	@Test
	public void testPrint1() throws Exception{
		tabela = new TabelaHash(8);
		int vet[] = {3,4,6,10,11,12,14,15,16,19,22,24};
		for(int i = 0; i < vet.length; i++) tabela.insert(new Pessoa(vet[i], vet[i], "Xxx"));
		String aux = 
				"0: 24, 16\n"+
				"1: \n"+ 
				"2: 10\n"+
				"3: 19, 11, 3\n"+
				"4: 12, 4\n"+
				"5: \n"+ 
				"6: 22, 14, 6\n"+
				"7: 15\n";
		assertTrue(aux.equals(tabela.print()));
	}
	
	@Test
	public void testPrint2() throws Exception{
		for(int i = 1; i <= 20; i++) tabela.insert(new Pessoa(i, i, "Xxx"));
		String aux = "0: 19\n"+
					 "1: 20, 1\n"+
				     "2: 2\n"+
					 "3: 3\n"+
				     "4: 4\n"+
					 "5: 5\n"+
				     "6: 6\n"+
					 "7: 7\n"+
				     "8: 8\n"+
					 "9: 9\n"+
				     "10: 10\n"+
					 "11: 11\n"+
				     "12: 12\n"+
					 "13: 13\n"+
				     "14: 14\n"+
					 "15: 15\n"+
				     "16: 16\n"+
					 "17: 17\n"+
				     "18: 18\n";
		assertTrue(aux.equals(tabela.print()));
	}

}
