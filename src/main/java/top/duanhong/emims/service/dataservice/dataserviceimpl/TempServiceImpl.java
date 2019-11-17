package top.duanhong.emims.service.dataservice.dataserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.duanhong.emims.dao.datadao.TempDao;
import top.duanhong.emims.pojo.po.Temp;
import top.duanhong.emims.service.dataservice.TempService;


/**
 * @author Administrator
 */
@Service
public class TempServiceImpl implements TempService {

    @Autowired
    private TempDao tempDao;

    @Override
    public Temp insertT(Temp t) {

        Temp result=tempDao.save(t);
        return result;
    }

    @Override
    public Page<Temp> getT(Pageable pageable) {
        Page<Temp> pageTemp=tempDao.findAll(pageable);
        return pageTemp;
    }
}
