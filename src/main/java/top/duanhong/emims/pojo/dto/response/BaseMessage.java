package top.duanhong.emims.pojo.dto.response;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 前端数据传输
 * @author Administrator
 */
@Component
public class BaseMessage {
    private String message;
    private List rows;
    private Long total;
    private int statuCode;
    private String dataInfo;
    private Page page;


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(String dataInfo) {
        this.dataInfo = dataInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List data) {
        this.rows = data;
        if (this.rows!=null){
            setMessage("成功");
            setStatuCode(1);
        }else {
            setMessage("失败");
            setStatuCode(0);
        }
    }

    public int getStatuCode() {
        return statuCode;
    }

    public void setStatuCode(int statuCode) {
        this.statuCode = statuCode;
    }

    @Override
    public String toString() {
        return "BaseMessage{" +
                "message='" + message + '\'' +
                ", rows=" + rows +
                ", statuCode='" + statuCode + '\'' +
                '}';
    }
}
