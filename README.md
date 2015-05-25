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
Deployment should follow blue-green technique. While the application is running, we would deploy a new version in parallel with the old one. Container that will be used already passed all sorts of unit and functional tests giving us reasonable confidence that each release is working correctly. However, we still need to test it after deployment in order to make the final verification that what we deployed is working correctly. Once all post-deployment tests passed we are ready to make the new release available to the public. We can do that by changing our nginx reverse proxy to redirect all requests to the newly deployed release. In other words, we should do following.

* Pull the latest version of the application container
* Run the latest application version without stopping the existing one
* Run post-deployment tests
* Notify etcd about the new release (port, name, etc)
* Change nginx configuration to point to the new release
* Stop the old release

If we do all of the above, we should accomplish zero-downtime. At any given moment our application should be available.

### Cluster setup

#### Service discovery
TBD

#### Configuration management
TBD

#### Monitoring & failover
TBD
