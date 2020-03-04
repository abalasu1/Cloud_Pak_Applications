DOCKERREPOSITORY=docker-registry.default.svc:5000
SUBDOMAIN=apps.eu-5.os.fyre.ibm.com

GITHUBREPO=https://github.com/abalasu1/Cloud_Pak_Applications.git

BOOKINGMS=booking
BOOKINGAPI=$(DOCKERREPOSITORY)/$(PROJECT)/booking

init-all: init-booking init-handling init-routing init-tracking
build-all: build-booking build-handling build-routing build-tracking
deploy-all: deploy-booking deploy-handling deploy-routing deploy-tracking
clean-all: clean-booking clean-handling clean-routing clean-tracking

init-db:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./database/pvc.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./database/mysql.yaml  | oc apply -f -

init-booking:
	-oc new-project $(BOOKINGMS)

build-booking:
	-sed -e 's~<CONTAINER>~$(BOOKINGAPI)~g' -e 's~<PROJECT>~$(BOOKINGMS)~g' ./booking/deployment/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(BOOKINGMS)~g' ./booking/deployment/buildconfig.yaml  | oc apply -f -	
	oc start-build booking

deploy-booking:
	-sed -e 's~<PROJECT>~$(BOOKINGMS)~g' ./booking/deploymentconfig.yaml  | oc apply -f -

clean-booking:
	-oc delete all -l app=$(BOOKINGMS)

init-handling:
	-oc new-project handling

deploy-handling:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/handling.yaml  | oc apply -f -

clean-handling:
	-oc delete all -l app=handling

init-routing:
	-oc new-project routing

deploy-routing:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/routing.yaml  | oc apply -f -

clean-routing:
	-oc delete all -l app=routing

init-tracking:
	-oc new-project tracking

deploy-tracking:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/tracking.yaml  | oc apply -f -

clean-tracking:
	-oc delete all -l app=tracking
