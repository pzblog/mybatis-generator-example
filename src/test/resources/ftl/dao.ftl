package ${daoPackageName};

import com.example.generator.core.BaseMapper;
import java.util.List;
import ${entityPackageName}.${entityName};
import ${dtoPackageName}.${dtoName};

/**
*
* @ClassName: ${daoName}
* @Description: 数据访问接口
* @author ${authorName}
* @date ${currentTime}
*
*/
public interface ${daoName} extends BaseMapper<${entityName}>{

	int countPage(${dtoName} ${dtoName?uncap_first});

	List<${entityName}> selectPage(${dtoName} ${dtoName?uncap_first});
}