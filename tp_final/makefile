.PHONY: build compile clean run

GAMEPLAY="lib/gameplay/abV1.32.zip"
APPCACHE="lib/appcache/Application_Cache.zip"
ifeq ($(shell uname),Darwin)
	LOCALAPPCACHE_NEW="/Users/$$USER/Library/Application\ Support/Google/Chrome/Default/Application\ Cache"
	LOCALAPPCACHE_OLD="/Users/$$USER/Library/Application\ Support/Google/Chrome/Default/Application\ Cache\ Original"
	NAV=open
else
	LOCALAPPCACHE_NEW="/home/$$USER/.config/google-chrome/Profile\ 1"
	LOCALAPPCACHE_OLD="/home/$$USER/.config/google-chrome/Profile\ 1_Original"
	NAV=sensible-browser
endif

build: truco

build-path:
	@echo ''
	@echo 'Creando los directorios necesarios para generar las salidas'
	@echo ''
	-mkdir -p build/source/
	-mkdir -p build/doc

unzip-libs: build-path
	@echo ''
	@echo 'Descomprimiendo librerías'
	@echo ''
	-if [ -d 'build/source/abV1.32' ]; then echo 'Game Play ya extraido!'; else echo ' --> Descomprimiendo Game Play..'; echo ''; unzip $(GAMEPLAY) -d build/source/; fi
	@echo ''
	if [ -d 'build/source/Application Cache' ]; then echo 'Application Cache ya extraido!'; else echo ' --> Descomprimiendo Application Cache'; echo ''; unzip $(APPCACHE) -d build/source/; echo ''; echo ' --> Application Cache Extraído'; fi
	@echo ''

clean: server-stop recover-appcache
	@echo ''
	@echo 'Borrando los directorios de resultados'
	@echo ''
	rm -rf build
	rm -f informe.pdf

prompt:
	while true; do echo;echo "=====REMINDER====="; read -p "Modo de desarrollador (es un check arriba a la derecha), está activado?" yn; case $$yn in [Yy]* ) echo "Continuando..."; echo; break;; [Nn]* ) echo 'Insisto en que lo verifique';; * ) echo "Responde y (yes) or n (no).";; esac; done

browse-close:
	-pkill -9 Chrome

browse-open:
	-$(NAV) http://chrome.angrybirds.com

server-start: build
	java -jar build/source/abV1.32/ABServer.jar &

server-stop:
	test=$$(ps -ef | grep ABServer.jar | grep -v grep | cut -f3 -d\ ); if [ ! -z "$$test" ]; then kill -9 $$test; fi

run: compile browse-close browse-open prompt server-start client-start

client-start:
	sleep 2
	java -jar build/source/abV1.32/ABSoftware.jar -nasc

recover-appcache:
	if [[ -d "$(LOCALAPPCACHE_NEW)" && -d "$(LOCALAPPCACHE_OLD)" ]]; then echo; echo "Recupero el orginal a su estado natural"; rm -rf "$(LOCALAPPCACHE_NEW)"; mv "$(LOCALAPPCACHE_OLD)" "$(LOCALAPPCACHE_NEW)"; fi

save-appcache:
	if [[ -d "$(LOCALAPPCACHE_NEW)" && ! -d "$(LOCALAPPCACHE_OLD)" ]]; then echo; echo "Guardo el Application Cache en una copia!!"; echo; mv "$(LOCALAPPCACHE_NEW)" "$(LOCALAPPCACHE_OLD)"; fi

truco: unzip-libs save-appcache
	cp -R 'build/source/Application Cache' "$(LOCALAPPCACHE_NEW)"

compile: build
	cp -R src/ 'build/source/abV1.32/src/'
	cd 'build/source/abV1.32/'; ant compile; error=`echo $$?`; [[ "error" -gt 0 ]] && exit $$error; ant jar; error=`echo $$?`; [[ "error" -gt 0 ]] && exit $$error; cd '../../../'
