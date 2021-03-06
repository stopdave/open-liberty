/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package jsf.container.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "jsfBean")
@SessionScoped
public class JSFBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String data = ":" + getClass().getSimpleName() + ":";

    @PostConstruct
    public void start() {
        System.out.println("JSFBean postConstruct called");
        this.data += ":PostConstructCalled:";
        System.out.println("JSFBean data is: " + data);
    }

    @PreDestroy
    public void stop() {
        System.out.println("JSFBean preDestroy called.");
    }

    public void setData(String newData) {
        this.data += newData;
    }

    public String getData() {
        return this.data;
    }

    public String nextPage() {
        return "TestBean";
    }
}
