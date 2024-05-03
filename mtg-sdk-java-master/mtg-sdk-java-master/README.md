Magic: The Gathering Java SDK 
===========

[![Build Status](https://travis-ci.org/MagicTheGathering/mtg-sdk-java.svg?branch=master)](https://travis-ci.org/MagicTheGathering/mtg-sdk-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.magicthegathering/javasdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.magicthegathering/javasdk)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9bb4a9c574ad44138d41168ff7095633)](https://www.codacy.com/app/nyholmniklas/mtg-sdk-java?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MagicTheGathering/mtg-sdk-java&amp;utm_campaign=Badge_Grade)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/MagicTheGathering/mtg-sdk-java/blob/master/LICENSE)
[![mtg-developers on discord](https://img.shields.io/badge/discord-mtg%20developers-738bd7.svg)](https://discord.gg/qwGJNnP)

Java SDK for using the [magicthegathering.io](http://magicthegathering.io) APIs.

Note that API use is free and does not require authentication or registration, but some rate limits apply. Read the official API website for more information.

Add the dependency to your project and you're good to go! If you are on Android make sure you call on a seperate thread than the main.

Prerequisites
-------
- Java JDK 7 or higher

Integration
-------

#### Maven
```xml
<dependency>
    <groupId>io.magicthegathering</groupId>
    <artifactId>javasdk</artifactId>
    <version>0.0.18</version>
</dependency>
```
#### Gradle
```gradle
implementation 'io.magicthegathering:javasdk:0.0.18'
```

#### Ivy
```xml
<dependency org="io.magicthegathering" name="javasdk" rev="0.0.18"/>
```

Usage examples
-------

#### Get a Card
```java
int multiverseId = 1;
Card card = CardAPI.getCard(multiverseId);
```

#### Get all Cards
```java
List<Card> cards = CardAPI.getAllCards();
```

#### Get a Set
```java
String setCode = "KLD";
MtgSet set = SetAPI.getSet(setCode);
```

#### Get all Sets
This does **not** populate the card lists by default. This is to improve perfomance if all you need is a set list.
Filter also does not currently load set lists. Will be adding in a future release.
```java
List<MtgSet> sets = SetAPI.getAllSets();
```

#### Get all Sets with card lists loaded.
```java
List<MtgSet> sets = SetAPI.getAllSetsWithCards();
```

#### Generate a Booster
```java
String setCode = "KLD";
List<Card> booster = SetAPI.getBooster(setCode);
```
#### Change the connection timeout values that are used by the OkHttpClient
```java
MTGAPI.setConnectTimeout(60);
MTGAPI.setReadTimeout(60);
MTGAPI.setWriteTimeout(60);
```
License
-------
This project is licensed under [MIT license](http://opensource.org/licenses/MIT).
