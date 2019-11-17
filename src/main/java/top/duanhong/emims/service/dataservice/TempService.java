package top.duanhong.emims.service.dataservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.duanhong.emims.pojo.po.Temp;

public interface TempService {

    Temp insertT(Temp t);

    Page<Temp> getT(Pageable pageable);
}
