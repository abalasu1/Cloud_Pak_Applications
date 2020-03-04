PROJECT=cargotracker
DOCKERREPOSITORY=docker-registry.default.svc:5000

SUBDOMAIN=apps.eu-5.os.fyre.ibm.com
GITHUBREPO=https://github.com/abalasu1/Cloud_Pak_Applications.git

CARGOTRACKER=$(DOCKERREPOSITORY)/$(PROJECT)/cargotracker

init:
	-oc new-project $(PROJECT)
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~cargotracker.$(SUBDOMAIN)~g' ./deployment/route.yaml  | oc apply -f -

init-db:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/pvc.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/mysql.yaml  | oc apply -f -

build:
	-sed -e 's~<CONTAINER>~$(CARGOTRACKER)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/buildconfig.yaml  | oc apply -f -	
	oc start-build cargotracker	

deploy:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/deploymentconfig.yaml  | oc apply -f -

test-1:
	-bash -c 'test/test-1.sh cargotracker.$(SUBDOMAIN)'

test-2:
	-bash -c 'test/test-2.sh cargotracker.$(SUBDOMAIN)'

clean:
	-oc delete all -l app=cargotracker-monolith
	-oc delete $(PROJECT)
