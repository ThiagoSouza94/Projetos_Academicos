public class Lista {
    private No primeiro;

    public Lista(){
        primeiro = null;

    }

    public No getPrimeiro() {
        return primeiro;
    }
    public boolean estaVazia(){
        return primeiro == null;

    }
    public void inserePrimeiro(int valor){
        No no1 = new No(valor);
        no1.setProximo(primeiro);
        primeiro = no1;
    }
    public void mostrar(){
        if (estaVazia()){
            System.out.println("Lista Vazia");
        }else {
            No cursor = primeiro;
            while (cursor != null){
                System.out.println(cursor.getInfo());
                cursor = cursor.getProximo();
            }
        }
    }
    public void insereUltimo(int valor){
        if (estaVazia()){
            inserePrimeiro(valor);
        }else {
            No cursor = primeiro;
            while (cursor.getProximo() != null) {
                cursor = cursor.getProximo();
            }
            No no1 = new No(valor);
            cursor.setProximo(no1);
        }
    }
    public void insereDepois(No no, int valor){
        No no1 = new No(valor);
        no1.setProximo(no.getProximo());
        no.setProximo(no1);
    }
    public No removePrimeiro(){
        if (estaVazia()){
            System.out.println("Vazia");
            return null;
        }else {
            No cursor = primeiro;
            primeiro = primeiro.getProximo();
            return cursor;
        }

    }

    public void removeDepois(No no){
        if (estaVazia()){
            System.out.println("Lista vazia");
        }else {
            No anterior = null;
            No cursor = primeiro;
            while (cursor.getProximo() != null){
                anterior = cursor;
                cursor = cursor.getProximo();

                if (cursor.equals(no)){
                    anterior.setProximo(cursor.getProximo());

                }
            }
        }
    }
    public void removeUltimo(){
        if (estaVazia()){
            System.out.println("Lista vazia");

        }else {
            No cursor = primeiro;
            No anterior = primeiro;
            while (cursor.getProximo() != null){
                anterior = cursor;
                cursor = cursor.getProximo();
            }
            anterior.setProximo(cursor.getProximo());
            cursor.setProximo(anterior);


        }
    }

}