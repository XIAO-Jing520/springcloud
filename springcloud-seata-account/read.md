
今天使用mybatis查询数据的时候，出现org.apache.ibatis.binding.BindingException: Parameter ‘username’ not found. Available parameters are [0, 1, param1, param2] 问题。

使用注解@Param(“XXX”)来完成。