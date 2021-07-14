# Final Project - Compilers Construction
### Federal University of Ceará, Computer Department, Compilers Construction Course
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

## Team:
  - Andreza Fernandes
  - Arina Sanches
  - Fernanda Bezerra

---

## Phases:
### 1. [Lexical and Syntactic Analysis](analisador_lexico/)
#### Instructions
```sh
$ cd analisador_lexico
$ javacc Parser.jj
$ javac *.java
$ java Parser minijava.java
```

### 2. [Semantic Analysis](analisador_semantico/)
#### a. [Abstract Syntax Tree](analisador_semantico/syntaxtree/)
#### b. [Symbol table - Environments](analisador_semantico/visitors/SymbolTable.java)
#### c. [Type Checking](analisador_semantico/visitors/TypeChecking.java)
#### Instructions
```sh
$ javacc analisador_semantico/syntaxtree/*.java
$ javac analisador_semantico/context/*.java
$ javac analisador_semantico/visitors/*.java
$ cd analisador_lexico/
$ javacc Parser.jj
$ cd ..
$ javac analisador_lexico/*.java
$ javac MainProgram.java
$ java MainProgram arquivos_teste/minijava.java
```
---
### 3. [Translation to intermediate code](traducao_intermediario/)
---
### 4. [IR Canônica](Canon/) e [Assembly translation](Assem/)
