package ${controllerPackageName};

import com.example.generator.common.IdRequest;
import com.example.generator.common.Pager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Objects;

import ${servicePackageName}.${serviceName};
import ${entityPackageName}.${entityName};
import ${dtoPackageName}.${dtoName};
import ${voPackageName}.${voName};

/**
 *
 * @ClassName: ${controllerName}
 * @Description: 外部访问接口
 * @author ${authorName}
 * @date ${currentTime}
 *
 */
@RestController
@RequestMapping("/${entityName?uncap_first}")
public class ${controllerName} {

	@Autowired
	private ${serviceName} ${serviceName?uncap_first};

	/**
	 * 分页列表查询
	 * @param request
	 */
	@PostMapping(value = "/getPage")
	public Pager<${voName}> getPage(@RequestBody ${dtoName} request){
		return ${serviceName?uncap_first}.getPage(request);
	}

	/**
	 * 查询详情
	 * @param request
	 */
	@PostMapping(value = "/getDetail")
	public ${voName} getDetail(@RequestBody IdRequest request){
		${entityName} source = ${serviceName?uncap_first}.selectById(request.getId());
		if(Objects.nonNull(source)){
			${voName} result = new ${voName}();
			BeanUtils.copyProperties(source, result);
			return result;
		}
		return null;
	}

	/**
	 * 新增操作
	 * @param request
	 */
	@PostMapping(value = "/save")
	public void save(${dtoName} request){
		${entityName} entity = new ${entityName}();
		BeanUtils.copyProperties(request, entity);
		${serviceName?uncap_first}.insert(entity);
	}

	/**
	 * 编辑操作
	 * @param request
	 */
	@PostMapping(value = "/edit")
	public void edit(${dtoName} request){
		${entityName} entity = new ${entityName}();
		BeanUtils.copyProperties(request, entity);
		${serviceName?uncap_first}.updateById(entity);
	}

	/**
	 * 删除操作
	 * @param request
	 */
	@PostMapping(value = "/delete")
	public void delete(IdRequest request){
		${serviceName?uncap_first}.deleteById(request.getId());
	}
}