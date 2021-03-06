PROJECT=calculator
DOCKERREPOSITORY=docker-registry.default.svc:5000

SUBDOMAIN=apps.gsitest.cp.fyre.ibm.com

BASICOPADD=$(DOCKERREPOSITORY)/$(PROJECT)/add
BASICOPSUB=$(DOCKERREPOSITORY)/$(PROJECT)/subtract
BASICOPMUL=$(DOCKERREPOSITORY)/$(PROJECT)/multiply
BASICOPDIV=$(DOCKERREPOSITORY)/$(PROJECT)/divide
COMPOSITEOP=$(DOCKERREPOSITORY)/$(PROJECT)/compositeop
PROCESSOR=$(DOCKERREPOSITORY)/$(PROJECT)/processor
UI=$(DOCKERREPOSITORY)/$(PROJECT)/ui

GITHUBREPO=https://github.com/abalasu1/Cloud_Pak_Applications.git

FORTIO_POD=$(shell kubectl get pod -n $(PROJECT) -l app=fortio -o jsonpath='{.items[0].metadata.name}')
DEBUG_POD=$(shell kubectl get pod -n $(PROJECT) -l app=curl -o jsonpath='{.items[0].metadata.name}')

init:
	-bash -c 'oc new-project $(PROJECT)'

clean:
	-bash -c 'oc delete project $(PROJECT)'

init-add:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/add/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~add.$(SUBDOMAIN)~g' ./basicop/add/route.yaml  | oc apply -f -

build-add:
	-sed -e 's~<CONTAINER>~$(BASICOPADD)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/add/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/add/buildconfig.yaml  | oc apply -f -	
	oc start-build add

deploy-add:
	-sed -e 's~<CONTAINER>~$(BASICOPADD)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/add/deploymentconfig.yaml  | oc apply -f -

clean-add:
	-oc delete all -l app=add

test-add:
	-bash -c 'basicop/add/test.sh add.$(SUBDOMAIN)'

init-subtract:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/subtract/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~subtract.$(SUBDOMAIN)~g' ./basicop/subtract/route.yaml  | oc apply -f -	

build-subtract:
	-sed -e 's~<CONTAINER>~$(BASICOPSUB)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/subtract/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/subtract/buildconfig.yaml  | oc apply -f -	
	oc start-build subtract
	
deploy-subtract:
	-sed -e 's~<CONTAINER>~$(BASICOPSUB)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/subtract/deploymentconfig.yaml  | oc apply -f -

clean-subtract:
	-oc delete all -l app=subtract

test-subtract:
	-bash -c 'basicop/subtract/test.sh subtract.$(SUBDOMAIN)'	

init-multiply:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/multiply/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~multiply.$(SUBDOMAIN)~g' ./basicop/multiply/route.yaml  | oc apply -f -	

build-multiply:
	-sed -e 's~<CONTAINER>~$(BASICOPMUL)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/multiply/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/multiply/buildconfig.yaml  | oc apply -f -	
	oc start-build multiply
	
deploy-multiply:
	-sed -e 's~<CONTAINER>~$(BASICOPMUL)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/multiply/deploymentconfig.yaml  | oc apply -f -

clean-multiply:
	-oc delete all -l app=multiply

test-multiply:
	-bash -c 'basicop/multiply/test.sh multiply.$(SUBDOMAIN)'	

init-divide:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/divide/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~divide.$(SUBDOMAIN)~g' ./basicop/divide/route.yaml  | oc apply -f -	

build-divide:
	-sed -e 's~<CONTAINER>~$(BASICOPDIV)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/divide/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/divide/buildconfig.yaml  | oc apply -f -	
	oc start-build divide
	
deploy-divide:
	-sed -e 's~<CONTAINER>~$(BASICOPDIV)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./basicop/divide/deploymentconfig.yaml  | oc apply -f -

clean-divide:
	-oc delete all -l app=divide

