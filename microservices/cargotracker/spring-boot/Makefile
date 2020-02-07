init-all: init-booking init-handling init-routing init-tracking
deploy-all: deploy-booking deploy-handling deploy-routing deploy-tracking
clean-all: clean-booking clean-handling clean-routing clean-tracking

init-booking:
	-oc new-project booking

deploy-booking:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/booking.yaml  | oc apply -f -

clean-booking:
	-oc delete all -l app=booking

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
