# BusinessAPI



BusinessAPI is a RESTful API that allows users to register, make orders, send and receive messages, and view their profile.
 It is inteded as the back-bone of a small training business where clients can engage with the trainer (admin) in virtual sessions. 
The application 

uses Spring-boot with Maven and JPA upon a MySQL database.


src/main/java/com/promineotech/BusinessBackEnd/..
----------------------------------------------





\n<b>


entity</b>
--------
Primary entities include the Client (user), Orders, and Messages. Additional entities assist with login and registering new users.



\n<b>controller</b>
----------
Contains all CRUD URI endpoints for Clients, Orders, Login, and Messages.





\n

<b>repository</b>
-------


JPA persists data through the database for each entity. 





\n<b>

service</b>
--------
Provides logic to operate on data sent to the DAO repository.
