package top.duanhong.emims.pojo.dto.response;

/**
 * @author duanhong
 * @description 响应对象
 * @date 2019/3/26
 */
public class BaseResponse<T> {
    private String message;

    private T data;

    private Object extra;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
