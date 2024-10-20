public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        System.out.println("Lista está vazia? " + lista.estaVazia());
        lista.inserePrimeiro(20);
        lista.inserePrimeiro(10);
        No no1 = lista.getPrimeiro().getProximo();
        lista.insereDepois(no1, 30);
        lista.insereUltimo(40);
        lista.insereUltimo(50);
        lista.mostrar();
        System.out.println("Lista Atualizada");
        lista.removePrimeiro();
        lista.mostrar();
        System.out.println("Lista atualizada");
        lista.removeUltimo();
        lista.mostrar();
        System.out.println("Lista atualizada");
        lista.removeDepois(lista.getPrimeiro().getProximo());
        lista.mostrar();

    }

}
