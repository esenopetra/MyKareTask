# MyKareTask
Internship Task <br />
Added Data initalizer to load data automatically in DB [H2 database] <br />

<b>For registration: [POST]</b> <br />

Input: <br />
 >{ <br />
        "name" : "Abhinav Selvarajan", <br />
        "email": "abhinavselvarajan@gamil.com", <br />
        "password":"1234",<br />
        "gender" : "M" <br />
    } <br />
    
  Path : http://localhost:8080/mykare/register <br /> 

<b>To view the users: [GET]</b> <br /> 

  Path: http://localhost:8080/mykare/userview <br />

  <b>To Login: [POST] </b><br />
  
  Input: <br />
  >{ <br />
        "email": "abhinavselvarajan@gamil.com", <br />
        "password":"1234",<br />
    } <br />

  Path: http://localhost:8080/mykare/login <br />

  To Delete User : [DELETE]<br />
  Input:  <br />
  >{ <br />
  "email": "abhinavselvarajan@gamil.com", <br />
  } <br />
  
  Path: http://localhost:8080/mykare/delete <br />
  
