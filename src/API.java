class No {

    private Integer idade;
    private No esquerda;
    private No direita;

    public No() {
        this.idade = null;
        this.esquerda = null;
        this.direita = null;
    }

    public No(Integer idade) {
        this.idade = idade;
        this.esquerda = null;
        this.direita = null;
    }

    public No(Integer idade, No esquerda, No direita) {
        this.idade = idade;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public Integer pegaIdade() {
        return idade;
    }

    public void mudaIdade(Integer idade) {
        this.idade = idade;
    }

    public No pegaEsquerda() {
        return esquerda;
    }

    public void mudaEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No pegaDireita() {
        return direita;
    }

    public void mudaDireita(No direita) {
        this.direita = direita;
    }

}


class ArvoreBinaria {

    private No arvore;

    public ArvoreBinaria(Integer raiz) {
        this.arvore = new No(raiz);
    }

    public ArvoreBinaria() {
        this.arvore = null;
    }

    public No pegaArvore() {
        return arvore;
    }

    public void mudaArvore(No arvore) {
        this.arvore = arvore;
    }

    public No insercao(Integer idade) {
        this.arvore = insercao(this.arvore, idade);
        return this.arvore;
    }

    public No insercao(No pRaiz, Integer idade) {
        if (pRaiz == null) {
            return new No(idade);
        }

        if (idade < pRaiz.pegaIdade()) {
            pRaiz.mudaEsquerda(insercao(pRaiz.pegaEsquerda(), idade));
        } else if (idade > pRaiz.pegaIdade()) {
            pRaiz.mudaDireita(insercao(pRaiz.pegaDireita(), idade));
        } else {
            return pRaiz;
        }

        return pRaiz;
    }

    public No MenorEsquerda() {
        return MenorEsquerda(this.arvore);
    }

    public No MenorEsquerda(No no) {
        if (no.pegaEsquerda() != null) {
            return MenorEsquerda(no.pegaEsquerda());
        }  
        return no;        
    }

    public No MaiorDireita() {
        return MaiorDireita(this.arvore);
    }

    public No MaiorDireita(No no) {
        if (no.pegaDireita() != null) {
            return MaiorDireita(no.pegaDireita());
        } 
        return no;
    }

    public int encontraMaior() {
        return encontraMaior(this.arvore);
    }

    public int encontraMaior(No raiz) {
        if (raiz.pegaDireita() != null) {
            return encontraMaior(raiz.pegaDireita());
        } else {
            return raiz.pegaIdade();
        }
    }

    public int encontraMenor() {
        return encontraMenor(this.arvore);
    }

    public int encontraMenor(No raiz) {
        if (raiz.pegaDireita() != null) {
            return encontraMenor(raiz.pegaDireita());
        } else {
            return raiz.pegaIdade();
        }
    }

    public No remover(Integer idade) {
        return remover(this.arvore, new No(idade));
    }

    public No remover(No raiz, No no) {
        if (raiz == null) {
            return null;
        }

        if (no.pegaIdade() == raiz.pegaIdade()) {
            if (raiz.pegaEsquerda() == null && raiz.pegaDireita() == null) {
                return null;
            }

            if (raiz.pegaEsquerda() == null) {
                return raiz.pegaDireita();
            }

            if (raiz.pegaDireita() == null) {
                return raiz.pegaEsquerda();
            }
        }

        if (no.pegaIdade() < raiz.pegaIdade()) {
            raiz.mudaEsquerda(remover(raiz.pegaEsquerda(), no));

            return raiz;
        }
        raiz.mudaDireita(remover(raiz.pegaDireita(), no));

        return raiz;
//        if (raiz == null) {
//            return raiz;
//        }
//
//        if (no.pegaIdade() < raiz.pegaIdade()) {
//            raiz.mudaEsquerda(remover(raiz.pegaEsquerda(), no));
//        } else if (no.pegaIdade() > raiz.pegaIdade()) {
//            raiz.mudaDireita(remover(raiz.pegaDireita(), no));
//        } else {
//            if (raiz.pegaEsquerda() == null) {
//                return raiz.pegaDireita();
//            } else if (raiz.pegaDireita() == null) {
//                return raiz.pegaEsquerda();
//            }
//
//            raiz.pegaIdade() = encontra
//        }
//        // implementar
//
//        return null;
    }

    public No removerMaior() {
        
        // implementar
        
        return null;
    }


    public No removerMenor() {
        
        // implementar
        
        return null;
    }

    public void PreOrdem() {
        PreOrdem(this.arvore);
        System.out.println();
    }

    public void PreOrdem(No pRaiz) {
        if (pRaiz == null) {
            return;
        }

        System.out.println(pRaiz.pegaIdade());
        PreOrdem(pRaiz.pegaEsquerda());
        PreOrdem(pRaiz.pegaDireita());
    }

    public void EmOrdem() {
        EmOrdem(this.arvore);
        System.out.println();
    }

    public void EmOrdem(No pRaiz) {
        if (pRaiz == null) {
            return;
        }

        EmOrdem(pRaiz.pegaEsquerda());
        System.out.println(pRaiz.pegaIdade());
        EmOrdem(pRaiz.pegaDireita());
    }

    public void PosOrdem() {
        PosOrdem(this.arvore);
        System.out.println();
    }

    public void PosOrdem(No pRaiz) {
        if (pRaiz == null) {
            return;
        }

        PosOrdem(pRaiz.pegaEsquerda());
        PosOrdem(pRaiz.pegaDireita());
        System.out.println(pRaiz.pegaIdade());
    }

    // Conta o número de elementos da árvore
    public int contarNos() {
        return contarNos(this.arvore);
    }

    // Conta o número de elementos da árvore
    private int contarNos(No pRaiz) {
        if (pRaiz == null) {
            return 0;
        } else {
            return 1 + (contarNos(pRaiz.pegaEsquerda()) + 
                        contarNos(pRaiz.pegaDireita()));
        }
    }

    // Conta o número de folhas da árvore
    public int contarFolhas() {
        return contarFolhas(this.arvore);
    }

    // Conta o número de folhas da árvore
    private int contarFolhas(No pRaiz) {
        if (pRaiz == null) {
            return 0;
        }
        if (pRaiz.pegaEsquerda() == null && pRaiz.pegaDireita() == null) {
            return 1;
        }
        return contarFolhas(pRaiz.pegaEsquerda()) + 
               contarFolhas(pRaiz.pegaDireita());
    }

    public int maiorQue(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // Calcula altura da árvore
    public int altura() {
        return altura(this.arvore);
    }

    // Calcula altura da árvore
    public int altura(No pRaiz) {
        if ((pRaiz == null) || (pRaiz.pegaEsquerda() == null
                && pRaiz.pegaDireita() == null)) {
            return 0;
        } else {
            return 1 + maiorQue(altura(pRaiz.pegaEsquerda()), altura(pRaiz.pegaDireita()));
        }
    }

    // Busca um elemento na árvore
    public No busca(int idade) {
        return busca(this.arvore, idade);
    }

    // Busca um elemento na árvore
    private No busca(No pRaiz, int idade) {
        if (pRaiz == null) {
            return null;
        } else if (pRaiz.pegaIdade() == idade) {
            return pRaiz;
        } else if (idade < pRaiz.pegaIdade()) {
            return busca(pRaiz.pegaEsquerda(), idade);
        }
        return busca(pRaiz.pegaDireita(), idade);
    }

}

class BuscaBinaria {
    
    public static int buscaBinaria(Integer [] V, int chave){
        return buscaBinaria(V, 0, V.length - 1, chave);
    }
    
    public static int buscaBinaria(Integer [] V, int inicio, int fim, int chave){
        int meio = (inicio + fim) / 2;

        while (V[meio] != chave) {
            meio = (inicio + fim) / 2;
            if (chave < V[meio]) {
                fim = meio - 1;
            } else if (chave > V[meio]) {
                inicio = meio + 1;
            }

            if (fim == inicio - 1 || inicio == fim + 1) {
                System.out.println("Chave inexistente!");
                return -1;
            }
        }

        return V[meio];
    }
    
}

public class API {
    
      public static void main(String[] args) {

        System.out.println("-----------Busca Binária --------------");
          
        Integer [] V = new Integer[10];
        V[0] = 4;
        V[1] = 23;
        V[2] = 41;
        V[3] = 43;
        V[4] = 56;
        V[5] = 76;
        V[6] = 81;
        V[7] = 94;
        V[8] = 95;
        V[9] = 100;

        int chave = 810;
        System.out.println("buscaBinaria: chave = "+chave+" "+(BuscaBinaria.buscaBinaria(V, chave)));
          
          
        System.out.println("-------------  Árvore de Binária de Busca----------");
        
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.insercao(8);
        arvore.insercao(5);
        arvore.insercao(9);
        arvore.insercao(3);
        arvore.insercao(7);
        arvore.insercao(2);
        arvore.insercao(4);
        arvore.insercao(6);


        System.out.println("PreOrdem (RED): "); arvore.PreOrdem();
        System.out.println("EmOrdem (ERD): "); arvore.EmOrdem();
        System.out.println("PosOrdem (EDR): "); arvore.PosOrdem();
        System.out.println("-----------------------------------------");

        arvore.remover(8);
//        arvore.removerMaior();
//        arvore.removerMenor();
        System.out.println("PreOrdem (RED): "); arvore.PreOrdem();
        System.out.println("EmOrdem (ERD): "); arvore.EmOrdem();
        System.out.println("PosOrdem (EDR): "); arvore.PosOrdem();
        System.out.println("-----------------------------------------");

        System.out.println("busca(4): "+arvore.busca(4).pegaIdade());

        System.out.println("altura: "+arvore.altura());
        System.out.println("contarFolhas: "+arvore.contarFolhas());
        System.out.println("contarNos: "+arvore.contarNos());
        System.out.println("encontraMaior: "+arvore.encontraMaior());
        System.out.println("MaiorDireita: "+arvore.MaiorDireita().pegaIdade());
        System.out.println("MenorEsquerda: "+arvore.MenorEsquerda().pegaIdade());
    }
  
}
