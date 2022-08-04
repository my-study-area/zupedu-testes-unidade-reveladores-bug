# zupedu-testes-unidade-reveladores-bug
Testes de Unidade Reveladores de Bugs

## Aplicando Testes de Unidade Reveladores de Bugs
### Teorias necessarias
1 - [Aprendendo sobre Specification Test](https://github.com/zup-academy/materiais-publicos-treinamentos/blob/main/testes-de-unidade-reveladores-de-bugs/specification-test.md)

Pensar em possíveis casos de testes baseados na especificação
- Identificação dos parametros de entrada. _Ex: identificador de aluno_
- Identificação das caractertisticas dos parametros de entrada. _Ex: o identificador é valor numérico inteiro e maior que zero_.
- Adicionando restrições a partir das caracteristicas das entradas e diminuindo o conjunto de testes. _Ex: não aceita valores nulos_
- Combinando valores de entrada e obtendo casos de testes.

**Partições de equivalencia**
- também conhecidas como classes de equivalência
- Partições de equivalencia se dividem em:
  - partição de equivalência válida
  - partição de equivalência inválida

![Imagem exibindo partição de equivalencia válida para valores entre 16 a 60 anos e partição de equivalencia inválida para os valores de 0 a 15 anos e a partir de 61 anos](./img/particao-equivalencia-valida-invalida.png)
fonte: [Técnica de Teste — Particionamento de Equivalência](https://medium.com/revista-tspi/t%C3%A9cnica-de-teste-particionamento-de-equival%C3%AAncia-d32a7d689d82)


[Vídeo no youtube: O que é partição de equivalência: o guia definitivo
](https://www.youtube.com/watch?v=-IdzE1GoC-g&ab_channel=JuliodeLima)
