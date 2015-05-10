
/**
 * DiagnosisCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package DiagnosisCL;

    /**
     *  DiagnosisCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DiagnosisCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DiagnosisCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DiagnosisCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getConditionDiagnosis method
            * override this method for handling normal response from getConditionDiagnosis operation
            */
           public void receiveResultgetConditionDiagnosis(
                    DiagnosisCL.DiagnosisStub.GetConditionDiagnosisResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getConditionDiagnosis operation
           */
            public void receiveErrorgetConditionDiagnosis(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getConditionID method
            * override this method for handling normal response from getConditionID operation
            */
           public void receiveResultgetConditionID(
                    DiagnosisCL.DiagnosisStub.GetConditionIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getConditionID operation
           */
            public void receiveErrorgetConditionID(java.lang.Exception e) {
            }
                


    }
    