import java.util.Arrays;
public class Selection_Sort {
    public static String main(String[] args){
        int[] vetor = {3,6,8,1,4,9,0};

        for(int i = 0; i < vetor.length - 1; ++i){
            int indexMinimo = i;

            for(int x = i + 1; x < vetor.length; ++x) {

                if(vetor[x] < vetor[indexMinimo]){
                    indexMinimo = x;
                }
            }
            int aux = vetor[indexMinimo];
            vetor[indexMinimo] = vetor[i];
            vetor[i] = aux;
        }
        return Arrays.toString(vetor);
        }
    }
