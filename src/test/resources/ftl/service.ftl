package ${servicePackageName};

import com.example.generator.core.BaseService;
import com.example.generator.common.Pager;
import ${voPackageName}.${voName};
import ${dtoPackageName}.${dtoName};
import ${entityPackageName}.${entityName};


/**
 *
 * @ClassName: ${serviceName}
 * @Description: ${entityName}业务访问接口
 * @author ${authorName}
 * @date ${currentTime}
 *
 */
public interface ${serviceName} extends BaseService<${entityName}> {

	/**
	 * 分页列表查询
	 * @param request
	 */
	Pager<${voName}> getPage(${dtoName} request);
}
