package com.yicai.taotalent.service;

import com.yicai.taotalent.domain.Girl;
import com.yicai.taotalent.enums.ResultEnum;
import com.yicai.taotalent.exception.GirlException;
import com.yicai.taotalent.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by RamboLi
 * Date 2018/4/20 0020
 * Time 10:11
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    //事务：对于处理多条数据的情况，要么都执行，要么都不执行。例如电商系统，扣款和减库存是一起操作的。
    @Transactional //此处注解事务无效，mongodb暂时不支持事务，4.0以后才支持。所以，如果开发财务系统或者电商系统等对于
                   //事务要求较高的平台，建议考虑关系型数据库。因为关系型数据库对事务的支持较好。
    public void insertTwo(){
        Random random=new Random();
        Girl girla=new Girl();
        girla.setId(random.nextInt(100000));
        girla.setAge(2);
        girla.setUserName("masa");
        girlRepository.save(girla);

        Girl girlb=new Girl();
        //girlb.setId(random.nextInt(100000));
        girlb.setAge(34);
        girlb.setUserName("damika");
        girlRepository.save(girlb);
    }
    public void getAgeById(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<16){
          throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>=16&&age<=20){
          throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else if(age>20){
            throw new GirlException(ResultEnum.UNIVERSITY);
        }
//        Girl girl2=girl.get(0);
    }

    /**
     * 通过ID查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
