package atividade03;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Test_ListaEncadeada {
    private ListaEncadeada_IF lista;
    private final long basecpf = 99955511100L;

    @Before
    public void setUp() {
        lista = new ListaEncadeada();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(lista.isEmpty());
        lista.insert(new Pessoa(25, basecpf, "Maria"));
        assertFalse(lista.isEmpty());
    }

	@Test
	public void testSize0(){
		assertEquals(0, lista.size());
	}
    
    @Test
    public void testSize() {
    	for (int i = 0; i < 999; i++) {
    		assertEquals(i, lista.size());
    		lista.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
    		assertEquals(i+1, lista.size());
    	}
    }

    @Test
    public void testInsertAndSearch1() throws Exception {
        Pessoa maria = new Pessoa(25, 99977755533L, "Maria");
        Pessoa joao = new Pessoa(30, 88866644422L, "João");
        lista.insert(maria);
        lista.insert(joao);
        assertEquals(maria, lista.search(maria));
        assertEquals(joao, lista.search(joao));
    }
    
	@Test
	public void testInsertAndSearch2() throws Exception {
		for(int i = 0; i < 999; i++){
			lista.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
			assertEquals( new Pessoa(i, basecpf+i, "Xxx"+i), lista.search( new Pessoa(i, basecpf+i, "Xxx"+i) ));
		}
	}

    @Test
    public void testRemove1() throws Exception {
        Pessoa maria = new Pessoa(25, 99977755533L, "Maria");
        Pessoa joao = new Pessoa(30, 88866644422L, "João");
        lista.insert(maria);
        lista.insert(joao);
        assertEquals(2, lista.size());
        lista.remove(maria);
        assertEquals(1, lista.size());
    }
    
    @Test(expected = Exception.class)
    public void testRemove2() throws Exception {
        Pessoa maria = new Pessoa(25, 99977755533L, "Maria");
        Pessoa joao = new Pessoa(30, 88866644422L, "João");
        lista.insert(maria);
        lista.insert(joao);
        lista.remove(maria);
        lista.search(maria);
    }

    @Test(expected = Exception.class)
    public void testRemoveNotFoundException() throws Exception {
        lista.remove(new Pessoa(25, basecpf, "Maria"));
    }
    

    @Test(expected = Exception.class)
    public void testSearchNotFoundException() throws Exception {
        lista.search(new Pessoa(25, basecpf, "Maria"));
    }

    @Test
    public void testToArray1() {
        Pessoa maria = new Pessoa(25, 99977755533L, "Maria");
        Pessoa joao = new Pessoa(30, 88866644422L, "João");
        lista.insert(maria);
        lista.insert(joao);
        Pessoa[] array = lista.toArray();
        assertEquals(joao, array[0]);
        assertEquals(maria, array[1]);
    }
    
    @Test
    public void testToArray2() {
		Pessoa vet[] = new Pessoa[999];
		for(int i = 0; i < vet.length; i++){
			lista.insert( new Pessoa(i, basecpf+i, "Xxx"+i) );
			vet[999-1-i] = new Pessoa(i, basecpf+i, "Xxx"+i) ;
		}
		assertArrayEquals(vet, lista.toArray());
    }
    
}
