#!/bin/sh

mv /install/consul/consul /usr/bin/
mv /install/consul /etc/service/
mkdir /consul
mkdir /consul-data
rm -r /install
