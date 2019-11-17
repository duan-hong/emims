package top.duanhong.emims.service.dataservice.remotedatahandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.duanhong.emims.dao.datadao.RemoteDataRepository;
import top.duanhong.emims.pojo.po.RemoteData;

/**
 * @author duanhong
 * @description 远程数据业务
 * @date 2019/5/5
 */
@Service
public class RemoteDataService {
    @Autowired
    private RemoteDataRepository remoteDataRepository;

    public RemoteData saveRemoteData(RemoteData remoteDatePo) {
        return remoteDataRepository.save(remoteDatePo);
    }

    public Page getRemoteData(Pageable pageable) {
        Page<RemoteData> page=remoteDataRepository.findAll(pageable);
        return page;
    }
}
