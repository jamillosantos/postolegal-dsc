#!/bin/bash
mvn compile
mvn de.juplo:hibernate-maven-plugin:create -P schema
