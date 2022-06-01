## Wallpaper API

Essa API vai retornar os papeis de paredes do site `https://hdqwalls.com/`.

### URL Base:

Na URL base retornará os últimos papeis de paredes da API.
`https://jarpaper.herokuapp.com/api/v1/`

### Endpoints:

##### Papeis de paredes populares

Vai retornar os papeis de paredes mais populares do momento.<br>
`/wallpaper/popular-wallpapers/`

##### Papeis de paredes aleatórios

Vai retornar papeis de paredes aleatórios.<br>
`/wallpaper/random-wallpapers/`

##### Paginação dos papeis de paredes

Vai retornar os papeis de paredes da página de número que será enviado no parâmetro.<br>
`/wallpaper/page={numero}/`

##### Paginação dos papeis de paredes populares

Vai retornar os papeis de paredes populares da página de número que será enviado no parâmetro.<br>
`/wallpaper/popular-wallpapers/page={numero}/`

##### Categorias

Vai retornar todas as categorias.<br>
`/category/`

##### Papeis de paredes da categoria

Vai retornar os papeis de paredes de acordo com a categoria.<br>
`/wallpaper/category/{nome categoria}/`

##### Paginação dos papeis de paredes da categoria

Vai retornar os papeis de paredes de acordo com a categoria e pelo número da página.<br>
`/category/{nome categoria}/page={numero}/`

##### Busca

Vai retornar os papeis de paredes buscados.<br>
`/search={papel de parede bucado}/`

##### Paginação da busca

Vai retornar os papeis de paredes buscados e caso o resultado seja mais de 18 papeis de paredes, com esse endpoint vai
poder navegar entre as páginas.<br>
`/search={papel de parede bucado}&page={numero}/`




