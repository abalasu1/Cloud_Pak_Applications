PROJECT=cargotracker-monolith
DOCKERREPOSITORY=docker-registry.default.svc:5000

GITHUBREPO=https://github.com/abalasu1/Cloud_Pak_Applications.git

init:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/service.yaml  | oc apply -f -

deploy:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./deployment/deployment.yaml  | oc apply -f -

clean:
	-oc delete all -l app=cargotracker-monolith
