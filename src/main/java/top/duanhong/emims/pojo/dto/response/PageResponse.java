package top.duanhong.emims.pojo.dto.response;

import java.util.List;

/**
 * @author duanhong
 * @description 分页响应数据
 * @date 2019/4/18
 */
public class PageResponse<T>{
    private long totalCount;

    private List<T> data;

    private String message;

    private Object extra;

    private int status;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
