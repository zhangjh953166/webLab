package com.example.webLab.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 授权客户端实体类
 * 只有数据库中存在的客户端站点才有资格申请访问服务器的资源
 * @author favccxx
 *
 */
@Entity
@Table(name = "FAV_AUTH_CLIENT")
@Data
public class AuthClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="authClientSeq")
    @SequenceGenerator(name="authClientSeq", initialValue = 1, allocationSize = 1, sequenceName = "FAV_AUTH_CLIENT_SEQ" )
    @Column(name = "ID")
    private Long id;

    /**
     * 客户端Id
     */
    @Column(name = "CLIENT_ID")
    private String clientId;

    /**
     * 客户端名称
     */
    @Column(name = "CLIENT_NAME")
    private String clientName;

    /**
     * 客户端密钥
     */
    @Column(name = "CLIENT_SECRET")
    private String clientSecret;
}
