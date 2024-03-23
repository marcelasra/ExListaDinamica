package ListaDinamica;

public class ListaDinamica {

    private No inicio;
    private No fim;

    public ListaDinamica() {
        this.inicio = null;
        this.fim = null;

    }

    public void inserePrimeiroElemento(double valor) {
        No aux = new No(valor); //auxi é a posição de memória do primeiro elemento
        this.inicio = aux;
        this.fim = aux;
    }

    public void insereInicio(double valor) {
        No aux = new No(valor);
        aux.setProximo(inicio);
        this.inicio = aux;
    }

    public void insereFinal(double valor) {
        No aux = new No(valor);
        this.fim.setProximo(aux);
        this.fim = aux;
    }

    public void insereMeio(double valor, int pos) {
        No aux = this.inicio;

        for (int i = 1; i < pos; i++) {
            aux = aux.getProximo();
        }
        No novo = new No(valor);
        novo.setProximo(aux.getProximo());
        aux.setProximo(novo);

    }

    public void imprimir() {
        No aux = this.inicio;

        while (aux != null) {

            System.out.println(aux.getValor());
            aux = aux.getProximo();
        }
    }


    public boolean ehVazia() {
        return ((this.inicio == null) && (this.fim == null));
    }

    public int tamanho() {
        int tamanho = 0;
        No aux = this.inicio;
        while (aux != null) {
            tamanho++;
            aux = aux.getProximo();
        }
        return tamanho;
    }

    public void insere(double valor) {
        if (ehVazia()) {
            inserePrimeiroElemento(valor);
        } else {
            insereFinal(valor);
        }
    }
}
