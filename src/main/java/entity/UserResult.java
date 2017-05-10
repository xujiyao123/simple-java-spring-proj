package entity;

/**
 * Created by xujiyao on 2017/4/26.
 * springdemo
 * entity
 */
public class UserResult {

    private String statusCode;
    private Object result;


    public UserResult() {
    }


    public UserResult(String statusCode, Object result) {
        this.statusCode = statusCode;
        this.result = result;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
