
/**
 * PatientCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package PatientCL;

    /**
     *  PatientCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PatientCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PatientCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PatientCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getName method
            * override this method for handling normal response from getName operation
            */
           public void receiveResultgetName(
                    PatientCL.PatientStub.GetNameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getName operation
           */
            public void receiveErrorgetName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllergies method
            * override this method for handling normal response from getAllergies operation
            */
           public void receiveResultgetAllergies(
                    PatientCL.PatientStub.GetAllergiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllergies operation
           */
            public void receiveErrorgetAllergies(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getReason method
            * override this method for handling normal response from getReason operation
            */
           public void receiveResultgetReason(
                    PatientCL.PatientStub.GetReasonResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getReason operation
           */
            public void receiveErrorgetReason(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDead method
            * override this method for handling normal response from getDead operation
            */
           public void receiveResultgetDead(
                    PatientCL.PatientStub.GetDeadResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDead operation
           */
            public void receiveErrorgetDead(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTreatment method
            * override this method for handling normal response from getTreatment operation
            */
           public void receiveResultgetTreatment(
                    PatientCL.PatientStub.GetTreatmentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTreatment operation
           */
            public void receiveErrorgetTreatment(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getDetails method
            * override this method for handling normal response from getDetails operation
            */
           public void receiveResultgetDetails(
                    PatientCL.PatientStub.GetDetailsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDetails operation
           */
            public void receiveErrorgetDetails(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getIsHarmful method
            * override this method for handling normal response from getIsHarmful operation
            */
           public void receiveResultgetIsHarmful(
                    PatientCL.PatientStub.GetIsHarmfulResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getIsHarmful operation
           */
            public void receiveErrorgetIsHarmful(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getStatus method
            * override this method for handling normal response from getStatus operation
            */
           public void receiveResultgetStatus(
                    PatientCL.PatientStub.GetStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getStatus operation
           */
            public void receiveErrorgetStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getComments method
            * override this method for handling normal response from getComments operation
            */
           public void receiveResultgetComments(
                    PatientCL.PatientStub.GetCommentsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getComments operation
           */
            public void receiveErrorgetComments(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSurname method
            * override this method for handling normal response from getSurname operation
            */
           public void receiveResultgetSurname(
                    PatientCL.PatientStub.GetSurnameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSurname operation
           */
            public void receiveErrorgetSurname(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDiagnosis method
            * override this method for handling normal response from getDiagnosis operation
            */
           public void receiveResultgetDiagnosis(
                    PatientCL.PatientStub.GetDiagnosisResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDiagnosis operation
           */
            public void receiveErrorgetDiagnosis(java.lang.Exception e) {
            }
                


    }
    