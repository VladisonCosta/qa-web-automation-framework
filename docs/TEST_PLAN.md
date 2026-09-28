# Plano de Testes — QA Web Automation Framework

## 1. Objetivo
Validar os fluxos críticos de autenticação, inventário, carrinho e checkout de uma aplicação web de e-commerce demonstrativa, além de criar uma base reutilizável para automação de regressão.

## 2. Escopo
### Em escopo
- Login válido e inválido
- Bloqueio de usuário
- Ordenação de produtos
- Inclusão e remoção do carrinho
- Validação de campos obrigatórios
- Checkout ponta a ponta

### Fora do escopo
- Testes de carga/performance
- Testes de segurança ofensiva
- Testes mobile nativos
- Validação de pagamentos reais

## 3. Tipos de teste
- Funcional E2E
- Smoke
- Regressão
- Testes negativos
- Validação de regras de interface

## 4. Ambiente
- Navegador: Google Chrome
- Automação: Selenium WebDriver
- Linguagem: Java
- Framework: JUnit 5
- Build: Maven
- Evidências: screenshots em falha + resultados Allure
- CI: GitHub Actions

## 5. Critérios de entrada
- Aplicação acessível
- Chrome instalado ou disponível no runner de CI
- Java 17+ e Maven disponíveis

## 6. Critérios de saída
- 100% dos casos smoke executados
- Nenhum defeito blocker conhecido nos fluxos críticos
- Resultados e evidências disponíveis na execução

## 7. Riscos
| Risco | Impacto | Mitigação |
|---|---|---|
| Instabilidade do site público de demonstração | Alto | Esperas explícitas e reexecução controlada apenas após análise |
| Alteração de seletores | Médio | Page Object Model centraliza manutenção |
| Diferença de navegador/driver | Médio | Selenium Manager + CI padronizado |

## 8. Estratégia de automação
Os testes são separados da camada de páginas por Page Object Model. A automação usa esperas explícitas, tags smoke/regression, screenshots em falha e execução headless no CI.
