#!/bin/bash

NS=$1
for api in `kubectl get crd -o name 2> /dev/null`; 
        do echo ====$api====; 
        kubectl get $api -n NS;
        kubectl delete $api -n NS; 
done