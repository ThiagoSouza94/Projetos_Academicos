public class Bubble_Sort {
    public static void main(String[] args){
        int[] vetor = {3,6,8,1,4,9,0};
        int aux;
        boolean controle;
        // Repetir conforme o tamanho do vetor
        for(int i = 0; i < vetor.length; ++i ){
            // Se tiver Ordenada retorna verdadeiro
            controle = true;
            // Analisa 2 valores
            for(int x = 0; x < (vetor.length - 1); ++x){
                // Compara se a posição x é maior que o proximo vetor
                if (vetor[x] > vetor[x + 1]){
                    // declara auxiliar na posição x
                    aux = vetor[x];
                    // declara a proxima posição como vetor x
                    vetor[x] = vetor[x + 1];
                    // o que seria a proxima posiçao passa a ser uma posiçao antes do x
                    vetor[x + 1] = aux;
                    // Se tiver Ordenada retorna verdadeiro
                    controle = false;

                }

            }
            // Se tiver Ordenada retorna verdadeiro
            if(controle){
                break;
            }

        }
        for (int i = 0; i < vetor.length; ++i){
            System.out.print(vetor[i] + "");

        }

    }
}
