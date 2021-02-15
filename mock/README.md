# Mocking the OSDM Interface

## Scenario 1: Basel SBB - Davos Platz

Mocked resources:

- POST `/trip-offers-collection`
- POST `/bookings`
- POST `/bookings/{bookingId}/fulfillments`

The [WireMock](https://wiremock.org) is used to build the Mock which is configured
by [WireMock Mappings](./mappings/sale-core-mappings.json).

Use `./startMock.sh` to run mock.

## Used Ids

- `offerId`:  `Offer_001`
- `admission`: `Admission_Basel-DavosPlatz`
- `reservations`: `Reservation_Basel-Landquart`, `Reservation_Landquart-DavosPlatz`
- `passengerId`: `Passenger_001`
- `fulfillmentId`: `Fulfillment_001`

### Station Information

```json
    "id": 8500010,
    "name": "Basel SBB",
    "coordinates": {
        "latitude": 47.547408,
        "longitude": 7.589548
    },
    "type": "STATION",
    "tariffBorder": false,
    "weight": 27902,
    "vehicleTypes": [
        "TRAMWAY",
        "TRAIN",
        "BUS"
    ]
```

```json
    "id": 8509002,
    "name": "Landquart",
    "coordinates": {
        "latitude": 46.967442,
        "longitude": 9.554032
    },
    "type": "STATION",
    "tariffBorder": false,
    "weight": 24706,
    "vehicleTypes": [
        "METRO",
        "TRAIN",
        "BUS"
    ]
```

```json
    "id": 8509073,
    "name": "Davos Platz",
    "coordinates": {
        "latitude": 46.791469,
        "longitude": 9.820733
    },
    "type": "STATION",
    "tariffBorder": false,
    "weight": 7424,
    "vehicleTypes": [
        "TRAIN",
        "BUS",
        "CABLE"
    ]
```

## Trip Information

```json
 "tripId": "ogvwSQoCV",
    "alternative": false,
    "valid": true,
    "segments": [
        {
            "type": "PUBLIC_JOURNEY",
            "stops": [
                {
                    "id": {
                        "value": "8500010",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Basel SBB",
                    "departureDateTime": "2021-03-22T13:06:00+01:00",
                    "departureDelayText": "",
                    "departureTrack": "5",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 13,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8503000",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Zürich HB",
                    "departureDateTime": "2021-03-22T14:07:00+01:00",
                    "departureDelayText": "",
                    "arrivalDateTime": "2021-03-22T14:00:00+01:00",
                    "arrivalDelayText": "",
                    "departureTrack": "10",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalTrack": "10",
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 15,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509411",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Sargans",
                    "departureDateTime": "2021-03-22T15:04:00+01:00",
                    "departureDelayText": "",
                    "arrivalDateTime": "2021-03-22T15:03:00+01:00",
                    "arrivalDelayText": "",
                    "departureTrack": "3",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalTrack": "3",
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 17,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509002",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Landquart",
                    "arrivalDateTime": "2021-03-22T15:12:00+01:00",
                    "arrivalDelayText": "",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalTrack": "2",
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 18,
                    "tariffBorder": false
                }
            ],
            "transportProduct": {
                "name": "ICE 71",
                "categoryShortForm": "ICE",
                "categoryLongForm": "InterCityExpress",
                "line": null,
                "number": "71",
                "vehicleType": "TRAIN"
            },
            "attributes": [
                {
                    "key": "OM",
                    "value": "Masks mandatory for travellers aged 12 and over"
                },
                {
                    "key": "WR",
                    "value": "Restaurant"
                },
                {
                    "key": "VR",
                    "value": "BICYCLES: Reservation required"
                },
                {
                    "key": "R ",
                    "value": "Reservation possible"
                }
            ],
            "messages": [],
            "direction": "Chur",
            "journeyStatus": "PLANNED",
            "cancelled": false,
            "partiallyCancelled": false,
            "reachable": true,
            "redirected": false
        },
        {
            "type": "PUBLIC_JOURNEY",
            "stops": [
                {
                    "id": {
                        "value": "8509002",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Landquart",
                    "departureDateTime": "2021-03-22T15:20:00+01:00",
                    "departureDelayText": "",
                    "departureTrack": "5",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 0,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509060",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Schiers",
                    "departureDateTime": "2021-03-22T15:33:00+01:00",
                    "departureDelayText": "",
                    "arrivalDateTime": "2021-03-22T15:31:00+01:00",
                    "arrivalDelayText": "",
                    "departureTrack": "3",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalTrack": "3",
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 1,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509064",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Küblis",
                    "departureDateTime": "2021-03-22T15:44:00+01:00",
                    "departureDelayText": "",
                    "arrivalDateTime": "2021-03-22T15:43:00+01:00",
                    "arrivalDelayText": "",
                    "departureTrack": "1",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalTrack": "1",
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 2,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509068",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Klosters Platz",
                    "arrivalDateTime": "2021-03-22T15:59:00+01:00",
                    "arrivalDelayText": "",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalTrack": "1",
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 3,
                    "tariffBorder": false
                }
            ],
            "transportProduct": {
                "name": "RE 1351",
                "categoryShortForm": "RE",
                "categoryLongForm": "RegioExpress",
                "line": null,
                "number": "1351",
                "vehicleType": "TRAIN"
            },
            "attributes": [
                {
                    "key": "OM",
                    "value": "Masks mandatory for travellers aged 12 and over"
                }
            ],
            "messages": [],
            "direction": "St. Moritz",
            "journeyStatus": "PLANNED",
            "cancelled": false,
            "partiallyCancelled": false,
            "reachable": true,
            "redirected": false
        },
        {
            "type": "PUBLIC_JOURNEY",
            "stops": [
                {
                    "id": {
                        "value": "8509068",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Klosters Platz",
                    "departureDateTime": "2021-03-22T16:02:00+01:00",
                    "departureDelayText": "",
                    "departureTrack": "3",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 0,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509069",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Cavadürli",
                    "departureDateTime": "2021-03-22T16:08:00+01:00",
                    "departureDelayText": "",
                    "arrivalDateTime": "2021-03-22T16:08:00+01:00",
                    "arrivalDelayText": "",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": true,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 1,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509070",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Davos Laret",
                    "departureDateTime": "2021-03-22T16:16:00+01:00",
                    "departureDelayText": "",
                    "arrivalDateTime": "2021-03-22T16:15:00+01:00",
                    "arrivalDelayText": "",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": true,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 2,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509071",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Davos Wolfgang",
                    "departureDateTime": "2021-03-22T16:21:00+01:00",
                    "departureDelayText": "",
                    "arrivalDateTime": "2021-03-22T16:20:00+01:00",
                    "arrivalDelayText": "",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": true,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 3,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509072",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Davos Dorf",
                    "departureDateTime": "2021-03-22T16:29:00+01:00",
                    "departureDelayText": "",
                    "arrivalDateTime": "2021-03-22T16:27:00+01:00",
                    "arrivalDelayText": "",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 4,
                    "tariffBorder": false
                },
                {
                    "id": {
                        "value": "8509073",
                        "type": "UIC",
                        "externalId": null
                    },
                    "name": "Davos Platz",
                    "arrivalDateTime": "2021-03-22T16:33:00+01:00",
                    "arrivalDelayText": "",
                    "departurePlatformChanged": false,
                    "delayUndefined": false,
                    "arrivalTrack": "2",
                    "arrivalPlatformChanged": false,
                    "stopStatus": "PLANNED",
                    "requestStop": false,
                    "boardingAlightingStatus": "BOARDING_ALIGHTING",
                    "routeIndex": 5,
                    "tariffBorder": false
                }
            ],
            "transportProduct": {
                "name": "R 1051",
                "categoryShortForm": "R",
                "categoryLongForm": "Regio",
                "line": null,
                "number": "1051",
                "vehicleType": "TRAIN"
            },
            "attributes": [
                {
                    "key": "X ",
                    "value": "Stop on request"
                },
                {
                    "key": "X ",
                    "value": "Stop on request"
                },
                {
                    "key": "X ",
                    "value": "Stop on request"
                },
                {
                    "key": "OM",
                    "value": "Masks mandatory for travellers aged 12 and over"
                }
            ],
            "messages": [],
            "direction": "Davos Platz",
            "journeyStatus": "PLANNED",
            "cancelled": false,
            "partiallyCancelled": false,
            "reachable": true,
            "redirected": false
        }
    ]
```