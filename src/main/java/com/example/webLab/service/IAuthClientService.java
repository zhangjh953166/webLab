package com.example.webLab.service;

import com.example.webLab.model.AuthClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="AuthClient")
@Qualifier("IAuthClientService")
public interface IAuthClientService extends CrudRepository<AuthClient,Long> {

    /**
     * 根据客户端Id查询认证客户端信息
     * @param clientId
     * @return
     */
    @Query("select t from AuthClient t where t.id=:clientId")
    public AuthClient findByClientId(@Param("clientId") Long clientId);
}
