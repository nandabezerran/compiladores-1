# Projeto Final - Construção de Compiladores
### Universidade Federal do Ceará, Departamento de Computação, Disciplina Construção de Compiladores
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

## Equipe:
  - Andreza Fernandes
  - Arina Sanches
  - Fernanda Bezerra

---

## Fases:
### 1. [Analisador Léxico e Sintático](analisador_lexico/)
#### Instruções
```sh
$ cd analisador_lexico
$ javacc Parser.jj
$ javac *.java
$ java Parser minijava.java
```

### 2. [Análise Semântica](analisador_semantico/)
#### a. [Árvore Sintática Abstrata](analisador_semantico/syntaxtree/)
#### b. [Tabela de símbolos - Ambientes](analisador_semantico/context/)
#### c. [Type Checking](analisador_semantico/typechecking/)
---
