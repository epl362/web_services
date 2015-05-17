
/**
 * LoginExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package LoginCL;

public class LoginExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1431891982179L;
    
    private LoginCL.LoginStub.LoginException faultMessage;

    
        public LoginExceptionException() {
            super("LoginExceptionException");
        }

        public LoginExceptionException(java.lang.String s) {
           super(s);
        }

        public LoginExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public LoginExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(LoginCL.LoginStub.LoginException msg){
       faultMessage = msg;
    }
    
    public LoginCL.LoginStub.LoginException getFaultMessage(){
       return faultMessage;
    }
}
    