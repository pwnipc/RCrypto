# RCrypto
Realtime Crypto (RCrypto) is a build a system that saves real-time BTC &amp; ETH prices in Kenya Shilling.

#### Live API <a href="https://rcrypto.herokuapp.com/"> View Here </a>

#### Live Release
Compiled Build   : <a href="https://github.com/Chal13W1zz/RCrypto/releases">Download Here</a>
Run the package using `java -jar RCrypto<version>.jar`

## API Features

1. Users can sync realtime BTC and ETH prices.
2. Users can retrieve BTC and Historical prices from the database.
3. Users can add new BTC and ETH records manually
4. [TO DO] The api has basic authentication.

### Dependencies

    1. [junit-jupiter-api] 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    2. [junit-jupiter-engine] 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
    3. [spark-core] 'com.sparkjava:spark-core:2.9.3'
    4. [slf4j-simple] 'org.slf4j:slf4j-simple:1.7.32'
    5. [gson] 'com.google.code.gson:gson:2.8.9'
    6. [retrofit] 'com.squareup.retrofit2:retrofit:2.9.0' 
    7. [postgresql] group: 'org.postgresql', name: 'postgresql', version: '42.2.2'  
    8. [okhttp] 'com.squareup.okhttp3:okhttp:4.9.3'
    9. [sql2o] 'group: 'org.sql2o', name: 'sql2o', version: '1.5.4'
    10.[converter-gson] 'com.squareup.retrofit2:converter-gson:2.9.0'




## Getting Started <Local Build>

    1. git clone https://github.com/Chal13W1zz/RCrypto.git

    2. cd RCrypto

    3. edit postgresql username and password in App.java 

    4. run psql < create.sql in the project root to create the database

    5. gradle compilejava  / mvn compile to compile the project
     
    6. gradle run to host a local server


## Tests [TO DO]
    1. cd RCrypto
    2. gradle test

## API Endpoints


| EndPoint                                |   Functionality                      |
| --------------------------------------- | ------------------------------------:|
| GET /records/sync                       | sync and save realtime crypto prices |
| GET /records/view                       | View historical prices               |
| POST /records/add                       | Manually add new price records       |



## Request & Response examples
Request curl   `/records/add` 


```curl
curl --location --request POST 'https://rcrypto.herokuapp.com/records/add' \
--header 'Content-Type: application/json' \
--data-raw '    {
        "bitcoin": {
            "usd": 41493
        },
        "ethereum": {
            "usd": 3026.81
        }
    }'
```

Response (application/json)
```curl
{
    "bitcoin": {
        "usd": 41493
    },
    "ethereum": {
        "usd": 3026.81
    },
    "id": 44
}
```

Request curl   `/records/sync`

```curl
curl --location --request GET 'https://rcrypto.herokuapp.com/records/sync' \
--header 'Content-Type: application/json' 
```
Response (application/json)

```curl 
{
"bitcoin": {
"usd": 41493
},
"ethereum": {
"usd": 3026.81
},
"id": 0
}

```

## Limitations

1. The API only responds with JSON
2. TO DO "respond with xml"

## Contribution

1. Fork it! :fork_and_knife:
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git add -A && git commit -m 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request
