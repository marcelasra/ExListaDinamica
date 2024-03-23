package exemplolista;

import ListaDinamica.ListaDinamica;

public class ExemploLista {

    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        
        lista.inserePrimeiroElemento(76);
        lista.insereInicio(3);
        lista.insereInicio(456);
        lista.insereFinal(987);
        lista.insereMeio(20, 2);
        
        lista.removeMeio(3);
        lista.removeInicio();
        lista.removeFinal();
        lista.imprimir();
        
    }
    
}
