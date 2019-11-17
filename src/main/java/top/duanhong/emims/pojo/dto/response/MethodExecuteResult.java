package top.duanhong.emims.pojo.dto.response;

import java.util.Map;

/**
 * @author duanhong
 * @description MethodExecuteResult
 * @date 2019/5/18
 */
public class MethodExecuteResult<T> {
    private String message = null;

    private boolean success = true;

    private T data;

    private Map<String, Object> extra;

    public MethodExecuteResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
