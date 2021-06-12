# Exercícios BDD e TDD em JAVA

# Considerações iniciais
Fiz alguns desvios em relação ao que foi proposto:
- o gerenciador do projeto é o Gradle, pois ja estou acostumado com ele.
- como uso linux, precisei de outro driver do firefox\
  para não dar problema para quem usa windows, coloquei ambos, e setei o path\
  dele em tempo de execução.
- alguns casos do exemplo no github estão desatualizados, então fiz de outra forma:
  - o cenário de procura por usuário agora procura o meu próprio usuário,\
    seleciona esta forma de pesquisa na barra lateral e verifica se foi encontrado
  - o cenário de busca por repositório procura peo repositório `cucumber-jvm`,\
    que foi usado para este exercício.
    