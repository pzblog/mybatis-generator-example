package ${serviceImplPackageName};

import com.example.generator.common.Pager;
import com.example.generator.core.BaseServiceImpl;
import com.example.generator.test.service.TestEntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


import ${daoPackageName}.${daoName};
import ${entityPackageName}.${entityName};
import ${dtoPackageName}.${dtoName};
import ${voPackageName}.${voName};


@Service
public class ${serviceImplName} extends BaseServiceImpl<${daoName}, ${entityName}> implements ${serviceName} {

	private static final Logger log = LoggerFactory.getLogger(${serviceImplName}.class);

	/**
	 * 分页列表查询
	 * @param request
	 */
	public Pager<${voName}> getPage(${dtoName} request) {
		List<${voName}> resultList = new ArrayList();
		int count = super.baseMapper.countPage(request);
		List<${entityName}> dbList = count > 0 ? super.baseMapper.selectPage(request) : new ArrayList<>();
		if(!CollectionUtils.isEmpty(dbList)){
			dbList.forEach(source->{
				${voName} target = new ${voName}();
				BeanUtils.copyProperties(source, target);
				resultList.add(target);
			});
		}
		return new Pager(request.getCurrPage(), request.getPageSize(), count, resultList);
	}
}
