package top.duanhong.emims.controller.utils;

import org.springframework.data.domain.Page;
import top.duanhong.emims.pojo.dto.response.BaseResponse;
import top.duanhong.emims.pojo.dto.response.PageResponse;

import java.util.List;

/**
 * @author duanhong
 * @description 响应对象工厂
 * @date 2019/3/26
 */
public class ResponseFactory {
    public static<T> BaseResponse<T> getBaseResponse(String message, T data){
        BaseResponse<T> baseResponse=new BaseResponse<>();
        baseResponse.setMessage(message);
        baseResponse.setData(data);
        return baseResponse;
    }
    public static<T> PageResponse<T> getPageResponse(Page<T> page){
        PageResponse<T> pageResponse = new PageResponse<>();
        pageResponse.setData(page.getContent());
        pageResponse.setTotalCount(page.getTotalElements());
        return  pageResponse;
    }

    public static<T> PageResponse<T> getPageResponse(Page<T> page,String message,int status){
        PageResponse<T> pageResponse = new PageResponse<>();
        pageResponse.setData(page.getContent());
        pageResponse.setTotalCount(page.getTotalElements());
        pageResponse.setMessage(message);
        pageResponse.setStatus(status);
        return  pageResponse;
    }

    public static<T> PageResponse<T> getPageResponse(List<T> datas, Long totalCount, String message){
        PageResponse<T> pageResponse = new PageResponse<>();
        pageResponse.setData(datas);
        pageResponse.setTotalCount(totalCount);
        pageResponse.setMessage(message);
        return  pageResponse;
    }

    public static<T> PageResponse<T> getPageResponse(List<T> datas,Long totalCount,String message,Object extra){
        PageResponse<T> pageResponse = new PageResponse<>();
        pageResponse.setData(datas);
        pageResponse.setTotalCount(totalCount);
        pageResponse.setMessage(message);
        pageResponse.setExtra(extra);
        return  pageResponse;
    }

    public static<T> BaseResponse<T> getBaseResponse(T data){
        BaseResponse<T> baseResponse =  new BaseResponse<T>();
        baseResponse.setData(data);
        return baseResponse;
    }

    public static<T> BaseResponse<T> getBaseResponse(T data,Object extra){
        BaseResponse<T> baseResponse =  new BaseResponse<T>();
        baseResponse.setData(data);
        baseResponse.setExtra(extra);
        return baseResponse;
    }

    public static<T> BaseResponse<T> getBaseResponse(String message, T data,Object extra){
        BaseResponse<T> baseResponse =  new BaseResponse<T>();
        baseResponse.setMessage(message);
        baseResponse.setData(data);
        baseResponse.setExtra(extra);
        return baseResponse;
    }

}
