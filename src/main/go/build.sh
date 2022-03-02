#!/bin/sh
GOOS=windows&go build -buildmode=c-shared -o ../resources/esb.dll .
GOOS=linux&go build -buildmode=c-shared -o ../resources/esb.linux.so .
GOOS=MacOS&go build -buildmode=c-shared -o ../resources/esb.mac.so .