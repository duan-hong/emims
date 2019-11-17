package top.duanhong.emims.dao.datadao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import top.duanhong.emims.pojo.po.Alarm;

/**
 * @author duanhong
 * @description 预警
 * @date 2019/5/4
 */
@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Integer>, JpaSpecificationExecutor {

    /**
     * 根据是否已读获取
     * @param alarmIsReaded
     * @param pageable
     * @return
     */
    Page findByIsReaded(int alarmIsReaded, Pageable pageable);
}
