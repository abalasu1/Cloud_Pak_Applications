PROJECT=quotemachine

DOCKERREPOSITORY=docker-registry.default.svc:5000
SUBDOMAIN=apps.eu-5.os.fyre.ibm.com

QUOTEAPI=$(DOCKERREPOSITORY)/$(PROJECT)/quoteapi
GITHUBREPO=https://github.com/abalasu1/Cloud_Pak_Applications.git

init-all: init init-quote-api
clean-all: clean

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

clean:
	-oc delete all -l app=$(PROJECT)
