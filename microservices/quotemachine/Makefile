PROJECT=quotemachine

DOCKERREPOSITORY=docker-registry.default.svc:5000
SUBDOMAIN=apps.eu-5.os.fyre.ibm.com

QUOTEAPI=$(DOCKERREPOSITORY)/$(PROJECT)/quoteapi
QUOTESERVER=$(DOCKERREPOSITORY)/$(PROJECT)/quoteserver
GITHUBREPO=https://github.com/abalasu1/Cloud_Pak_Applications.git

init-all: init init-quote-api init-quote-server
build-all: build-quote-api build-quote-server
deploy-all: deploy-quote-api build-quote-server
clean-all: clean clean-quote-api clean-quote-server

init:
	-oc new-project $(PROJECT)

init-quote-api:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./quoteapi/deployment/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~quoteapi.$(SUBDOMAIN)~g' ./quoteapi/deployment/route.yaml  | oc apply -f -

build-quote-api:
	-sed -e 's~<CONTAINER>~$(QUOTEAPI)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./quoteapi/deployment/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./quoteapi/deployment/buildconfig.yaml  | oc apply -f -	
	oc start-build quoteapi	

deploy-quote-api:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./quoteapi/deployment/deploymentconfig.yaml  | oc apply -f -

clean-quote-api:
	-oc delete all -l app=quoteapi

init-quote-server:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./quoteserver/deployment/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~quoteserver.$(SUBDOMAIN)~g' ./quoteserver/deployment/route.yaml  | oc apply -f -

build-quote-server:
	-sed -e 's~<CONTAINER>~$(QUOTESERVER)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./quoteserver/deployment/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./quoteserver/deployment/buildconfig.yaml  | oc apply -f -	
	oc start-build quoteserver

deploy-quote-server:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./quoteserver/deployment/deploymentconfig.yaml  | oc apply -f -

clean-quote-server:
	-oc delete all -l app=quoteserver

clean:
	-oc delete project $(PROJECT)
