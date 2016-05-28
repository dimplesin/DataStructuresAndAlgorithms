package com.merchant.guide.to.galaxy.exception;

/**
 * Created by v-dsindhi on 5/10/15.
 */
public class InvalidQueryExceptionHandler  extends Exception {

    private static final long serialVersionUID = -4357624213287685810L;

    //Setting default value of Error Message.
    private String errMsg = "I have no idea what you are talking about";

    public InvalidQueryExceptionHandler() {
        super();
    }

    public InvalidQueryExceptionHandler(String errMessage) {
        this.errMsg = errMessage;
    }

    public InvalidQueryExceptionHandler(String errMessage, Exception e) {
        super("[" + errMessage + "]", e);
        this.errMsg = errMessage;
    }

    public InvalidQueryExceptionHandler( String errMessage, Throwable e) {
        super("[" + errMessage + "]", e);
        this.errMsg = errMessage;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }


}
