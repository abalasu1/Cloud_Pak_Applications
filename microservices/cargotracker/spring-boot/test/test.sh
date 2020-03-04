booking=$(curl -s -X POST http://booking-booking.apps.eu-3.os.fyre.ibm.com/cargobooking -H 'Content-Type: application/json' \
  -d '{
    "bookingAmount": 100,
    "originLocation": "CNHKG",
    "destLocation" : "USNYC",
    "destArrivalDeadline" : "2020-01-28"
}')

bookingId=$(echo `jq -r  .bookingId <<< "${booking}"`)
bookingId=$(echo $bookingId | awk -F '[_-]' '{print $1}')
echo $bookingId 

curl -s -X GET 'http://routing-routing.apps.eu-3.os.fyre.ibm.com/cargorouting/optimalRoute?origin=CNHKG&destination=USNYC&deadline=2020-01-28' | jq
curl -s -X GET 'http://booking-booking.apps.eu-3.os.fyre.ibm.com/cargobooking/findCargo?bookingId='$bookingId'' | jq

routing=$(curl -s -X POST http://booking-booking.apps.eu-3.os.fyre.ibm.com/cargorouting -H 'Content-Type: application/json' \
  -d '{
    "bookingId": "'$bookingId'"
}')
echo $routing

receive=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "CNHKG",
    "handlingType" : "RECEIVE",
    "completionTime": "2019-08-23",
    "voyageNumber" : ""
}')
echo $receive

firstload=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "CNHKG",
    "handlingType" : "LOAD",
    "completionTime": "2019-08-25",
    "voyageNumber" : "0100S"
}')
echo $firstload

firstunload=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "CNHGH",
    "handlingType" : "UNLOAD",
    "completionTime": "2019-08-28",
    "voyageNumber" : "0100S"
}')
echo $firstunload

secondload=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "CNHGH",
    "handlingType" : "LOAD",
    "completionTime": "2019-09-01",
    "voyageNumber" : "0101S"
}')
echo $secondload

secondunload=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "JNTKO",
    "handlingType" : "UNLOAD",
    "completionTime": "2019-09-10",
    "voyageNumber" : "0101S"
}')
echo $secondunload

thirdload=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "JNTKO",
    "handlingType" : "LOAD",
    "completionTime": "2019-09-15",
    "voyageNumber" : "0102S"
}')
echo $thirdload

thirdunload=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "USNYC",
    "handlingType" : "UNLOAD",
    "completionTime": "2019-09-25",
    "voyageNumber" : "0102S"
}')
echo $thirdunload

customs=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "USNYC",
    "handlingType" : "CUSTOMS",
    "completionTime": "2019-09-26",
    "voyageNumber" : ""
}')
echo $customs

claim=$(curl -s -X POST http://handling-handling.apps.eu-3.os.fyre.ibm.com/cargohandling -H 'Content-Type: application/json' -d '{
    "bookingId" : "'$bookingId'",
    "unLocode" : "USNYC",
    "handlingType" : "CLAIM",
    "completionTime": "2019-09-28",
    "voyageNumber" : ""
}')
echo $claim
