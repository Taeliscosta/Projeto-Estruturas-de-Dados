# Projeto Estruturas de Dados - Implementação de Lista Encadeada, Árvore Binária e Tabela Hash em Java

Este projeto é uma implementação didática de estruturas de dados fundamentais em Java, desenvolvida como parte da disciplina de Estruturas de Dados. O foco principal é o manuseio de objetos da classe Pessoa, utilizando o CPF como chave para operações de busca, inserção e remoção.

Estruturas Implementadas:

Lista Encadeada--Implementa uma lista dinâmica onde cada elemento aponta para o próximo, com operações de inserção, remoção, busca, verificação de tamanho e conversão para array.

Árvore Binária de Busca (BST)--Estrutura hierárquica que organiza elementos de forma ordenada pelo CPF, possibilitando busca, remoção e múltiplas formas de percurso (pré-ordem, in-ordem, pós-ordem). Inclui também verificação se a árvore é completa.

Tabela Hash com Encadeamento Separado--Estrutura que permite acesso rápido a elementos via hash do CPF, tratando colisões por meio de listas encadeadas em cada entrada da tabela.

Funcionalidades Principais:

Inserção, busca e remoção eficientes baseadas na chave CPF.

Conversão das estruturas para formas iteráveis (arrays ou listas).

Testes automatizados utilizando JUnit para garantir o correto funcionamento das operações principais e para validar o tratamento de casos de erro.

Tecnologias e Ferramentas:
Java e JUnit para testes unitários.
