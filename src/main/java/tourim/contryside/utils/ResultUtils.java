package tourim.contryside.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

/*
* 固定请求响应格式
* */
@Data
@Component
public class ResultUtils<T> {
    private int status;
    private String message;
    private String errorMsg;
    private T data;
    private long timestamp ;

    public ResultUtils(){
        this.timestamp = System.currentTimeMillis();
    }
    public static <T> ResultUtils<T> success(T data) {
        if(data == null){
            return ResultUtils.fail(500,"No data found");
        }
        ResultUtils<T> resultData = new ResultUtils<T>();
        resultData.setStatus(200);
        resultData.setMessage("Operation is successful");
        resultData.setData(data);
        return resultData;
    }
    public static <T> ResultUtils<T> success(String message) {
        ResultUtils<T> resultData = new ResultUtils<>();
        resultData.setStatus(200);
        resultData.setMessage(message);
        return resultData;
    }
    public static <T> ResultUtils<T> fail(int code, String message) {
        ResultUtils<T> resultData = new ResultUtils<>();
        resultData.setStatus(code);
        resultData.setErrorMsg(message);
        return resultData;
    }
    public static <T> ResultUtils<T> fail(String message) {
        ResultUtils<T> resultData = new ResultUtils<>();
        resultData.setStatus(300);///业务错误
        resultData.setErrorMsg(message);
        return resultData;
    }
    public T ResultData(T data) {
        if(data == null){
            return (T) ResultUtils.fail(500,"No data found");
        }else{
            return data;
        }
    }
    public T ResultData(int code,String errorMsg) {
        return (T) ResultUtils.fail(code,errorMsg);
    }
}
