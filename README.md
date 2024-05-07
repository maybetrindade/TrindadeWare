<p align="center">
  <img src="assets/Sketchware-Pro.png" style="width: 30%;" />
</p>

# TrindadeWare
[![GitHub contributors](https://img.shields.io/github/contributors/Sketchware-Pro/Sketchware-Pro)](https://github.com/Sketchware-Pro/Sketchware-Pro/graphs/contributors)
[![GitHub last commit](https://img.shields.io/github/last-commit/Sketchware-Pro/Sketchware-Pro)](https://github.com/Sketchware-Pro/Sketchware-Pro/commits/)
[![Discord server stats](https://img.shields.io/discord/790686719753846785)](http://discord.gg/kq39yhT4rX)
[![Total downloads](https://img.shields.io/github/downloads/Sketchware-Pro/Sketchware-Pro/total)](https://github.com/Sketchware-Pro/Sketchware-Pro/releases)
[![Repository Size](https://img.shields.io/github/repo-size/Sketchware-Pro/Sketchware-Pro)](https://github.com/Sketchware-Pro/Sketchware-Pro)

Bem-vindo ao TrindadeWare! Aqui você encontrará o código fonte de muitas classes do TrindadeWare e, o mais importante, o local para contribuir com o TrindadeWare.
 
## Building the App
Para construir o aplicativo, você deve usar o Gradle. É altamente recomendável usar o Android Studio para obter a melhor experiência.
 
Existem duas variantes de construção com recursos diferentes: 

- `minApi26:` Esta variante oferece suporte à exportação de AABs de projetos e à compilação de código Java 1.8, 1.9, 10 e 11. No entanto, só funciona no Android 8.0 (O) e superior. 
- `minApi21:` Esta variante não pode produzir AABs de projetos e só pode compilar código Java 1.7, mas oferece suporte ao Android 5 e superior. 

Para selecionar a variante de build apropriada no Android Studio, use a guia Build Variants ou use o comando de build apropriado do Gradle. 

### Mapa de código-fonte
 
| Class           | Role                                        |
| --------------- | ------------------------------------------- |
| `a.a.a.ProjectBuilder`      | Auxiliar para compilar um projeto inteiro        |
| `a.a.a.Ix`      | Responsável por gerar AndroidManifest.xml  |
| `a.a.a.Jx`      | Gera código fonte das atividades           |
| `a.a.a.Lx`      | Gera código-fonte de componentes, como ouvintes, etc.  |
| `a.a.a.Ox`      | Responsável por gerar arquivos XML de layouts  |
| `a.a.a.qq`      | Registro de dependências de bibliotecas integradas  |
| `a.a.a.tq`      | Responsável pelos questionários do diálogo de compilação  |
| `a.a.a.yq`      | Organiza os caminhos dos arquivos dos projetos do Sketchware     |

> [!DICA ]
> Você também pode verificar o pacote `mod`, que contém a maioria das alterações dos contribuidores. 

## Contribuindo 

Se você gostaria de contribuir com o TrindadeWare, siga estes passos: 

1. Bifurque este repositório. 
2. Faça alterações em seu repositório bifurcado. 
3. Teste essas mudanças. 
4. Crie uma solicitação pull neste repositório. 
5. Sua solicitação pull será revisada pelos membros do repositório e mesclada se for aceita. 

Aceitamos contribuições de qualquer tamanho, sejam elas recursos importantes ou correções de bugs, mas observe que todas as contribuições serão revisadas minuciosamente.
 
### Commit Message

Ao fazer alterações em um ou mais arquivos, você precisa confirmar essas alterações com uma mensagem de confirmação. Aqui estão algumas diretrizes: 

- Mantenha a mensagem de commit curta e detalhada. 
- Use um destes tipos de commit como prefixo: 
  - `feat:` para um recurso, possivelmente melhorando algo já existente. 
  - `fix:` para uma correção, como uma correção de bug. 
  - `style:` para recursos e atualizações relacionadas ao estilo. 
  - `refactor:` para refatorar uma seção específica da base de código. 
  - `test:` para tudo relacionado a testes. 
  - `docs:` para tudo relacionado à documentação. 
  - `chore:` para manutenção de código (você também pode usar emojis para representar tipos de commit). 

Examples:
- `feat: Acelere a compilação com a nova técnica` 
- `fix: Corrigir falha durante a inicialização em determinados telefones 
- `refactor: Reformate o código em File.java`     

- Lembrando que dependendo do seu PR (Pull Request) mesmo sem seguir as regras do commit ele pode ser aceito!

## Obrigado por contribuir 

Obrigado por contribuir com TrindadeWare! Suas contribuições ajudam a manter o TrindadeWare vivo. Cada contribuição aceita será anotada na atividade "Sobre Modders". Usaremos inicialmente seu nome GitHub e foto de perfil, mas eles podem ser alterados, é claro. 