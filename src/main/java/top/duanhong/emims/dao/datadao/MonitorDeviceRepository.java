package top.duanhong.emims.dao.datadao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.duanhong.emims.pojo.po.MonitorDevice;

/**
 * @author duanhong
 * @description 监测设备
 * @date 2019/5/22
 */
@Repository
public interface MonitorDeviceRepository extends JpaRepository<MonitorDevice,Long> {

    /**
     * 通过deviceMac获取设备记录
     * @param deviceMac
     * @return
     */
    MonitorDevice findByDeviceMac(String deviceMac);
}
