package pilha;
import ListaDinamica.*;

public class Pilha {
    
    private ListaDinamica lista;
    
    public Pilha(){
        lista = new ListaDinamica();
    }
    
    public boolean pop(double valor){
        return lista.pop(valor);
    }
    public boolean push(){
        return lista.push();
    }
    public double getElemento(){
        return lista.getElemento(0);
    }
    public void imprimir(){
        lista.imprimirRec();
    }
}
