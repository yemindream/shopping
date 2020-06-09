package com.online.shopping.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

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

  public static void clearHolder() {
    if (logger.isDebugEnabled()) {
      logger.debug("clear SpringContextHolder ApplicationContext:"
          + holdApplicationContext);
    }
    holdApplicationContext = null;
  }

  @Override
  public void destroy() throws Exception {
    SpringContextHolder.clearHolder();
  }

}
