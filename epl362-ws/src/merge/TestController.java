package merge;

import merge.TestStub.TestQueryResponse;

//package org.webapp.ws;
//import org.webapp.ws.HelloStub.SayHello;
 
public class TestController {
	
	
	
 public static void main(String[] args) throws Exception { 
     TestStub stub  = new TestStub();

     //Creating the request
     TestStub.TestQuery request = new TestStub.TestQuery();
     request.setName("a");
     request.setSurname("");
     request.setID("944444");
    
     //Invoking the service
     TestQueryResponse response = stub.testQuery(request);
     
     System.out.println("Output : " + response.get_return());
    }
}