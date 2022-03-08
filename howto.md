## Часть 1
#### Работа со своим репозиторием
Добавили удаленные репозиторий:   
`git remote add my2021 https://github.com/Qustarnick/KotlinAsFirst2021.git`  
Создали ветку `backport`:  
`git branch backport`   
Загрузили репозиторий локально:   
`git fetch my2021`  
Перешли в ветку `backport`:  
`git checkout backport`  
Осуществляем `cherry-pick` коммитов с решениями заданий из репозитория,
используя IDE.
## Часть 2
#### Работа с репозиторием напарника
Добавляем удалённый репозиторий напарника:  
`git remote add mate2021 https://github.com/frjumi/KotlinAsFirst2021.git`   
Создаём ветку `backport_mate`:   
`git branch backport_mate`  
Загружаем репозиторий локально:  
`git fetch mate2021`    
Переходим в ветку `backport_mate`      
`git checkout backport_mate`  
Осуществляем `cherry-pick` коммитов с решениями заданий из репозитория напарника,
используя IDE.
## Часть 3
#### Слияние веток в `master`
Переходим в ветку `master`:  
`git checkout master`   
Производим слияние веток, используя опцию `-Xtheirs` для избежания конфликтов:  
`git merge backport`    
`git merge backport1 -Xtheirs`
## Часть 4
#### Добавление файлов `remotes.txt` и `howto.md`
Используя IDE, создаём файл `remotes.txt`   
Вводим в терминал `git remote -v` и копируем информацию в созданный файл.   
Используя IDE, создаём файл `howto.md` и заполняем его. 
Делаем `Commit` и `Push`, используя IDE.