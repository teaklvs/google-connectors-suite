/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

/**
 * The amount of quota consumed by the object.
 *
 * 
 */
public class QuotaBytesUsed extends Element {

  /**
   * The key for this element.
   */
  public static final ElementKey<Long,
      QuotaBytesUsed> KEY = ElementKey.of(new QName(Namespaces.gNs,
      "quotaBytesUsed"), Long.class, QuotaBytesUsed.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    // The builder for this element
    ElementCreator builder = registry.build(KEY).setContentRequired(false);
  }

  /**
   * Constructs an instance using the default key.
   */
  public QuotaBytesUsed() {
    super(KEY);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected QuotaBytesUsed(ElementKey<Long, ? extends QuotaBytesUsed> key) {
    super(key);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link Element} instance. Will use the given {@link ElementKey} as the key
   * for the element. This constructor is used when adapting from one element
   * key to another. You cannot call this constructor directly, instead use
   * {@link Element#createElement(ElementKey, Element)}.
   *
   * @param key The key to use for this element.
   * @param source source element
   */
  protected QuotaBytesUsed(ElementKey<Long, ? extends QuotaBytesUsed> key,
      Element source) {
    super(key, source);
  }

  /**
   * Constructs a new instance with the given value.
   *
   * @param value value.
   */
  public QuotaBytesUsed(Long value) {
    this();
    setValue(value);
  }

  @Override
  public QuotaBytesUsed lock() {
    return (QuotaBytesUsed) super.lock();
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public Long getValue() {
    return super.getTextValue(KEY);
  }

  /**
   * Sets the value.
   *
   * @param value value or {@code null} to reset
   * @return this to enable chaining setters
   */
  public QuotaBytesUsed setValue(Long value) {
    super.setTextValue(value);
    return this;
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasValue() {
    return super.hasTextValue();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    QuotaBytesUsed other = (QuotaBytesUsed) obj;
    return eq(getValue(), other.getValue());
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (getValue() != null) {
      result = 37 * result + getValue().hashCode();
    }
    return result;
  }
}


