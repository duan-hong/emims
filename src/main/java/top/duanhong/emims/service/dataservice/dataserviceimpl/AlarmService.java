package top.duanhong.emims.service.dataservice.dataserviceimpl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import top.duanhong.emims.dao.datadao.AlarmRepository;
import top.duanhong.emims.pojo.po.Alarm;
import top.duanhong.emims.service.utils.Constant;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author duanhong
 * @description 预警业务
 * @date 2019/5/4
 */
@Service
public class AlarmService {
    @Autowired
    private AlarmRepository alarmRepository;

    public Page<Alarm> serach(String serach, String stime, String etime,Pageable pageable) {
        Page<Alarm> page = null;
        Specification<Alarm> querySpecifi = new Specification<Alarm>() {
            @Override
            public Predicate toPredicate(Root<Alarm> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(stime)) {
                    //大于或等于传入时间
                    predicates.add(cb.greaterThanOrEqualTo(root.get("date").as(String.class), stime));
                }
                if (StringUtils.isNotBlank(etime)) {
                    //小于或等于传入时间
                    predicates.add(cb.lessThanOrEqualTo(root.get("date").as(String.class), etime));
                }
                if (StringUtils.isNotBlank(serach)) {
                    //模糊查找
                    predicates.add(cb.like(root.get("title").as(String.class), "%" + serach + "%"));
                }
                // and到一起的话所有条件就是且关系，or就是或关系
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        page = this.alarmRepository.findAll(querySpecifi,pageable);
        return page;
    }

    public Page getAllAlarm(Pageable pageable) {
        Page page=alarmRepository.findAll(pageable);
        return page;
    }

    public Page getNewAlarm(Pageable pageable) {
        Page page=alarmRepository.findByIsReaded(Constant.ALARM_IS_READED,pageable);
        return page;
    }
}
