- jpa
- h2(mem)
- redis
- mail
- actuator
- websocket
- knife4j
- 接口加解密

=======================
- security
- test
- oauth
========================
## 监控端点
http://localhost:8080/actuator

### 动态修改日志等级
curl --location --request POST 'http://localhost:8080/actuator/loggers/com.example' \
--header 'Content-Type: application/json' \
--data-raw '{
    "configuredLevel": "DEBUG"
}'

## websocket
http://localhost:8080/webSocket

balabala
