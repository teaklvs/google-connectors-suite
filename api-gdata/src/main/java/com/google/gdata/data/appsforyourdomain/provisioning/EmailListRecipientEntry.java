/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.appsforyourdomain.provisioning;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.extensions.Who;
import com.google.gdata.util.Namespaces;

/**
 * Google Apps for Your Domain GData Entry which models a particular recipient
 * on an email list.  This is a simple Entry which contain only a single Who
 * extension.  
 *
 * This is temporary for code reviewers.
 * 
 * Sample XML.
 * <code>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * &lt;atom:entry xmlns:atom="http://www.w3.org/2005/Atom"&gt;
 *   &lt;atom:category scheme="http://schemas.google.com/g/2005#kind"
 * term="http://schemas.google.com/apps/2006#emailList.recipient"/&gt;
 *   &lt;gd:who xmlns:gd="http://schemas.google.com/g/2005"
 * email="SusanJones-1321@apps-provisioning-test.com"/&gt;
 * &lt;/atom:entry&gt;
 * </code>
 *
 * 
 */
@Kind.Term(EmailListRecipientEntry.EMAILLIST_RECIPIENT_KIND)
public class EmailListRecipientEntry
    extends BaseEntry<EmailListRecipientEntry> {

  /**
   * Kind term value for EmailListRecipient category labels.
   */
  public static final String EMAILLIST_RECIPIENT_KIND
      = com.google.gdata.data.appsforyourdomain.Namespaces.APPS_PREFIX
	  + "emailList.recipient";

  /**
   * Kind category used to label feeds or entries that have EmailListRecipient
   * extension data.
   */
  public static final Category EMAILLIST_RECIPIENT_CATEGORY =
      new Category(Namespaces.gKind, EMAILLIST_RECIPIENT_KIND);

  /**
   * Constructs a new empty EmailListRecipientEntry with the appropriate kind
   * category to indicate that it is an email list.
   */
  public EmailListRecipientEntry() {
    super();
    getCategories().add(EMAILLIST_RECIPIENT_CATEGORY);
  }

  /**
   * Constructs a new EmailListRecipientEntry by doing a shallow copy of data
   * from an existing BaseEntry intance.
   */
  public EmailListRecipientEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
    getCategories().add(EMAILLIST_RECIPIENT_CATEGORY);
  }

  /**
   * Declares an Extension.
   */
  @Override
  public void declareExtensions(ExtensionProfile extensionProfile) {

    // Who extension is repeatable by default.
    ExtensionDescription desc = Who.getDefaultDescription();
    desc.setRepeatable(false);

    // The Who extension is required for EmailListRecipientEntry
    desc.setRequired(true);
    extensionProfile.declare(EmailListRecipientEntry.class, desc);

    // Declare our "apps" namespace
    extensionProfile.declareAdditionalNamespace(
        com.google.gdata.data.appsforyourdomain.Namespaces.APPS_NAMESPACE);
  }

}