test-divide:
	-bash -c 'basicop/divide/test.sh divide.$(SUBDOMAIN)'	

init-compositeop:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./compositeop/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~compositeop.$(SUBDOMAIN)~g' ./compositeop/route.yaml  | oc apply -f -	

build-compositeop:
	-sed -e 's~<CONTAINER>~$(COMPOSITEOP)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./compositeop/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./compositeop/buildconfig.yaml  | oc apply -f -	
	oc start-build compositeop

deploy-compositeop:
	-sed -e 's~<CONTAINER>~$(COMPOSITEOP)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./compositeop/deploymentconfig.yaml  | oc apply -f -

clean-compositeop:
	-oc delete all -l app=compositeop

test-compositeop:
	-bash -c 'compositeop/test.sh compositeop.$(SUBDOMAIN)'	

init-processor:
	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./processor/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g'  -e 's~<DOMAIN>~processor.$(SUBDOMAIN)~g' ./processor/route.yaml  | oc apply -f -	

build-processor:
	-sed -e 's~<CONTAINER>~$(PROCESSOR)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./processor/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./processor/buildconfig.yaml  | oc apply -f -	
	oc start-build processor

deploy-processor:
	-sed -e 's~<CONTAINER>~$(PROCESSOR)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./processor/deploymentconfig.yaml  | oc apply -f -

clean-processor:
	-oc delete all -l app=processor

test-processor:
	-bash -c 'processor/test.sh processor.$(SUBDOMAIN)'	

init-ui:
	-bash -c 'oc create serviceaccount ui-sa -n $(PROJECT) --as system:admin'
	-bash -c 'oc adm policy add-scc-to-user anyuid -z ui-sa -n $(PROJECT) --as system:admin'
	-sed -e 's~<PROXY>~processor.$(SUBDOMAIN)~g' ./ui/src/environments/environment.ts.template > ./ui/src/environments/environment.ts
	-sed -e 's~<PROXY>~processor.$(SUBDOMAIN)~g' ./ui/src/environments/environment.prod.ts.template > ./ui/src/environments/environment.prod.ts	

	-sed -e 's~<PROJECT>~$(PROJECT)~g' ./ui/service.yaml  | oc apply -f -
	-sed -e 's~<PROJECT>~$(PROJECT)~g' -e 's~<DOMAIN>~ui.$(SUBDOMAIN)~g' ./ui/route.yaml  | oc apply -f -	

build-ui:
	-sed -e 's~<CONTAINER>~$(UI)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./ui/imagestream.yaml  | oc apply -f -
	-sed -e 's~<GITHUBREPO>~$(GITHUBREPO)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./ui/buildconfig.yaml  | oc apply -f -	
	oc start-build ui
	
deploy-ui:
	-sed -e 's~<CONTAINER>~$(UI)~g' -e 's~<PROJECT>~$(PROJECT)~g' ./ui/deploymentconfig.yaml  | oc apply -f -
	
clean-ui:
	-oc delete sa ui-sa
	-oc delete all -l app=ui

init-all: init init-add init-subtract init-multiply init-divide init-compositeop init-processor init-ui
build-all: build-add build-subtract build-multiply build-divide build-compositeop build-processor build-ui
push-all: push-add push-subtract push-multiply push-divide push-compositeop push-processor push-ui
deploy-all: deploy-add deploy-subtract deploy-multiply deploy-divide deploy-compositeop	deploy-processor deploy-ui
clean-all: clean-add clean-subtract clean-multiply clean-divide clean-compositeop clean-processor clean-ui clean
test-all: test-add test-subtract test-multiply test-divide test-compositeop test-processor

UI_POD_NAME=$(shell kubectl -n $(PROJECT) get pod -l app=ui -o jsonpath='{.items[0].metadata.name}') 

uiaccess:
	$(shell kubectl -n $(PROJECT) port-forward $(UI_POD_NAME) 9080:80)
	
restart-all:
	kubectl delete pods --all -n $(PROJECT)
