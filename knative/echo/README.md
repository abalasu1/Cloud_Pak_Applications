# K-Native Echo Sample
## Create a simple echo sample to demonstrate K-Native demos

### Commands:
- Create knative service: kn service create echo --image duglin/bp-11-2019-echo
http endpoint works: curl http://echo.knative-samples.cp4a-b2e73aa4eddf9dc566faa4f42ccdd306-0001.us-east.containers.appdomain.cloud

- Change concurrency limit to 0, to demonstrate autoscaling: kn service update echo --concurrency-limit=1
- Generate load to see more instances spawn up: fortio load -c 5 -qps 100 -n 100 http://echo.knative-samples.cp4a-b2e73aa4eddf9dc566faa4f42ccdd306-0001.us-east.containers.appdomain.cloud

- Assign a revision name: kn service update echo --revision-name echo-v1 --concurrency-limit=0
- Specify a Message: kn service update echo --revision-name echo-v2 --env MSG="Dog's Rule"
- http endpoint displays the message: curl http://echo.knative-samples.cp4a-b2e73aa4eddf9dc566faa4f42ccdd306-0001.us-east.containers.appdomain.cloud

- Traffic Splitting: kn service update echo --traffic echo-v1=50,echo-v2=50
- Test traffic Splitting:
while sleep 0.1; 
  do 
    curl "http://echo.knative-samples.cp4a-b2e73aa4eddf9dc566faa4f42ccdd306-0001.us-east.containers.appdomain.cloud"
    echo ""; 
  done ;

- Create a new tagged revision:
kn service update echo --revision-name=echo-v3 --tag echo-v3=r3 --env MSG="TEST TEST TEST"

- Test the dedicated tagged revision:
curl http://echo-r3.knative-samples.cp4a-b2e73aa4eddf9dc566faa4f42ccdd306-0001.us-east.containers.appdomain.cloud

- Traffic will only go to non tagged versions:
while sleep 0.1; 
  do 
    curl "http://echo.knative-samples.cp4a-b2e73aa4eddf9dc566faa4f42ccdd306-0001.us-east.containers.appdomain.cloud"
    echo ""; 
  done ;

## Authors
Arun Balasubramanyan

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
