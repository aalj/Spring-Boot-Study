package spring.boot.security.sample.entity;

import javax.persistence.*;

@Table(name = "TestDb..SYS_USER")
public class SysUserEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACCOUNT_NON_EXPIRED")
    private Boolean accountNonExpired;

    @Column(name = "ACCOUNT_NON_LOCKED")
    private Boolean accountNonLocked;

    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private Boolean credentialsNonExpired;

    @Column(name = "ENABLED")
    private Boolean enabled;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return ACCOUNT_NON_EXPIRED
     */
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * @param accountNonExpired
     */
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * @return ACCOUNT_NON_LOCKED
     */
    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * @param accountNonLocked
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    /**
     * @return CREDENTIALS_NON_EXPIRED
     */
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * @param credentialsNonExpired
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * @return ENABLED
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}