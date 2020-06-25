package soft.train.spring.rest;

import java.util.ArrayList;
import java.util.List;

public class MyErrorObject {

    private List<MyErrorObject> subErrors;
    private String              domain;
    private String              subDomain;
    private String              boundedContext;
    private String              microservice;
    private String              desc;
    private String              errorDomain;
    private int                 cause;

    public MyErrorObject() {
    }

    public MyErrorObject(final List<MyErrorObject> subErrorsParam,
                         final String domainParam,
                         final String subDomainParam,
                         final String boundedContextParam,
                         final String microserviceParam,
                         final String descParam,
                         final String errorDomainParam,
                         final int causeParam) {
        this.subErrors = subErrorsParam;
        this.domain = domainParam;
        this.subDomain = subDomainParam;
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.desc = descParam;
        this.errorDomain = errorDomainParam;
        this.cause = causeParam;
    }

    public MyErrorObject(final String domainParam,
                         final String subDomainParam,
                         final String boundedContextParam,
                         final String microserviceParam,
                         final String descParam,
                         final String errorDomainParam) {
        this.domain = domainParam;
        this.subDomain = subDomainParam;
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.desc = descParam;
        this.errorDomain = errorDomainParam;
    }

    public MyErrorObject copyMe() {
        return new MyErrorObject().setDomain(this.domain)
                                  .setSubDomain(this.subDomain)
                                  .setBoundedContext(this.boundedContext)
                                  .setErrorDomain(this.errorDomain);
    }

    public void addError(final MyErrorObject myErrorObjectParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(myErrorObjectParam);
    }

    public List<MyErrorObject> getSubErrors() {
        return this.subErrors;
    }

    public String getDomain() {
        return this.domain;
    }

    public MyErrorObject setDomain(final String domainParam) {
        this.domain = domainParam;
        return this;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public MyErrorObject setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public MyErrorObject setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public MyErrorObject setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public MyErrorObject setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    public String getErrorDomain() {
        return this.errorDomain;
    }

    public MyErrorObject setErrorDomain(final String errorDomainParam) {
        this.errorDomain = errorDomainParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public MyErrorObject setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }
}
