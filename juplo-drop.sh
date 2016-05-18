#!/bin/bash
mvn compile
mvn de.juplo:hibernate-maven-plugin:drop -P schema
