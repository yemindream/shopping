package com.online.shopping.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 工具类：
 *
 * 本类中持有spring容器对象的引用，可方便获取spring容器中维护的对象
 *
 * @author yemin
 *
 */
@Service
public final class SpringContextHolder
    implements ApplicationContextAware, DisposableBean {

  private static ApplicationContext holdApplicationContext;
  private static Logger logger =
      LoggerFactory.getLogger(SpringContextHolder.class);

  @Override
  public void setApplicationContext(
      final ApplicationContext applicationContext) {
    setHoldApplicationContext(applicationContext);
  }

  public static void setHoldApplicationContext(
      final ApplicationContext holdApplicationContext) {
    SpringContextHolder.holdApplicationContext = holdApplicationContext;
  }

  public static ApplicationContext getHoldApplicationContext() {
    return holdApplicationContext;
  }

  public static Object getBean(final String beanName) {
    return holdApplicationContext.getBean(beanName);
  }

  public static <T> T getBean(final String beanName, final Class<T> clazz) {
    return holdApplicationContext.getBean(beanName, clazz);
  }

  /**
   * 清除SpringContextHolder中的ApplicationContext为Null.
   */
  public static void clearHolder() {
    if (logger.isDebugEnabled()) {
      logger.debug("clear SpringContextHolder ApplicationContext:"
          + holdApplicationContext);
    }
    holdApplicationContext = null;
  }

  /**
   * 实现DisposableBean接口, 在Context关闭时清理静态变量.
   */
  @Override
  public void destroy() throws Exception {
    SpringContextHolder.clearHolder();
  }

}
