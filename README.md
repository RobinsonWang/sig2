# sig2
  Java Web SSH framwork.

IDE
--------
  Eclipse for Java EE

Struts2
-------
  version: struts-2.3.32
  
  需要修改WEB-INF/web.xml文件
  
  需要在src/目录下添加struts.xml文件  
  
  WEB-INF/lib目录下的jar包未上传  

Spring
------
  version: 3.2.9
  
  新增applicationContext.xml文件
  
  修改web.xml和struts.xml文件

Hibernate
----------
  version:3.6.10
  
  新增hibernate.cfg.xml文件（在spring中整合hibernate后，该文件没有用，仅用作hibernate反向工程时使用）
  
  在spring中整合hibernate：定义数据源（使用c3p0），sessionFactory，需要注入的组件等。
  
  
框架
----------
  分层：action model dao service
