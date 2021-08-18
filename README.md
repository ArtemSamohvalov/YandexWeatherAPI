# Installation:

## Required software:

- Java 8
- Maven 
- IDE
- okhttp
- gson
- testng

## About tests

There are several tests here to get information about the weather in different cities of the world.
Each test's request contains information about the latitude and longitude of the desired location and some additional parameters
Such as: 
- The combination of language and country that weather information will be returned for.
- The number of days in the forecast, including the current day.
- The hourly weather forecast.
- Extra information about precipitation.

These tests cover only half of the possible parameters: show the current weather situation in different locations using multiple languages.
Pairwise testing technique was used for other request attributes.
However, no additional information related to these values was displayed in the tests. 
This is a kind of groundwork for the future.

In addition to happy-path tests, two negative checks were added: 
- incorrect data for the time parameter (code 400)
- use of values for the coordinates that exceed the allowable (code 404)

