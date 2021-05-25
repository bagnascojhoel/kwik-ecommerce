# Kwik-Ecommerce API

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

