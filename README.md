# QA Web Automation Framework

[![QA Automation Tests](https://github.com/VladisonCosta/qa-web-automation-framework/actions/workflows/qa-tests.yml/badge.svg)](https://github.com/VladisonCosta/qa-web-automation-framework/actions/workflows/qa-tests.yml)

Projeto de portfólio de **Quality Assurance e automação de testes Web** desenvolvido com Java, Selenium WebDriver e JUnit 5.

A proposta não é apenas automatizar cliques: o repositório demonstra estratégia de testes, cenários positivos e negativos, Page Object Model, evidências de falha, smoke/regressão, rastreabilidade e execução automatizada em CI.

## Stack
- Java 17+
- Selenium WebDriver 4
- JUnit 5
- Maven
- Allure
- GitHub Actions
- Google Chrome

## Cobertura atual
- Login válido
- Login inválido
- Usuário bloqueado
- Ordenação de produtos por preço
- Adição e remoção no carrinho
- Checkout completo
- Validação de campo obrigatório

## Estrutura
```text
src/test/java/br/com/vladison/qa/
├── core/          # driver, config e classes base
├── extensions/    # screenshot automático em falhas
├── pages/         # Page Object Model
└── tests/         # casos automatizados

docs/
├── TEST_PLAN.md
├── TEST_CASES.md
├── TRACEABILITY_MATRIX.md
├── BUG_REPORT_TEMPLATE.md
└── INTERVIEW_STUDY_GUIDE.md
```

## Executar
```bash
mvn clean test
```

Headless:
```bash
mvn clean test -Dheadless=true
```

Smoke:
```bash
mvn test -Dgroups=smoke
```

Regressão:
```bash
mvn test -Dgroups=regression
```

## Relatórios
Os resultados do Allure são gerados em:
```text
target/allure-results
```

Com Allure CLI instalado:
```bash
allure serve target/allure-results
```

A documentação atual do Allure recomenda a integração JUnit Jupiter e armazenamento dos resultados em `target/allure-results`.

## CI
O workflow `.github/workflows/qa-tests.yml` executa a suíte em Chrome headless a cada push ou pull request para `main` e envia relatórios/evidências como artifact.

## Documentação de QA
- [Plano de Testes](docs/TEST_PLAN.md)
- [Casos de Teste](docs/TEST_CASES.md)
- [Matriz de Rastreabilidade](docs/TRACEABILITY_MATRIX.md)
- [Template de Bug](docs/BUG_REPORT_TEMPLATE.md)
- [Guia para entrevista](docs/INTERVIEW_STUDY_GUIDE.md)

## Sistema sob teste
A automação utiliza uma aplicação pública de demonstração para fins educacionais. O código de automação e a documentação deste repositório são independentes do sistema testado.

## Autor
**Vladison Costa**  
Ciência da Computação | QA / Engenharia de Software  
GitHub: https://github.com/VladisonCosta
