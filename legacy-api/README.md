# Kwik-Ecommerce API

1. [Rodando a aplicação localmente](#Rodando a aplicação localmente)
2. [Padrões](#Padrões)

## Rodando a aplicação localmente

1. Necessário ter o Docker instalado.
2. Entrar no diretório da aplicação.
3. Iniciar o banco e a aplicação.

    ```shell
    // rodar a aplicação no background
    docker compose up -e ENV=default -d
    
    // rodar a aplicação no console, podendo encerra-la com CRTL + C
    docker compose up -e ENV=default
    ```
4. A aplicação deve estar rodando.
    * A aplicação deve estar acessível através do link http://localhost:8080/api.
    * Para utilizar o Swagger e fazer requisições através dele acesse o link
      http://localhost:8080/api/swagger-ui/

### Configurações

#### Definição de ambiente

A variável de ambiente `ENV` é utilizada para definir os perfis maven a serem utilizados na execução
do projeto. Os possíveis perfis são:

* default
* homolog

#### Carregando alterações

Se fez alguma alteração na aplicação, e quer utilizar o docker para executa-la roda o seguinte
comando:

```shell
docker compose up -e ENV=default --build
```

A opção `--build` força uma reconstrução da imagem da aplicação. Se essa opção não for utilizada, o
docker apenas constroi a imagem na primeira vez que o subcomando `up` é executado, ignorando
quaisquer alterações realizadas após a última construção da imagem.

## Padrões

### Qualidade geral

* Métodos devem sempre iniciar com um verbo ou advérbio, dependendo da classe em que ele se
  encontra.

### Services

Os verbos utilizados nas services deverão seguir as seguintes regras:

* Métodos que realizam alguma **operação de CRUD em conjunto com alguma outra lógica**, não devem
  ser nomeados seguindo o padrão JPA. (Essa regra visa evitar confusão no uso dos métodos.)
    * C -> create
    * U -> update
    * R -> fetch, fetchAll, fetchWithFilter
    * D -> delete

    ```java
    class ProductServiceImpl {
        // definição das dependências
        Long create(CreationRequestDto requestDto) {
            var product = productMapper.map(requestDto);
            return productRepository.save(product).getId();
        }
 
    }
    ```

* Métodos que realizam **apenas uma operação de CRUD** devem ser nomeados de acordo com o padrão do
  JPA. Entretanto, o método da Service pode alterar o tipo de dado recebido e o retornado.
    ```java
    interface ProductService {
  
        Page<ProductListingResponseDto> findAll();
        
        Long save(); // o método do JPA retorna o Product, a Service o id
        
        boolean exists(Product product);
  
        void delete(Product product);
  
      }
    ```

### Exceções

* Todas exceções específicas devem estender uma das exceções base:
    * BusinessLogicException
    * NotFoundException
    * ProxyException
    * UnauthorizedException
    * PassableException (exceção base para as que não encerram o fluxo)

* Problemas que encerrem o fluxo da requisição devem ser exceções **unchecked**. Se o erro pode ser
  contornado sem encerrar o fluxo, deve ser uma exceção **checked**.

    