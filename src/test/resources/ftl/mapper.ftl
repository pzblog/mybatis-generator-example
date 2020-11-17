<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${daoPackageName}.${daoName}">

	<!--BaseResultMap-->
	<resultMap id="BaseResultMap" type="${entityPackageName}.${entityName}">
        <#list columns as pro>
            <#if pro.proName == primaryId>
				<id column="${primaryId}" property="${primaryId}" jdbcType="${pro.fieldType}"/>
            <#else>
				<result column="${pro.fieldName}" property="${pro.proName}" jdbcType="${pro.fieldType}"/>
            </#if>
        </#list>
	</resultMap>

	<!--Base_Column_List-->
	<sql id="Base_Column_List">
        <#list columns as pro>
            <#if pro_index == 0>${pro.fieldName}<#else>,${pro.fieldName}</#if>
        </#list>
	</sql>

	<!--批量插入-->
	<insert id="insertList" parameterType="java.util.List">
		insert into ${tableName} (
        <#list columns as pro>
            <#if pro_index == 0>${pro.fieldName},<#elseif pro_index == 1>${pro.fieldName}<#else>,${pro.fieldName}</#if>
        </#list>
		)
		values
		<foreach collection ="list" item="obj" separator =",">
			<trim prefix=" (" suffix=")" suffixOverrides=",">
                <#list columns as pro>
                    ${r"#{obj." + pro.proName + r"}"},
                </#list>
			</trim>
		</foreach >
	</insert>

	<!--按需新增-->
	<insert id="insertPrimaryKeySelective" parameterType="${entityPackageName}.${entityName}">
		insert into ${tableName}
		<trim prefix="(" suffix=")" suffixOverrides=",">
            <#list columns as pro>
				<if test="${pro.proName} != null">
                    ${pro.fieldName},
				</if>
            </#list>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list columns as pro>
				<if test="${pro.proName} != null">
                    ${r"#{" + pro.proName + r",jdbcType=" + pro.fieldType +r"}"},
				</if>
            </#list>
		</trim>
	</insert>

	<!-- 按需修改-->
	<update id="updatePrimaryKeySelective" parameterType="${entityPackageName}.${entityName}">
		update ${tableName}
		<set>
            <#list columns as pro>
                <#if pro.fieldName != primaryId && pro.fieldName != primaryId>
					<if test="${pro.proName} != null">
                        ${pro.fieldName} = ${r"#{" + pro.proName + r",jdbcType=" + pro.fieldType +r"}"},
					</if>
                </#if>
            </#list>
		</set>
		where ${primaryId} = ${r"#{" + "${primaryId}" + r",jdbcType=BIGINT}"}
	</update>

	<!-- 按需批量修改-->
	<update id="updateBatchByIds" parameterType="java.util.List">
		update ${tableName}
		<trim prefix="set" suffixOverrides=",">
            <#list columns as pro>
                <#if pro.fieldName != primaryId && pro.fieldName != primaryId>
					<trim prefix="${pro.fieldName}=case" suffix="end,">
						<foreach collection="list" item="obj" index="index">
							<if test="obj.${pro.proName} != null">
								when id = ${r"#{" + "obj.id" + r"}"}
								then  ${r"#{obj." + pro.proName + r",jdbcType=" + pro.fieldType +r"}"}
							</if>
						</foreach>
					</trim>
                </#if>
            </#list>
		</trim>
		where
		<foreach collection="list" separator="or" item="obj" index="index" >
			id = ${r"#{" + "obj.id" + r"}"}
		</foreach>
	</update>

	<!-- 删除-->
	<delete id="deleteByPrimaryKey" parameterType="java.lang.Long">
		delete from ${tableName}
		where ${primaryId} = ${r"#{" + "${primaryId}" + r",jdbcType=BIGINT}"}
	</delete>

	<!-- 查询详情 -->
	<select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Long">
		select
		<include refid="Base_Column_List"/>
		from ${tableName}
		where ${primaryId} = ${r"#{" + "${primaryId}" + r",jdbcType=BIGINT}"}
	</select>

	<!-- 按需查询 -->
	<select id="selectByPrimaryKeySelective" resultMap="BaseResultMap" parameterType="${entityPackageName}.${entityName}">
		select
		<include refid="Base_Column_List"/>
		from ${tableName}
	</select>

	<!-- 批量查询-->
	<select id="selectByIds" resultMap="BaseResultMap" parameterType="java.util.List">
		select
		<include refid="Base_Column_List"/>
		from ${tableName}
		<where>
			<if test="ids != null">
				and ${primaryId} in
				<foreach item="item" index="index" collection="ids" open="(" separator="," close=")">
                    ${r"#{" + "item" + r"}"}
				</foreach>
			</if>
		</where>
	</select>

	<!-- 根据条件查询 -->
	<select id="selectByMap" resultMap="BaseResultMap" parameterType="java.util.Map">
		select
		<include refid="Base_Column_List"/>
		from ${tableName}
	</select>

	<!-- 查询${entityName}总和 -->
	<select id="countPage" resultType="int" parameterType="${dtoPackageName}.${dtoName}">
		select count(${primaryId})
		from ${tableName}
	</select>

	<!-- 查询${entityName}列表 -->
	<select id="selectPage" resultMap="BaseResultMap" parameterType="${dtoPackageName}.${dtoName}">
		select
		<include refid="Base_Column_List"/>
		from ${tableName}
		limit ${r"#{" + "start,jdbcType=INTEGER" + r"}"},${r"#{" + "end,jdbcType=INTEGER" + r"}"}
	</select>

</mapper>