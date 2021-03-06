package cn.akira.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class ResponseData implements Serializable {
    private String message = null;
    private boolean flag = true;
    private String errInfo = null;
    private String errDetail = null;
    private Object resource = null;
    private Integer status = 0;
    private Object customProp;
    private Exception exceptionInfo;
    private StackTraceElement[] errTrace;
    public ResponseData() {}

    public ResponseData(String message) {
        this.message = message;
    }

    public ResponseData(String message, boolean flag) {
        this.message = message;
        this.flag = flag;
    }

    public ResponseData(String message, boolean flag, Exception e) {
        this.message = message;
        this.flag = flag;
        this.errInfo = e.getLocalizedMessage();
        this.errDetail = Arrays.toString(e.getStackTrace());
    }

    public ResponseData(String message, Exception e) {
        this.flag = false;
        this.message = message;
        this.errInfo=e.getLocalizedMessage();
        this.errDetail=Arrays.toString(e.getStackTrace());
    }

    public ResponseData(String message, Object resource, boolean flag) {
        this.message = message;
        this.flag = flag;
        this.resource = resource;
    }

    public ResponseData(Object resource, boolean flag) {
        this.flag = flag;
        this.resource = resource;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getErrInfo() {
        return errInfo;
    }

    public void setErrInfo(String errInfo) {
        this.errInfo = errInfo;
    }

    public String getErrDetail() {
        return errDetail;
    }

    public void setErrDetail(String errDetail) {
        this.errDetail = errDetail;
    }

    public Object getResource() {
        return resource;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getCustomProp() {
        return customProp;
    }

    public void setCustomProp(Object customProp) {
        this.customProp = customProp;
    }

    public Exception getExceptionInfo() {
        return exceptionInfo;
    }

    public StackTraceElement[] getErrTrace() {
        return errTrace;
    }

    public void setExceptionInfo(Exception e) {
        this.exceptionInfo = e;
        this.setMessage(e.getMessage());
        this.setFlag(false);
        this.setErrDetail(Arrays.toString(e.getStackTrace()));
        this.errTrace = e.getStackTrace();
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "message='" + message + '\'' +
                ", flag=" + flag +
                ", errInfo='" + errInfo + '\'' +
                ", errDetail='" + errDetail + '\'' +
                ", resource=" + resource +
                '}';
    }
}