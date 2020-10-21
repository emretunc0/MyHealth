This project performs the following items.

1. Garmin connect User Authorization ( 3-leg oauth process)
2. Ping Service.
3. Push Service.


It is using H2 in memory database and all the key and secret values are configured in the properties file. 
Before starting this project, please proceed  with the following.

1. specify partner consumer key and secret in .properties file. 

Ex: oauth.consumerkey = 3b936cf6-0f4e-40a2-b151-64dc8535e252
	oauth.consumerSecret =NKlPcGvag4M5tiXP6d8gM6JEate0dEgiIrh
	
2. Optionally, specify default users useraccesstoken and secret values in .properties file. 
	
Ex: partner.users[0].user-name=user1
	partner.users[0].user-access-token=a2ea4ce9-9968-422f-ab38-11773bf82c24
	partner.users[0].user-access-secret= ohbRG0MVTOCCLAXB0e4akr9qsMvmMAF6QHh	
	
	
	
