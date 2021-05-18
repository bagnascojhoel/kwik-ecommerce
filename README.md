# Kwik-Ecommerce API

## Passo para execução

### Construir imagem da aplicação

Estando na raiz do projeto, execute os seguintes comandos:

```shell
docker compose -f build.yml up
```

Para construir uma imagem para algum ambiente específico deve ser utilizado o seguinte comando:

```shell
ENV=hml docker compose -f build.yml build
```

Os possíveis ambientes são:

* default (o comando sem ENV=<ambiente> já esse ambiente)
* hml
* prod

### Iniciar a aplicação

```shell
docker compose -f run.yml up --build
```