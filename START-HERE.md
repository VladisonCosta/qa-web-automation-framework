# COMEÇE AQUI — 3 passos

## PASSO 1 — Rodar e validar (prioridade máxima)
Pré-requisitos: Java 17+, Maven e Google Chrome.

No PowerShell, dentro da pasta do projeto:

```powershell
java -version
mvn -version
mvn clean test
```

Para rodar sem abrir o Chrome:

```powershell
mvn clean test -Dheadless=true
```

O esperado é a suíte finalizar com `BUILD SUCCESS`.

## PASSO 2 — Subir para o GitHub
Crie um repositório público chamado `qa-web-automation-framework` sem README automático.

```powershell
git init -b main
git add .
git commit -m "feat: add QA web automation framework"
git remote add origin https://github.com/SEU-USUARIO/qa-web-automation-framework.git
git push -u origin main
```

Depois confira a aba **Actions**. O workflow deve ficar verde.

## PASSO 3 — Atualizar o currículo
Somente depois do passo 1 (idealmente também do passo 2), use o texto de `docs/CV_BULLETS.md`.

Para a academia de QA, destaque no currículo:
- Java
- Selenium WebDriver
- JUnit 5
- Maven
- Testes E2E
- Page Object Model
- Testes de API (seus projetos anteriores já ajudam aqui)
- Pytest / JUnit / Mockito
- Git / GitHub / GitHub Actions
- SQL

Depois estude `docs/INTERVIEW_STUDY_GUIDE.md` para conseguir explicar cada decisão.
