This project is a proof of concept. 

We have:

* distributed system
* polyglot programming approach

We want:

* continious delivery pipeline
* service discovery and coordination
* multiple environments: dev, qa, production

### A single server setup _aka DEV or QA env_

__Prepare__

Install Docker && Docker Compose && Docker Machine - https://docs.docker.com/installation/

__Run__

As simple as:

	docker-compose up
_(it takes some time when you do that first time. Don't worry, next time - it's a matter of seconds)_

__Rebuild images__ _(after some changes in source code or files)_
	
	docker-compose build
	
__Start & Stop & Restart all containers__

	docker-compose start
	docker-compose stop
	docker-compose restart

### Continious Delivery Pipeline
TBD


### Cluster setup

#### Service discovery
TBD

#### Configuration management
TBD

#### Monitoring & failover
TBD
