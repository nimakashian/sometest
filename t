In all calls, if any error happens, we return back this response:
			{
			   "result": "FAILED",
			   "error": <error-message>
			}
Everywhere we use 'pattern', it means it's a REGEXP.

Accounts:
---------
	* Get account info
		method: GET
		URL: http://<host>:<port>/account/<id>
		RESPONSE:
			{
				"account": {
					"credit": 8226014,
					"id": 129,
					"name": "saman",
					"status": true,
					"unlimited": true
				},
				"result": "OK"
			}

	* Get account info by name
		method: GET
		URL: http://<host>:<port>/account/byName/<name>
		RESPONSE:
			{
				"account": {
					"credit": 8226014,
					"id": 129,
					"name": "saman",
					"status": true,
					"unlimited": true
				},
				"result": "OK"
			}

	* Get all accounts
		method: GET
		URL:
		    http://<host>:<port>/account/all
			Or
		    http://<host>:<port>/account/all/<pattern>

		RESPONSE:
			{
				"accounts": [
				    {
					    "credit": 8226014,
					    "id": 129,
					    "name": "saman",
					    "status": true,
					    "unlimited": true
				    },
					...
                ]
				"result": "OK"
			}

	* Add an account
		method: PUT
		URL: http://<host>:<port>/account
		BODY:
		     {
		       "name": <account-name>, // mandatory
		       "password": <password>, // mandatory
		       "unlimited": true|false, // optional, default: false
		       "customerGroup": <group-name>, // optional, default: 'adpgroup'
		       "credit": <credit-level>, // optional, default: 0
		     }
		RESPONSE:
			{
				"account": {
					"credit": 10000,
					"id": 4747,
					"name": "mars",
					"status": false,
					"unlimited": false
				},
				"result": "OK"
			}

	* Update an account:
		method: POST
		URL: http://<host>:<port>/queue
		BODY:
			 {
			   "name": <account-name>, // mandatory
			   "status": true|false, // would be updated if present
			   "credit": <credit-level>, // would be updated if present
			   "unlimited": true|false, // would be updated if present
			 }

		RESPONSE:
			{
				"account": {
					"credit": 10000,
					"id": 4747,
					"name": "mars",
					"status": false,
					"unlimited": false
				},
				"result": "OK"
			}

Queues:
--------

	* Get account queues
		method: GET
		URL: http://<host>:<port>/queue/byAccountId/<accountId>
		RESPONSE:
			{
			   "result": "OK",
			   "queues": [
				   {
					   "accountId": 943,
					   "accountName": "websrv",
					   "number": "982000400940",
					   "queueId": 918,
					   "queueName": "websrv"
				   },
				   ...
			}

	* Get account queues
		method: GET
		URL: http://<host>:<port>/queue/byAccountName/<account-name>
		RESPONSE:
			{
			   "result": "OK",
			   "queues": [
				   {
					   "accountId": 943,
					   "accountName": "websrv",
					   "number": "982000400940",
					   "queueId": 918,
					   "queueName": "websrv"
				   },
				   ...
			}

	* Get queue by name
		method: GET
		URL: http://<host>:<port>/queue/<queueName>
		RESPONSE:
			{
				"queue": {
					"blocking": true,
					"boundClient": "",
					"ownerId": 943,
					"queueId": 918,
					"queueName": "websrv",
					"retryTime": 0
				},
				"result": "OK"
			}

			if not found:
			{
				"queue": {},
				"result": "OK"
			}

	* Add a queue:
		method: PUT
		URL: http://<host>:<port>/queue
		BODY:
		     {
		       "owner": <owner_id>
		       "queue": <queue_name>
		     }
		RESPONSE:
			{
			   "result": "OK",
			   "queueId": <queue_id>
			}

			or

			{
			   "result": "FAILED",
			   "error": <error-message>
			}

	* Update a queue:
		method: POST
		URL: http://<host>:<port>/queue
		BODY:
			 {
			   "owner": <new_owner_id>
			   "queue": <queue_name>
			 }
		RESPONSE:
			{
			   "result": "OK"
			}

			or

			{
			   "result": "FAILED",
			   "error": <error-message>
			}

MSISDNs:
--------

	* Add a number:
		method: PUT
		URL: http://<host>:<port>/msisdn
		BODY:
		     {
		       "number": "9820008957",
		       "queue": "hekmat_mb"
		     }
		RESPONSE:
			{
			   "result": "OK"
			}

	* Update a number:
		method: POST
		URL: http://<host>:<port>/msisdn
		BODY:
			 {
			   "number": "9820008957",
			   "queue": "hekmat_mb"
			 }
		RESPONSE:
			{
			   "result": "OK"
			}

	* Delete a number:
		method: DELETE
		URL: http://<host>:<port>/msisdn/<number>
		RESPONSE:
			{
			   "result": "OK"
			}

	* Get a number:
		method: GET
		URL: http://<host>:<port>/msisdn/<number>
		RESPONSE:
			 {
				 "number": {
					 "number": "9820008957",
					 "accountId": 2522,
					 "accountName": "hekmat",
					 "queueId": 2532,
					 "queueName": "hekmat_mb"
				 },
				 "result": "OK"
			 }

	* Get all msisdns:
		method: GET
		URL: http://<host>:<port>/msisdn/all
		RESPONSE:
			 {
				 "numbers": [
					 {
						 "accountId": 1699,
						 "accountName": "simorgh",
						 "number": "98709517",
						 "queueId": 1684,
						 "queueName": "simorgh"
					 },
					 ...
				 ],
				 "result": "OK"
			 }

	* Get all msisdns matching a regexp pattern:
		method: GET
		URL: http://<host>:<port>/msisdn/all/<regexp>
		RESPONSE:
			 {
				 "numbers": [
					 {
						 "accountId": 1699,
						 "accountName": "simorgh",
						 "number": "98709517",
						 "queueId": 1684,
						 "queueName": "simorgh"
					 },
					 ...
				 ],
				 "result": "OK"
			 }

Routing:
--------
	* Reload number-based routes:
		method: GET
		URL: http://<host>:<port>/routing/reload
			Params:
				'MNP': just update MNP database
				'SBR': just update Source-based routing database
				none: update all databases

    * Delete a destination change:
		method: DEL
		URL: http://<host>:<port>/dest/<mobile>
			Params:
				none
			RESPONSE:
				{
				   "result": "OK"
				}

	* Issue a destination change:
		method: POST
		URL: http://<host>:<port>/divert
		BODY:
			 {
			   "dest": "989123048876",
			   "newDest": "989023048876",
			   "dir": <0 (MO), 1 (MT), 2 (MT/MO)>,
			   "mode": <0 (replace), 1 (duplicate), 2 (ignore)>
			 }
		RESPONSE:
			{
			   "result": "OK"
			}

	* Block short number:
    		method: POST
    		URL: http://<host>:<port>/block
    		BODY:
    			 {
    			   "number": "982000123",
    			   "dir": <0 (MO), 1 (MT), 2 (MT/MO)>
    			 }
    		RESPONSE:
    			{
    			   "result": "OK"
    			}

    * Unblock short number:
            method: DELETE
            URL: http://<host>:<port>/block/<number>
            RESPONSE:
                {
                   "result": "OK"
                }
Misc:
-----
	* Get debug:
		method: GET
		URL: http://<host>:<post>/debuginfo

