module pplgenerator {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.web;
    requires java.persistence;
    requires spring.data.commons;
    requires spring.context;
    requires spring.core;

    opens us.greatapps4you.pplgenerator to spring.core, spring.beans;
    opens us.greatapps4you.pplgenerator.rest to spring.beans;
    opens us.greatapps4you.pplgenerator.repository to spring.beans;
    opens us.greatapps4you.pplgenerator.service to spring.beans;

    exports us.greatapps4you.pplgenerator;
    exports us.greatapps4you.pplgenerator.domain;
    exports us.greatapps4you.pplgenerator.repository;
    exports us.greatapps4you.pplgenerator.rest;
    exports us.greatapps4you.pplgenerator.service;

}