# MDP / Forecast Service
A back-end project to show the software team how to have fun with Spring Framework.

##Project Setup

Go to the [Project's Wiki](https://github.com/rastadrian/mdp-forecast-service/wiki#forecast-service) for detailed instructions.

##Service Features

The Forecast Service in this branch **01_simple_forecast_fetch**  (which will also be **master**) provides the following features:

###Get Forecast by State
```
/forecast/{state}
```
This is a public endpoint that, provided a United States' State, will respond with a weather **Forecast** information about it in a `JSON` format. The state has to be provided in accordance to the [ANSI State Code List](https://en.wikipedia.org/wiki/List_of_U.S._state_abbreviations#Table) in a capitalized two-letter code.

##Service Models
###Forecast 
The Forecast entity contains information relevant to the weather for the given State, also a textual description in English.
```JSON
{
    "temperature": 14,
    "scale": "FAHRENHEIT",
    "description": "It's snowy and slippery!",
    "state": "MI"
}
```

