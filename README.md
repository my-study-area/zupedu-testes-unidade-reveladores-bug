# zupedu-testes-unidade-reveladores-bug
Testes de Unidade Reveladores de Bugs

## Aplicando Testes de Unidade Reveladores de Bugs
### Teorias necessarias
1 - [Aprendendo sobre Specification Test](https://github.com/zup-academy/materiais-publicos-treinamentos/blob/main/testes-de-unidade-reveladores-de-bugs/specification-test.md)

Pensar em possíveis casos de testes baseados na especificação
- Identificação dos parametros de entrada. _Ex: identificador de aluno_
- Identificação das caractertisticas dos parametros de entrada. _Ex: o identificador é valor numérico inteiro e maior que zero_.
- Adicionando restrições a partir das caracteristicas das entradas e diminuindo o conjunto de testes. _Ex: não aceita valores nulos_
- Combinando valores de entrada e obtendo casos de testes. _Ex: identificador menor que 1 e identificador nulo; identificador positivo com mais de um ano e identificador positivo com menos de um ano_

**Partições de equivalencia**
- também conhecidas como classes de equivalência
- Partições de equivalencia se dividem em:
  - partição de equivalência válida
  - partição de equivalência inválida

![Imagem exibindo partição de equivalencia válida para valores entre 16 a 60 anos e partição de equivalencia inválida para os valores de 0 a 15 anos e a partir de 61 anos](./img/particao-equivalencia-valida-invalida.png)
fonte: [Técnica de Teste — Particionamento de Equivalência](https://medium.com/revista-tspi/t%C3%A9cnica-de-teste-particionamento-de-equival%C3%AAncia-d32a7d689d82)


[Vídeo no youtube: O que é partição de equivalência: o guia definitivo
](https://www.youtube.com/watch?v=-IdzE1GoC-g&ab_channel=JuliodeLima)

2 - Aprendendo sobre Boundary Test
- visa encontrar os limites das classes de entradas. _Por - exemplo, na maioridade, os valores que são igual ou maiores que de 18, como: 18, 19, 25, 34 e 76 e sem maioridade, os valores que por natureza são menores que 18, como: 1, 2, 3, 16 e 17_
- para encontrar os limites utilizams alguns conceitos como: `point, offpoint, inpoints e offpoints`
  - `point`: valor exato do limite. Ex: 18 anos
  - `offpoint`: valor mais próximo que invalida. ex: 17 anos
  - `inpoints`: são todos os valores válidos. Ex: 18, 19, 20, 21 ... anos
  - `offpoints`: são todos os valores inválidos. Ex: 17, 16 ... 2 anos e etc 


3 - Aprendendo sobre Structural Test
- Structural Test ou Testes Estruturais são testes construídos guiados pelo código-fonte
- Tem como responsabilidade garantir um critério de cobertura

Exemplo de calculo de cobertura por  método:
```
Quantidade de métodos executados pelo teste: 1

Quantidade métodos existentes na classe: 1

(1/1) * 100 = 100%
```

- Tipos de testes de cobertura:
  - Line Coverage (and statement coverage)
  - Block coverage
  - Branch/Decision coverage
  - Condition (Basic and condition+branc) coverage
  - Path coverage
  - MC/DC coverage

#### Line Coverage (Cobertura por Linhas)
- o objetivo é cobrir as linhas de codigo de determinada unidade, ao executar um teste.

Exemplo de calculo:
```
cobertura = (linhasExecutadasPorUmTeste/totalDeLinhas) * 100
```

- [ST1x_2018_Week_3_01_Structural_testing_line_coverage-video](https://www.youtube.com/watch?v=12P-UCRFanI&ab_channel=ST1xAutomatedSoftwareTestingPracticalSkills)

#### Block Coverage (Cobertura por blocos)
- visa a cobertura de código por blocos de códigos

*Bloco básico*

 São aqueles onde existem diversas operações que são executadas de maneira continua. Ex:
 ```java
public void somaDosQuadrados(int a, int b){ 
    int quadradoDeA = a*a;
    int quadradoDeB = b*b;
    int soma = quadradoDeA + quadradoDeB;
    System.out.println("Soma dos quadrados: "  + soma);
}
 ```

*Bloco de decisão*

São blocos de códigos que podem seguir caminhos diferentes quando utilizam estruturas de decisão como `if` e `else` ou de repetição como `while` e `for`. Ex:
```java
class Primo {

    public boolean isPrimo(int numero) { 
        int foiDividido = 0;

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                foiDividido++;
            }
        }

        if (foiDividido == 2) {
            return true;
        }
        return false;
    }

}
```
Exemplos de testes:
```java
@Test
@DisplayName("o número zero não deve ser primo")
void test() {
    NumeroPrimo numero = new NumeroPrimo();
    assertFalse(numero.isPrimo(0));
}

@Test
@DisplayName("o número 2 deve ser primo")
void test1() {
    NumeroPrimo numero = new NumeroPrimo();
    assertTrue(numero.isPrimo(2));
}

@Test
@DisplayName("o número 15 não deve ser primo")
void test2() {
    NumeroPrimo numero = new NumeroPrimo();
    assertFalse(numero.isPrimo(15));
}
```

- [ST1x_2018_Week_3_03_Branch_coverage-video
](https://www.youtube.com/watch?v=u0UJn1FseKY&ab_channel=ST1xAutomatedSoftwareTestingPracticalSkills)

### Cobertura condicional ((Basic) condition coverage)
- Visa a cobertura de código baseada nas condicionais
- Alguns casos onde as condicionais fazem mais de uma verificação é necessário verificar as demais ramificações (filiais ou caminhos)

Exemplo de condicional simples:
```java
public boolean ehPositivo(int a){
    if(a > -1 ){
        return true;
    }

    return false;
}
```

Exemplo de condicional complexa:
```java
public boolean crescente(int a, int b, int c){
    if(a > b && b > c && c < a){
        return true;
    }

    return false;
}
```

Testes da condicional complexa:
```java
class CrescenteTest {
    private Crescente numero;

    @BeforeEach
    void setUp() {
        this.numero = new Crescente();
    }

    @Test
    @DisplayName("a deve ser maior que b, e b maior que c, por fim c menor que a")
    void test() {
        assertTrue(this.numero.crescente(10, 8, 5));
    }


    @Test
    @DisplayName("a deve ser menor que b, e b maior que c, por fim c maior que a")
    void test1() {
        assertFalse(this.numero.crescente(10, 20, 15));
    }

    @Test
    @DisplayName("A deve ser maior que B")
    void test2() {
        assertTrue(this.numero.crescente(25, 20, 15));
    }

    @Test
    @DisplayName("A deve ser menor que B")
    void test3() {
        assertFalse(this.numero.crescente(15, 20, 15));
    }

    @Test
    @DisplayName("B deve ser maior que C")
    void test4() {
        assertTrue(this.numero.crescente(23, 22, 15));
    }

    @Test
    @DisplayName("b deve ser menor que C")
    void test5() {
        assertFalse(this.numero.crescente(15, 20, 25));
    }


    @Test
    @DisplayName("C deve ser menor que A")
    void test6() {
        assertTrue(this.numero.crescente(23, 22, 21));
    }

    @Test
    @DisplayName("C deve ser maior que A")
    void test7() {
        assertFalse(this.numero.crescente(21, 20, 25));
    }
}

```
- [ST1x_2018_Week_3_04_Condition_coverage-video
](https://www.youtube.com/watch?v=6FlpIG7h8TQ&ab_channel=ST1xAutomatedSoftwareTestingPracticalSkills)

### Cobertura de Caminho (Path Coverage)

- Visa criar testes apartir da combinação completa das condições de uma decisão
- Cada combinação é um caminho que deve ser exercicitado por teste
```
cobertura de caminhos = (caminhos percorridos/total de caminhos) * 100

caminhos percoridos= 2
total de camimhos = 6

cobertura de caminhos ->  (2/6) * 100 =  33,33%
```

### MC/DC - Condição Modificada/Cobertura de decisão (Modified Condition/Decision Coverage)

- [MCDC](https://github.com/zup-academy/materiais-publicos-treinamentos/blob/main/testes-de-unidade-reveladores-de-bugs/structural-test.md#mcdc---condi%C3%A7%C3%A3o-modificadacobertura-de-decis%C3%A3o-modified-conditiondecision-coverage)

- [ST1x_2018_Week_3_06_MCDC-video](https://www.youtube.com/watch?v=bwtALQVx86w&t=5s&ab_channel=ST1xAutomatedSoftwareTestingPracticalSkills)
