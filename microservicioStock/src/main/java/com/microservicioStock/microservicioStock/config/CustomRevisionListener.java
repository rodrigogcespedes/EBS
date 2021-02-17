package com.microservicioStock.microservicioStock.config;

import org.hibernate.envers.RevisionListener;

import com.microservicioStock.microservicioStock.local_models.audit.Revision;

public class CustomRevisionListener implements RevisionListener{

    @Override
    public void newRevision(Object revisionEntity) {
        final Revision revision = (Revision) revisionEntity;
    }

}
