package ListaDinamica;

public class ListaDinamica {

    private No inicio;
    private No fim;

    public ListaDinamica() {
        this.inicio = null;
        this.fim = null;

    }

    private void inserePrimeiroElemento(double valor) {
        No aux = new No(valor); //aux é a posição de memória do primeiro elemento
        this.inicio = aux;
        this.fim = aux;
    }

    private void insereInicio(double valor) {
        No aux = new No(valor);
        aux.setProximo(inicio);
        this.inicio = aux;
    }

    private void insereFinal(double valor) {
        No aux = new No(valor);
        this.fim.setProximo(aux);
        this.fim = aux;
    }

    private void insereMeio(double valor, int pos) {
        No aux = this.inicio;

        for (int i = 1; i < pos; i++) {
            aux = aux.getProximo();
        }
        No novo = new No(valor);
        novo.setProximo(aux.getProximo());
        aux.setProximo(novo);

    }

    public boolean insere(double valor) {
        if (ehVazia()) {
            inserePrimeiroElemento(valor);
            return true;
        } else {
            insereFinal(valor);
            return true;
        }
    }

    public boolean insere(double valor, int pos) {
        if (pos == 0) {
            insereInicio(valor);
            return true;
        } else if (pos == tamanho()) {
            insereFinal(valor);
            return true;
        } else if (posValida(pos)) {
            insereMeio(valor, pos);
            return true;
        } else {
            return false;
        }
    }

    public boolean posValida(int pos) {
        return (pos >= 0) && (pos < tamanho());
    }

    public void imprimirRec() { //da inicio a recursão     
        No aux = this.inicio;
        Rec(aux);
    }

    private void Rec(No temp) {
        if (temp != null) {
            System.out.println(temp.getValor());
            Rec(temp.getProximo());
        } else {

        }
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

    public void removeMeio(int pos) {
        No aux = this.inicio; //define o inicio como aux

        for (int i = 1; i < pos; i++) { //encontrou o aux //i é o contador
            aux = aux.getProximo();
        }
        No prox = aux.getProximo(); //o aux vira o prox
        aux.setProximo(prox.getProximo());
        prox = null;
    }

    public void removeInicio() {
        No aux = this.inicio;
        this.inicio = aux.getProximo();
        aux = null;
    }

    public void removeFinal() {
        No aux = this.inicio;

        for (int i = 1; i < (tamanho() - 1); i++) {
            aux = aux.getProximo();
        }
        No prox = aux.getProximo();
        aux.setProximo(null);
        this.fim = aux;
        prox = null;
    }

    public boolean remove(int pos) {
        if (pos == 0) {
            removeInicio();
            return true;
        } else if (pos == tamanho() - 1) {
            removeFinal();
            return true;
        } else if (posValida(pos)) {
            removeMeio(pos);
            return true;
        } else {
            return false;
        }
    }

    public boolean pop(double valor) {
        return insere(valor, 0);
    }

    public boolean push() {
        return remove(0);
    }

    public boolean queue(double valor) {
        return insere(valor);
    }

    public boolean dequeue() {
        return remove(0);
    }

    public Double getElemento(int pos) {
        if (!posValida(pos)) {
            return null;
        } else {
            No aux = this.inicio;
            for (int i = 1; i <= pos ; i++){
                aux = aux.getProximo();
            }
            return aux.getValor();
        }
    }
}
