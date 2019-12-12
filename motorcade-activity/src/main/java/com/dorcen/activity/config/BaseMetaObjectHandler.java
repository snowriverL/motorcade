package com.dorcen.activity.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 填充创建时间，创建人，更新时间，更新人
 */
@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {
    /**
     * 删除标记
     */
    public static final String DEL_FLAG = "delFlag";
    /**
     * 创建时间
     */
    public static final String CREATE_BY = "createBy";
    /**
     * 创建时间
     */
    public static final String CREATE_DATE = "createDate";
    /**
     * 创建时间
     */
    public static final String UPDATE_BY = "updateBy";
    /**
     * 更新时间
     */
    public static final String UPDATE_DATE = "updateDate";

    /**
     * 新增
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建人ID
        Object createBy = getFieldValByName(CREATE_BY, metaObject);
        if (createBy == null) {
            setFieldValByName(CREATE_BY, 0, metaObject);
        }

        // 创建时间
        Object createDate = getFieldValByName(CREATE_DATE, metaObject);
        if (createDate == null) {
            setFieldValByName(CREATE_DATE, new Date(), metaObject);
        }

        // 删除标记
        Object delFlag = getFieldValByName(DEL_FLAG, metaObject);
        if (delFlag == null) {
            setFieldValByName(DEL_FLAG, 0, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 填充更新人的ID
        setFieldValByName(UPDATE_BY, 0, metaObject);

        // 填充更新时间
        setFieldValByName(UPDATE_DATE, new Date(), metaObject);
    }
}