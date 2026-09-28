# Guia rápido para entrevista

## O que você precisa saber explicar
1. **Page Object Model:** separa seletores/ações das classes de teste, reduz duplicação e facilita manutenção.
2. **Smoke x regressão:** smoke valida rapidamente fluxos críticos; regressão cobre comportamento mais amplo após mudanças.
3. **Teste positivo x negativo:** positivo confirma uso esperado; negativo valida tratamento de entradas/estados inválidos.
4. **Espera explícita:** espera uma condição específica, evitando sleeps fixos e reduzindo flakiness.
5. **Selenium Manager:** auxilia no gerenciamento do driver do navegador.
6. **JUnit 5:** organiza execução, assertions, tags, lifecycle e extensões.
7. **CI:** cada push/PR executa os testes em ambiente limpo e reproduzível.
8. **Allure:** transforma resultados em evidências e relatórios de execução.
9. **Screenshot em falha:** facilita triagem e diagnóstico.
10. **Rastreabilidade:** liga requisito/riscos aos casos que os validam.

## Perguntas que podem fazer
### Por que não usar Thread.sleep?
Porque cria espera fixa e deixa os testes lentos ou instáveis. O projeto usa WebDriverWait com condições explícitas.

### Por que separar pages e tests?
Para centralizar seletores e comportamentos da interface. Uma mudança de seletor tende a exigir alteração em um único Page Object.

### O que você automatizaria primeiro em um sistema real?
Fluxos críticos, repetitivos, estáveis e de alto risco/valor para o negócio. Nem todo teste deve ser automatizado.

### O que fazer quando um teste falha no CI?
Analisar evidências, logs e screenshot; reproduzir localmente; diferenciar defeito real, problema de ambiente ou teste instável; corrigir a causa em vez de simplesmente reexecutar indefinidamente.

### O que melhoraria depois?
Cross-browser, paralelismo, dados parametrizados, integração com gestão de testes, análise de acessibilidade e testes de API complementares.
