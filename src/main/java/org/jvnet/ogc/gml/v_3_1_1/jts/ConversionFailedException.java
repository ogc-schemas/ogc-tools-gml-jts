package org.jvnet.ogc.gml.v_3_1_1.jts;

import org.jvnet.jaxb.locator.ObjectLocator;

public class ConversionFailedException extends Exception {

  private static final long serialVersionUID = 1L;
  private final ObjectLocator locator;

  public ConversionFailedException(ObjectLocator locator, String message) {

    super(message);
    this.locator = locator;
  }

  public ConversionFailedException(ObjectLocator locator, Throwable throwable) {

    super(throwable);
    this.locator = locator;
  }

  public ConversionFailedException(ObjectLocator locator, String message, Throwable throwable) {

    super(message, throwable);
    this.locator = locator;
  }

  public ConversionFailedException(ObjectLocator locator) {
    super();
    this.locator = locator;
  }

  public ObjectLocator getLocator() {
    return locator;
  }

}
