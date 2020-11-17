package ${apiTestPackageName};

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ActiveProfiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yijiupi.basic.request.BaseResponse;
import com.yijiupi.basic.request.IdRequest;
import com.yijiupi.basic.utils.JsonUtils;
import ${apiPackageName}.${apiName};
import ${requestPackageName}.${requestSearchName};
import ${requestPackageName}.${requestName};

import java.util.*;

/**
 * 
 * @ClassName: ${apiTestName}
 * @Description: 代码生成器单元测试
 * @author ${authorName}
 * @date ${currentTime}
 *
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ${apiTestName} {

	private static final Logger log = LoggerFactory.getLogger(${apiTestName}.class);

	@Autowired
	private ${serviceName} ${serviceName?uncap_first};

	@Test
	public void (){
		${dtoName} request = new ${dtoName}();
		//公共参数
		request.setLoginUserId("");
		request.setLoginUserName("");
		request.setPage(1);
		request.setPageSize(20);

		//业务参数...

		System.out.println("请求参数:" + JsonUtils.toJson(request));
		Pager<${voName}> result = ${serviceName?uncap_first}.getPage(request);
		System.out.println("返回参数："+ JsonUtils.toJson(result));
	}

	@Test
	public void getDetail(){
		IdRequest request = new IdRequest();
		//公共参数
		request.setLoginUserId("");
		request.setLoginUserName("");

		//业务参数...

		log.info("请求参数：{}", JsonUtils.toJson(request));
		BaseResponse baseResponse = ${serviceName?uncap_first}.getDetail(request);
		log.info("返回参数：{}", JsonUtils.toJson(baseResponse));
	}

	@Test
	public void save(){
		${dtoName} request = new ${dtoName}();
		//公共参数
		request.setLoginUserId("");
		request.setLoginUserName("");
		request.setSubmitToken("");

		//业务参数...

		log.info("请求参数：{}", JsonUtils.toJson(request));
		BaseResponse baseResponse = ${serviceName?uncap_first}.add${entityName}(request);
		log.info("返回参数：{}", JsonUtils.toJson(baseResponse));
	}

	@Test
	public void edit(){
		${dtoName} request = new ${dtoName}();
		//公共参数
		request.setLoginUserId("");
		request.setLoginUserName("");
		request.setSubmitToken("");

		//业务参数...

		log.info("请求参数：{}", JsonUtils.toJson(request));
		BaseResponse baseResponse = ${serviceName?uncap_first}.edit${entityName}(request);
		log.info("返回参数：{}", JsonUtils.toJson(baseResponse));
	}

	@Test
	public void delete(){
		IdRequest request = new IdRequest();
		//公共参数
		request.setLoginUserId("");
		request.setLoginUserName("");
		request.setSubmitToken("");

		//业务参数...

		log.info("请求参数：{}", JsonUtils.toJson(request));
		BaseResponse baseResponse = ${serviceName?uncap_first}.delete${entityName}(request);
		log.info("返回参数：{}", JsonUtils.toJson(baseResponse));
	}

}