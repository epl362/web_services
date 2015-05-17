package ws362;


import ws362.DatabaseStub.SayHello;


public class Client {
	
 public static void main(String[] args) throws Exception {
     DatabaseStub stub = new DatabaseStub();
     
     //Creating the request
     DatabaseStub.SayHello  request = new  DatabaseStub.SayHello();
     request.setStr("Java web");
    
    
     //Invoking the service
     DatabaseStub.SayHelloResponse response  = stub.sayHello(request);
     System.out.println("Response : " + response.get_return());
    }
}