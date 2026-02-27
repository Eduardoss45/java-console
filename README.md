# Desafio Técnico: Mini Sistema de Gerenciamento de Tarefas (Java Console)

**Data de Início:** `dd/mm/aaaa`
**Data de Expiração:** 14 dias após início

## Objetivo

Criar um **mini sistema de gerenciamento de tarefas** em Java puro (sem frameworks), aplicando conceitos essenciais da linguagem, tais como:

* Classes, objetos e construtores
* Encapsulamento (`private`, `getters`/`setters`)
* Herança e polimorfismo
* Interfaces
* Coleções (`ArrayList`, `HashMap`, `Set`)
* Tratamento de exceções (`try/catch` e exceções customizadas)
* Enum para tipos fixos (ex.: status da tarefa)

O foco é **prática de lógica e conceitos Java**, simulando operações de CRUD em memória (sem banco de dados).

---

## Requisitos Funcionais

1. **Gerenciamento de Tarefas**

   * Criar, editar, listar e excluir tarefas.
   * Cada tarefa deve ter:

     * ID único
     * Título
     * Descrição
     * Status (`PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`)
     * Prioridade (opcional: `BAIXA`, `MÉDIA`, `ALTA`)

2. **Herança e Polimorfismo**

   * Crie uma classe pai `Usuario` com atributos básicos.
   * Crie pelo menos duas classes filhas (`Desenvolvedor`, `Gerente`) com métodos sobrescritos, como `exibirResumo()`.

3. **Interfaces**

   * Crie uma interface `AcoesTarefa` com métodos `criar()`, `editar()`, `remover()`, `listar()`.
   * Implemente essa interface na classe responsável por gerenciar tarefas.

4. **Coleções**

   * Armazene as tarefas em `ArrayList` ou `HashMap`.
   * Opcional: utilize `Set` para evitar duplicação de IDs ou nomes de tarefa.

5. **Enum**

   * Utilize `enum` para status e prioridade das tarefas.

6. **Tratamento de Exceções**

   * Valide operações, por exemplo:

     * Tentativa de remover tarefa inexistente
     * Atribuir status inválido
   * Crie pelo menos uma **exceção customizada** (`TarefaNaoEncontradaException`).

---

## Regras do Desafio

* O sistema deve rodar **no console**.
* Não usar frameworks externos ou bibliotecas adicionais (apenas Java padrão).
* Código deve ser organizado, comentado e seguir boas práticas.
* Priorizar clareza de lógica e uso correto dos conceitos de OOP.

---

## Critérios de Avaliação (Autoavaliação / Mentoria)

* Uso correto de classes, objetos e encapsulamento.
* Aplicação de herança, polimorfismo e interfaces.
* Manipulação correta de coleções.
* Implementação de enum e validação de dados.
* Tratamento de exceções.
* Estrutura do código e legibilidade.

---

## Entregáveis

* Projeto Java com código-fonte completo.
* Classe `Main.java` para executar e testar o sistema.
* README atualizado com instruções de execução e exemplos de uso.
* Opcional: screenshots do console com execução de CRUD completo.

---

## Data de Expiração

* Prazo sugerido: **14 dias a partir da data de início**.
* Recomendação: dividir o desafio em etapas diárias:

  1. Dia 1–3: Classes, Objetos, Encapsulamento
  2. Dia 4–6: Herança, Polimorfismo, Interfaces
  3. Dia 7–10: Coleções e Enum
  4. Dia 11–12: Tratamento de Exceções
  5. Dia 13–14: Testes finais e refinamento do console