package top.duanhong.emims.dao.datadao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import top.duanhong.emims.pojo.po.AlarmArgument;

/**
 * @author duanhong
 * @description 预警参数持久层
 * @date 2019/5/16
 */
@Repository
public interface AlarmArgumentRepository extends JpaRepository<AlarmArgument,Long> {
    /**
     * 通过设备号获取预警参数
     * @param deviceMac
     * @return
     */
    AlarmArgument findByDeviceMac(String deviceMac);
}
