package top.duanhong.emims.dao.datadao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.duanhong.emims.pojo.po.Temp;

/**
 * @author Administrator
 */
@Repository
public interface TempDao extends JpaRepository<Temp,String> {
}
