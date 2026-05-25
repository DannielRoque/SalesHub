# SalesHub

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose para gerenciamento de vendas, permitindo criar pedidos, visualizar histórico de vendas e consultar produtos de forma simples e intuitiva.

---

## ✨ Features

- 📦 Cadastro de novas vendas
- 👤 Seleção de clientes
- 🛒 Adição de múltiplos produtos ao pedido
- 💰 Cálculo automático do valor total
- 📄 Histórico de vendas
- 📦 Listagem de produtos
- ⚙️ Tela de configurações
- 🌙 Estrutura preparada para Dark Mode
- 🎨 UI moderna utilizando Material 3
- 🧩 Componentização com Jetpack Compose
- 🧪 Dados mockados para simulação de fluxo real

---

## 📱 Screens

### Home
- Resumo do negócio
- Últimas vendas
- Acesso rápido para nova venda

### Sales
- Histórico de pedidos
- Visualização de pedidos realizados

### Create Sale
- Seleção de cliente
- Seleção de produtos via BottomSheet
- Carrinho de itens adicionados
- Remoção de produtos
- Total automático do pedido
- Controle de estado da venda

### Products
- Lista de produtos
- Estoque e valores

### Settings
- Configurações gerais
- Estrutura para personalização futura

---

## 🛠️ Tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose
- Compose State Management
- Mock Data
- Clean UI Structure

---

## 🧱 Arquitetura

O projeto foi estruturado seguindo boas práticas de organização e componentização.

```text
presentation/
 ├── components/
 ├── home/
 ├── products/
 ├── sales/
 └── settings/

data/
 ├── local/
 ├── mock/
 └── model/
Separação aplicada
UI desacoplada
Componentes reutilizáveis
Estados centralizados nas telas
Dados mockados isolados
Navegação centralizada
🎯 Objetivo do projeto

Este projeto foi desenvolvido como teste técnico com foco em:

Qualidade de código
Organização
Manutenção
Experiência do usuário
Arquitetura
Componentização
Fluxo real de vendas (no momento)

🚀 Como executar
1. Clone o repositório
git clone <repo>
2. Abra o projeto no Android Studio
3. Execute o projeto em um emulador ou dispositivo físico

📌 Melhorias futuras
Persistência com Room Database
Integração com API
Autenticação
Dashboard com gráficos
Dark Mode completo
Testes unitários
Testes UI
Injeção de dependência
Offline first


👨‍💻 Desenvolvido por

Daniel Roque