# Cloud Pak for Applications
## Frequently asked questions

### Project in terminating state and not going away.
- This happens because usually some objects are left over and not getting deleted. This happens
when knative/istio which are part of cp4a are installed.

- Get script [delete-ns.sh](../scripts/delete-ns.sh)
- Give execute privileges to the script (chmod +x delete-ns.sh)
- Execute script to delete the project (./delete-ns.sh <project-name>)

### Delete all crd's under a namespace
- Get script [delete-crd.sh](../scripts/delete-crd.sh)
- Give execute privileges to the script (chmod +x delete-crd.sh)
- Execute script to delete the project (./delete-crd.sh <project-name>)

### Set up access to ibm registry for installing CP4A using an entitlement key
export ENTITLED_REGISTRY=cp.icr.io
export ENTITLED_REGISTRY_USER=ekey
export ENTITLED_REGISTRY_KEY=xxx

docker login "$ENTITLED_REGISTRY" -u "$ENTITLED_REGISTRY_USER" -p "$ENTITLED_REGISTRY_KEY"