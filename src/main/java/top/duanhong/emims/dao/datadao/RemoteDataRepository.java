package top.duanhong.emims.dao.datadao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.duanhong.emims.pojo.po.RemoteData;

/**
 * @author duanhong
 * @description 远程数据
 * @date 2019/5/5
 */
@Repository
public interface RemoteDataRepository extends JpaRepository<RemoteData,Long> {
}
