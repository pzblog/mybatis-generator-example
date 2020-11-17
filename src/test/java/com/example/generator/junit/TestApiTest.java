//package com.example.generator.junit;
//
//import com.yijiupi.basic.request.BaseResponse;
//import com.yijiupi.basic.request.IdRequest;
//import com.yijiupi.basic.utils.IdGenerator;
//import com.yijiupi.basic.utils.JsonUtils;
//import com.yijiupi.yjgj.Application;
//import com.yijiupi.yjgj.api.TestEntityApi;
//import com.yijiupi.yjgj.request.TestEntityRequest;
//import com.yijiupi.yjgj.request.TestEntityRequestSearch;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.*;
//
///**
// * @author panzhi
// * @Description 代码生成器单元测试
// * @since 2020-11-11
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class TestApiTest {
//
//    @Autowired
//    public TestApi testApi;
//
//    @Autowired
//    private TestService testService;
//
//
//    @Test
//    public void addTest(){
//        testApi.addTest(new TestRequest().setId(IdGenerator.getId(Test.class.getSimpleName())).setName("张三"));
//    }
//
//    @Test
//    public void addBatchTest(){
//        List<com.yijiupi.yjgj.entity.Test> list = new ArrayList<>();
//        list.add(new com.yijiupi.yjgj.entity.Test()
//                .setId(IdGenerator.getId(Test.class.getSimpleName()))
//                .setName("李四1")
//                .setIsDelete(0)
//                .setCreateTime(new Date()).setUpdateTime(new Date()));
//
//        list.add(new com.yijiupi.yjgj.entity.Test()
//                .setId(IdGenerator.getId(Test.class.getSimpleName()))
//                .setName("李四2")
//                .setIsDelete(0)
//                .setCreateTime(new Date()).setUpdateTime(new Date()));
//
//        list.add(new com.yijiupi.yjgj.entity.Test()
//                .setId(IdGenerator.getId(Test.class.getSimpleName()))
//                .setName("李四3")
//                .setIsDelete(0)
//                .setCreateTime(new Date()).setUpdateTime(new Date()));
//
//        testService.insertList(list);
//    }
//
//    @Test
//    public void editTest(){
//        testApi.editTest(new TestRequest().setId(4858375270745890699l).setName("张三11"));
//    }
//
//
//    @Test
//    public void editBatchTest(){
//        List<com.yijiupi.yjgj.entity.Test> list = new ArrayList<>();
//        list.add(new com.yijiupi.yjgj.entity.Test()
//                .setId(4858375523595199904l)
//                .setName("李四11")
//                .setIsDelete(0));
//
//        list.add(new com.yijiupi.yjgj.entity.Test()
//                .setId(4858375523595199905l)
//                .setName("李四12")
//                .setIsDelete(0));
//
//        list.add(new com.yijiupi.yjgj.entity.Test()
//                .setId(4858375523595199906l)
//                .setName("李四13")
//                .setIsDelete(0));
//        testService.updateBatchByIds(list);
//    }
//
//    @Test
//    public void deleteTest(){
//        testApi.deleteTest(new IdRequest().setId(4858375270745890699l));
//    }
//
//
//
//    @Test
//    public void getDetail(){
//        BaseResponse response = testApi.getDetail(new IdRequest().setId(4858375523595199904l));
//        System.out.println("baseResponse:" + JsonUtils.toJson(response));
//    }
//
//    @Test
//    public void selectByIds(){
//        List<Long> ids = Arrays.asList(4858375523595199904l,4858375523595199905l,4858375523595199906l);
//        List<com.yijiupi.yjgj.entity.Test> response = testService.selectByIds(ids);
//        System.out.println("baseResponse:" + JsonUtils.toJson(response));
//    }
//
//    @Test
//    public void selectByPrimaryKeySelective(){
//        com.yijiupi.yjgj.entity.Test test = new com.yijiupi.yjgj.entity.Test();
//        test.setName("张三");
//        List<com.yijiupi.yjgj.entity.Test> response = testService.selectByPrimaryKeySelective(test);
//        System.out.println("baseResponse:" + JsonUtils.toJson(response));
//    }
//
//    @Test
//    public void selectByMap(){
//        Map map = new HashMap();
//        map.put("name","张三");
//        List<com.yijiupi.yjgj.entity.Test> response = testService.selectByMap(map);
//        System.out.println("baseResponse:" + JsonUtils.toJson(response));
//    }
//
//    @Test
//    public void findListByPage(){
//        BaseResponse response = testApi.findListByPage(new TestRequestSearch());
//        System.out.println("baseResponse:" + JsonUtils.toJson(response));
//    }
//
//
//
//}
