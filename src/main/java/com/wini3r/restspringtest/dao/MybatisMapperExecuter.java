/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wini3r.restspringtest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MybatisMapperExecuter<M> {

    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public MybatisMapperExecuter(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    abstract protected Class<M> getMapperClass();

    protected SqlSession openSqlSession() {
        return sqlSessionFactory.openSession();
    }

    protected <R, L extends List> List<R> getResults(SessionResultHandler<M, List<R>> handler) {
        return getResults(handler, ArrayList<R>::new);
    }

    protected <R, L extends List> List<R> getResults(SessionResultHandler<M, List<R>> handler, Supplier<L> createList) {
        try (SqlSession session = openSqlSession();) {
            M mapper = session.getMapper(getMapperClass());
            List<R> result = createList.get();
            result.addAll(handler.getResult(mapper));
            return result;
        }
    }

    protected <R> R getResult(SessionResultHandler<M, R> handler) {
        try (SqlSession session = openSqlSession();) {
            M mapper = session.getMapper(getMapperClass());
            return handler.getResult(mapper);
        }
    }

    protected void run(SessionHandler<M> handler) {
        try (SqlSession session = openSqlSession();) {
            M mapper = session.getMapper(getMapperClass());
            handler.doRun(mapper);
        }
    }

    protected void runAndCommit(SessionHandler<M> handler) {
        try (SqlSession session = openSqlSession();) {
            M mapper = session.getMapper(getMapperClass());
            handler.doRun(mapper);
            session.commit();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * SessionHandler
     *
     * @param <M>
     */
    public interface SessionHandler<M> {

        public void doRun(M mapper);
    }

    /**
     * SessionResultHandler
     *
     * @param <M>
     * @param <R>
     */
    public interface SessionResultHandler<M, R> {

        public R getResult(M mapper);
    }
}
