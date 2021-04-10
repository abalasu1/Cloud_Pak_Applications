# Earthquake mapping
## Demo to show knative capabilities

### Commands:
- Create new project: oc new-project earthquake-demo

- Pull latest postgres image: docker pull registry.redhat.io/rhscl/postgresql-95-rhel7

- Deploy postgres database on the cluster
  oc new-app \
    -e POSTGRESQL_USER=admin \
    -e POSTGRESQL_PASSWORD=admin \
    -e POSTGRESQL_DATABASE=geocodedb \
    registry.redhat.io/rhscl/postgresql-95-rhel7

- check if pods are created: oc get pods

- Check if postgres is working properly:
  oc rsh <pod>
  PGPASSWORD=$POSTGRESQL_PASSWORD psql -h postgresql-95-rhel7 $POSTGRESQL_DATABASE $POSTGRESQL_USER

## Authors
Arun Balasubramanyan

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
