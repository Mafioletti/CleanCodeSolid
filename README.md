Aplicação Java em console desenvolvida para gerenciar dispositivos tecnológicos (Computadores, Impressoras e Roteadores). O objetivo principal do projeto é exemplificar a aplicação prática dos **princípios SOLID** e padrões de **Clean Code** no desenvolvimento de software em Java.

---

## 💻 Funcionalidades

- ➕ **Cadastro de Dispositivos**: Suporte para diferentes tipos de hardware com atributos específicos:
  - **Computador**: Memória RAM e Sistema Operacional.
  - **Impressora**: Tipo de impressão e Velocidade.
  - **Roteador**: Quantidade de portas e Velocidade da rede.
- 📋 **Listagem & Consulta**: Exibição unificada de todos os dispositivos ou busca individual por código.
- ⚡ **Controle de Estado**: Alteração de status (*Ligar* / *Desligar*) com tratamento de exceções de estado.
- 📊 **Relatórios Estatísticos**: Processamento de métricas gerais e percentuais por tipo de dispositivo utilizando **Java Streams**.

---

## 📁 Arquitetura e Estrutura do Projeto

O projeto adota uma divisão em camadas com responsabilidades bem definidas:

```text
src/
 ├── App.java                         # Classe principal (Orquestradora e Menu)
 ├── model/                           # Modelo de Domínio
 │    ├── Dispositivo.java            # Superclasse base abstrata
 │    ├── Operavel.java               # Interface de comportamento
 │    ├── Computador.java             # Subclasse de Dispositivo
 │    ├── Impressora.java             # Subclasse de Dispositivo
 │    └── Roteador.java               # Subclasse de Dispositivo
 ├── repository/                      # Camada de Persistência / Dados
 │    ├── DispositivoRepository.java     # Interface do Repositório
 │    └── DispositivoRepositoryImpl.java # Implementação em memória
 ├── service/                         # Camada de Serviços
 │    └── RelatorioService.java      # Processamento e exibição de relatórios
 └── util/                            # Utilitários Auxiliares
      └── LeitorConsole.java         # Leitura e validação de dados de entrada
```

---

## 🏛️ Princípios SOLID Aplicados

### 1. **S** - Single Responsibility Principle (Princípio da Responsabilidade Única)
Cada classe possui uma única responsabilidade no sistema:
- `LeitorConsole`: Exclusivamente responsável pela leitura, validação de tipos e sanitização de entrada via `Scanner`.
- `DispositivoRepositoryImpl`: Trata apenas da persistência e manipulação da coleção de dados em memória.
- `RelatorioService`: Responsável apenas pelo cálculo e formatação do relatório estatístico final.
- `App`: Atua unicamente como orquestrador do fluxo do menu de navegação.

### 2. **O** - Open/Closed Principle (Princípio Aberto/Fechado)
O sistema está aberto para extensão, mas fechado para modificação:
- A adição de novos dispositivos (ex: `Smartphone`, `Servidor`) requer apenas a criação de uma nova subclasse herdando de `Dispositivo`. O repositório, menu de navegação e serviço de relatórios continuarão funcionando sem necessidade de alteração estrutural.

### 3. **L** - Liskov Substitution Principle (Princípio da Substituição de Liskov)
- As subclasses `Computador`, `Impressora` e `Roteador` podem ser tratadas indistintamente como instâncias da classe base `Dispositivo` sem quebrar a execução das operações do repositório ou da listagem de relatórios.

### 4. **I** - Interface Segregation Principle (Princípio da Segregação de Interfaces)
- A interface `Operavel` provê um contrato magro e focado em comportamentos essenciais de controle (`ligar()`, `desligar()`, `exibirStatus()`), evitando que classes dependam de métodos que não utilizam.

### 5. **D** - Dependency Inversion Principle (Princípio da Inversão de Dependência)
- A classe `App` não depende da implementação concreta do repositório (`DispositivoRepositoryImpl`), mas sim da abstração `DispositivoRepository`. Além disso, utiliza **Injeção de Dependência via Construtor**:
  ```java
  public App(DispositivoRepository repository, LeitorConsole leitor, RelatorioService relatorioService) {
      this.repository = repository;
      this.leitor = leitor;
      this.relatorioService = relatorioService;
  }
  ```

---

## ✨ Destaques de Clean Code

- **Nomes Autodescritivos**: Variáveis, parâmetros e métodos possuem nomenclatura clara em português (ex: `buscarPorCodigo`, `quantidadePortas`, `estaVazio`).
- **Encapsulamento e Proteção de Dados**: O repositório retorna uma cópia imutável através de `Collections.unmodifiableList()`, impedindo alterações indesejadas por camadas externas.
- **Uso do `Optional`**: Tratamento seguro contra `NullPointerException` ao consultar dispositivos por código (`buscarPorCodigo()`).
- **Tratamento de Fluxo Elegante**: Uso das APIs de **Streams** e `ifPresentOrElse` para manipulação limpa de dados funcionais.