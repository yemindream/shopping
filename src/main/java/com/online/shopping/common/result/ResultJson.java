package com.online.shopping.common.result;

import java.io.Serializable;

/**
 * json object of response.
 *
 *
 */
public final class ResultJson<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer resultCode;

  private T resultData;

  private String msg;

  public ResultJson() {
    super();
  }

  public ResultJson(final Integer resultCode, final T resultData,
                    final String msg) {
    super();
    this.resultCode = resultCode;
    this.resultData = resultData;
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(final String msg) {
    this.msg = msg;
  }

  public Integer getResultCode() {
    return resultCode;
  }

  public void setResultCode(final Integer resultCode) {
    this.resultCode = resultCode;
  }

  public T getResultData() {
    return resultData;
  }

  public void setResultData(final T resultData) {
    this.resultData = resultData;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((msg == null) ? 0 : msg.hashCode());
    result =
        prime * result + ((resultCode == null) ? 0 : resultCode.hashCode());
    result =
        prime * result + ((resultData == null) ? 0 : resultData.hashCode());
    return result;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ResultJson other = (ResultJson) obj;
    if (msg == null) {
      if (other.msg != null) {
        return false;
      }
    } else if (!msg.equals(other.msg)) {
      return false;
    }
    if (resultCode == null) {
      if (other.resultCode != null) {
        return false;
      }
    } else if (!resultCode.equals(other.resultCode)) {
      return false;
    }
    if (resultData == null) {
      if (other.resultData != null) {
        return false;
      }
    } else if (!resultData.equals(other.resultData)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ResultJson [resultCode=" + resultCode + ", resultData=" + resultData
        + ", msg=" + msg + "]";
  }

}
