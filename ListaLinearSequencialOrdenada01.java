package listalinearsequencialordenada01;
import java.util.Scanner;

public class ListaLinearSequencialOrdenada01 {

    public static int pesquisarMaior(float vet[], int qtd, float valor){
        for (int i = 0; i < qtd; i++){
            if (valor < vet[i]){
                return i;
            }
        }
        return -1;
    }

    public static boolean listavazia(int qtd){
        if (qtd == 0){
            System.out.println("Lista vazia!");
            return false;
        }
        return true;
    }

    public static boolean listacheia(float vetor[], int qtd){
        if (qtd == vetor.length){
            System.out.println("Lista cheia!");
            return false;
        }
        return true;
    }

    public static int inserir(float vet[], int qtd){
        Scanner ler = new Scanner(System.in);
        float valor;
        int indice;
        if (qtd == vet.length){
            System.out.println("Lista Cheia! Não posso incluir.");
            return qtd;
        }
        System.out.print("Informe o valor: ");
        valor = ler.nextFloat();
        if (qtd == 0){
            vet[qtd] = valor;
        } else {
            indice = pesquisarMaior(vet, qtd, valor);
            if (indice == -1){
                vet[qtd] = valor;
            } else {
                for (int i = qtd; i > indice; i--){
                    vet[i] = vet[i - 1];
                }
                vet[indice] = valor;
            }
        }
        return qtd + 1;
    }

    public static void listar(float vet[], int qtd){
        for (int i = 0; i < qtd; i++){
            System.out.println("O valor na posição "+ i + " é: " + vet[i]);
        }
    }

    public static int pesquisar(float vet[], int qtd){
        Scanner ler = new Scanner(System.in);
        float valor = ler.nextFloat();
        for (int i = 0; i < qtd; i++){
            if (vet[i] == valor){
                return i;
            }
        }
        return -1;
    }

    public static int excluir(float vet[], int qtd){
        int indice = pesquisar(vet, qtd);
        if (indice != -1){
            for (int i = indice; i < qtd - 1; i++){
                vet[i] = vet[i + 1];
            }
            return qtd - 1;
        }
        return qtd;
    }

    public static void bubbleSort(float[] vet, int qtd) {
        int com = 0;
        int tro = 0;

        for (int i = 0; i < qtd - 1; i++) {
            for (int j = 0; j < qtd - i - 1; j++) {
                com++;
                if (vet[j] > vet[j + 1]) {
                    float temp = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = temp;
                    tro++;
                }
            }
        }
        System.out.println("Bubble Sort: Comparisons: " + com + ", Swaps: " + tro);
        printArray(vet);
    }

    public static void selectionSort(float[] vet, int qtd) {
        int com = 0;
        int tro = 0;

        for (int i = 0; i < qtd - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < qtd; j++) {
                com++;
                if (vet[j] < vet[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                float temp = vet[i];
                vet[i] = vet[min_idx];
                vet[min_idx] = temp;
                tro++;
            }
        }
        System.out.println("Selection Sort: Comparisons: " + com + ", Swaps: " + tro);
        printArray(vet);
    }

    public static void insertionSort(float[] vet, int qtd) {
        int com = 0;
        int tro = 0;

        for (int i = 1; i < qtd; i++) {
            float key = vet[i];
            int j = i - 1;
            while (j >= 0 && vet[j] > key) {
                com++;
                vet[j + 1] = vet[j];
                tro++;
                j--;
            }
            vet[j + 1] = key;
        }
        System.out.println("Insertion Sort: Comparisons: " + com + ", Swaps: " + tro);
        printArray(vet);
    }

    public static void printArray(float[] array) {
        for (float value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float[] notas = new float[5];
        int qtd = 0;
        int opc;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Bubble Sort");
            System.out.println("6 - Selection Sort");
            System.out.println("7 - Insertion Sort");
            System.out.println("8 - Sair");
            System.out.print("Informe a opção desejada: ");
            opc = ler.nextInt();

            switch (opc) {
                case 1:
                    qtd = inserir(notas, qtd);
                    break;
                case 2:
                    listar(notas, qtd);
                    break;
                case 3:
                    pesquisar(notas, qtd);
                    break;
                case 4:
                    qtd = excluir(notas, qtd);
                    break;
                case 5:
                    bubbleSort(notas, qtd);
                    break;
                case 6:
                    selectionSort(notas, qtd);
                    break;
                case 7:
                    insertionSort(notas, qtd);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opc != 8);
    }
}
