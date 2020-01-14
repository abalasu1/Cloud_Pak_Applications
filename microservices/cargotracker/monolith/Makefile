PROJECT=cargotracker-monolith
DOCKERREPOSITORY=docker-registry.default.svc:5000

GITHUBREPO=https://github.com/abalasu1/Cloud_Pak_Applications.git

init:
        -sed -e 's~<PROJECT>~$(PROJECT)~g' ./deploy/service.yaml  | oc apply -f -

build:
        -sed -e 's~<PROJECT>~$(PROJECT)~g' ./deploy/imagestream.yaml  | oc apply -f -
        -sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./deploy/buildconfig.yaml  | oc apply -f -
        oc start-build cargotracker

deploy:
        -sed -e 's~<PROJECT>~$(PROJECT)~g' ./deploy/deploymentconfig.yaml  | oc apply -f -

clean:
        -oc delete all -l app=cargotracker-monolith
