# Mini Sistema de Gerenciamento de Tarefas (Java Console)

Projeto de console em Java para praticar:

- classes, objetos e construtores
- encapsulamento
- herança e polimorfismo
- interfaces
- coleções (`HashMap`)
- enums (`States`, `Priority`)
- tratamento de exceções com exceção customizada

## Estrutura principal

- `src/Main.java`: ponto de entrada do programa e menu principal
- `src/services/TaskService.java`: regra de negócio do CRUD de tarefas
- `src/models/Task.java`: modelo da tarefa
- `src/models/User.java`: classe abstrata base para usuários
- `src/models/Developer.java` e `src/models/Manager.java`: classes filhas com polimorfismo via `showSummary()`
- `src/interfaces/Actions.java`: contrato com `create`, `edit`, `remove`, `list`
- `src/enums/States.java` e `src/enums/Priority.java`: tipos fixos de status e prioridade
- `src/exceptions/TaskNotFoundException.java`: exceção customizada

## Pré-requisitos

- JDK 17+ instalado (testado com `javac 25.0.2`)
- Terminal com suporte a `javac` e `java` no PATH

## Como executar

### 1. Compilar

No diretório raiz do projeto (`c:\dev\prompt-app`), execute:

```powershell
if (-not (Test-Path out)) { New-Item -ItemType Directory out | Out-Null }
javac -encoding UTF-8 -d out src\Main.java src\interfaces\*.java src\services\*.java src\models\*.java src\ui\*.java src\enums\*.java src\exceptions\*.java
```

> O parâmetro `-encoding UTF-8` evita problemas de acentuação na compilação.

---

### 2. Rodar

```powershell
java -cp out Main
```

---

## Menu da aplicação

Ao iniciar, o console mostra:

```text
1. Criar tarefa
2. Listar tarefa
3. Editar tarefa
4. Excluir tarefa
5. Sair
```

---

## Usuários pré-cadastrados

No serviço atual, existem 2 usuários carregados em memória:

- ID `1`: Developer (Eduardo, Java)
- ID `2`: Manager (Carlos, equipe com 5 pessoas)

---

## Observação sobre o estado atual

No código atual existe uma validação invertida em `src/services/TaskService.java` no método `create()`.

- comportamento atual: IDs válidos (`1` e `2`) retornam "Usuário não encontrado"
- impacto: não é possível concluir o fluxo completo de CRUD sem corrigir essa condição

---

## Exemplo de uso

### Exemplo 1: Criar tarefa

Entrada sugerida:

```text
1
1
Implementar login
Criar autenticação com validação de senha
2
3
```

Sequência acima significa:

- `1` no menu: criar tarefa
- `1` para o ID do usuário responsável
- título e descrição da tarefa
- `2` para status `IN_PROGRESS`
- `3` para prioridade `HIGH`

---

### Exemplo 2: Listar tarefas (após criar)

Depois de criar, selecione:

```text
2
```

Saída esperada (após ajuste da validação no `create()`):

```text
ID: 1 | Título: Implementar login | Descrição: Criar autenticação com validação de senha | Status: IN_PROGRESS | Prioridade: HIGH | Responsável: Dev: Eduardo | Linguagem: Java
```

---

### Exemplo 3: Editar tarefa (após criar)

Entrada sugerida:

```text
3
1
Implementar login com MFA
Adicionar segundo fator de autenticação
2
2
```

Sequência acima significa:

- `3` no menu: editar tarefa
- `1` para editar a tarefa com ID 1
- novo título e nova descrição
- status `IN_PROGRESS`
- prioridade `MEDIUM`

---

### Exemplo 4: Excluir tarefa (após criar)

Entrada sugerida:

```text
4
1
```

Saída esperada:

```text
Tarefa removida com sucesso.
```

---

## Exceções tratadas

- tentativa de editar/excluir tarefa inexistente (`TaskNotFoundException`)
- entrada inválida para IDs e opções numéricas (`InputMismatchException`)

---

# 🔧 Se o problema persistir no Windows

Execute antes:

```powershell
chcp 65001
```

E garanta que:

- O arquivo README está salvo como **UTF-8**
- Seu editor (VSCode, IntelliJ) está configurado para UTF-8
