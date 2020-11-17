package ${entityPackageName};

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @ClassName: ${entityName}
 * @Description: ${tableDes!}实体类
 * @author ${authorName}
 * @date ${currentTime}
 *
 */
public class ${entityName} implements Serializable {

	private static final long serialVersionUID = 1L;
	
	<#--属性遍历-->
	<#list columns as pro>
	<#--<#if pro.proName != primaryId
	&& pro.proName != 'remarks'
	&& pro.proName != 'createBy'
	&& pro.proName != 'createDate'
	&& pro.proName != 'updateBy'
	&& pro.proName != 'updateDate'
	&& pro.proName != 'delFlag'
	&& pro.proName != 'currentUser'
	&& pro.proName != 'page'
	&& pro.proName != 'sqlMap'
	&& pro.proName != 'isNewRecord'
	></#if>-->
	/**
	 * ${pro.proDes!}
	 */
	private ${pro.proType} ${pro.proName};
	</#list>

	<#--属性get||set方法-->
	<#list columns as pro>
	public ${pro.proType} get${pro.proName?cap_first}() {
		return this.${pro.proName};
	}

	public ${entityName} set${pro.proName?cap_first}(${pro.proType} ${pro.proName}) {
		this.${pro.proName} = ${pro.proName};
		return this;
	}
	</#list>
}