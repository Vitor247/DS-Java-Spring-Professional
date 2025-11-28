## DESAFIO: Consulta vendas

Trata-se de um sistema de vendas (Sale) e vendedores (Seller). Cada venda está para um vendedor, e um vendedor pode ter várias vendas.

![Modelo](https://github.com/Vitor247/DS-Java-Spring-Professional/blob/4-JPA-consultas-SQL-e-JPQL/desafio/Modelo.png)

Você deverá implementar as seguintes consultas:

### Relatório de vendas

1. [IN] O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor.
2. [OUT] O sistema informa uma listagem paginada contendo id, data, quantia vendida e nome do vendedor, das vendas que se enquadrem nos dados informados.

Informações complementares:
- Se a data final não for informada, considerar a data atual do sistema. Para instanciar a data atual.
- Se a data inicial não for informada, considerar a data de 1 ano antes da data final.
- Se o nome não for informado, considerar o texto vazio.

### Sumário de vendas por vendedor

1. [IN] O usuário informa, opcionalmente, data inicial, data final.
2. [OUT] O sistema informa uma listagem contendo nome do vendedor e soma de vendas deste vendedor no período informado.
Informações complementares:
- As mesmas do caso de uso Relatório de vendas

> Requisições no arquivos postman.
