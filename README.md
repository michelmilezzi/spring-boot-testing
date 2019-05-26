# Spring Demo App

App construída para definir os padrões da arquitetura Spring

`./mvnw spring-boot:run
`

## Testing
* Models/Entities
* Repositories
* Services
* API
* Integração
* TAP
* PostgreSQL

## Health check

```sh
$ docker pull prom/prometheus
$ docker run -d --name=prometheus -p 9090:9090 -v /<path_to_project>/src/main/resources/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
$ docker run -d --name=grafana -p 3000:3000 grafana/grafana
```
Credenciais: admin/admin

Importar painel no Grafana: https://grafana.com/dashboards/4701

## Patterns
TODO

## CI/CD
TODO