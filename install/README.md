# Configuration files with CP4A
## As of version 3.0.1.0

### How to use these files:
a) Change the configuration you need to customize such as:
- Change subdomain to be used by CP4A routes
- If TA is needed, add PV/storageClassName

### Standard:
Standard configuration files with minimal istio

### istio-full:
Standard configuration files with full istio

Post-Install:
- oc adm policy add-cluster-role-to-user cluster-admin -z istiocoredns-service-account -n istio-system
- oc adm pod-network make-projects-global kappnav istio-system kube-system

## As of version 4.0.0.0

### istio-full:
Standard configuration files with full istio 