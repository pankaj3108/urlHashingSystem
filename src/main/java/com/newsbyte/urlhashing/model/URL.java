package com.newsbyte.urlhashing.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "URL_DETAIL")
public class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "URL_HASH_KEY")
    private String urlHashKey;
    @Column(name = "URL_NAME")
    private String longUrl;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "EXPIARY_DATE")
    private Date expiaryDate;

    public URL() {
    }

    public URL(String urlHashKey, String longUrl, Date createDate) {
        this.urlHashKey = urlHashKey;
        this.longUrl = longUrl;
        this.createDate = createDate;
        this.expiaryDate = addDays(createDate, 7);
    }

    public URL(Integer id, String urlHashKey, String longUrl, Date createDate) {
        this.id = id;
        this.urlHashKey = urlHashKey;
        this.longUrl = longUrl;
        this.createDate = createDate;
    }

    private Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlHashKey() {
        return urlHashKey;
    }

    public void setUrlHashKey(String urlHashKey) {
        this.urlHashKey = urlHashKey;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpiaryDate() {
        return expiaryDate;
    }

    public void setExpiaryDate(Date expiaryDate) {
        this.expiaryDate = expiaryDate;
    }
}
