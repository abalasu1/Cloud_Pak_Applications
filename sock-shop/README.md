# sock-shop microservices samples
## Weaveworks sock-shop samples

### Commands:
oc new-project sock-shop

- Sock shop pods need full access to Kubernetes API
oc adm policy add-cluster-role-to-user cluster-admin -z default

- Give openshift monitoring id access to sock-shop and other namespaces
oc adm policy add-cluster-role-to-user cluster-admin system:serviceaccount:openshift-monitoring:prometheus-k8s

- Socks shop pods also need to run as priviliaged containers, so grant 'privileged' Security Context Constrains (SCC)
oc adm policy add-scc-to-user privileged -z default

- Deploy application in OpenShift using oc tools
oc apply -f complete-demo.yaml

- Set up Service Monitors
oc apply -f servicemonitors.yaml

- Load testing sock-shop
docker run --net=host weaveworksdemos/load-test -h eu-cluster-1.fyre.ibm.com:30001 -r 100 -c 2

- Run the load test in a loop
while sleep 0.1; 
  do 
    docker run --net=host weaveworksdemos/load-test -h eu-cluster-1.fyre.ibm.com:30001 -r 1000 -c 10
    echo ""; 
  done ;

- Prometheus Queries:
Request rate:
sum(rate(request_duration_seconds_count{namespace="sock-shop"} [1m]))  by (endpoint)

Error rate:
sum(rate(request_duration_seconds_count{namespace="sock-shop", status_code!~"2.."} [1m]))  by (endpoint, status_code)

Duration:
histogram_quantile(0.99, sum(rate(request_duration_seconds_bucket{namespace="sock-shop"} [1m]))  by (le))

- Import the grafana dashboards to visualize metrics.
