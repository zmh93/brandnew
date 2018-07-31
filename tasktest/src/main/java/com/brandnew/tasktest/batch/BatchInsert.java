package com.brandnew.tasktest.batch;

import com.brandnew.tasktest.domain.Csdn;
import com.brandnew.tasktest.mapper.CsdnMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController
@EnableAsync
public class BatchInsert implements Runnable {
    private static int fileCount = 0;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void run() {
        fileCount++;
        try {
            batchInsert(fileCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  多线程插入数据，提高数据插入速度
     * @createDate 2018/7/5
     * @author zmh email: zmhzhaomenghui@gmail.com
     */
    @GetMapping
    public String test() throws InterruptedException {
        for (int i = 0; i < 6428 ; i++) {
            threadPoolTaskExecutor.execute(this);
            Thread.sleep(800);
        }

        return "success";
    }

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private void batchInsert(int fileCount) throws IOException {
        FileReader     reader     = new FileReader("F:/csdn/csdn" + fileCount + ".sql");
        BufferedReader br         = new BufferedReader(reader);
        SqlSession     session    = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);//关闭session的自动提交
        CsdnMapper     csdnMapper = session.getMapper(CsdnMapper.class);//利用反射生成mapper对象
        int            count      = 0;
        String         str        = null;
        Long           begin      = System.currentTimeMillis();
        try {
            while ((str = br.readLine()) != null) {
                count++;
                String[] split = str.split("#");
                Csdn     csdn  = new Csdn();
                csdn.setUsername(split[0]);
                csdn.setPassword(split[1]);
                csdn.setEmail(split[2]);
                csdnMapper.insert(csdn);
                if (count % 1000 == 0) {
                    session.commit();
                    session.clearCache();
                }
            }
            Long spend = System.currentTimeMillis() - begin;
            System.out.println("执行1000个花费：" + spend / 1000 + "秒");
            System.out.println("共需要：" + spend / 10 + "分钟");
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            br.close();
            reader.close();
            session.close();
        }
    }

}
