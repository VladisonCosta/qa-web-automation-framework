# Casos de Teste

| ID | Cenário | Tipo | Prioridade | Resultado esperado |
|---|---|---|---|---|
| TC-LOGIN-001 | Login com credenciais válidas | Smoke/Positivo | Crítica | Usuário acessa a página de produtos |
| TC-LOGIN-002 | Login com credenciais inválidas | Negativo | Alta | Mensagem de erro é exibida |
| TC-LOGIN-003 | Login com usuário bloqueado | Negativo | Alta | Sistema informa que o usuário está bloqueado |
| TC-INV-001 | Ordenar produtos por menor preço | Regressão | Média | Lista fica em ordem crescente de preço |
| TC-CART-001 | Adicionar e remover produto | Smoke | Alta | Badge do carrinho reflete a quantidade corretamente |
| TC-CHK-001 | Finalizar compra com dados válidos | Smoke/E2E | Crítica | Confirmação de pedido é exibida |
| TC-CHK-002 | Continuar checkout sem dados obrigatórios | Negativo | Alta | Validação de primeiro nome obrigatório é exibida |

## Dados de teste
- Usuário padrão: configurado em `src/test/resources/config.properties`
- Usuário bloqueado: conta de demonstração pública do ambiente de testes
- Dados pessoais do checkout: dados fictícios, sem informação sensível
